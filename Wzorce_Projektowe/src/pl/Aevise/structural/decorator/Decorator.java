package pl.Aevise.structural.decorator;

public abstract class Decorator implements Component{
    private final Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation(){
        component.operation();
    }
}
