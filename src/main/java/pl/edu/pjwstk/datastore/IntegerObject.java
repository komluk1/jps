package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IDoubleObject;
import edu.pjwstk.jps.datastore.IIntegerObject;
import edu.pjwstk.jps.datastore.IOID;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class IntegerObject extends OIDAwareObject implements IIntegerObject {
    private Integer value;

    public IntegerObject(IOID ioid, Integer value, String name) {
        super(ioid,name);
        this.value = value;

    }

    @Override
    public Integer getValue() {
        return value;
    }


}
