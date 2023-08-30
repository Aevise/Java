package materialy.methodReference;

public class Car {
    private final SteeringWheel steeringWheel;

    public Car(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "steeringWheel=" + steeringWheel +
                '}';
    }
}
