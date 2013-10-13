package pl.edu.pjwstk.datastore.util;

import edu.pjwstk.jps.datastore.ISBAObject;
import pl.edu.pjwstk.datastore.OIDAwareObject;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public interface ObjectPersister {
    public void persist(ISBAObject isbaObject);
}
