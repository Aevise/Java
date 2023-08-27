package zadania.kolekcje;

import java.util.*;
/*Napisz implementację książki telefonicznej, która umożliwi wprowadzenie przez użytkownika osoby
wraz z numerem telefonu, w sposób pokazany poniżej:
• Jan Kowalski +48000192871
• Stefan Nawrocki +48000125847
• Anna Tomaszewska +48000421458
Dodaj te osoby do Mapy w taki sposób, żeby kluczem było nazwisko, a wartością zbiór osób
występujących pod takim nazwiskiem, posortowanych w kolejności nazwisko, a potem imię. Po każdej
dodanej osobie, wyświetl zawartość mapy na ekranie. Spraw, żeby osoby były posortowane w książce po
nazwisku. Dla uproszczenia załóż, że osoby mogą mieć tylko jedno imię i tylko jedno nazwisko.
*/
public class Zad2 {
    public static void main(String[] args) {
        Map<String, List<Person>> TelephoneBook = new TreeMap<>();
        Comparator<Person> sortBySurnameAscending = (p1, p2) -> p1.getSurname().compareTo(p2.getSurname());
        Comparator<Person> sortByNameAscending = Comparator.comparing(person -> person.getName());
        Comparator<Person> chainSort = sortBySurnameAscending.thenComparing(sortByNameAscending);


        Person person1 = new Person("Tomasz", "Jedras", "32451234523");
        Person person2 = new Person("Tomasz", "Wojtas", "32451234523");
        Person person3 = new Person("Tomasz", "Miron", "32451234523");
        Person person4 = new Person("Wojtas", "Miron", "32451234523");
        Person person5 = new Person("Radek", "Jedras", "32451234523");
        Person person6 = new Person("Marian", "Zera", "32451234523");
        Person person7 = new Person("Krysia", "Zera", "32451234523");
        Person person8 = new Person("Mateusz", "Baran", "32451234523");
        Person person9 = new Person("Damian", "Adamek", "32451234523");
        Person person10 = new Person("Bartosz", "Adamek", "32451234523");
        Person person11 = new Person("Wojtas", "Maron", "32451234523");
        Person person12 = new Person("Adam", "Jedras", "32451234523");
        Person person13 = new Person("Zbyszek", "Jedras", "32451234523");

        addPerson(TelephoneBook, person1, chainSort);
        addPerson(TelephoneBook, person2, chainSort);
        addPerson(TelephoneBook, person3, chainSort);
        addPerson(TelephoneBook, person4, chainSort);
        addPerson(TelephoneBook, person5, chainSort);
        addPerson(TelephoneBook, person6, chainSort);
        addPerson(TelephoneBook, person7, chainSort);
        addPerson(TelephoneBook, person8, chainSort);
        addPerson(TelephoneBook, person9, chainSort);
        addPerson(TelephoneBook, person10, chainSort);
        addPerson(TelephoneBook, person11, chainSort);
        addPerson(TelephoneBook, person12, chainSort);
        addPerson(TelephoneBook, person13, chainSort);


    }

    public static void addPerson(Map<String, List<Person>> book, Person person, Comparator<Person> sortBy) {
        String surname = person.getSurname();
        if (book.containsKey(surname)) {
            List<Person> existingList = book.get(surname);
            existingList.add(person);
            existingList.sort(sortBy);
        } else {
            List<Person> newList = new ArrayList<>();
            newList.add(person);
            book.put(surname, newList);
        }
        System.out.println(book);
    }

    public static class Person implements Comparable<Person> {
        private final String name;
        private final String surname;
        private final String number;

        public Person(String name, String surname, String number) {
            if (number.trim().matches("[0-9]{11}")) {
                this.number = "+" + number;
            } else {
                throw new IllegalArgumentException("Please provide correct number");
            }
            this.name = name.trim();
            this.surname = surname.trim();
        }

        @Override
        public int compareTo(Person person) {
            int result = this.surname.compareTo(person.surname);
            if (result != 0) {
                return result;
            }
            return this.name.compareTo(person.name);
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return surname + ' ' + name + ' ' + number;
        }
    }
}
