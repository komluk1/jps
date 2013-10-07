package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IAbstractQueryResult;

public abstract class AbstractQueryResult implements IAbstractQueryResult {

    private IOID oid;

    protected AbstractQueryResult() {
    }

    protected AbstractQueryResult(IOID oid) {
        this.oid = oid;
    }

    public IOID getOid() {
        return oid;
    }

    public void setOid(IOID oid) {
        this.oid = oid;
    }
}
