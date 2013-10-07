package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.ISimpleResult;

public abstract class AbstractResult<T> implements ISimpleResult<T> {

    private T value;


    public AbstractResult(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }


}
