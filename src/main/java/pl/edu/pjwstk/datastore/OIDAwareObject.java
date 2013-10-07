package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */


public abstract class OIDAwareObject implements ISBAObject {
    private String name;
    private IOID oid;

    protected OIDAwareObject(String name) {
        this.name = name;
    }

    protected OIDAwareObject(IOID oid, String name) {
        this.oid = oid;
        this.name = name;
    }



    @Override
    public String getName() {
        return name;  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected void setOID(IOID ioid){
        this.oid=ioid;
    }

    @Override
    public IOID getOID() {
        return oid;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
