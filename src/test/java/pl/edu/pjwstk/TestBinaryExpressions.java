package pl.edu.pjwstk;

import edu.pjwstk.jps.result.IAbstractQueryResult;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.ast.binary.*;
import pl.edu.pjwstk.ast.terminal.BooleanTerminal;
import pl.edu.pjwstk.ast.terminal.DoubleTerminal;
import pl.edu.pjwstk.ast.terminal.IntegerTerminal;
import pl.edu.pjwstk.ast.unary.*;
import pl.edu.pjwstk.datastore.SBAStore;
import pl.edu.pjwstk.interpreter.envs.ENVS;
import pl.edu.pjwstk.interpreter.envs.Interpreter;
import pl.edu.pjwstk.interpreter.qres.*;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class TestBinaryExpressions
        extends TestCase {

    private Interpreter interpreter = null;
    private SBAStore store = null;
    private QresStack stack = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestBinaryExpressions(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TestBinaryExpressions.class);
    }

    public void setUp() {
        URL url = getClass().getClassLoader().getResource("TestCw4_dane.xml");
        store = new SBAStore();
        store.loadXML(url.getPath());
        stack = new QresStack();
        interpreter = new Interpreter(stack, store, new ENVS());
    }

    public void testAndExpression() {
        AndExpression andExpression = new AndExpression(new BooleanTerminal(true), new BooleanTerminal(true));
        andExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        andExpression = new AndExpression(new BooleanTerminal(true), new BooleanTerminal(false));
        andExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testCloseByExpression() {
        CloseByExpression closeByExpression = new CloseByExpression(new BooleanTerminal(false), new IntegerTerminal(2));
        closeByExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BagResult);
    }

    public void testCommaExpression() {
        CommaExpression andExpression = new CommaExpression(new CommaExpression(new IntegerTerminal(1), new IntegerTerminal(2)), new DoubleTerminal(2.2));
        andExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BagResult);
        assertEquals(2, ((BagResult) result).getElements().size());
        assertTrue(((BagResult) result).getElements().iterator().next() instanceof StructResult);
    }

    public void testDivideExpression() {
        DivideExpression divideExpression = new DivideExpression(new IntegerTerminal(2), new IntegerTerminal(4));
        divideExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof IntegerResult);
        assertTrue(((IntegerResult) result).getValue() == 0);
        divideExpression = new DivideExpression(new IntegerTerminal(2), new DoubleTerminal(4.0));
        divideExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof DoubleResult);
        assertTrue(((DoubleResult) result).getValue() == 0.5);
    }

    public void testDotExpression() {
        DotExpression dotExpression = new DotExpression(new StructExpression(new IntegerTerminal(2)), new StructExpression(new IntegerTerminal(4)));
        dotExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BagResult);
        IAbstractQueryResult struct = ((BagResult) result).getElements().iterator().next();
        assertTrue(struct instanceof StructResult);
        IAbstractQueryResult intResult = ((StructResult) struct).elements().iterator().next();
        assertTrue(intResult instanceof IntegerResult);
        assertTrue(((IntegerResult) intResult).getValue() == 4);
    }

}
