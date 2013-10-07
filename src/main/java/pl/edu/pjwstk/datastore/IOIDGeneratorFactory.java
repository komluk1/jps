package pl.edu.pjwstk.datastore;


public class IOIDGeneratorFactory {
    private Class<? extends IOIDGenerator> ioidGeneratorClass;

    public IOIDGeneratorFactory(Class<? extends IOIDGenerator> ioidGeneratorClass) {
        this.ioidGeneratorClass = ioidGeneratorClass;
    }

    public final IOIDGenerator getIOIDGenerator() {

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
