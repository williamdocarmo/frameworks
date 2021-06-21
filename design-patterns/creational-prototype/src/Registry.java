import java.util.HashMap;
import java.util.Map;

public class Registry {

	private Map<String, Item> items = new HashMap<String, Item>();

	public Registry() {
		loadItems();
	}

	public Item createItem(String type) {
		Item item = null;
		try {
			item = (Item) (items.get(type)).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return item;
	}

	private void loadItems() {
		Movie m = new Movie();
		m.setTitle("Star Wars");
		m.setPrice(100);
		m.setRuntime(150);

		Book b = new Book();
		b.setTitle("The HUngry Tides");
		b.setPrice(150);
		b.setNumberOfPages(300);

		items.put("Movie", m);
		items.put("Book", b);

	}

}
