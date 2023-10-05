public class Main {
    public static void main(String[] args) {
        NewsTopic subject = new NewsTopic();

        Observer observer1 = new NewSubscriber("Cyprian");
        Observer observer2 = new NewSubscriber("Cyprian2");
        Observer observer3 = new NewSubscriber("Cyprian3");

        subject.register(observer1);
        subject.register(observer2);
        subject.register(observer3);

        subject.setNews("Nasrinix has arrived");
    }
}
