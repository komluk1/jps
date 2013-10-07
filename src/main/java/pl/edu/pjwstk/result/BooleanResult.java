package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IBooleanResult;

public class BooleanResult extends AbstractResult<Boolean> implements IBooleanResult {
    public BooleanResult(Boolean value) {
        super(value);
    }
}
