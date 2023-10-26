package pl.Aevise.structural.decorator;

public class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("Additional functionality from concreteDecorator2");
    }
}
