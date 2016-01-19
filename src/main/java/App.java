import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory fabrica = SAXParserFactory.newInstance();
        fabrica.setNamespaceAware(true);
        SAXParser parser = fabrica.newSAXParser();
        parser.parse(new File(App.class.getResource("lliga.xml").getFile()), new Processar());
    }
}
