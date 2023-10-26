package pl.Aevise.behavioral.template_method;

public class ConcreteClass1 extends AbstractClass {
    @Override
    public void stepOne() {
        System.out.println("Concrete Class 1 step one");
    }

    @Override
    public void stepTwo() {
        System.out.println("Concrete Class 1 step two");
    }

    @Override
    public void stepThree() {
        System.out.println("Concrete Class 1 step three");
    }
}
