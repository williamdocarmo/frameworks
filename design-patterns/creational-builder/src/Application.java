
public class Application {

	public static void main(String[] args) {
		SubscriberServiceBean.Builder builder = new SubscriberServiceBean.Builder();
		builder.voice("Enabled").sms("Provisioned").gprs("Suspended");
		SubscriberServiceBean bean = builder.build();
		System.out.println(bean);
	}

	private static void stringBuilderDemo() {
		StringBuilder builder = new StringBuilder();

		builder.append("This is a String Builder Example. ");
		builder.append("We can add any type of Object using it. ");
		builder.append("For example, boolean: ");
		builder.append(true);
		builder.append(" and Number: ");
		builder.append(13);

		System.out.println(builder.toString());
	}

}
