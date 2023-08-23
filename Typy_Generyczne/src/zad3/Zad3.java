package zad3;

//Napisz metodę generyczną, która zliczy ilość elementów w kolekcji, które mają w sobie coś
//charakterystycznego, np. liczby są nieparzyste, podane wyrazy są palindromami. Wykorzystaj
//predykat.

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Zad3 {
    public static void main(String[] args) {
        List<Integer> example = new ArrayList<>();
        example.add(2);
        List<String> test = new ArrayList<>();
        test.add("ada");
        test.add("Taco cat");
        test.add("nUN");
        test.add("Go deliver a dare vile dog");
        test.add("Go");

        System.out.println(numberOfEvenNumbers(example));
        System.out.println(numberOfPalindromes(test));
        System.out.println(numberOfPalindromes(example));
    }
    public static<T extends Number> int numberOfEvenNumbers(List<T> numbers){
        Predicate<Number> isEven = number -> number.intValue() % 2 == 0;
        return (int)numbers.stream().filter(isEven).count();
    }
    public static<T> int numberOfPalindromes(List<T> words){
        Predicate<String> isPalindrome = myWord -> {
            myWord = myWord.trim().replaceAll(" ", "").toLowerCase();
            int length = myWord.length();
            for (int i = 0; i < length/2; i++) {
                if(myWord.charAt(i) != myWord.charAt(length - 1 - i)){
                    return false;
                }
            }
            return true;
        };
        return (int)words
                .stream()
                .map(Object::toString)
                .filter(isPalindrome).count();
    }
}
