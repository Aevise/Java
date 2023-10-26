package pl.Aevise.creational.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class ShapeFactory {

    private static final Map<String, Supplier<Shape>> FACTORY_CONSTRUCTS = new HashMap<>();

    static {
        FACTORY_CONSTRUCTS.put("CIRCLE", Circle::new);
        FACTORY_CONSTRUCTS.put("SQUARE", Square::new);
    }

    public Shape getShape(String requiredShape) {
        return Optional.of(FACTORY_CONSTRUCTS.get(requiredShape.toUpperCase()))
                .map(Supplier::get)
                .orElseThrow(()-> new RuntimeException(
                        String.format("Sorry, we do not support %s shape!", requiredShape)
                ));
    }
}
