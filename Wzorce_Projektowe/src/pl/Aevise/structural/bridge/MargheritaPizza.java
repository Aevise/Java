package pl.Aevise.structural.bridge;

public class MargheritaPizza extends Pizza {
    public MargheritaPizza(PizzaMaker pizzaMaker) {
        super(pizzaMaker);
    }

    @Override
    public void preparePizza() {
        System.out.println("Preparing Margherita Pizza");
        pizzaMaker.make();
    }
}
