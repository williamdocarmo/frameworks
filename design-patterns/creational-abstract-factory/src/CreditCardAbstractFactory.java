
public abstract class CreditCardAbstractFactory {

	public static CreditCardAbstractFactory getCreditCardAbstractFactory(int creditScore) {
		if (creditScore > 650) {
			return new AmexFactory();
		} else {
			return new VisaFactory();
		}
	}

	public abstract CreditCard getCreditCard(CardType cardType);

	public abstract Validator validator(CardType cardType);

}
