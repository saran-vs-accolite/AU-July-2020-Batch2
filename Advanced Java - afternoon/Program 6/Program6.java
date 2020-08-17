import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Program6 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("/home/saran/Desktop/Accolite_bootcamp/AU-July-2020-Batch2/Advanced Java - afternoon/employees.xml"));
            Element root = document.getDocumentElement();
            System.out.println("Root element :" + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("employee");
            System.out.println("----------------------------");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    System.out.println("Employee ID: " + element.getAttribute("id"));
                    System.out.println("Employee First Name: " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Employee Last Name: " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Employee Title: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Employee Division: " + element.getElementsByTagName("division").item(0).getTextContent());
                    System.out.println("Employee Building: " + element.getElementsByTagName("building").item(0).getTextContent());
                    System.out.println("Employee Room: " + element.getElementsByTagName("room").item(0).getTextContent());

                    System.out.println();
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
