
public class Book extends Item {

	private int numberOfPages;

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Movie [title=" + super.getTitle() + ", price=" + super.getPrice() + ", url=" + super.getUrl()
				+ ", numberOfPages=" + numberOfPages + "]";
	}

}
