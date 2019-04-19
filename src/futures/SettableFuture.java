package futures;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SettableFuture<T> implements Future<T> {

    public static <K> SettableFuture<K> create(Listener<K> listener, ExecutorService listenerExecutor) {
        return new SettableFuture<>(listener, listenerExecutor);
    }

    private Listener<T> listener;
    private ExecutorService listenerExecutor;
    private ReadWriteLock readWriteLock;
    private boolean isCancelled;
    private T object;
    private Exception exception;


    private SettableFuture(Listener<T> listener, ExecutorService listenerExecutor) {
        this.listener = listener;
        this.listenerExecutor = listenerExecutor;
        this.readWriteLock = new ReentrantReadWriteLock();
        this.isCancelled = false;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        readWriteLock.writeLock().lock();
        try {
            this.isCancelled = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public boolean isDone() {
        readWriteLock.readLock().lock();
        try {
            return this.object != null;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        readWriteLock.readLock().lock();
        try {
            return this.object;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void set(T object) {
        readWriteLock.writeLock().lock();
        try {
            if (exception != null) {
                return;
            }
            this.object = object;
            System.out.println("BEING SET ON:"+Thread.currentThread().getId());
            if (this.listenerExecutor == null) {
                this.listener.settableSet(object, null);
            }else{
                this.listenerExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("BEING LISTENED ON:"+Thread.currentThread().getId());
                        listener.settableSet(object, null);
                    }
                });
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void setError(Exception object) {
        readWriteLock.writeLock().lock();
        try {
            if (object != null) {
                return;
            }
            this.exception = exception;
            this.listener.settableSet(null, exception);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return get();
    }

    public interface Listener<T> {
        void settableSet(T result, Exception e);
    }
}
