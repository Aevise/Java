package pl.Aevise.behavioral.visitor;

public class Book implements Visitable {

    double price;
    String title;
    String author;

    public Book(double price, String title, String author) {
        this.price = price;
        this.title = title;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
