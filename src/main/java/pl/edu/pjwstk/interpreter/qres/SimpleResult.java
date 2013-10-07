package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.ISimpleResult;

public class SimpleResult<T> extends SingleResult implements ISimpleResult<T> {

    private T value;

    protected SimpleResult(IOID ioid){
        super(ioid);
    }

    protected SimpleResult(T value){
        this.value = value;
    }

    protected SimpleResult(IOID ioid, T value) {
        super(ioid);
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}
