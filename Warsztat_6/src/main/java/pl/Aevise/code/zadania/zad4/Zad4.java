package pl.Aevise.code.zadania.zad4;

import java.util.Objects;

//@Value
//public class Employee {
//  String name;
//  String surname;
//}
public final class Zad4 {
    private final String name;
    private final String surname;

    public Zad4(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zad4 zad4 = (Zad4) o;
        return Objects.equals(name, zad4.name) && Objects.equals(surname, zad4.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Zad4{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
