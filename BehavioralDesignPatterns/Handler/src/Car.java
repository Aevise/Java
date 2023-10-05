import java.util.List;
import java.util.Objects;

public class Car {
    private Type type;
    private String color;
    private List<String> equipment;

    public Car(Type type, String color, List<String> equipment) {
        this.type = type;
        this.color = color;
        this.equipment = equipment;
    }

    public Car withColor(String color) {
        return Objects.equals(this.color, color) ? this : new Car(type, color, equipment);
    }

    public Car withEquipment(List<String> equipment) {
        return this.equipment == equipment ? this : new Car(type, color, equipment);
    }
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }


    enum Type{
        CABRIOLET,
        JEEP
    }
}
