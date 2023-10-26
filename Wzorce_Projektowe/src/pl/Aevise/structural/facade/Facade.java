package pl.Aevise.structural.facade;

public class Facade {
    private final ComplexSystem complexSystem;

    public Facade(ComplexSystem complexSystem) {
        this.complexSystem = complexSystem;
    }

    public void simpleOperation() {
        System.out.println("Performing single operation on complex system");
        complexSystem.method1();
    }

    public void complexOperation() {
        System.out.println("Performing complex operation on complex system");
        complexSystem.method1();
        complexSystem.method2();
        complexSystem.method3();
    }
}
