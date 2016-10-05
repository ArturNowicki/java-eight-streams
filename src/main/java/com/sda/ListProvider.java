package com.sda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListProvider {
    
    public static List<Integer> integerList(int from, int upTo) {
        return IntStream.range(from, upTo)
            .boxed()
            .collect(Collectors.toList());
    }

}
