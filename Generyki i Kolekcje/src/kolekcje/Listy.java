package kolekcje;

import java.util.*;

public class Listy {


    public static void main(String[] args) {
        List<String> stringList1 = Arrays.asList("a", "b", "c");                            //jest immutable
//        List<String> stringList2 = List.of("a", "b", "c"); - nie dostępnie w Javie 8      //jest immutable
        List<String> stringList3 = Collections.singletonList("a");                          //jest immutable
        List<String> stringList4 = Collections.emptyList();                                 //jest immutable
        List<String> stringList5 = new LinkedList<>();
        List<String> stringList6 = new ArrayList<>();

        System.out.println(stringList6);
        stringList6.add("hehe");
        stringList6.add("hehe2");
        stringList6.add(1,"not hehe");
        stringList6.add("not hehe");
        System.out.println(stringList6 + " " + stringList6.lastIndexOf("not hehe"));

    }
}
