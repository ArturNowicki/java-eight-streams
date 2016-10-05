package com.sda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class FlatMapTest {

    @Test
    public void basic() {
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        listOfLists.add(ListProvider.integerList(0, 5));
        listOfLists.add(ListProvider.integerList(1, 2));
        listOfLists.add(ListProvider.integerList(-5, 4));
        listOfLists.add(ListProvider.integerList(-10, 12));

        List<Integer> normalList = listOfLists.stream()
            .flatMap(e -> e.stream())
            .collect(Collectors.toList());

        System.out.println(normalList);
    }

}
