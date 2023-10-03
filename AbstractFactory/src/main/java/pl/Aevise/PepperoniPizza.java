package main.java.pl.Aevise;

public class PepperoniPizza implements Pizza {

    @Override
    public void bake() {
        System.out.println("Baking Pepperoni pizza");
    }

    @Override
    public String whatSauce() {
        return "Tomato";
    }

    public void moreSpicy(){
        System.out.println("Adding more spice");
    }
}
