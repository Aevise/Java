package pl.Aevise.structural.bridge;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza(PizzaMaker pizzaMaker) {
        super(pizzaMaker);
    }

    @Override
    public void preparePizza() {
        System.out.println("Preparing pepperoni pizza");
        pizzaMaker.make();
    }
}
