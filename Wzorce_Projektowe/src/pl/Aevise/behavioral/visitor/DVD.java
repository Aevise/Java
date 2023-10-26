package pl.Aevise.behavioral.visitor;

public class DVD implements Visitable {

    double price;
    String title;
    String director;

    public DVD(double price, String title, String director) {
        this.price = price;
        this.title = title;
        this.director = director;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
