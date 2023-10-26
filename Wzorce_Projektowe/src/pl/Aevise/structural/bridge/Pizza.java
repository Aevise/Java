package pl.Aevise.structural.bridge;

public abstract class Pizza {
    protected PizzaMaker pizzaMaker;

    public Pizza(PizzaMaker pizzaMaker) {
        this.pizzaMaker = pizzaMaker;
    }

    public abstract void preparePizza();
}
