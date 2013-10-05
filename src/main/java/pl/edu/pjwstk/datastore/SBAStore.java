package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import org.apache.log4j.Logger;
import pl.edu.pjwstk.datastore.util.BeanToMap;
import pl.edu.pjwstk.datastore.util.XMLToMap;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class SBAStore implements ISBAStore {

    private static final Logger logger = Logger.getLogger(SBAStore.class);
    public static final String XML_ENTRY_POINT_NODE_NAME = "entry";

    private Map<IOID,ISBAObject> data = new TreeMap<IOID, ISBAObject>();
    private IOIDGenerator ioidGenerator =
            new IOIDGeneratorFactory(LongOIDGenerator.class).getIOIDGenerator();

    @Override
    public ISBAObject retrieve(IOID oid) {
        return data.get(oid);
    }

    @Override
    public IOID getEntryOID() {
        return ioidGenerator.generateEntry();
    }

    @Override
    public void loadXML(String filePath) {
        addObjectMap(XMLToMap.toMap(filePath),XML_ENTRY_POINT_NODE_NAME);

    }

    @Override
    public IOID generateUniqueOID() {
        return ioidGenerator.generate();
    }

    @Override
    public void addJavaObject(Object o, String objectName) {
        addJavaObjectGetId(o,objectName);
    }

    public IOID addJavaObjectGetId(Object o, String objectName) {
        IOID ioid = generateUniqueOID();
        ISBAObject isbaObject = null;
        if (o instanceof String){
            isbaObject = new StringObject(ioid,objectName,(String)o);
        } else if (o instanceof Byte){
            isbaObject = new IntegerObject(ioid,objectName,((Byte)o).intValue());
        } else if (o instanceof Character){
            isbaObject = new StringObject(ioid,objectName,((Character)o).toString());
        } else if (o instanceof Short){
            isbaObject = new IntegerObject(ioid,objectName,((Short)o).intValue());
        } else if (o instanceof Integer){
            isbaObject = new IntegerObject(ioid,objectName,(Integer)o);
        } else if (o instanceof Long){
            isbaObject = new IntegerObject(ioid,objectName,((Long)o).intValue());
        } else if (o instanceof Double){
            isbaObject = new DoubleObject(ioid,objectName,((Double)o));
        }  else if (o instanceof Float){
            isbaObject = new DoubleObject(ioid,objectName,((Float)o).doubleValue());
        } else if (o instanceof Collection) {
            isbaObject = getComplexObject(ioid,objectName,(Collection) o);
        }  else if (o instanceof Map){
            isbaObject = getComplexObject(ioid,objectName,(Map)o);
        }
        else {
            isbaObject = getComplexObject(ioid,objectName,getObjectAsFieldValuesMap(o));
        }
        data.put(ioid,isbaObject);
        return ioid;
    }

    @Override
    public void addJavaCollection(Collection o, String collectionName) {
        IOID ioid = generateUniqueOID();
        data.put(ioid,getComplexObject(ioid,collectionName,o));
    }

    protected ComplexObject getComplexObject(IOID ioid, String objectName, Collection o){
        Iterator<Object> objectsIterator = o.iterator();
        List<IOID> ioidList = new ArrayList<IOID>();
        while (objectsIterator.hasNext()){
            Object namedObject = objectsIterator.next();
            ioidList.add(addJavaObjectGetId(namedObject, null));
        }
        return  new ComplexObject(ioid,objectName,ioidList);
    }

    protected ComplexObject getComplexObject(IOID ioid, String objectName,Map<String,Object> map){
        List<IOID> ioids =  new ArrayList<IOID>();
        for (Map.Entry<String,Object> namedObject: map.entrySet()){
            ioids.add(addJavaObjectGetId(namedObject.getValue(), namedObject.getKey()));
        }
        return new ComplexObject(ioid,objectName,ioids);
    }

     protected void addObjectMap(Map<String,Object> map,String objectName){
         IOID ioid = ioidGenerator.generate();
         data.put(ioid,getComplexObject(ioid,objectName,map));
     }



     protected Map<String,Object>  getObjectAsFieldValuesMap(Object o){
         return BeanToMap.toMap(o);
    }


}
