package Students;

import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class xmlCreation {
    public void xmlCreation(String pathOut, Document document) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(pathOut));
        transformer.transform(domSource, streamResult);
        System.out.println("done xml creation");
    }
    public void xmlCreation1(String pathOut, Source domSource) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        StreamResult streamResult = new StreamResult(new File(pathOut));
        transformer.transform(domSource, streamResult);
        System.out.println("done xml1 creation");
    }

}

