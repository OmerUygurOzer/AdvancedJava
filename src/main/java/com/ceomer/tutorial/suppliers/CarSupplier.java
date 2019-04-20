package com.ceomer.tutorial.suppliers;

import com.ceomer.tutorial.builders.Car;
import com.ceomer.tutorial.builders.Vehicle;

public class CarSupplier implements Supplier<Car> {
    @Override
    public Car get() {
        return new Vehicle.VehicleBuilder()
                .setMake("MERCEDES")
                .setYear("1999")
                .setModel("E-Class")
                .setFuelType(Car.FuelType.GAS)
                .setIsAutomatic(true)
                .buildCar();
    }
}
