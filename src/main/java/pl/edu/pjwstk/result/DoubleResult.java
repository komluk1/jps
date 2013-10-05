package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IBooleanResult;
import edu.pjwstk.jps.result.IDoubleResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class DoubleResult extends AbstractResult<Double> implements IDoubleResult{
    public DoubleResult(Double value) {
        super(value);
    }
}
