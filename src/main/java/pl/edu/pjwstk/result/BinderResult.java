package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBinderResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class BinderResult extends AbstractResult<IAbstractQueryResult> implements IBinderResult {
    private String name;

    public BinderResult(String name, IAbstractQueryResult value) {
        super(value);
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }
}
