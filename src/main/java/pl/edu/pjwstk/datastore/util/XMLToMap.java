package pl.edu.pjwstk.datastore.util;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 06.10.13
 * Time: 00:41
 * To change this template use File | Settings | File Templates.
 */
public class XMLToMap {
    public static Map<String,Object> toMap(String filePath){
        try {
            String xml = IOUtils.toString(new URL("file://"+filePath).openStream());
            XMLSerializer xmlSerializer = new XMLSerializer();
            return JSONObject.fromObject(xmlSerializer.read(xml));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
