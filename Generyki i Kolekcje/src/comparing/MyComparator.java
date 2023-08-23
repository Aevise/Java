package comparing;

import comparing.helper.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyComparator {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Roman"));
        dogs.add(new Dog("Stefan"));
        dogs.add(new Dog("Burek"));
        dogs.add(new Dog("Zbyszek"));
        dogs.add(new Dog("Marian"));
        dogs.add(new Dog("Karol"));

        //jak usuniemy z klasy Dog "implements Comparable<Dog>" to poleci nam błąd na metodzie sort
        Collections.sort(dogs);
    }
}
