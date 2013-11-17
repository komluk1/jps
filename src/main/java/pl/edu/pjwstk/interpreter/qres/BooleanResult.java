package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IBooleanResult;

public class BooleanResult extends SimpleResult<Boolean> implements IBooleanResult {

    public BooleanResult(IOID ioid) {
        super(ioid);
    }

    public BooleanResult(Boolean value) {
        super(value);
    }

    public BooleanResult(IOID ioid, Boolean value) {
        super(ioid, value);
    }

    public String toString() {
        return "BooleanResult{" +
                "value=" + getValue() +
                '}';
    }

    public boolean equals(Object o) {
        return o == this || o instanceof BooleanResult && (((BooleanResult) o).getValue().equals(this.getValue()));
    }
}
