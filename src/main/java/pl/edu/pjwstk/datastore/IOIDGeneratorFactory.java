package pl.edu.pjwstk.datastore;

import edu.pjwstk.jps.datastore.IOID;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 23:17
 * To change this template use File | Settings | File Templates.
 */
public class IOIDGeneratorFactory {
    private Class<? extends IOIDGenerator> ioidGeneratorClass;

    public IOIDGeneratorFactory(Class<? extends IOIDGenerator> ioidGeneratorClass) {
        this.ioidGeneratorClass = ioidGeneratorClass;
    }

    public final IOIDGenerator getIOIDGenerator(){

        try {
            return ioidGeneratorClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
