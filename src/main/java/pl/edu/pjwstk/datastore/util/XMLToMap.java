package pl.edu.pjwstk.datastore.util;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;

import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class XMLToMap {

    private static Pattern INTEGER_PATTERN = Pattern.compile("([\\+-]?\\d+)([eE][\\+-]?\\d+)?");
    private static Pattern DOUBLE_PATTERN = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
    private static Pattern BOOLEAN_PATTERN = Pattern.compile("true|false", Pattern.CASE_INSENSITIVE);

    public static List<NamedObject> toNamedObjects(String filePath) {
        try {
            String xml = IOUtils.toString(new URL("file://" + filePath).openStream());
            xml = "<root>" + xml + "</root>";
            XMLSerializer xmlSerializer = new XMLSerializer();
            JSONObject object = JSONObject.fromObject(xmlSerializer.read(xml));
            List<NamedObject> out = toNamedObjects(object);
            return out;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static List<NamedObject> toNamedObjects(Map<String, Object> toParsed) {
        List<NamedObject> namedObjects = new ArrayList<NamedObject>();
        for (Map.Entry<String, Object> toParseEntry : toParsed.entrySet()) {
            if (toParseEntry.getValue() instanceof String) {
                String val = (String) toParseEntry.getValue();
                if (INTEGER_PATTERN.matcher(val).matches()) {
                    namedObjects.add(new NamedObject(toParseEntry.getKey(), new Long(val)));
                } else if (DOUBLE_PATTERN.matcher(val).matches()) {
                    namedObjects.add(new NamedObject(toParseEntry.getKey(), new Double(val)));
                } else if (BOOLEAN_PATTERN.matcher(val).matches()) {
                    namedObjects.add(new NamedObject(toParseEntry.getKey(), new Boolean(val)));
                } else {
                    namedObjects.add(new NamedObject(toParseEntry.getKey(), val));
                }
            } else if (toParseEntry.getValue() instanceof Map) {
                namedObjects.add(new NamedObject(toParseEntry.getKey(), toNamedObjects((Map) toParseEntry.getValue())));
            } else if (toParseEntry.getValue() instanceof Collection){
                for (Object o: ((Collection)toParseEntry.getValue())){
                    if (o instanceof Map){
                        namedObjects.add(new NamedObject(toParseEntry.getKey(), toNamedObjects((Map) o)));
                    }
                }

            }
        }
        return namedObjects;


    }
}
