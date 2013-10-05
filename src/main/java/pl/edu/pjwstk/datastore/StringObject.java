package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IBooleanObject;
import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.IStringObject;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class StringObject extends OIDAwareObject implements IStringObject {
    private String value;

    public StringObject(IOID ioid, String value, String name) {
        super(ioid,name);
        this.value = value;

    }

    @Override
    public String getValue() {
        return value;
    }


}
