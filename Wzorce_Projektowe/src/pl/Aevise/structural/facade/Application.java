package pl.Aevise.structural.facade;

public class Application {
    public static void main(String[] args) {
        Facade facade = new Facade(new ConcreteComplexSystem());
        facade.simpleOperation();
        facade.complexOperation();
    }
}
