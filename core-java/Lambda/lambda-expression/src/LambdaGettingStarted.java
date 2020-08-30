import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaGettingStarted {

	public static void main(String[] args) {
		LambdaGettingStarted gettingStarted = new LambdaGettingStarted();

		Executor lambdaCreateExecutor = () -> System.out.println("Created!");
		gettingStarted.performExecute(() -> System.out.println("Created!"));
		
		StringLengthLambda length = (s) -> s.length();
		
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		
		Predicate p;
		
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map((cost) -> cost*1.12).forEach(System.out::println);


	}
	
	void performExecute(Executor executor) {
		executor.execute();
	}

}

interface StringLengthLambda{
	public int getLength(String s);
}