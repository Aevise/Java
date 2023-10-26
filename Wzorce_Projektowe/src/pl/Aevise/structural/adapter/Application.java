package pl.Aevise.structural.adapter;

public class Application {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request(); //"method called"
    }
}
