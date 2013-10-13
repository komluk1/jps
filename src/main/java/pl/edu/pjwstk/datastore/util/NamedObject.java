package pl.edu.pjwstk.datastore.util;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public class NamedObject {
    private String name;
    private Object object;

    public NamedObject(String name, Object object) {
        this.name = name;
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public Object getObject() {
        return object;
    }
}
