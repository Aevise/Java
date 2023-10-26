package pl.Aevise.structural.composite;


public class Application {
    public static void main(String[] args) {
        Composite composite = new Composite("Composite");
        composite.add(new Leaf("Leaf1"));
        composite.add(new Leaf("Leaf2"));
        Composite subComposite = new Composite("SubComposite");
        subComposite.add(new Leaf("Leaf3"));
        subComposite.add(new Leaf("Leaf4"));
        composite.add(subComposite);
        composite.operation();
    }
}
