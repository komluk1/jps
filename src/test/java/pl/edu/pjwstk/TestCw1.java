package pl.edu.pjwstk;

import edu.pjwstk.jps.ast.IExpression;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.ast.binary.EqualsExpression;
import pl.edu.pjwstk.ast.binary.GreaterThanExpression;
import pl.edu.pjwstk.ast.binary.WhereExpression;
import pl.edu.pjwstk.ast.terminal.IntegerTerminal;
import pl.edu.pjwstk.ast.terminal.NameTerminal;
import pl.edu.pjwstk.ast.terminal.StringTerminal;
import pl.edu.pjwstk.ast.unary.CountExpression;

/**
 * Unit test for simple App.
 */
public class TestCw1
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCw1(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestCw1.class );
    }

    /**
     * osoba where (count(imie) > 1)
     */
    public void test1()
    {
        IExpression expression = new WhereExpression(
                new NameTerminal("osoba"),
                new GreaterThanExpression(
                    new CountExpression(
                            new NameTerminal("imie")
                    ),
                    new IntegerTerminal(3)

                )
        );
        assertTrue( true );
    }

    /**
     * firma where (lokalizacja in (bag(„Warszawa”, „Łódź”)))
     */
    public void test2()
    {

        assertTrue( true );
    }

    /**
     * bag(1,2) in bag(1,2,3)
     */
    public void test3()
    {


        assertTrue( true );
    }

    /**
     * (firma where nazwa=”XYZ”).(zatrudnia where nazwisko=”Kowalski”)
     */
    public void test4()
    {
        IExpression expression = new WhereExpression(
               new WhereExpression(
                       new NameTerminal("firma"),
                       new EqualsExpression(
                               new NameTerminal("nazwa"),
                               new StringTerminal("XYZ")
                       )
               ),
               new WhereExpression(
                       new NameTerminal("zatrudnia"), // TODO ZAMIENIC NA NAMED BAGA?!
                       new EqualsExpression(
                               new NameTerminal("nazwisko"),
                               new StringTerminal("Kowalski")
                       )
               )
        );
        assertTrue( true );
    }
}
