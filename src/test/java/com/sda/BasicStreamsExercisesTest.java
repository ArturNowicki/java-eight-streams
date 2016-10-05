package com.sda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class BasicStreamsExercisesTest {

    /**
     * Z1: Zadaniem jest uzupelnienie kody, a dokladniej metody reduce w taki sposob, by 
     * zwracala iloczyn elementow przekazanej listy.
     */
    @Test
    public void product() {
        List<Integer> intsOne = ListProvider.integerList(1, 10);
        int product = intsOne.stream()
            .reduce(
                null/*ZMIEN MNIE*/,
                null /*ZMIEN MNIE*/
            );
       assertEquals(3628800, product);
    }

    /**
     * Z2: Przy uzyciu strumienia oraz metody reduce oblicz sume dlugosci
     * Stringow zawartych w Liscie strings. Np ["test", "kot", "tata"] -> [4, 3,
     * 4] -> 11
     */
    @Test
    public void sumLength() {
        List<String> strings = new ArrayList<String>();
        strings.add("test");
        strings.add("a");
        strings.add("abc");
        strings.add("drogowka");
        strings.add("kocham strumienie");
        
        int sumOfLengths = 0; /* DO TEJ ZMIENNEJ PRZYPISZ WYNIK */
        assertEquals(33, sumOfLengths);
        
    }

    /**
     * Z3: Przy uzycia strumienia, metody filter() oraz reduce (trzy
     * argumentowego) ze wskazanej listy wybierz tylko elementy podzielne przez
     * 2, a nastepnie zbierz wyniki do Set<Integer>.
     * 
     * Jako ostatni argument w redukcji mozesz po prostu uzyc (a, b) -> a
     */
    @Test
    public void setReducing() {
        List<Integer> ints = ListProvider.integerList(0, 20);
        Set<Integer> evens = null; // TU PRZYPISZ WYNIK.
        
        Set<Integer> evenSet = new HashSet<Integer>();
        for (int i = 0; i < 20; i = i + 2)
            evenSet.add(i);

        assertThat(evens, is(evenSet));
    }

    /**
     * Z4: Majac liste stringow przefiltruj - wynik powinien odrzucic elementy
     * krotsze niz 4 znaki oraz dluzsze niz 8 znakow. Nastepnie stworz mape,
     * ktora jako wartosc bedzie miala elementy o tej samej dlugosci, a jako
     * klucz te dlugosc. Np ["a", "abcd", "abcdefgh", "abcdefghi"] -> ["abc",
     * "abcdefgh"] -> {4=["abcd"], 8=["abcdefgh"]}
     */
    @Test
    public void collectors() {
        final String loremIpsum ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
        + "Aenean mattis nibh in turpis vestibulum, nec accumsan tortor imperdiet. "
        + "Maecenas nec varius arcu. Aenean eu massa rutrum enim fringilla lobortis "
        + "ut eget lectus. In hac habitasse platea dictumst. Nunc vestibulum elit sed dictum "
        + "vulputate. Suspendisse convallis turpis non justo scelerisque, eget blandit dolor convallis. "
        + "Quisque pharetra tortor vel elementum ornare. Vestibulum ante ipsum primis in faucibus orci "
        + "luctus et ultrices posuere cubilia Curae; Cras ultrices leo vitae risus tincidunt, "
        + "eu bibendum ligula auctor. Vivamus malesuada, quam sit amet tincidunt porta, "
        + "leo ipsum malesuada arcu, ut hendrerit sapien sapien eu augue. "
        + "Vivamus vehicula odio eu fermentum mollis. Aenean tempus augue eget feugiat eleifend. "
        + "Mauris vehicula lectus vel arcu ultricies euismod. In hac habitasse platea dictumst. "
        + "Cras eget hendrerit nulla. Etiam vitae urna laoreet, scelerisque arcu non, vehicula arcu. "
        + "Praesent eget rhoncus mauris, sed ultrices dolor. Mauris eleifend rutrum elit, ac porttitor "
        + "ligula accumsan vel. Donec eget dolor vitae nisi facilisis sodales. Duis at fermentum sem, "
        + "vitae posuere quam. Sed varius pulvinar justo. Mauris iaculis, velit sit amet mollis congue, "
        + "diam tortor finibus est, in vestibulum libero lacus ac erat. Cras vehicula ornare nibh,"
        + " sed mattis nisi pretium id. Maecenas id lorem consequat.";

        Map<Integer, List<Integer>> lengthToWords = null;
    }
}
