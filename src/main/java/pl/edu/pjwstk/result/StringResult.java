package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IStringResult;

public class StringResult extends AbstractResult<String> implements IStringResult {
    public StringResult(String value) {
        super(value);
    }
}
