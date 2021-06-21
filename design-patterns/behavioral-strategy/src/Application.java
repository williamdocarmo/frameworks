import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

	public static void main(String[] args) {

		CreditCard amexCard = new CreditCard(new AmexStrategy());
		amexCard.setNumber("123456789012345");
		amexCard.setCvv("1234");
		amexCard.setDate("0912");
		System.out.println("Is AMEX Card Valid: "+amexCard.isValid());
		
		CreditCard visaCard = new CreditCard(new VisaStrategy());
		visaCard.setNumber("1234567890123456");
		visaCard.setCvv("123");
		visaCard.setDate("0912");
		System.out.println("Is Visa Card Valid: "+visaCard.isValid());
	}

	private static void comparatorDemo() {
		List<Person> persons = Arrays.asList(new Person("Santanu", 31, "9903123499"),
				new Person("Taniya", 30, "9433876808"), new Person("Madhumita", 56, "8584003499"));

		// Sorting by age
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getAge() > o2.getAge())
					return 1;
				if (o1.getAge() < o2.getAge())
					return -1;
				return 0;
			}
		});
		System.out.println("Sorted: " + persons);
		
		// Sorting by name
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("Sorted: " + persons);

	}

}
