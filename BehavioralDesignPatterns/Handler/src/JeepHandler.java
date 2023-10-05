import java.util.ArrayList;
import java.util.List;

public class JeepHandler implements CarHandler{
    private CarHandler nextHandler;

    @Override
    public void setNextHandler(CarHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Car car) {
        if(Car.Type.JEEP.equals(car.getType())){
            System.out.println("Preparing Jeep skeleton");
            final List<String> jeepEquipment = new ArrayList<>(car.getEquipment());
            jeepEquipment.add("JeepRoof");
            this.nextHandler.handle(car.withEquipment(jeepEquipment));
        }else{
            this.nextHandler.handle(car);
        }
    }
}
