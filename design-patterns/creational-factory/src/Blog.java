
public class Blog extends Website {

	@Override
	public void createWebsite() {
		pages.add(new ContactPage());
		pages.add(new ContentPage());
	}

}
