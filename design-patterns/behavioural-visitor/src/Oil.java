
public class Oil implements Part {

	@Override
	public void accept(PartVisitor visitor) {
		visitor.visit(this);
	}

}
