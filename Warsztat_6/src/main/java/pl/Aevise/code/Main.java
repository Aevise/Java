package pl.Aevise.code;


public class Main {
    public static void main(String[] args) {
        Owner Tomasz = new Owner();
        Dog burek1 = Dog.of("Burek", 4, Tomasz, new Food());
        Dog burek2 = Dog.of("Burek", 4, new Owner(), new Food());
        Dog burek3 = Dog.of("Burek", 4, Tomasz, new Food());

        String name = burek1.getName();
        burek1.consume(name + " eats Kupa");
        System.out.println(burek1);
        System.out.println(burek1.equals(burek2));
        System.out.println(burek1.equals(burek3));
        System.out.println(burek2.equals(burek3));
    }
}