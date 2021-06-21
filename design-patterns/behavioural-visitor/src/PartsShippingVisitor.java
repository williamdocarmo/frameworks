
public class PartsShippingVisitor implements PartVisitor {

	int shippingAmount = 0;

	@Override
	public void visit(Wheel wheel) {
		shippingAmount += 10;
		System.out.println("Wheel: 10");
	}

	@Override
	public void visit(Fender fender) {
		shippingAmount += 5;
		System.out.println("Fender: 5");
	}

	@Override
	public void visit(Oil oil) {
		shippingAmount += 6;
		System.out.println("Oil: 6");
	}

	@Override
	public void visit(PartsOrder partsOrder) {
		System.out.println("Inside Visit PartsOrder, Shipping Amount is: "+shippingAmount);

	}

}
