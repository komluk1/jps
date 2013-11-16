package pl.edu.pjwstk;

import edu.pjwstk.jps.result.IAbstractQueryResult;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.ast.auxname.AsExpression;
import pl.edu.pjwstk.ast.auxname.GroupAsExpression;
import pl.edu.pjwstk.ast.terminal.IntegerTerminal;
import pl.edu.pjwstk.datastore.SBAStore;
import pl.edu.pjwstk.interpreter.envs.ENVS;
import pl.edu.pjwstk.interpreter.envs.Interpreter;
import pl.edu.pjwstk.interpreter.qres.*;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class TestAuxiliaryExpressions
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
    public TestAuxiliaryExpressions(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestAuxiliaryExpressions.class );
    }

    public void setUp(){
        URL url =  getClass().getClassLoader().getResource("TestCw4_dane.xml");
        store = new SBAStore();
        store.loadXML(url.getPath());
        stack = new QresStack();
        interpreter = new Interpreter(stack, store, new ENVS());
    }

    public void testAsExpression(){
        AsExpression asExpression = new AsExpression("dwa", new IntegerTerminal(2));
        asExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BinderResult);
        assertTrue(((BinderResult) result).getValue() instanceof IntegerResult);
        assertTrue(((IntegerResult) ((BinderResult) result).getValue()).getValue() == 2);
        assertEquals(((BinderResult) result).getName(), "dwa");

        // TODO sprawdzić IBagResult oraz ISequenceResult
    }

    public void testGroupAsExpression(){
        GroupAsExpression groupAsExpression = new GroupAsExpression("dwa", new IntegerTerminal(2));
        groupAsExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BinderResult);
        assertTrue(((BinderResult) result).getValue() instanceof IntegerResult);
        assertTrue(((IntegerResult) ((BinderResult) result).getValue()).getValue() == 2);
        assertEquals(((BinderResult) result).getName(), "dwa");
    }

}
