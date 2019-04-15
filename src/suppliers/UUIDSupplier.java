package suppliers;

import java.util.UUID;

public class UUIDSupplier implements Supplier<String> {
    @Override
    public String get() {
        return UUID.randomUUID().toString();
    }
}
