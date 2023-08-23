package comparing;

import comparing.helper.Cat;

import java.util.*;

public class MyComparable {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "A", "l", "1", "B", "c", "aA", "Aa", "AA", "a1", "1a", "aa");
        System.out.println(strings);
        Collections.sort(strings);
//      najpierw ustawiane sa cyfry, a potem duze i male literki - domyslnie NaturalOrder
        System.out.println(strings);

        //Interfejs Comparator
//       Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
        System.out.println("\nInterfejs Comparator:");
        Comparator<String> comparator = Comparator.reverseOrder();
        Comparator<String> comparator2 = Comparator.<String>naturalOrder().reversed();
        List<String> strings2 = Arrays.asList("a", "A", "l", "1", "B", "c", "aA", "Aa", "AA", "a1", "1a", "aa");

        strings2.sort(comparator);
        System.out.println(strings2);
        strings2.sort(comparator2);
        System.out.println(strings2);
        //implementacja klasy anonimowej
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "Karol"));
        cats.add(new Cat(4, "Karol"));
        cats.add(new Cat(6, "Michał"));
        cats.add(new Cat(7, "Adam"));
        cats.add(new Cat(5, "Rafał"));
        cats.add(new Cat(2, "Stefan"));
        cats.add(new Cat(3, "Karol"));

        Comparator<Cat> comparingName = new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                return cat1.getName().compareTo(cat2.getName());
            }
        };
        Comparator<Cat> comparingNameLambda = (cat1, cat2) -> cat1.getName().compareTo(cat2.getName());
        Comparator<Cat> comparingNameLambda2 = Comparator.comparing((Cat cat) -> cat.getName()).reversed();
        Comparator<Cat> comparingNameLambda3 = Comparator.comparing(cat -> cat.getName());

        Comparator<Cat> chainCompare = comparingNameLambda.thenComparing((cat1, cat2) -> cat1.getId() - cat2.getId());
        Comparator<Cat> elegantChainCompare = Comparator.<Cat, String>comparing(cat1 -> cat1.getName())
                .thenComparing(cat -> cat.getId());

        Comparator<Cat> comparingID = new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                return cat1.getId() - cat2.getId();
            }
        };

//      taka sama funkcjonalność
        Comparator<Cat> comparatorImplementation = new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                int result =  cat1.getName().compareTo(cat2.getName());
                if(result != 0){
                    return result;
                }
                return cat1.getId() - cat2.getId();
            }

        }.thenComparing(new Comparator<Cat>() {
            @Override
            public int compare(Cat cat1, Cat cat2) {
                return cat1.getId() - cat2.getId();
            }

        });

        cats.sort(chainCompare);
        System.out.println(cats);




    }
}