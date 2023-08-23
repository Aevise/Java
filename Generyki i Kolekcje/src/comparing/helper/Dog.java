package comparing.helper;

public class Dog implements Comparable<Dog> {
    private final String name;
    private final Integer ID;

    public Dog(String name, Integer ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Dog: " + ID + " name: " + name;
    }

    @Override
    public int compareTo(Dog dog) {
        int result = this.name.compareTo(dog.name); // kolejnosc rosnaca
//      return dog.name.compareTo(this.name); - kolejnosc malejaca
        if(result != 0 ){
            return result;
        }
        return this.ID - dog.ID;
    }
}
