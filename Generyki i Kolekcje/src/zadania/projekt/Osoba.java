package zadania.projekt;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Osoba implements Comparable<Osoba>{
    private final String name;
    private final String surname;
    private boolean VIP = false;
    private Integer ID = 0;
    private static Map<String, Integer> clientRegister = new HashMap<>();
    private Integer arrivalID;
    private static Integer counter = 0;

    public Osoba(String name, String surname, boolean VIP) {
        this.name = name;
        this.surname = surname;
        this.VIP = VIP;
        updateClientRegister((name + surname).toUpperCase());
        arrivalID = ++counter;

    }

    public Osoba(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private void updateClientRegister(String person){
        if(clientRegister.containsKey(person)){
            Integer currentID = clientRegister.get(person);
            this.setID(currentID + 1);
            clientRegister.put(person, this.getID());
        }else {
            this.setID(1);
            clientRegister.put(person, this.getID());
        }
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Osoba o) {
        int result = Boolean.compare(o.VIP, this.VIP);
        if(result != 0){
            return result;
        }
        return Integer.compare(this.arrivalID, o.arrivalID);
//        result = this.surname.compareTo(o.surname);
//        if(result != 0){
//            return result;
//        }
//        result = this.name.compareTo(o.name);
//        if(result != 0){
//            return result;
//        }
//        return Integer.compare(this.ID, o.ID);
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
        Osoba osoba = (Osoba) o;
        return name.equals(osoba.name) && surname.equals(osoba.surname) && ID.equals(osoba.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, ID);
    }

    @Override
    public String toString() {
        String personInfo = name + '_' + surname + "_" + ID;
        if(VIP){
            personInfo += "_VIP";
        }
        return personInfo;
    }
}
