package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
public class LongOID implements IOID, Comparable<LongOID>{

    private long identifier;

    public LongOID(long identifier) {
        this.identifier = identifier;
    }

    public long getIdentifier() {
        return identifier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongOID)) return false;

        LongOID longOID = (LongOID) o;

        if (identifier != longOID.identifier) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (identifier ^ (identifier >>> 32));
    }

    @Override
    public int compareTo(LongOID o) {
        return Long.compare(this.getIdentifier(),o.getIdentifier());
    }
}
