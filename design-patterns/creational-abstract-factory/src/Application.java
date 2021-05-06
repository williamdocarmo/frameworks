
public class Application {
	
	public static void main(String[] args) {
		CreditCardAbstractFactory abstractFactory1 = CreditCardAbstractFactory.getCreditCardAbstractFactory(775);
		
		CreditCard card1 = abstractFactory1.getCreditCard(CardType.PLATINUM);
		
		System.out.println(card1.getClass());
		
		CreditCardAbstractFactory abstractFactory2 = CreditCardAbstractFactory.getCreditCardAbstractFactory(600);
		
		CreditCard card2 = abstractFactory2.getCreditCard(CardType.GOLD);
		
		System.out.println(card2.getClass());
		
	} 

}
