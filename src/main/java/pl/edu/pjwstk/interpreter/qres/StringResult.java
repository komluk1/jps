package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IStringResult;

public class StringResult extends SimpleResult<String> implements IStringResult {

    public StringResult(IOID ioid) {
        super(ioid);
    }

    public StringResult(String value) {
        super(value);
    }

    public StringResult(IOID ioid, String value) {
        super(ioid, value);
    }

    public String toString() {
        return "StringResult{" +
                "value=" + getValue() +
                '}';
    }
}