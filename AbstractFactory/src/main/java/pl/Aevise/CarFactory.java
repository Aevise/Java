package main.java.pl.Aevise;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class CarFactory implements AbstractFactory<Car>{
    private static final Map<String, Supplier<Car>> CAR_MAP = new HashMap<>();

    static {
        CAR_MAP.put("SUV", SUV::new);
        CAR_MAP.put("CABRIOLET", Cabriolet::new);
    }
    @Override
    public Car create(String type) {
        return Optional.ofNullable(CAR_MAP.get(type))
                .map(Supplier::get)
                .orElseThrow(() -> new RuntimeException(String.format("Sorry we do not offer [%s]", type)));
    }
}
