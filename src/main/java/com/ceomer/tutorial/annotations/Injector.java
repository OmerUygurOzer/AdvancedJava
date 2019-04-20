package com.ceomer.tutorial.annotations;

import com.ceomer.tutorial.suppliers.Supplier;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Injector {

    public static final String SUP1 = "s1";
    public static final String SUP2 = "s2";

    public static void inject(Object object, Supplier<Object> supplier, Supplier<Object> supplier2) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers()) && field.getAnnotation(Inject.class) != null) {
                try {
                    String val = field.getAnnotation(Inject.class).value();
                    if (val.equals(SUP1)) {
                        field.set(object, supplier.get());
                    }else if(val.equals(SUP2)){
                        field.set(object, supplier2.get());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
