package basicweb;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamsTest {
	public void regular() {
		// count number of names starting with "A" in a list
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anh");
		names.add("Thanh");
		names.add("An Nam");
		int count = 0;
		for (String name : names) {
			if (name.startsWith("A")) {
				System.out.println(name);
				count++;
			}
		}

		// System.out.println(count);
		Assert.assertEquals(count, 2);
	}

	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anh");
		names.add("Thanh");
		names.add("An Nam");

//		System.out.println((names.stream().filter(s -> s.startsWith("A")).count()));
//		long count = names.stream().filter(s -> s.startsWith("A")).count();

		Stream<String> tems =Stream.of("Anh", "Thanh", "An Nam");
		long count = tems.filter(s->s.startsWith("A")).count();
//		tems.forEach(tem -> System.out.println(tem));
//		long count = tems.count();
//		Assert.assertEquals(count, 2);
		System.out.println(count);
		//print all names of ArrayList
		names.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));
	
	}

}
