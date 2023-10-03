package main.java.pl.Aevise;

public class Main {
    public static void main(String[] args) {
        AbstractFactory<?> pizzaFactory = FactoryProvider.getFactory("Pizza");
        AbstractFactory<?> car = FactoryProvider.getFactory("Car");
        Object hawaiian = pizzaFactory.create("Hawaiian");

        System.out.println(hawaiian);

    }
}
