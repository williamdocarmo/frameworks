
public class PartsDisplayVisitor implements PartVisitor {

	@Override
	public void visit(Wheel wheel) {
		System.out.println("Wheel Added");
	}

	@Override
	public void visit(Fender fender) {
		System.out.println("Fender Added");
	}

	@Override
	public void visit(Oil oil) {
		System.out.println("Oil Added");
	}

	@Override
	public void visit(PartsOrder partsOrder) {
		System.out.println("Order Created");
	}

}
