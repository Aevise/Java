package pl.Aevise.creational.abstract_factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class ColorFactory implements AbstractFactory {

    private final static Map<String, Supplier<Color>> FACTORY_CONSTRUCTS = new HashMap<>();

    static {
        FACTORY_CONSTRUCTS.put("RED", Red::new);
        FACTORY_CONSTRUCTS.put("BLUE", Blue::new);
    }

    @Override
    public Color getColor(String colorType) {
        return Optional.of(FACTORY_CONSTRUCTS.get(colorType.toUpperCase()))
                .map(Supplier::get)
                .orElseThrow(
                        () -> new RuntimeException(String.format("We do not provide %s color", colorType)
                        ));
    }
}
