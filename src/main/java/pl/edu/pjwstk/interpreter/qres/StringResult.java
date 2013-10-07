package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IStringResult;

public class StringResult extends SimpleResult<String> implements IStringResult {

    protected StringResult(IOID ioid) {
        super(ioid);
    }

    protected StringResult(String value) {
        super(value);
    }

    protected StringResult(IOID ioid, String value) {
        super(ioid, value);
    }

    public String toString() {
        return "StringResult{" +
                "value=" + getValue() +
                '}';
    }
}