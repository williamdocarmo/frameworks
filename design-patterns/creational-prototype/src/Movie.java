
public class Movie extends Item {

	private int runtime;

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return "Movie [title=" + super.getTitle() + ", price=" + super.getPrice() + ", url=" + super.getUrl()
				+ ", runtime=" + runtime + "]";

	}

}
