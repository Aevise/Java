package zadania.projekt;

import zadania.kolekcje.Zad2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(new PriorityQueue<>());
        shop.addPerson(new Osoba("Tomasz", "Zera", false));
        shop.addPerson(new Osoba("Tomasz", "Zera", false));
        shop.addPerson(new Osoba("Tomasz", "Zera", true));
        shop.addPerson(new Osoba("Tomasz", "Zera", false));
        System.out.println(shop);
        shop.leaveQueue("Tomasz", "Zera", 4);
//        shop.addPerson(new Osoba("Tomasz", "Zera", false));
//        shop.addPerson(new Osoba("Tomasz", "Zera", false));
//        shop.addPerson(new Osoba("Tomasz", "Zera", false));
//        shop.addPerson(new Osoba("Fabian", "Zera", true));
//        shop.addPerson(new Osoba("Krystyna", "Zera", false));
//        shop.addPerson(new Osoba("Morda", "Zera", false));
//        shop.addPerson(new Osoba("Merda", "Zera", false));
//
//        System.out.println(shop);
//        shop.processQueue();
//        System.out.println(shop);
//
//        shop.addPerson(new Osoba("Radoslaw", "Jedruszczak", true));
//        shop.addPerson(new Osoba("Radoslaw", "Jedruszczak", true));
//        shop.addPerson(new Osoba("Radoslaw", "Jedruszczak", true));

        System.out.println(shop);

    }
}
