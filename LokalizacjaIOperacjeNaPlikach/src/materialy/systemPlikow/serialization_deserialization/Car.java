package materialy.systemPlikow.serialization_deserialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Car implements Serializable {

    @Serial
    private static final long serialVersionUID = -3693752187112414237L; //dobra praktyka przy serializowaniu.
    private Hood hood;
    private final String name; // pominiete w procesie Serializacji (nie bedziemy mieli tej wartosci podczas deserializacji)
    private final Long year;
    private final transient List<Door> doors;
    private String someNull;

    public Car(String name, Long year, List<Door> doors) {
        this.name = name;
        this.year = year;
        this.doors = doors;
    }

    public String getName() {
        return name;
    }

    public Long getYear() {
        return year;
    }

    public List<Door> getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "hood=" + hood +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", doors=" + doors +
                ", someNull='" + someNull + '\'' +
                '}';
    }
}
