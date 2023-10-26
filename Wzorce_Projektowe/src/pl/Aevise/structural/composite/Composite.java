package pl.Aevise.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private final List<Component> children = new ArrayList<>();
    private final String name;

    public Composite(String name) {
        this.name = name;
    }


    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public void operation() {
        System.out.printf("Operation performed on a composite: %s%n", name);
        for (Component child : children) {
            child.operation();
        }
    }
}
