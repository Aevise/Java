package main.java.pl.Aevise;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class FactoryProvider {

    private static final Map<String, Supplier<AbstractFactory<?>>> FACTORY_MAP = new HashMap<>();

    static {
        FACTORY_MAP.put("Car", CarFactory::new);
        FACTORY_MAP.put("Pizza", PizzaFactory::new);
    }

    public static AbstractFactory<?> getFactory(String whatType){
        return Optional.ofNullable(FACTORY_MAP.get(whatType))
                .map(Supplier::get)
                .orElseThrow(() -> new RuntimeException(String.format("Sorry can not open such factory: [%s]", whatType)));
    }
}
