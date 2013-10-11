package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBinderResult;

public class BinderResult extends SingleResult implements IBinderResult {

    private String name;
    private IAbstractQueryResult value;

    public BinderResult(IOID ioid, String name, IAbstractQueryResult value) {
        super(ioid);
        this.name = name;
        this.value = value;
    }

    public BinderResult(String name, IAbstractQueryResult value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IAbstractQueryResult getValue() {
        return value;
    }

    public String toString() {
        return "BinderResult{" +
                "name=" + getName() +
                ", value=" + getValue() +
                '}';
    }
}
