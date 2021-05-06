
public class AmexStrategy extends ValidationStrategy {

	@Override
	public boolean isValid(CreditCard creditCard) {
		String number = creditCard.getNumber();
		String cvv = creditCard.getCvv();
		return (number.length() == 15 && cvv.length() == 4);
	}

}