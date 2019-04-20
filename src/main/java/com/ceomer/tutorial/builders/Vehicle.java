package com.ceomer.tutorial.builders;

public abstract class Vehicle {

    private String make; //brand
    private String model;
    private String year;

    protected Vehicle(String make,String model,String year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    private interface BaseVehicleBuilder<T>{
        T setMake(String make);
        T setModel(String model);
        T setYear(String year);
    }

    public interface ICarBuilder extends Car.CarBuilder<ICarBuilder>{}
    public interface ISUVBuilder extends SUV.SUVBuilder<ISUVBuilder>{}

    public static class VehicleBuilder implements BaseVehicleBuilder<VehicleBuilder>,ICarBuilder,ISUVBuilder{
        private String make; //brand
        private String model;
        private String year;
        private boolean isAutomatic;
        private Car.FuelType fuelType;
        private boolean is4WD; //4 wheel drive;
        private SUV.Size size;

        @Override
        public ICarBuilder setIsAutomatic(boolean isAutomatic) {
            this.isAutomatic = isAutomatic;
            return this;
        }

        @Override
        public ICarBuilder setFuelType(Car.FuelType fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        @Override
        public Car buildCar() {
            return new Car(make,model,year,isAutomatic,fuelType);
        }

        @Override
        public ISUVBuilder setIs4WD(boolean is4WD) {
            this.is4WD = is4WD;
            return this;
        }

        @Override
        public ISUVBuilder setSize(SUV.Size size) {
            this.size = size;
            return this;
        }

        @Override
        public SUV buildSUV() {
            return new SUV(make,model,year,is4WD,size);
        }

        @Override
        public VehicleBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        @Override
        public VehicleBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        @Override
        public VehicleBuilder setYear(String year) {
            this.year = year;
            return this;
        }
    }
}
