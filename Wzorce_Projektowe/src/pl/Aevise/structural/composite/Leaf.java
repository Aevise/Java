package pl.Aevise.structural.composite;

public class Leaf implements Component {
    private final String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.printf("Operation performed on leaf: %s%n", name);
    }
}
