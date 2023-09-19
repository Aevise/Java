package projekt.base;

import java.math.BigDecimal;
import java.util.Comparator;

public class Samochod implements Comparable<Samochod> {
    String color;
    String car_vin;
    String car_company;
    String car_model;
    String car_model_year;
    BigDecimal car_price;

    public Samochod(String color, String car_vin, String car_company, String car_model, String car_model_year, BigDecimal car_price) {
        this.color = color;
        this.car_vin = car_vin;
        this.car_company = car_company;
        this.car_model = car_model;
        this.car_model_year = car_model_year;
        this.car_price = car_price;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "color='" + color + '\'' +
                ", car_vin='" + car_vin + '\'' +
                ", car_company='" + car_company + '\'' +
                ", car_model='" + car_model + '\'' +
                ", car_model_year='" + car_model_year + '\'' +
                ", car_price=" + car_price +
                '}';
    }

    public String getColor() {
        return color;
    }

    public String getCar_vin() {
        return car_vin;
    }

    public String getCar_company() {
        return car_company;
    }

    public String getCar_model() {
        return car_model;
    }

    public String getCar_model_year() {
        return car_model_year;
    }

    public BigDecimal getCar_price() {
        return car_price;
    }

    @Override
    public int compareTo(Samochod samochod) {
        return 0;
    }
}
