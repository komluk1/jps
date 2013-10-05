package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IStringResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class StringResult extends AbstractResult<String> implements IStringResult {
    public StringResult(String value) {
        super(value);
    }
}
