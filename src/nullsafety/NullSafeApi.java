package nullsafety;

import java.util.Optional;
import java.util.UUID;

public class NullSafeApi {

    private Listener listener;

    public NullSafeApi(Listener listener){
        this.listener = listener;
    }

    public void generateValue(){
        this.listener.accept(Optional.of(UUID.randomUUID().toString()));
    }

    public interface Listener{
        void accept(Optional<String> valueOptional);
    }
}
