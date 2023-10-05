import java.util.List;

public class ChainRunner {
    private final CarHandler carHandler;

    public ChainRunner() {
        this.carHandler = new CabrioletHandler();
        CarHandler handler2 = new JeepHandler();
        CarHandler handler3 = new ColorHandler();
        CarHandler handler4 = new EquipmentHandler();
        CarHandler handler5 = new QualityCheckHandler();

        carHandler.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler3.setNextHandler(handler4);
        handler4.setNextHandler(handler5);
    }

    public static void main(String[] args) {
        ChainRunner chainRunner = new ChainRunner();
        chainRunner.carHandler.handle(new Car(Car.Type.JEEP, "Red", List.of("Steering Wheel")));
        chainRunner.carHandler.handle(new Car(Car.Type.CABRIOLET, "Blue", List.of("Doooors")));
    }
}
