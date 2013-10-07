package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IOID;

import java.util.List;

public class ComplexObject extends OIDAwareObject implements IComplexObject {
    private List<IOID> children;

    public ComplexObject(String name, List<IOID> children) {
        super(name);
        this.children = children;
    }

    public ComplexObject(IOID ioid, String name, List<IOID> children) {
        super(ioid, name);
        this.children = children;
    }

    @Override
    public List<IOID> getChildOIDs() {
        return children;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "name=" + getName() +
                ", ids=" + children +
                '}';
    }
}
