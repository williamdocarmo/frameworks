
public class Fender implements Part {

	@Override
	public void accept(PartVisitor visitor) {
		visitor.visit(this);
	}

}
