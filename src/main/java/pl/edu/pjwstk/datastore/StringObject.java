package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.IStringObject;

public class StringObject extends SingleObject<String> implements IStringObject {
    public StringObject(String name, String value) {
        super(name, value);
    }

    public StringObject(IOID ioid, String name, String value) {
        super(ioid, name, value);
    }

    @Override
    public String toString() {
        return "StringObject{" +
                "name=" + getName() +
                ", value=" + getValue() +
                '}';
    }
}
