package zad5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Napisz generyczną metodę statyczną, która znajdzie maksymalną wartość w podanym przedziale
//wartości [start, end) w podanej liście. Elementy listy mogą być zarówno Integer, Long, Double oraz
//Float. Start oraz end również mogą być typu Integer, Long, Double oraz Float.
public class Zad5 {

    public static void main(String[] args) {
        List numbers = new ArrayList();
        numbers.add(3);
        numbers.add(1);
        numbers.add(6);
        numbers.add(2);
        numbers.add("not hehe");

        System.out.println(findHighestNumber(numbers, 2, 3));
    }
    public static<T extends Number> Number findHighestNumber(List<T> numbers, int start, int stop){
        Predicate<Integer> isOutOfBoundary = position -> position < 0 || position >= numbers.size();
        if (isOutOfBoundary.test(start) || isOutOfBoundary.test(stop)){
            throw new RuntimeException("Out of Boundary :(");
        }
        Number highestNumber = numbers.get(start);
        for (int i = start + 1; i <= stop; i++) {
            T number = numbers.get(i);
            if(number.doubleValue() > highestNumber.doubleValue()){
                highestNumber = number;
            }
        }
        return highestNumber;
    }
}
