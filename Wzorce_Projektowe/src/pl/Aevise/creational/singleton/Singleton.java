package pl.Aevise.creational.singleton;


// 1. Prywatny konstruktor
// 2. Instancja obiektu musi być gdzieś przechowywana np. w zmiennej
// 3. Posiada statyczną metodę publiczną, która zwraca obiekt
// 4. Można klasę zdefiniować jako final

public final class Singleton {

    private static Singleton instance;
    private String appName;

    private Singleton() {
        instance = this;
        appName = "default";
    }

    public static Singleton getInstance() {
        if (instance == null){
            new Singleton();
        }
            return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
