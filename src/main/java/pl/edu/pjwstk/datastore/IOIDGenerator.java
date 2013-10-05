package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 23:17
 * To change this template use File | Settings | File Templates.
 */
public interface IOIDGenerator {
    IOID generateEntry();
    IOID generate();
}
