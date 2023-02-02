package Emploi;

import net.sf.saxon.s9api.*;
import org.w3c.dom.Document;
import Students.*;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class Emploi_XmlGenerate {
    public void generateFile(String xmlFile, File xqueryFile, String outputPath,int sem) throws IOException, SaxonApiException {
        try {
            // the Saxon processor object
            Processor saxon = new Processor(false);
            // compile the query
            XQueryCompiler compiler = saxon.newXQueryCompiler();
            XQueryExecutable exec = compiler.compile(xqueryFile);

            // parse the string as a document node
            DocumentBuilder builder = saxon.newDocumentBuilder();

            InputStream inputStream = new FileInputStream(xmlFile);
            Source src = new StreamSource(inputStream);
            XdmNode doc = builder.build(src);
            // instantiate the query, bind the input and evaluate
            XQueryEvaluator query = exec.load();
            query.setContextItem(doc);
            query.setExternalVariable(new QName("numero"),new XdmAtomicValue(sem+""));
            XdmValue result = query.evaluate();
            try {
                XdmNode domSource = (XdmNode) result;
                xmlCreation EmploiXml = new xmlCreation();
                EmploiXml.xmlCreation1(outputPath,domSource.asSource());
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }

        } catch (SaxonApiException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}