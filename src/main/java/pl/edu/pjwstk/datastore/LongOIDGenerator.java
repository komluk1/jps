package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;

public class LongOIDGenerator implements IOIDGenerator {
    private static final long ENTRY_OID = 0l;
    private long last = ENTRY_OID;

    @Override
    public synchronized IOID entryOid() {
        return new LongOid(ENTRY_OID);
    }

    @Override
    public synchronized IOID generate() {

        return new LongOid(++last);
    }
}
