package pdf;

import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class pdfCreation {

    public static void createFile(String input, String output, String xsl) throws FOPException, TransformerException, FileNotFoundException {


        File xslFile = new File(xsl);
        StreamSource xmlSource = new StreamSource(new File(input));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent fOUserAgent = fopFactory.newFOUserAgent();
        try (OutputStream outputStream = new java.io.FileOutputStream(output)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, fOUserAgent, outputStream);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
            System.out.println("done pdf creation");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
