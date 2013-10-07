package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IIntegerResult;

public class IntegerResult extends SimpleResult<Integer> implements IIntegerResult {

    protected IntegerResult(IOID ioid) {
        super(ioid);
    }

    protected IntegerResult(Integer value) {
        super(value);
    }

    protected IntegerResult(IOID ioid, Integer value) {
        super(ioid, value);
    }

    public String toString() {
        return "IntegerResult{" +
                "value=" + getValue() +
                '}';
    }
}
