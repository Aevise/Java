package zadania.projekt;

import java.util.Objects;

public class Osoba implements Comparable<Osoba>{
    private String name;
    private String surname;
    private boolean VIP = false;
    private Integer ID = 0;

    public Osoba(String name, String surname, boolean VIP) {
        this.name = name;
        this.surname = surname;
        this.VIP = VIP;
    }

    public Osoba(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isVIP() {
        return VIP;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Osoba o) {
        int isVip = this.VIP ? 1 : 0;
        int isVIPo = o.VIP ? 1 : 0;
        int result = isVIPo - isVip;
        if(result != 0){
            return result;
        }
        result = this.surname.compareTo(o.surname);
        if(result != 0){
            return result;
        }
        return this.ID - o.ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return name.equals(osoba.name) && surname.equals(osoba.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return name + '_'+ surname + ID + ", VIP= " + VIP;
    }
}
