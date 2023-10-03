package main.java.pl.Aevise;

public class HawaiianPizza implements Pizza {

    @Override
    public void bake() {
        System.out.println("Baking Hawaiian pizza");
    }

    @Override
    public String whatSauce() {
        return "Spicy";
    }

    public void morePineapple(){
        System.out.println("Adding more pineapple");
    }
}
