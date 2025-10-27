package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEM = 100000;
    private static final int READ = 100;


    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=1000 ; i < 2000; i++ ) {
                num.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> num2 = new LinkedList<>(num);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int first = num.get(0);
        num.set(0, num.get(num.size()-1));
        num.set(num.size()-1,first);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(int i : num) {
            System.out.println(i + "|");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
         long time = System.nanoTime();
         for(int i = 0; i < ELEM; i++ ) {
         num.add(0, i);
        }
         time = System.nanoTime() - time;
         final var millis = TimeUnit.NANOSECONDS.toMillis(time);
         System.out.println("time required to add in an Arraylist is: " + num.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millis
                + "ms)");
         long time2 = System.nanoTime();
         for(int i = 0;i < ELEM; i++) {
            num2.add(i);
         }
         time2 = System.nanoTime() - time2;
         final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
          System.out.println("time required to add in a Linkedlist is: " + num2.size()
                + " ints to String and inserting them in a Set took "
                + time2
                + "ns ("
                + millis2
                + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long time3 = System.nanoTime();
        for(int i = 0; i < READ; i++ ) {
            num.get(num.size()/2);
        }
         time3 = System.nanoTime() - time3;
         final var millis3 = TimeUnit.NANOSECONDS.toMillis(time3);
         System.out.println("time required to read in an Arraylist is: " + num.size()
                + " ints to String and inserting them in a Set took "
                + time3
                + "ns ("
                + millis3
                + "ms)");
        
         long time4 = System.nanoTime();
        for(int i = 0; i < READ; i++ ) {
            num2.get(num.size()/2);
        }
         time4 = System.nanoTime() - time4;
         final var millis4 = TimeUnit.NANOSECONDS.toMillis(time4);
          System.out.println("time required to read in a Linkedlist is: " + num2.size()
                + " ints to String and inserting them in a Set took "
                + time4
                + "ns ("
                + millis4
                + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> map = new HashMap<>();
        map.put("Africa",1110635000L);
        map.put("Americas",972005000L);
        map.put("Antarctica",0L);
        map.put("Asia",4298723000L);
        map.put("Europe",742452000L);
        map.put("Oceania",38304000L);

        /*
         * 8) Compute the population of the world
         */
        long sum =0;
        for(final Long l : map.values()) {
            sum +=l;
        }
        System.out.println("the population of whole world is : " + sum);
    }
}
