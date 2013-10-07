package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IReferenceResult;

public class ReferenceResult extends SingleResult implements IReferenceResult {

    protected ReferenceResult(IOID ioid) {
        super(ioid);
    }

    @Override
    public IOID getOIDValue() {
        return getOid();
    }

    public String toString() {
        return "ReferenceResult{" +
                "oid=" + getOid() +
                '}';
    }
}
