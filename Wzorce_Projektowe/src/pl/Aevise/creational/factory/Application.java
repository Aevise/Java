package pl.Aevise.creational.factory;

public class Application {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        Shape shape2 = shapeFactory.getShape("SQUARE");

        shape1.draw(); //"drawing circle"
        shape2.draw(); //"drawing square"
    }
}
