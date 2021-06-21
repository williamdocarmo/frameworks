
public class VisaStrategy extends ValidationStrategy {

	@Override
	public boolean isValid(CreditCard creditCard) {
		String number = creditCard.getNumber();
		String cvv = creditCard.getCvv();
		return (number.length() == 16 && cvv.length() == 3);
	}

}
