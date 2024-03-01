package JavaStreamsDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class Intro {

	// @Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");

		long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		// names.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
		names.stream().filter(s -> s.length() > 3).limit(1).forEach(s -> System.out.println(s));
	}

	// @Test
	public void mapFilter() {
		String[] names = { "Abhijeet", "Don", "Alekhya", "Adam", "ARama" };
		List<String> names1 = Arrays.asList(names);
		names1.stream().filter(s -> s.endsWith("a")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

	// @Test
	public void mergingStream() {

		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Virat");
		names1.add("Rohit");
		names1.add("Sachin");
		names1.add("Dravid");
		names1.add("Siraj");

		List<String> names3 = Arrays.asList("Abhijeet", "Don", "Alekhya", "Adam", "ARama");

		Stream<String> newstream = Streams.concat(names1.stream(), names3.stream());
		// .sorted().map(s->s.toUpperCase());

		// newstream.forEach(s->System.out.println(s));

		boolean flag = newstream.anyMatch(s -> s.equalsIgnoreCase("virat"));
		Assert.assertTrue(flag);

	}

	@Test
	public void NumberSort() {

		List<Integer> values = Arrays.asList(1, 2, 33, 44, 1, 2, 3, 21, 34, 13);
		// values.stream().distinct().sorted().forEach(s -> System.out.println(s)); //
		// printing unique number and sorted

		List<Integer> ls = values.stream().distinct().sorted().collect(Collectors.toList());// converting back into list
																							// and printing particular
																							// index value.
		System.out.println(ls.get(3));
	}
}
