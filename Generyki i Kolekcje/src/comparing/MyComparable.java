package comparing;

import comparing.helper.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyComparable {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Roman",1));
        dogs.add(new Dog("Stefan",3));
        dogs.add(new Dog("Burek",5));
        dogs.add(new Dog("Zbyszek",2));
        dogs.add(new Dog("Marian", 4));
        dogs.add(new Dog("Karol",6));

        //jak usuniemy z klasy Dog "implements Comparable<Dog>" to poleci nam błąd na metodzie sort
        System.out.println(dogs);
        Collections.sort(dogs);
        System.out.println(dogs);

        List<Dog2> doge2 = Arrays.asList(new Dog2(), new Dog2());
        Collections.sort(doge2);
    }

    public static class Dog2 implements Comparable<Dog2>{

        @Override
        public int compareTo(Dog2 o) {
            return 0;
        }
    }
}
