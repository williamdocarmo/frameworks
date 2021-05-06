import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartsOrder implements Part {

	private List<Part> parts = new ArrayList<Part>();

	public void addPart(Part part) {
		parts.add(part);
	}

	public List<Part> getParts() {
		return Collections.unmodifiableList(this.parts);
	}

	@Override
	public void accept(PartVisitor visitor) {
		for (Part part : parts) {
			part.accept(visitor);
		}
		visitor.visit(this);
	}

}
