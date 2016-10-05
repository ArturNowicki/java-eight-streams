package com.sda;

import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class BasicStreamsTest {

    @Test
    public void oneTimeOnly() {
        List<Integer> ints = new ArrayList<Integer>();
        Stream<Integer> intsStream = ints.stream();
        List<Integer> collectedList =
                        intsStream.collect(Collectors.toList());
        try {
            List<Integer> againCollectedList =
                            intsStream.collect(Collectors.toList());
            fail();
        } catch (IllegalStateException ise) {
            System.out.println(ise);
        }
    }

    @Test
    public void basicReduction() {
        List<Integer> list = ListProvider.integerList(0, 100);
        int sumOne = list.stream()
            .reduce(
                0,
                (result, element) -> result + element
            );
        System.out.println(sumOne);
        int loudSum = list.stream()
               .reduce(0, (result, element) -> {
                   System.out.printf("Result at the begging is equal to %d\n", result);
                   System.out.printf("Now i am operating  on element with value of %d\n", element);
                   int sum = result + element;
                   System.out.printf("After finish calculating I got value: %d. It will become new result in next step\n", sum);
                   return sum;
               }
           );
    }

    @Test
    public void reducingToCollection() {
        List<Integer> ints = ListProvider.integerList(0, 50);
        List<Integer> doubled = ints.stream()
            .map(i -> i * 2)
            .reduce(
                new ArrayList<Integer>(),
                (list, element) -> {
                    list.add(element);
                    return list;
                },
                (previous, current) -> current
            );
        System.out.println(doubled);
        List<Integer> tripled = ints.stream()
            .map(i -> i * 3)
            .reduce(
                new ArrayList<Integer>(),
                (accumulatingList, element) -> {
                    System.out.println("Current value of list: " + accumulatingList);
                    System.out.println("Current element is: " + element);
                    accumulatingList.add(element);
                    return accumulatingList;
                },
                (partOne, partTwo) -> partOne // potrzebne tylko przy strumieniach rownoleglych
             );
        System.out.println(tripled);
    }

    @Test
    public void basicCollectors() {
        List<Integer> ints = ListProvider.integerList(0, 50);
        long count = ints.stream()
            .collect(Collectors.counting());
        System.out.println(count);

        List<Integer> toList = ints.stream()
            .collect(Collectors.toList());

        Set<Integer> toSet = ints.stream()
            .collect(Collectors.toSet());
        
        Map<Integer, Integer> mapSquares = ints.stream()
            .collect(Collectors.toMap(
                            e -> e, // mapowanie kluczy 
                            e -> e * e // mapowanie wartosci
                            ));
        System.out.println(mapSquares);
        
        String allValues = ints.stream()
            .map(e -> e.toString())
            .collect(Collectors.joining(","));
        System.out.println(allValues);
        
        Map<Integer, List<Integer>> grouped =
            ints.stream()
                .collect(Collectors.groupingBy(e -> e % 16));

        System.out.println(grouped);
    }
}
