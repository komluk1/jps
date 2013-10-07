package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IBooleanObject;
import edu.pjwstk.jps.datastore.IOID;

public class BooleanObject extends SingleObject<Boolean> implements IBooleanObject {
    protected BooleanObject(String name, Boolean value) {
        super(name, value);
    }

    public BooleanObject(IOID ioid, String name, Boolean value) {
        super(name, value);
    }

    @Override
    public String toString() {
        return "BooleanObject{" +
                "name=" + getName() +
                ", value=" + getValue() +
                '}';
    }
}
