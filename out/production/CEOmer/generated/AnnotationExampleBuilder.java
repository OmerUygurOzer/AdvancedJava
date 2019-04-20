package com.ceomer.tutorial.annotations;
public class AnnotationExampleBuilder{
public static AnnotationExampleBuilder create(){
return new AnnotationExampleBuilder();}

private AnnotationExample object;
private AnnotationExampleBuilder(){
this.object = new AnnotationExample();}

public AnnotationExampleBuilder setobject1(java.lang.Object param){
this.object.object1 = param;
return this;}

public AnnotationExampleBuilder setobject2(java.lang.Object param){
this.object.object2 = param;
return this;}

public AnnotationExampleBuilder setobject3(java.lang.Object param){
this.object.object3 = param;
return this;}
public AnnotationExample build(){return this.object;}
}