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

    public void testEqualsExpression() {
        EqualsExpression equalsExpression = new EqualsExpression(new IntegerTerminal(2), new IntegerTerminal(2));
        equalsExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        equalsExpression = new EqualsExpression(new DoubleTerminal(2.0), new IntegerTerminal(2));
        equalsExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testForAllExpression() {
        ForAllExpression forAll = new ForAllExpression(new BooleanTerminal(true), new BooleanTerminal(true));
        forAll.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        forAll = new ForAllExpression(new BooleanTerminal(true), new BooleanTerminal(false));
        forAll.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testForAnyExpression() {
        ForAnyExpression forAny = new ForAnyExpression(new BooleanTerminal(false), new BooleanTerminal(true));
        forAny.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        forAny = new ForAnyExpression(new BooleanTerminal(false), new BooleanTerminal(false));
        forAny.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testGreaterOrEqualThanExpression() {
        GreaterOrEqualThanExpression greaterOrEqualThanExpression = new GreaterOrEqualThanExpression(new IntegerTerminal(2), new IntegerTerminal(2));
        greaterOrEqualThanExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        greaterOrEqualThanExpression = new GreaterOrEqualThanExpression(new IntegerTerminal(3), new IntegerTerminal(2));
        greaterOrEqualThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        greaterOrEqualThanExpression = new GreaterOrEqualThanExpression(new DoubleTerminal(1.0), new DoubleTerminal(2.0));
        greaterOrEqualThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testGreaterThanExpression() {
        GreaterThanExpression greaterThanExpression = new GreaterThanExpression(new IntegerTerminal(2), new IntegerTerminal(2));
        greaterThanExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());

        greaterThanExpression = new GreaterThanExpression(new IntegerTerminal(3), new IntegerTerminal(2));
        greaterThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        greaterThanExpression = new GreaterThanExpression(new DoubleTerminal(1.0), new DoubleTerminal(2.0));
        greaterThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testInExpression() {
        InExpression inExpression = new InExpression(new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(3)), new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(3)));
        inExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        inExpression = new InExpression(new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(3)), new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(0)));
        inExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());
    }

    public void testJoinExpression() {
        JoinExpression joinExpression = new JoinExpression(new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(3)), new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(3)));
        joinExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BagResult);
        assertTrue(((BagResult) result).getElements().size() == 4);
    }

    public void testLessOrEqualThanExpression() {
        LessOrEqualThanExpression lessOrEqualThanExpression = new LessOrEqualThanExpression(new IntegerTerminal(2), new IntegerTerminal(2));
        lessOrEqualThanExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());

        lessOrEqualThanExpression = new LessOrEqualThanExpression(new IntegerTerminal(3), new IntegerTerminal(2));
        lessOrEqualThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());

        lessOrEqualThanExpression = new LessOrEqualThanExpression(new DoubleTerminal(1.0), new DoubleTerminal(2.0));
        lessOrEqualThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());
    }

    public void testLessThanExpression() {
        LessThanExpression lessOrEqualThanExpression = new LessThanExpression(new IntegerTerminal(2), new IntegerTerminal(2));
        lessOrEqualThanExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());

        lessOrEqualThanExpression = new LessThanExpression(new IntegerTerminal(3), new IntegerTerminal(2));
        lessOrEqualThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertFalse(((BooleanResult) result).getValue());

        lessOrEqualThanExpression = new LessThanExpression(new DoubleTerminal(1.0), new DoubleTerminal(2.0));
        lessOrEqualThanExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof BooleanResult);
        assertTrue(((BooleanResult) result).getValue());
    }

    public void testMinusExpression() {
        MinusExpression minusExpression = new MinusExpression(new IntegerTerminal(2), new DoubleTerminal(2.0));
        minusExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof DoubleResult);
        assertEquals(0.0, ((DoubleResult) result).getValue());

        minusExpression = new MinusExpression(new IntegerTerminal(2), new IntegerTerminal(1));
        minusExpression.accept(interpreter);
        result = stack.pop();

        assertTrue(result instanceof IntegerResult);
        assertTrue(((IntegerResult) result).getValue() == 1);
    }

    public void testMinusSetExpression() {
        MinusSetExpression minusSetExpression = new MinusSetExpression(new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(3)), new CommaExpression(new IntegerTerminal(2), new IntegerTerminal(1)));
        minusSetExpression.accept(interpreter);
        IAbstractQueryResult result = stack.pop();

        assertTrue(result instanceof BagResult);
        assertEquals(1, ((BagResult) result).getElements().size());
        IAbstractQueryResult element = ((BagResult) result).getElements().iterator().next();
        assertTrue(element instanceof IntegerResult);
        assertTrue(((IntegerResult) element).getValue() == 3);
    }
}
