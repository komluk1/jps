package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IDoubleResult;

public class DoubleResult extends SimpleResult<Double> implements IDoubleResult {

    public DoubleResult(IOID ioid) {
        super(ioid);
    }

    public DoubleResult(Double value) {
        super(value);
    }

    public DoubleResult(IOID ioid, Double value) {
        super(ioid, value);
    }

    public String toString() {
        return "DoubleResult{" +
                "value=" + getValue() +
                '}';
    }
}
