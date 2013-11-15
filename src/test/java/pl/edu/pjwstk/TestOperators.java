package pl.edu.pjwstk;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.datastore.SBAStore;
import pl.edu.pjwstk.interpreter.envs.ENVS;
import pl.edu.pjwstk.interpreter.envs.Interpreter;
import pl.edu.pjwstk.interpreter.qres.*;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class TestOperators
    extends TestCase
{

    private Interpreter interpreter = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestOperators(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestOperators.class );
    }

    public void setUp(){
        URL url =  getClass().getClassLoader().getResource("TestCw4_dane.xml");
        SBAStore sbaStore = new SBAStore();
        sbaStore.loadXML(url.getPath());
        interpreter = new Interpreter(new QresStack(), sbaStore, new ENVS());
    }


    public void testPlusOperator(){
    }

}
