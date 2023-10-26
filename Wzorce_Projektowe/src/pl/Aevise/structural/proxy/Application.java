package pl.Aevise.structural.proxy;

public class Application {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.png");
        Image image2 = new ProxyImage("image2.png");

        image1.display();
        image1.display();

        image2.display();
        image2.display();
    }
}
