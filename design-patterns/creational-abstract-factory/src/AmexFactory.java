
public class AmexFactory extends CreditCardAbstractFactory {

	@Override
	public CreditCard getCreditCard(CardType cardType) {
		switch (cardType) {
		case GOLD: {
			return new AmexGoldCreditCard();
		}
		case PLATINUM: {
			return new AmexPlatinumCreditCard();
		}
		default: {
			break;
		}
		}
		return null;
	}

	@Override
	public Validator validator(CardType cardType) {
		switch (cardType) {
		case GOLD: {
			return new AmexGoldValidator();
		}
		case PLATINUM: {
			return new AmexPlatinumValidator();
		}
		default: {
			break;
		}
		}
		return null;
	}

}
