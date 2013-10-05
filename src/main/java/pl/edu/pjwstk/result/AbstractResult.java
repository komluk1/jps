package pl.edu.pjwstk.result;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.ISimpleResult;
import edu.pjwstk.jps.result.IAbstractQueryResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 22:05
 * To change this template use File | Settings | File Templates.
 */
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
