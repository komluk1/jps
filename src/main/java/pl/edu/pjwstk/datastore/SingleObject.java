package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISimpleObject;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public abstract class SingleObject<T> extends OIDAwareObject implements ISimpleObject<T> {
    private T value;
    protected SingleObject( String name, T value) {
        super(name);
        this.value = value;
    }
    protected SingleObject(IOID ioid, String name, T value) {
        super(ioid,name);
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}
