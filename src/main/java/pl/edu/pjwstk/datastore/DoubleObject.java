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
public class DoubleObject extends SingleObject<Double> implements IDoubleObject {
    public DoubleObject( String name,Double value) {
        super(name,value);
    }

    public DoubleObject(IOID ioid, String name,Double value) {
        super(ioid,name,value);
    }

    @Override
    public String toString() {
        return "DoubleObject{" +
                "name="+getName()+
                ", value=" + getValue() +
                '}';
    }
}
