package pl.edu.pjwstk;

import edu.pjwstk.jps.result.IAbstractQueryResult;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.ast.binary.CommaExpression;
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
public class TestUnaryExpressions
        extends TestCase {

    private Interpreter interpreter = null;
    private SBAStore store = null;
    private QresStack stack = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestUnaryExpressions(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TestUnaryExpressions.class);
    }

    public void setUp() {
        URL url = getClass().getClassLoader().getResource("TestCw4_dane.xml");
        store = new SBAStore();
        store.loadXML(url.getPath());
        stack = new QresStack();
        interpreter = new Interpreter(stack, store, new ENVS());
    }

    public void testAvgExpression() {
        AvgExpression avgExpression = new AvgExpression(new BagExpression(new CommaExpression(new DoubleTerminal(2.2), new IntegerTerminal(4))));
        avgExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof DoubleResult);
        assertTrue(((DoubleResult) result).getValue() == 3.1);
    }

    public void testBagExpression() {
        BagExpression bagExpression = new BagExpression(new CommaExpression(new DoubleTerminal(2.2), new IntegerTerminal(4)));
        bagExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BagResult);
        assertTrue(((BagResult) result).getElements().size() == 2);
    }

    public void testCountExpression() {
        CountExpression countExpression = new CountExpression(new BagExpression(new CommaExpression(new DoubleTerminal(2.2), new IntegerTerminal(3))));
        countExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof IntegerResult);
        assertTrue(((IntegerResult) result).getValue() == 2);
    }

    public void testExistExpression() {
        ExistExpression existExpression = new ExistExpression(new BagExpression(new CommaExpression(new DoubleTerminal(2.2), new IntegerTerminal(3))));
        existExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());
    }

    public void testMaxExpression() {
        MaxExpression maxExpression = new MaxExpression(new BagExpression(new CommaExpression(new DoubleTerminal(2.2), new IntegerTerminal(3))));
        maxExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof IntegerResult);
        assertTrue(((IntegerResult) result).getValue() == 3);
    }

    public void testMinExpression() {
        MinExpression minExpression = new MinExpression(new BagExpression(new CommaExpression(new DoubleTerminal(2.2), new IntegerTerminal(3))));
        minExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof DoubleResult);
        assertTrue(((DoubleResult) result).getValue() == 2.2);
    }

    public void testNotExpression() {
        NotExpression notExpression = new NotExpression(new BooleanTerminal(false));
        notExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        notExpression = new NotExpression(new BooleanTerminal(true));
        notExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testStructExpression() {
        StructExpression structExpression = new StructExpression(new IntegerTerminal(2));
        structExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof StructResult);
    }

    public void testSumExpression() {
        SumExpression sumExpression = new SumExpression(new BagExpression(new CommaExpression(new DoubleTerminal(2.2), new IntegerTerminal(3))));
        sumExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof DoubleResult);
        assertTrue(((DoubleResult) result).getValue() == 5.2);
    }

}
