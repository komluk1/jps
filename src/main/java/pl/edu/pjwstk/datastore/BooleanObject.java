package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IBooleanObject;
import edu.pjwstk.jps.datastore.IOID;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class BooleanObject extends OIDAwareObject implements IBooleanObject {
    private Boolean value;

    public BooleanObject(IOID ioid, Boolean value, String name) {
        super(ioid,name);
        this.value = value;

    }

    @Override
    public Boolean getValue() {
        return value;
    }


}
