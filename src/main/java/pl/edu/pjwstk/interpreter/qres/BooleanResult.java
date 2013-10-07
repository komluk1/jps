package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IBooleanResult;

public class BooleanResult extends SimpleResult<Boolean> implements IBooleanResult {

    protected BooleanResult(IOID ioid) {
        super(ioid);
    }

    protected BooleanResult(Boolean value) {
        super(value);
    }

    protected BooleanResult(IOID ioid, Boolean value) {
        super(ioid, value);
    }

    public String toString() {
        return "BooleanResult{" +
                "value=" + getValue() +
                '}';
    }
}
