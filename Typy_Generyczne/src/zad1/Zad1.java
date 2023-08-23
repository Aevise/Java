package zad1;

import java.util.ArrayList;
import java.util.List;


public class Zad1 {

    public static void main(String[] args) {
        List<?>[] test = new ArrayList[]{new ArrayList<>()};

        List<String> test2 = new ArrayList<>();
        test2.add("1");

//        System.out.println(method(test, test));
//        System.out.println(method(test2, test2));
        System.out.println(method(test, test2));
    }
//    public static<T extends List<?>> int method(List<? super T> arg1, List<? super T> arg2){
//        return 0;
//    }
    public static int method(List<?>[] arg1, List<?> arg2){
        return 0;
    }
}
//    Jak będzie wyglądał poniższy kod po dokonaniu Type Erasure?
//    public static<T extends List<T>> int method (T[] arg1, T arg2){
//        return 0;
//    }