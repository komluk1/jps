package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IBooleanResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class BooleanResult extends AbstractResult<Boolean> implements IBooleanResult{
    public BooleanResult(Boolean value) {
        super(value);
    }
}
