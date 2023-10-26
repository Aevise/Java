package pl.Aevise.behavioral.visitor;

public interface Visitor {
    void visit(Book book);
    void visit(DVD dvd);
}
