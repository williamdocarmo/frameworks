
public class Application {

	public static void main(String[] args) {
		
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Design Patterns");
		
		System.out.println(movie);

	}

}
