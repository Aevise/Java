package kolekcje;

import java.util.*;

public class Mapy {

    public static void main(String[] args) {

        Map<String, String> someMap = new HashMap<>();
        someMap.put("1", "ABC");
        someMap.put("2", "BC");
        someMap.put("3", "C");
        System.out.println(someMap);

        Map<Dog2, String> dogStringMap = new HashMap<>();
        dogStringMap.put(new Dog2("Romek"), "hehe");
        dogStringMap.put(new Dog2("Wojtek"), "not hehe");
        dogStringMap.put(new Dog2("Zbyszek"), "hehe xDD");
        dogStringMap.put(new Dog2("Wojtek"), "hehe");

        System.out.println(dogStringMap);


        Dog2 romek = new Dog2("Romek");
        Dog2 wojtek1 = new Dog2("Wojtek");
        Dog2 zbyszek = new Dog2("Zbyszek");
        Dog2 wojtek2 = new Dog2("Wojtek");

        Map<Dog2, String> dogStringMap2 = new HashMap<>();
        dogStringMap2.put(romek, "hehe");
        dogStringMap2.put(wojtek1, "not hehe");
        dogStringMap2.put(zbyszek, "hehe xDD");
        dogStringMap2.put(wojtek2, "hehe");

        System.out.println(dogStringMap2);
        //ponizszy kod wyswietli to samo. Wyswietlona zostanie nadpisana wartość, czyli w tym przypadku hehe zamiast not hehe
        System.out.println(dogStringMap2.get(wojtek1));
        System.out.println(dogStringMap2.get(wojtek2));

        wojtek1.setName("Wojtek1");
        System.out.println(dogStringMap2.get(wojtek1));
        System.out.println(dogStringMap2.get(wojtek2));

        wojtek2.setName("hehe");
        System.out.println(dogStringMap2.get(wojtek1));
        System.out.println(dogStringMap2.get(wojtek2));

        //-----------------------------Linked Hash Map ------------------------------
        Map<Dog2, Integer> someMap2 = new LinkedHashMap<>();
        someMap2.put(new Dog2("a"), 1);
        someMap2.put(new Dog2("g"), 4);
        someMap2.put(new Dog2("d"), 5);
        someMap2.put(new Dog2("b"), 2);
        someMap2.put(new Dog2("c"), 151);

        System.out.println(someMap2);


        //--------------------------Tree Map ----------------------------------
        Map<Dog2, String> treeMap = new TreeMap<>();
        treeMap.put(new Dog2("a"), "1");
        treeMap.put(new Dog2("g"), "4");
        treeMap.put(new Dog2("d"), "5");
        treeMap.put(new Dog2("b"), "2");
        treeMap.put(new Dog2("c"), "151");

        System.out.println(treeMap);

        for (Map.Entry<Dog2, String> entry : treeMap.entrySet()){
            System.out.println(entry);
        }


    }

    private static class Dog2 implements Comparable<Dog2> {
        @Override
        public int compareTo(Dog2 o) {
            return this.name.compareTo(o.name);
        }

        private String name;

        public Dog2(String name) {
            this.name = name;
        }

        public void setName(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return " name: " + name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dog2 dog2 = (Dog2) o;
            return name.equals(dog2.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
