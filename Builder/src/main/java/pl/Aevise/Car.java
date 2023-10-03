package main.java.pl.Aevise;

public class Car {
    private final String brand;
    private final String model;
    private final String year;
    private final String towbar;
    private final String skiRack;
    private final String sunRoof;

    private Car(final CarBuilder carBuilder){
        this.brand = carBuilder.brand;
        this.model = carBuilder.model;
        this.year = carBuilder.year;
        this.towbar = carBuilder.towbar;
        this.skiRack = carBuilder.skiRack;
        this.sunRoof = carBuilder.sunRoof;
    }
    public static CarBuilder builder(){
        return new CarBuilder();
    }

    public static class CarBuilder{
        private String brand;
        private String model;
        private String year;
        private String towbar;
        private String skiRack;
        private String sunRoof;

        public CarBuilder brand(String brand){
            this.brand = brand;
            return this;
        }
        public CarBuilder model(String model){
            this.model = model;
            return this;
        }
        public CarBuilder year(String year){
            this.year = year;
            return this;
        }
        public CarBuilder towbar(String towbar){
            this.towbar = towbar;
            return this;
        }
        public CarBuilder skiRack(String skiRack){
            this.skiRack = skiRack;
            return this;
        }
        public CarBuilder sunRoof(String sunRoof){
            this.sunRoof = sunRoof;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }
}
