package kolekcje;

import java.util.*;

public class Sety {
    public static void main(String[] args) {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("Marina"));
        dogs.add(new Dog("Stefan"));
        dogs.add(new Dog("Marina"));
        dogs.add(new Dog("Wojtas"));
        dogs.add(new Dog("Mariola"));
        dogs.add(new Dog("Fafik"));
        System.out.println(dogs);

        Set<String> strings = new LinkedHashSet<>();
        strings.add("hehe");
        strings.add("ekstra not hehe");
        strings.add("not hehe");
        strings.add("super hehe");

        System.out.println(strings);
        for (int i = 0; i < strings.size(); i++){
            System.out.println(strings.toArray()[i]);
        }

        List<Integer> integerList = Arrays.asList(1,2,3,2,4,1,6,7,2, 14, 12, 10, 81, 41, 23, 4, 65);
        Set<Integer> hashSet = new HashSet<>(integerList);
        Set<Integer> linkedHashSet = new LinkedHashSet<>(integerList);
        Set<Integer> treeSet = new TreeSet<>(integerList);

        System.out.println("hashSet: " + hashSet);
        System.out.println("linkedHashSet: " + linkedHashSet);
        System.out.println("treeSet: " + treeSet);

        Set<Dog> anotherDogs = new TreeSet<>();
        anotherDogs.add(new Dog("Wojtek"));
        anotherDogs.add(new Dog("Karina"));
        anotherDogs.add(new Dog("Karina"));
        anotherDogs.add(new Dog("Michau"));
        anotherDogs.add(new Dog("Michau"));
        anotherDogs.add(new Dog("Barktek"));

        System.out.println(anotherDogs);
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        for (int i = 0 ; i < 100; i ++){
            navigableSet.add(i);
        }
        System.out.println("navigableSet.lower(50): " + navigableSet.lower(50));
        System.out.println("navigableSet.floor(50): " + navigableSet.floor(50));
        System.out.println("navigableSet.ceiling(90): " + navigableSet.ceiling(90));
        System.out.println("navigableSet.higher(90): " + navigableSet.higher(90));
        System.out.println("navigableSet.ceiling(100): " + navigableSet.ceiling(100));
        System.out.println("navigableSet.higher(100): " + navigableSet.higher(100));

        NavigableSet<Dog> navigableDogo = new TreeSet<>(anotherDogs);
        System.out.println(navigableDogo);
        System.out.println(navigableDogo.pollFirst());
        System.out.println(navigableDogo.lower(new Dog("Michau")));
        System.out.println(navigableDogo.lower(new Dog("Zbigniew")));


    }
    private static class Dog implements Comparable<Dog>{
        private final String name;
        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog: " + name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dog dog = (Dog) o;
            return Objects.equals(name, dog.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(Dog doggo) {
            return this.name.compareTo(doggo.name);
        }
    }
}
