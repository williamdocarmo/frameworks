
public class CreditCard {

	private String number;

	private String date;

	private String cvv;

	private ValidationStrategy strategy;

	public CreditCard() {
		super();
	}

	public CreditCard(String number, String date, String cvv) {
		super();
		this.number = number;
		this.date = date;
		this.cvv = cvv;
	}

	public CreditCard(String number, String date, String cvv, ValidationStrategy strategy) {
		super();
		this.number = number;
		this.date = date;
		this.cvv = cvv;
		this.strategy = strategy;
	}

	public CreditCard(ValidationStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	public String getCvv() {
		return cvv;
	}

	public String getDate() {
		return date;
	}

	public String getNumber() {
		return number;
	}

	public ValidationStrategy getStrategy() {
		return strategy;
	}

	public boolean isValid() {
		return strategy.isValid(this);
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setStrategy(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public String toString() {
		return "CreditCard [number=" + number + ", date=" + date + ", cvv=" + cvv + ", strategy=" + strategy + "]";
	}

}
