package pl.Aevise.creational.abstract_factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class AbstractFactoryImpl implements AbstractFactory {

    private static final Map<String, Supplier<AbstractFactory>> ABSTRACT_FACTORY_CONSTRUCTS = new HashMap<>();

    static {
        ABSTRACT_FACTORY_CONSTRUCTS.put("SHAPE", ShapeFactory::new);
        ABSTRACT_FACTORY_CONSTRUCTS.put("COLOR", ColorFactory::new);
    }


    static AbstractFactory getFactory(String factoryType) {
        return Optional.of(ABSTRACT_FACTORY_CONSTRUCTS.get(factoryType.toUpperCase()))
                .map(Supplier::get)
                .orElseThrow(
                        () -> new RuntimeException(String.format("We do not provice %s factory", factoryType))
                );
    }
}
