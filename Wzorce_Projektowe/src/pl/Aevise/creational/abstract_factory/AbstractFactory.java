package pl.Aevise.creational.abstract_factory;

public interface AbstractFactory {
    default Shape getShape(String shapeType) {
        return null;
    }

    default Color getColor(String colorType) {
        return null;
    }
}
