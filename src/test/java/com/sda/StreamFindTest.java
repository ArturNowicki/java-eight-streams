package com.sda;

import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class StreamFindTest {

    @Test
    public void test() {
        List<Integer> ints = ListProvider.integerList(10, 20);
        Optional<Integer> headOption = ints.stream().findFirst();
        System.out.println(headOption);

        ints.stream()
            .filter(n -> n % 3 == 0)
            .findFirst()
            .ifPresent(System.out::println);

        boolean allEven = ints.stream().allMatch(n -> n % 2 == 0);
        System.out.println(allEven);

        boolean anyEven = ints.stream().anyMatch(n -> n % 2 == 0);
        System.out.println(anyEven);

        boolean smallerThanHundred = ints.stream().noneMatch(n -> n > 100);
        System.out.println(smallerThanHundred);
    }
}
