package pl.Aevise.structural.facade;

public class ConcreteComplexSystem implements ComplexSystem {
    @Override
    public void method1() {
        System.out.println("Method 1 from complex system");
    }

    @Override
    public void method2() {
        System.out.println("Method 2 from complex system");
    }

    @Override
    public void method3() {
        System.out.println("Method 3 from complex system");
    }
}
