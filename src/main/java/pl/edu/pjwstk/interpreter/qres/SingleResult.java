package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.ISingleResult;

public class SingleResult extends AbstractQueryResult implements ISingleResult {

    protected SingleResult(IOID ioid) {
        super(ioid);
    }

    protected SingleResult() {
    }

}
