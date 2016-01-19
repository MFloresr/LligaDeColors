import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class App {
    private static String[] nombresFicheros = { "lliga-1.xml", "lliga-2.xml", "lliga-1.xml"};
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory fabrica = SAXParserFactory.newInstance();
        fabrica.setNamespaceAware(true);
        SAXParser parser = fabrica.newSAXParser();
        for (String fichero : nombresFicheros)
            parser.parse(new File(App.class.getResource(fichero).getFile()), new Processar());
    }
}
