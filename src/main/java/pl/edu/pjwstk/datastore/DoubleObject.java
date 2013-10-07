package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IDoubleObject;
import edu.pjwstk.jps.datastore.IOID;

public class DoubleObject extends SingleObject<Double> implements IDoubleObject {
    public DoubleObject(String name, Double value) {
        super(name, value);
    }

    public DoubleObject(IOID ioid, String name, Double value) {
        super(ioid, name, value);
    }

    @Override
    public String toString() {
        return "DoubleObject{" +
                "name=" + getName() +
                ", value=" + getValue() +
                '}';
    }
}
