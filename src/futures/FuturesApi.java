package futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FuturesApi {

    private ExecutorService executorService;

    public FuturesApi() {
        this.executorService = Executors.newFixedThreadPool(1);
    }

    public <T> SettableFuture<T> submit(Callable<T> task, SettableFuture.Listener<T> listener, ExecutorService listenerExecutor) {
        SettableFuture settableFuture = SettableFuture.create(listener,listenerExecutor);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    settableFuture.set(task.call());
                } catch (Exception e) {
                    settableFuture.setError(e);
                }
            }
        });
        return settableFuture;
    }

}
