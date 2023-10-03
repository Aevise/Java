package main.java.pl.Aevise;

public class LazySingleton {
    private static LazySingleton instance;

    public LazySingleton() {
        System.out.println("Lazy singleton constructor");
    }

    public static LazySingleton getInstance(){
        System.out.println("Get Instance Lazy Singleton");
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
    static void someMethod(){
        System.out.println("Some method");
    }


}
