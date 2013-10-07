package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IIntegerObject;
import edu.pjwstk.jps.datastore.IOID;

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
