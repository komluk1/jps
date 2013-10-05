package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 TODO
 */
public class SBAStore implements ISBAStore {

    @Override
    public ISBAObject retrieve(IOID oid) {
        return null;
    }

    @Override
    public IOID getEntryOID() {
        return null;
    }

    @Override
    public void loadXML(String filePath) {

    }

    @Override
    public IOID generateUniqueOID() {
        return null;
    }

    @Override
    public void addJavaObject(Object o, String objectName) {

    }

    @Override
    public void addJavaCollection(Collection o, String collectionName) {

    }
}
