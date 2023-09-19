package projekt.base;

public class Lokalizacja {
    String country;
    String city;

    public Lokalizacja(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Lokalizacja{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
