package pl.edu.pjwstk;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IReferenceResult;
import java_cup.runtime.Symbol;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.ast.binary.*;
import pl.edu.pjwstk.ast.terminal.BooleanTerminal;
import pl.edu.pjwstk.ast.terminal.DoubleTerminal;
import pl.edu.pjwstk.ast.terminal.IntegerTerminal;
import pl.edu.pjwstk.ast.terminal.StringTerminal;
import pl.edu.pjwstk.ast.unary.StructExpression;
import pl.edu.pjwstk.datastore.SBAStore;
import pl.edu.pjwstk.interpreter.envs.ENVS;
import pl.edu.pjwstk.interpreter.envs.Interpreter;
import pl.edu.pjwstk.interpreter.qres.*;
import pl.edu.pjwstk.parser.ParserCup;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class TestCw7
        extends TestCase {

    private Interpreter interpreter = null;
    private SBAStore store = null;
    private QresStack stack = null;







    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCw7(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TestCw7.class);
    }

    public void setUp() {
        URL url = getClass().getClassLoader().getResource("TestCw4_dane.xml");
        store = new SBAStore();
        store.loadXML(url.getPath());
        stack = new QresStack();
        interpreter = new Interpreter(stack, store, new ENVS());
    }
    private String[] queries = {
            "true",
            "true and false",
            "true or false",
            "true or (true and false)",
            "true and (true or false)",
            "1+2",
            "5",
            "(3*(5-2))==9",
            "integerNumber"

    };
    private IAbstractQueryResult[] results = {
            new BooleanResult(true),
            new BooleanResult(false),
            new BooleanResult(true),
            new BooleanResult(true),
            new BooleanResult(true),
            new IntegerResult(3),
            new IntegerResult(5),
            new BooleanResult(true),
            new ReferenceResult(null),
    };
    public void testAll() {
        int passed = 0;
        for (int i=0; i<queries.length;i++){
            String query = queries[i];
            ParserCup cup = new ParserCup(query);
            IExpression expression  =null;
            IAbstractQueryResult result = null;
            try {
                expression  = (IExpression)cup.parse().value;
                expression.accept(interpreter);
                result = stack.pop();
                System.out.println(query+" -> "+result.toString());
                if (results[i].equals(result)){
                    passed++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assertEquals(queries.length,passed);
    }


}
