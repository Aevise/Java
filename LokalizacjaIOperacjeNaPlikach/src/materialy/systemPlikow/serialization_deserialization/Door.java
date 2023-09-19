package materialy.systemPlikow.serialization_deserialization;

public class Door {

    private final static long serialVersionUID = 7436131742284297442L;
    private final String which;

    public Door(String which) {
        this.which = which;
    }

    public String getWhich() {
        return which;
    }

    @Override
    public String toString() {
        return "Door{" +
                "which='" + which + '\'' +
                '}';
    }
}
