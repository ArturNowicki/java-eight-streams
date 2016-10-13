package com.sda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Uzywajac do tej pory poznanych techinik.
 * Lista devevlopers zawiera 10 {@code Developer}. Twoim zadaniem jest uzyskanie
 * nastepujacych informacji. W nawasie przedstawiona jest oczekiwana forma danych:
 *  DONE STREAM Jakie jezyki znaja nasi Developerzy? (List<String>)
 *  DONE Ilu jest developerow? (int)
 *  DONE UGLY Pogrupuj developerow ze wzgledu na imiona (Map<String, List<Developer>);
 *  DONE STREAM Ile osob zna dana technologie? (Map<String, Integer>)
 *  - Ktory developer jest najstarszy? (Developer)
 *  - Ktory developer jest najmlodszy? (Developer)
 *  - Ktora technologia jest najpopularniejsza? (String)
 *
 */
public class DevelopersExercise {

	@Test
	public void testListOfTechnologies() {
		List<Developer> developers = this.createDevelopers();
		developers.stream()
		.flatMap(l -> l.getTechnologies().stream())
		.map(t -> t.toLowerCase())
		.distinct().sorted()
		.forEach(System.out::println);
	}
	
	@Test
	public void testNumberOfDevs() {
		List<Developer> developers = this.createDevelopers();
		System.out.println(developers.size());
	}
	
	@Test
	public void testGroupDevsByName() {
		List<Developer> developers = this.createDevelopers();
		Map<String, List<Developer>> devs = new HashMap<>();
		for(Developer dev : developers) {
			List<Developer> mergedList = devs.getOrDefault(dev.getName(), new ArrayList<Developer>());
			mergedList.add(dev);
			devs.put(dev.getName(), mergedList);
		}
		List<String> names = developers.stream()
				.map(d -> d.getName()).distinct()
				.collect(Collectors.toList());
		for(String name: names) {
			System.out.println(name + " " + devs.get(name).size());
		}
	}

	@Test
	public void howManyPeopleKnowsTech() {
		List<Developer> developers = this.createDevelopers();
		Map<String, Long> technologiesPopularity = developers.stream()
			.flatMap(dev -> dev.getTechnologies().stream())
			.map(tech -> tech.toLowerCase()).
			collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for(String tech : technologiesPopularity.keySet()) {
			System.out.println(tech + " " + technologiesPopularity.get(tech));
		}
		
	}
	
	public void developers() {
        List<Developer> developers = this.createDevelopers(); // Lista developerów
    }

    private List<Developer> createDevelopers() {
        List<Developer> developers = new ArrayList<Developer>();
        Developer one = new Developer("one", this.technologies("Java",
                        "Spring", "MySQL"), 20);
        Developer two = new Developer("intern", this.technologies("java",
                        "spring", "mysql"), 20);
        Developer three = new Developer("intern", this.technologies("Jenkins",
                        "linux"), 21);
        Developer four = new Developer("joke", this.technologies("php",
                        "javascript", "html"), 21);
        Developer five = new Developer("backend", this.technologies("Java",
                        "Scala", "Haskell", "SQL", "Algos"), 33);
        Developer six = new Developer("archaic", this.technologies("COBOL",
                        "LISP", "Assembler"), 1254);
        Developer seven = new Developer("hipster", this.technologies("Ruby",
                        "Rails", "MongoDB"), 29);
        Developer eight = new Developer("frontend", this.technologies(
                        "Angular2", "Javascript", "Ajax", "React"), 16);
        Developer nine = new Developer("devops", this.technologies("linux",
                        "ubuntu", "docker"), 20);
        Developer ten = new Developer("devops", this.technologies("puppet",
                        "jenkins", "consul", "microservices"), 24);
        developers.add(one);
        developers.add(two);
        developers.add(three);
        developers.add(four);
        developers.add(five);
        developers.add(six);
        developers.add(seven);
        developers.add(eight);
        developers.add(nine);
        developers.add(ten);
        return developers;
    }

    private List<String> technologies(String... langs) {
        return Arrays.asList(langs);
    }
}
