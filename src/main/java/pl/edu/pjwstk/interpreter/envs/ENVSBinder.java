package pl.edu.pjwstk.interpreter.envs;

import edu.pjwstk.jps.interpreter.envs.IENVSBinder;
import edu.pjwstk.jps.result.IAbstractQueryResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 09:34
 * To change this template use File | Settings | File Templates.
 */
public class ENVSBinder implements IENVSBinder {
    private String name;
    private IAbstractQueryResult value;

    public ENVSBinder(String name, IAbstractQueryResult value) {
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
}
