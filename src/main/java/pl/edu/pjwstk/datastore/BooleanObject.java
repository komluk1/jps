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
public class BooleanObject extends SingleObject<Boolean> implements IBooleanObject {
    protected BooleanObject(String name,Boolean value) {
        super(name,value);
    }
    public BooleanObject(IOID ioid,  String name,Boolean value) {
        super(name,value);
    }

    @Override
    public String toString() {
        return "BooleanObject{" +
                "name="+getName()+
                ", value=" + getValue() +
                '}';
    }
}
