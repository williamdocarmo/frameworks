import java.util.Calendar;

public class Application {

	public static void main(String[] args) {
		Website website = null;
		
		website = WebsiteFactory.getWebsite(WebsiteType.BLOG);
		website.createWebsite();
		System.out.println(website.getPages());
		
		website = WebsiteFactory.getWebsite(WebsiteType.BLOG);
		website.createWebsite();
		System.out.println(website.getPages());
	}

	private static void calendarDemo() {
		Calendar cal = Calendar.getInstance();

		System.out.println(cal);

		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
	}

}
