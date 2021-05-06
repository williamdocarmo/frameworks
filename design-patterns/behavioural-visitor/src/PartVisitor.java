
public interface PartVisitor {

	public void visit(Wheel wheel);

	public void visit(Fender fender);

	public void visit(Oil oil);

	public void visit(PartsOrder partsOrder);
	

}
