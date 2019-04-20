package com.ceomer.tutorial.builders;
public class CarBuilder{
public static CarBuilder create(){
return new CarBuilder();}

private Car object;
private CarBuilder(){
this.object = new Car();}

public CarBuilder setisAutomatic(boolean param){
this.object.isAutomatic = param;
return this;}

public CarBuilder setfuelType(com.ceomer.tutorial.builders.Car.FuelType param){
this.object.fuelType = param;
return this;}
public Car build(){return this.object;}
}