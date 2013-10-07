package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IDoubleResult;

public class DoubleResult extends AbstractResult<Double> implements IDoubleResult {
    public DoubleResult(Double value) {
        super(value);
    }
}
