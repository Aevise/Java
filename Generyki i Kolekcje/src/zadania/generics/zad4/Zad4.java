package zadania.generics.zad4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Napisz metodę generyczną, która w podanej tablicy będzie w stanie zamienić ze sobą elementy na
//dwóch podanych pozycjach.

@SuppressWarnings({"rawtypes", "unchecked"})
public class Zad4 {

    public static void main(String[] args) {
        Zad4 test = new Zad4();
        List tester = new ArrayList();
        tester.add("gmmm");
        tester.add(23);
        tester.add("hehe");
        tester.add("not hehe");

        System.out.println(tester);
        test.swapElements(tester, 1,3);
        System.out.println(tester);
//        test.swapElements(tester, -23, 4326);

        Integer[] tester2 = new Integer[]{1,2,3,4,5,6};
        for (Integer integer : tester2) {
            System.out.print(integer + " ");
        }
        test.swapElements(tester2, 0, 3);
        for (Integer integer : tester2) {
            System.out.print(integer + " ");
        }


    }

    public <T> void swapElements(List<T> array, int position1, int position2){
        Predicate<Integer> isOutOfBoundary = position -> position < 0 || position >= array.size();
        if(isOutOfBoundary.test(position1) || isOutOfBoundary.test(position2)){
            throw new RuntimeException(" Out of boundary");
        }
        T storage = array.get(position2);
        array.set(position2, array.get(position1));
        array.set(position1, storage);
    }

    public <T> void swapElements(T[] array, int position1, int position2){
        Predicate<Integer> isOutOfBoundary = position -> position < 0 || position >= array.length;
        if(isOutOfBoundary.test(position1) || isOutOfBoundary.test(position2)){
            throw new RuntimeException(" Out of boundary");
        }
        T storage = array[position2];
        array[position2] = array[position1];
        array[position1] =  storage;
    }
}
