package main.java.pl.Aevise;


//eager implementation
public class EagerSingleton {
    private static final EagerSingleton instance;

    static {
        try{
            instance = new EagerSingleton();
        }catch (Exception e){
            throw new RuntimeException("Exception while creating instance");
        }
    }

    private EagerSingleton(){
        System.out.println("StaticBlockSingleton constructor");
    }

    public EagerSingleton getInstance(){
        System.out.println(getClass().getName() + " getInstance()");
        return instance;
    }

    static void someMethod(){
        System.out.println("Some method");
    }
}
