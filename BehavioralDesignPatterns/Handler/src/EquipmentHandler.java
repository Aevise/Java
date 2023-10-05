import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EquipmentHandler implements CarHandler{
    private CarHandler nextHandler;

    @Override
    public void setNextHandler(CarHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(Car car) {
        if(Objects.nonNull(car.getEquipment())){
            System.out.printf("preparing %s equipment%n", car.getEquipment());
            this.nextHandler.handle(car);
        }else{
            this.nextHandler.handle(car);
        }
    }
}
