package pl.Aevise.structural.decorator;

public class Application {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecorator1(component);
        component = new ConcreteDecorator2(component);
        component.operation();
    }
}
