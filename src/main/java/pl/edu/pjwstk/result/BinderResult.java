package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBinderResult;

public class BinderResult extends AbstractResult<IAbstractQueryResult> implements IBinderResult {
    private String name;

    public BinderResult(String name, IAbstractQueryResult value) {
        super(value);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
