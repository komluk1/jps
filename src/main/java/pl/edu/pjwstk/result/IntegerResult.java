package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IIntegerResult;

public class IntegerResult extends AbstractResult<Integer> implements IIntegerResult {
    public IntegerResult(Integer value) {
        super(value);
    }
}
