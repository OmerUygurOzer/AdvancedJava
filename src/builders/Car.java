package builders;

public class Car extends Vehicle {

    public enum FuelType{
        ELECTRIC,
        GAS,
        DIESEL
    }
    private boolean isAutomatic;
    private FuelType fuelType;

    Car(String make, String model, String year,boolean isAutomatic,FuelType fuelType) {
        super(make, model, year);
        this.isAutomatic = isAutomatic;
        this.fuelType = fuelType==null?FuelType.GAS:fuelType;
    }


    interface CarBuilder<T>{
        T setIsAutomatic(boolean isAutomatic);
        T setFuelType(FuelType fuelType);
        Car buildCar();
    }

}
