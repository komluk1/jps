package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
public class OIDObject implements IOID {

    private long identifier;

    public OIDObject(long identifier) {
        this.identifier = identifier;
    }

    public long getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OIDObject)) return false;

        OIDObject oidObject = (OIDObject) o;

        if (identifier != oidObject.identifier) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (identifier ^ (identifier >>> 32));
    }
}
