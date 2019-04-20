package com.ceomer.tutorial.suppliers;

import java.util.HashMap;
import java.util.Map;

public class IdManager {

    private Supplier<String> uuidSupplier;
    private Map<String, User> userToIdMap = new HashMap<>();

    public IdManager(Supplier<String> uuidSupplier) {
        this.uuidSupplier = uuidSupplier;
    }

    public void addUser(String userName) {
        userToIdMap.put(userName, new User(userName, uuidSupplier.get()));
    }

    public User getUser(String userName) {
        return userToIdMap.get(userName);
    }

    public class User {
        String name;
        String id;

        public User(String name, String id) {
            this.name = name;
            this.id = id;
        }
    }


}
