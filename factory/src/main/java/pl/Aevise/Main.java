package main.java.pl.Aevise;

public class Main {
    public static void main(String[] args) {
        Pizza hawaiian = PizzaFactory.preparePizza("Hawaiian");
        Pizza pepperoni = PizzaFactory.preparePizza("Pepperoni");

        hawaiian.bake();
        System.out.println(hawaiian.whatSauce());
//        hawaiian.morePineapple();

        HawaiianPizza hawaiianPizza = new HawaiianPizza();
        hawaiianPizza.morePineapple();

        pepperoni.bake();
        System.out.println(pepperoni.whatSauce());
    }
}
