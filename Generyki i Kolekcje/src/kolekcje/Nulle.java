package kolekcje;

import java.util.*;

public class Nulle {
    public static void main(String[] args) {
//      Null Pointer Exceptions
        Map<String, Integer> treeMap = new TreeMap<>();
//        treeMap.put(null, 2);
        treeMap.put("1", null);

        Hashtable<Integer, String> hashtable = new Hashtable<>();
//        hashtable.put(null, "2");

        Set<Integer> treeSet = new TreeSet<>((o1, o2)->
        {
            if (o1 == null || o2 == null) {
                return 0;
            }
            return o1 - o2;
        });
//        treeSet.add(null);

        Queue<String> queue = new ArrayDeque<>();
//        queue.offer(null);

        Queue<String> queue2 = new PriorityQueue<>();
//        queue2.offer(null);


//      No Null Pointer Exception

    }


}
