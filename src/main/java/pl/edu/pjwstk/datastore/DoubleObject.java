package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IBooleanObject;
import edu.pjwstk.jps.datastore.IDoubleObject;
import edu.pjwstk.jps.datastore.IOID;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class DoubleObject extends OIDAwareObject implements IDoubleObject {
    private Double value;

    public DoubleObject(IOID ioid, Double value, String name) {
        super(ioid,name);
        this.value = value;

    }

    @Override
    public Double getValue() {
        return value;
    }


}
