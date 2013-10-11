package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;

public class LongOid implements IOID, Comparable<LongOid> {

    private long identifier;

    public LongOid(long identifier) {
        this.identifier = identifier;
    }

    public long getIdentifier() {
        return identifier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongOid)) return false;

        LongOid longOid = (LongOid) o;

        if (identifier != longOid.identifier) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (identifier ^ (identifier >>> 32));
    }

    @Override
    public int compareTo(LongOid o) {
        return Long.compare(this.getIdentifier(), o.getIdentifier());
    }

    @Override
    public String toString() {
        return Long.toString(identifier);
    }
}
