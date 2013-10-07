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
public class IntegerObject extends SingleObject<Integer> implements IIntegerObject {
    public IntegerObject(String name,Integer value) {
        super(name,value);

    }
    public IntegerObject(IOID ioid,  String name,Integer value) {
        super(ioid,name,value);

    }

    @Override
    public String toString() {
        return "IntegerObject{" +
                "name="+getName()+
                ", value=" + getValue() +
                '}';
    }
}
