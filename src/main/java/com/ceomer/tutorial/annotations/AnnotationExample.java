package com.ceomer.tutorial.annotations;

import com.ceomer.tutorial.Builder;

@Builder
public class AnnotationExample {

    private static final Object suppliedObject1 = new Object();
    private static final Object suppliedObject2 = new Object();

    @Inject(Injector.SUP1) public Object object1;
    @Inject(Injector.SUP1) public Object object2;
    @Inject(Injector.SUP2) public Object object3;

    public AnnotationExample(){
        Injector.inject(this, () -> suppliedObject1,() -> suppliedObject2);
    }

}
