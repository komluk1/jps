package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IIntegerResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class IntegerResult extends AbstractResult<Integer> implements IIntegerResult {
    public IntegerResult(Integer value) {
        super(value);
    }
}
