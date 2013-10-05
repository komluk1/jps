package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IBooleanObject;
import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IOID;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class ComplexObject  extends OIDAwareObject implements IComplexObject {
    private List<IOID> children;
    public ComplexObject(IOID ioid, String name,List<IOID> children) {
        super(ioid, name);
        this.children=children;
    }

    @Override
    public List<IOID> getChildOIDs() {
        return children;
    }


}
