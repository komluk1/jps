package pl.edu.pjwstk.datastore.util;

import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public interface DataSourceParser {


    ISBAObject parse(InputStream inputStream)  throws Exception;
}
