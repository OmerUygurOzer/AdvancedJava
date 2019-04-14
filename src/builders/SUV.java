package builders;

public class SUV extends Vehicle {

    public enum Size{
        M,
        L
    }
    private boolean is4WD; //4 wheel drive;
    private Size size;

    SUV(String make, String model, String year,boolean is4WD,Size size) {
        super(make, model, year);
        this.is4WD = is4WD;
        this.size = size==null?Size.M:size;
    }

    interface SUVBuilder<T>{
        T setIs4WD(boolean is4WD);
        T setSize(Size size);
        SUV buildSUV();
    }
}
