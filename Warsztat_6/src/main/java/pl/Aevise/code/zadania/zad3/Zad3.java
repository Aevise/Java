package pl.Aevise.code.zadania.zad3;

import java.util.Objects;

//@Data
//public class Employee {
//  private String name;
//  private String surname;
//}
public class Zad3 {

    private String name;
    private String surname;

    public Zad3() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zad3 zad3 = (Zad3) o;
        return Objects.equals(name, zad3.name) && Objects.equals(surname, zad3.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Zad3{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
