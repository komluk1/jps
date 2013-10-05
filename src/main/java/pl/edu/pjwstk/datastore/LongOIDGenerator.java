package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
public class LongOIDGenerator implements IOIDGenerator{
    private static final long ENTRY_OID = 0l;
    private  long last =ENTRY_OID;

    @Override
    public synchronized IOID generateEntry(){
        return new LongOID(ENTRY_OID);
    }
    @Override
    public synchronized IOID generate() {

        return new LongOID(++last);
    }
}
