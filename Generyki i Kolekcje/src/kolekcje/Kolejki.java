package kolekcje;

import java.util.*;

public class Kolejki {


    public static void main(String[] args) {
//        List<Integer> input = List.of(1,2,54,6,7,5,8);
        List<Integer> input = Arrays.asList(1,2,3,43,45,5,6);

        Queue<Integer> queue = new ArrayDeque<>(input);
        System.out.println(queue);
        queue.add(123);
        queue.offer(51);
        System.out.println(queue);

        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(number -> number));
        priorityQueue.offer(123);
        priorityQueue.add(23);
        priorityQueue.add(23);
        priorityQueue.add(233);
        priorityQueue.add(23);
        priorityQueue.add(2134);
        System.out.println(priorityQueue);

        for (Integer integer : priorityQueue) {
            System.out.println(integer);
        }
    }

    private static class Dog implements Comparable<Dog> {
        @Override
        public int compareTo(Dog o) {
            return this.name.compareTo(o.name);
        }

        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public void setName(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return " name: " + name;
        }

    }
}
