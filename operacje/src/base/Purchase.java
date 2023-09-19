package base;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Purchase {
    BigDecimal id;
    Osoba osoba;
    Samochod samochod;
    Lokalizacja lokalizacja;
    LocalDate date;

    public Purchase(BigDecimal id, Osoba osoba, Samochod samochod, Lokalizacja lokalizacja, LocalDate date) {
        this.id = id;
        this.osoba = osoba;
        this.samochod = samochod;
        this.lokalizacja = lokalizacja;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", osoba=" + osoba +
                ", samochod=" + samochod +
                ", lokalizacja=" + lokalizacja +
                ", date=" + date +
                '}';
    }

    public BigDecimal getId() {
        return id;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public Samochod getSamochod() {
        return samochod;
    }

    public Lokalizacja getLokalizacja() {
        return lokalizacja;
    }

    public LocalDate getDate() {
        return date;
    }
}
