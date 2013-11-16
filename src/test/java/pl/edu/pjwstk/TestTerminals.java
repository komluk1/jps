package pl.edu.pjwstk;

import edu.pjwstk.jps.result.IAbstractQueryResult;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.ast.terminal.*;
import pl.edu.pjwstk.datastore.SBAStore;
import pl.edu.pjwstk.interpreter.envs.ENVS;
import pl.edu.pjwstk.interpreter.envs.Interpreter;
import pl.edu.pjwstk.interpreter.qres.*;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class TestTerminals
    extends TestCase
{

    private Interpreter interpreter = null;
    private SBAStore store = null;
    private QresStack stack = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestTerminals(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestTerminals.class );
    }

    public void setUp(){
        URL url =  getClass().getClassLoader().getResource("TestCw4_dane.xml");
        store = new SBAStore();
        store.loadXML(url.getPath());
        stack = new QresStack();
        interpreter = new Interpreter(stack, store, new ENVS());
    }

    public void testBooleanTerminal(){
        BooleanTerminal booleanTerminal = new BooleanTerminal(true);
        booleanTerminal.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());
    }

    public void testIntegerTerminal(){
        IntegerTerminal integerTerminal = new IntegerTerminal(1);
        integerTerminal.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof IntegerResult);
        assertTrue(((IntegerResult) result).getValue() == 1);
    }

    public void testDoubleTerminal(){
        DoubleTerminal doubleTerminal = new DoubleTerminal(1.2);
        doubleTerminal.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof DoubleResult);
        assertTrue(((DoubleResult) result).getValue() == 1.2);
    }

    public void testNameTerminal(){
        NameTerminal nameTerminal = new NameTerminal("Jas");
        nameTerminal.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BinderResult);
        assertEquals(((BinderResult) result).getName(), "Jas");
    }

    public void testStringTermin(){
        StringTerminal stringTerminal = new StringTerminal("Jas2");
        stringTerminal.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof StringResult);
        assertEquals(((StringResult) result).getValue(), "Jas2");
    }

}
