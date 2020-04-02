import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class SchemaValidator {

	public static void main(String[] args) throws SAXException, IOException {
		String[] files = new String[] {"correct-request.xml", "incorrect-request.xml"};
		Validator validator = validator(new String[] {"MobileService.xsd"});
			for (String file : files) {
				try{
					validator.validate(new StreamSource(new File(file)));
					System.out.println(file+ " Validated Successfully.");
				} catch(Exception e) {
					System.out.println(file+ " Failed With Error: "+e.getMessage());
				}
			}
	}

	public static Validator validator(String[] xsdPaths) throws SAXException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Source[] sources = new Source[xsdPaths.length];
		for (int i = 0; i < xsdPaths.length; i++) {
			sources[i] = new StreamSource(xsdPaths[i]);
		}
		Schema schema = factory.newSchema(sources);
		return schema.newValidator();
	}

}
