package pl.edu.pjwstk.datastore.util;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import pl.edu.pjwstk.datastore.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 */
public class XMLDataSourceParser implements DataSourceParser {
    private static Pattern INTEGER_PATTERN = Pattern.compile("([\\+-]?\\d+)([eE][\\+-]?\\d+)?");
    private static Pattern DOUBLE_PATTERN = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
    private static Pattern BOOLEAN_PATTERN = Pattern.compile("true|false", Pattern.CASE_INSENSITIVE);

    private ObjectPersister persister;

    public XMLDataSourceParser(ObjectPersister persister) {
        this.persister =persister;
    }

    @Override
    public ISBAObject parse(InputStream inputStream) throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(inputStream);
        return doSomething(document.getDocumentElement());
    }
    public  ISBAObject doSomething(Node node) {
        // do something with the current node instead of System.out
        String nodeName = node.getNodeName();
        ISBAObject toReturn = null;
        List<IOID> children = new ArrayList<IOID>();
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                ISBAObject object = doSomething(currentNode);
                children.add(object.getOID());
            } else if  (currentNode.getNodeType() == Node.TEXT_NODE){
                String val = currentNode.getTextContent();
                if (INTEGER_PATTERN.matcher(val).matches()) {
                    toReturn = new IntegerObject(nodeName, new Integer(val));
                } else if (DOUBLE_PATTERN.matcher(val).matches()) {
                    toReturn = new DoubleObject(nodeName, new Double(val));
                } else if (BOOLEAN_PATTERN.matcher(val).matches()) {
                    toReturn = new BooleanObject(nodeName, new Boolean(val));
                } else {
                    toReturn = new StringObject(nodeName, val);
                }
            }
            if(toReturn==null || !children.isEmpty()){

                toReturn= new ComplexObject(nodeName,children);
            }
        }


        persister.persist(toReturn);
        return toReturn;
    }

}
