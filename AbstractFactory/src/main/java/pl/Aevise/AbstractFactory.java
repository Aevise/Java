package main.java.pl.Aevise;

public interface AbstractFactory<T> {
    T create(String type);
}
