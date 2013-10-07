package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISimpleObject;

public abstract class SingleObject<T> extends OIDAwareObject implements ISimpleObject<T> {

    private T value;

    protected SingleObject(String name, T value) {
        super(name);
        this.value = value;
    }

    protected SingleObject(IOID ioid, String name, T value) {
        super(ioid, name);
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}
