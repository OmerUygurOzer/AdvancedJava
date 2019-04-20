package com.ceomer.tutorial.builders;

import com.ceomer.tutorial.Builder;

@Builder
public class Car extends Vehicle {

    public enum FuelType{
        ELECTRIC,
        GAS,
        DIESEL
    }
    public boolean isAutomatic;
    public FuelType fuelType;

    Car(String make, String model, String year,boolean isAutomatic,FuelType fuelType) {
        super(make, model, year);
        this.isAutomatic = isAutomatic;
        this.fuelType = fuelType==null?FuelType.GAS:fuelType;
    }

    public Car(){
        super(null,null,null);
    }


    interface CarBuilder<T>{
        T setIsAutomatic(boolean isAutomatic);
        T setFuelType(FuelType fuelType);
        Car buildCar();
    }

}
