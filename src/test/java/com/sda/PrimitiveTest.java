package com.sda;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import org.junit.Test;

public class PrimitiveTest {

    @Test
    public void show() {
        OptionalInt max = IntStream.range(0, 10).map(i -> i * 100).max();
        max.ifPresent(System.out::println);

        OptionalDouble average = DoubleStream.of(1.0d, 2.0d, 3.0d).average();

        IntStream.range(0, 10).min();
    }
}
