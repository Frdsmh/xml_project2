import Emploi.*;
import pdf.pdfCreation;
import net.sf.saxon.s9api.SaxonApiException;
import org.apache.fop.apps.FOPException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SaxonApiException, FOPException {

        String EpathOut = "C:\\Users\\Dell PC\\IdeaProjects\\notes_xml\\src\\db\\Emploi_Ginf2.xml";
        String EpathIn = "C:\\Users\\Dell PC\\IdeaProjects\\notes_xml\\src\\db\\Ginf2_Emploi.xml";
        String EmploiXquery = "C:\\Users\\Dell PC\\IdeaProjects\\notes_xml\\XMLUtils\\EmploiWeek.xquery";

        String EpathPdf = "C:\\Users\\Dell PC\\IdeaProjects\\notes_xml\\output\\EmploiWeek.pdf";
        String EpathXslt = "C:\\Users\\Dell PC\\IdeaProjects\\notes_xml\\XMLUtils\\Emploi.xsl";

        Emploi_XmlGenerate emp = new Emploi_XmlGenerate();
        emp.generateFile(EpathIn, new File(EmploiXquery), EpathOut, 1);
        //pdf emploi
        pdfCreation.createFile(EpathOut, EpathPdf, EpathXslt);
    }
}


