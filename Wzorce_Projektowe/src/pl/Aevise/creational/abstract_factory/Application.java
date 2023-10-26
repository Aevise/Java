package pl.Aevise.creational.abstract_factory;

public class Application {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = AbstractFactoryImpl.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");     //drawing circle
        Shape shape2 = shapeFactory.getShape("SQUARE");     //drawing square
        shape1.draw();
        shape2.draw();

        AbstractFactory colorFactory = AbstractFactoryImpl.getFactory("COLOR");
        Color color1 = colorFactory.getColor("RED");    //filling with red
        Color color2 = colorFactory.getColor("BLUE");   //filling with blue
        color1.fill();
        color2.fill();
    }
}
