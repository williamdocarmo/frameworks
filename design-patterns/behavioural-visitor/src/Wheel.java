
public class Wheel implements Part {

	@Override
	public void accept(PartVisitor visitor) {
		visitor.visit(this);
	}

}
