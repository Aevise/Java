package pl.Aevise.creational.prototype;

public class Car implements Cloneable {

    private final String model;
    private String color;
    private final String brand;

    public Car(String model, String brand, String color) {
        this.model = model;
        this.color = color;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
