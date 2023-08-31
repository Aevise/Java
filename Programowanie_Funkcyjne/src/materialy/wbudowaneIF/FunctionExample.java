package materialy.wbudowaneIF;

import java.util.Optional;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Car, String> carStringFunction = Car::toString;
        Optional<String> opt = Optional.of(new Car()).map(carStringFunction);

        Function<Car, String> carStringFunction1 = car -> {
            System.out.println(car);
            return "tehehe";
        };

        Function<Car, String> carStringFunction2 = FunctionExample::convertCarToString;

        carStringFunction1.apply(new Car());
        carStringFunction2.apply(new Car());
    }

    private static String convertCarToString(Car car){
        System.out.println("convertCarToString");
        return "convertCarToString: " + car;
    }

    static class Car {


    }
}
