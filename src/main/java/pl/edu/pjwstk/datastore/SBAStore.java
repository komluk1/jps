package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import org.apache.log4j.Logger;
import pl.edu.pjwstk.datastore.util.BeanToMap;
import pl.edu.pjwstk.datastore.util.XMLToMap;
import java.util.*;

public class SBAStore implements ISBAStore {

    private static final Logger logger = Logger.getLogger(SBAStore.class);
    public static final String XML_ENTRY_POINT_NODE_NAME = "entry";

    private Map<IOID,ISBAObject> data = new LinkedHashMap<IOID, ISBAObject>();
    private IOIDGenerator ioidGenerator =
            new IOIDGeneratorFactory(LongOIDGenerator.class).getIOIDGenerator();

    @Override
    public ISBAObject retrieve(IOID oid) {
        return data.get(oid);
    }

    //TODO (?) czy na pewno o to chodzi
    @Override
    public IOID getEntryOID() {
        return ioidGenerator.generateEntry();
    }

    @Override
    public void loadXML(String filePath) {
        Map<String,Object> base = XMLToMap.toMap(filePath);
        for (Map.Entry<String,Object> baseEntry: base.entrySet()){
            if (baseEntry.getValue() instanceof  Map){
                addObjectMap((Map)baseEntry.getValue(),baseEntry.getKey());
            }
        }

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
        ISBAObject isbaObject = null;
        if (o instanceof String){
            isbaObject = new StringObject(objectName,(String)o);
        } else if (o instanceof Boolean){
            isbaObject = new BooleanObject(objectName,((Boolean)o));
        }  else if (o instanceof Byte){
            isbaObject = new IntegerObject(objectName,((Byte)o).intValue());
        } else if (o instanceof Character){
            isbaObject = new StringObject(objectName,((Character)o).toString());
        } else if (o instanceof Short){
            isbaObject = new IntegerObject(objectName,((Short)o).intValue());
        } else if (o instanceof Integer){
            isbaObject = new IntegerObject(objectName,(Integer)o);
        } else if (o instanceof Long){
            isbaObject = new IntegerObject(objectName,((Long)o).intValue());
        } else if (o instanceof Double){
            isbaObject = new DoubleObject(objectName,((Double)o));
        }  else if (o instanceof Float){
            isbaObject = new DoubleObject(objectName,((Float)o).doubleValue());
        } else if (o instanceof Collection) {
            isbaObject = getComplexObject(objectName,(Collection) o);
        }  else if (o instanceof Map){
            isbaObject = getComplexObject(objectName,(Map)o);
        }
        else {
            isbaObject = getComplexObject(objectName,getObjectAsFieldValuesMap(o));
        }
        persist((OIDAwareObject)isbaObject);
        return isbaObject.getOID();
    }

    @Override
    public void addJavaCollection(Collection o, String collectionName) {
        persist(getComplexObject(collectionName,o));
    }

    protected ComplexObject getComplexObject(String objectName, Collection o){
        Iterator<Object> objectsIterator = o.iterator();
        List<IOID> ioidList = new ArrayList<IOID>();
        while (objectsIterator.hasNext()){
            Object namedObject = objectsIterator.next();
            ioidList.add(addJavaObjectGetId(namedObject, null));
        }
        return  new ComplexObject(objectName,ioidList);
    }

    protected ComplexObject getComplexObject(String objectName,Map<String,Object> map){
        List<IOID> ioids =  new ArrayList<IOID>();
        for (Map.Entry<String,Object> namedObject: map.entrySet()){
            ioids.add(addJavaObjectGetId(namedObject.getValue(), namedObject.getKey()));
        }
        return new ComplexObject(objectName,ioids);
    }

     protected void addObjectMap(Map<String,Object> map,String objectName){
         persist(getComplexObject(objectName,map));
     }

    protected void persist(OIDAwareObject oidAwareObject){
        IOID ioid = ioidGenerator.generate();
        oidAwareObject.setOID(ioid);
        data.put(ioid,oidAwareObject);
    }



     protected Map<String,Object>  getObjectAsFieldValuesMap(Object o){
         return BeanToMap.toMap(o);
    }

    @Override
    public String toString() {
        String out ="";
        String separator = "";
        for (Map.Entry<IOID,ISBAObject> objects: data.entrySet()){
            out+=separator +"<i"+objects.getKey()+", "+objects.getValue().toString()+">";
            separator=System.lineSeparator();
        }
        return out;
    }
}
