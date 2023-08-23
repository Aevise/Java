package comparing.helper;

public class Dog implements Comparable<Dog> {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog: " + name;
    }

    @Override
    public int compareTo(Dog dog) {
        return 0;
    }
}
