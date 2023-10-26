package pl.Aevise.creational.abstract_factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class ShapeFactory implements AbstractFactory {

    private final static Map<String, Supplier<Shape>> FACTORY_CONSTRUCTS = new HashMap<>();

    static {
        FACTORY_CONSTRUCTS.put("CIRCLE", Circle::new);
        FACTORY_CONSTRUCTS.put("SQUARE", Square::new);
    }

    @Override
    public Shape getShape(String shapeType) {
        return Optional.of(FACTORY_CONSTRUCTS.get(shapeType.toUpperCase()))
                .map(Supplier::get)
                .orElseThrow(
                        () -> new RuntimeException(String.format("We do not provide %s shape", shapeType)
                        ));
    }
}
