import builders.Car;
import builders.SUV;
import builders.Vehicle;

public class Main {

    public static void main(String[] args) {



//        //Painful
//        GoodExample goodExample = new GoodExample(false, true, false, new Object(), null, new Object());
//        //Super cool
//        GoodExample goodExample1 = new GoodExampleBuilder()
//                .setFlag2(true)
//                .setDep1(new Object())
//                .setDep3(new Object())
//                .build();
//
//        //NPE
//        BadExample badExample = new BadExampleBuilder()
//                .setFirstName("CE")
//                .setLastName("Omer")
//                .build();
//
//        Car car = new Vehicle.VehicleBuilder()
//                .setMake("MERCEDES")
//                .setFuelType(Car.FuelType.GAS)
//                .setIsAutomatic(true)
//                .buildCar();
//
//        SUV suv = new Vehicle.VehicleBuilder()
//                .setYear("2011")
//                .setMake("Toyota")
//                .setModel("RAV4")
//                .setIs4WD(true)
//                .setSize(SUV.Size.L)
//                .buildSUV();



    }

    private static class GoodExample {
        private boolean flag1;
        private boolean flag2;
        private boolean flag3;
        private Object dep1;
        private Object dep2;
        private Object dep3;

        public GoodExample(boolean flag1, boolean flag2, boolean flag3, Object dep1, Object dep2, Object dep3) {
            this.flag1 = flag1;
            this.flag2 = flag2;
            this.flag3 = flag3;
            this.dep1 = dep1 == null ? new Object() : dep1;
            this.dep2 = dep2 == null ? new Object() : dep2;
            this.dep3 = dep3 == null ? new Object() : dep3;
        }
    }

    private static class GoodExampleBuilder {
        private boolean flag1;
        private boolean flag2;
        private boolean flag3;
        private Object dep1;
        private Object dep2;
        private Object dep3;

        private GoodExampleBuilder setFlag1(boolean flag) {
            this.flag1 = flag;
            return this;
        }

        private GoodExampleBuilder setFlag2(boolean flag) {
            this.flag2 = flag;
            return this;
        }

        private GoodExampleBuilder setFlag3(boolean flag) {
            this.flag3 = flag;
            return this;
        }

        private GoodExampleBuilder setDep1(Object dep1) {
            this.dep1 = dep1;
            return this;
        }

        private GoodExampleBuilder setDep2(Object dep1) {
            this.dep2 = dep1;
            return this;
        }

        private GoodExampleBuilder setDep3(Object dep1) {
            this.dep3 = dep1;
            return this;
        }

        private GoodExample build() {
            return new GoodExample(flag1, flag2, flag3, dep1, dep2, dep3);
        }

    }

    private static class BadExample {
        private final Card card;

        public BadExample(String firstName, String lastName, Card card) {
            this.card = card;
            this.card.setFullName(firstName + " " + lastName);
        }
    }

    private static class BadExampleBuilder {
        private String firstName;
        private String lastName;
        private Card card;

        private BadExampleBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        private BadExampleBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        private BadExampleBuilder setCard() {
            this.card = card;
            return this;
        }

        private BadExample build() {
            return new BadExample(firstName, lastName, card);
        }
    }

    private static class Card {
        private String fullName;

        private void setFullName(String name) {
            this.fullName = name;
        }
    }
}
