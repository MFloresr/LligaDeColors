import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static String[] nombresFicheros = {"/lliga1.xml", "/lliga2.xml", "/lliga1.xml"};
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory fabrica = SAXParserFactory.newInstance();
        fabrica.setNamespaceAware(true);
        SAXParser parser = fabrica.newSAXParser();
        //parser.parse(new File(App.class.getResource("/lliga1.xml").getFile()), new Processar());
        for (String fichero : nombresFicheros)
            parser.parse(new File(App.class.getResource(fichero).getFile()), new Processar());
    }
}
