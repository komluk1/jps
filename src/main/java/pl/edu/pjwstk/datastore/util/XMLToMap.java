package pl.edu.pjwstk.datastore.util;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;
import pl.edu.pjwstk.datastore.DoubleObject;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 06.10.13
 * Time: 00:41
 * To change this template use File | Settings | File Templates.
 */
public class XMLToMap {

    private static Pattern INTEGER_PATTERN = Pattern.compile("([\\+-]?\\d+)([eE][\\+-]?\\d+)?");
    private static Pattern DOUBLE_PATTERN = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
    private static Pattern BOOLEAN_PATTERN = Pattern.compile("true|false",Pattern.CASE_INSENSITIVE);


    public static Map<String,Object> toMap(String filePath){
        try {
            String xml = IOUtils.toString(new URL("file://"+filePath).openStream());
            xml="<root>"+xml+"</root>";
            XMLSerializer xmlSerializer = new XMLSerializer();
            JSONObject object =  JSONObject.fromObject(xmlSerializer.read(xml));
            Map<String,Object> out = toParsedMap(object);
            return out;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static Map<String,Object> toParsedMap(Map<String,Object> toParsed){

        Map<String,Object> linkedHashMap = new LinkedHashMap<String, Object>();
        for (Map.Entry<String,Object> toParseEntry: toParsed.entrySet()){
            if (toParseEntry.getValue() instanceof String){
                String val = (String) toParseEntry.getValue();
                if (INTEGER_PATTERN.matcher(val).matches()){
                    linkedHashMap.put(toParseEntry.getKey(),new Long(val));
                } else if (DOUBLE_PATTERN.matcher(val).matches()){
                    linkedHashMap.put(toParseEntry.getKey(),new Double(val));
                } else if (BOOLEAN_PATTERN.matcher(val).matches()){
                    linkedHashMap.put(toParseEntry.getKey(),new Boolean(val));
                } else {
                    linkedHashMap.put(toParseEntry.getKey(),val);
                }
            } else if (toParseEntry.getValue() instanceof Map) {
                linkedHashMap.put(toParseEntry.getKey(),toParsedMap((Map)toParseEntry.getValue()));
            }
        }

        return linkedHashMap;


    }
}
