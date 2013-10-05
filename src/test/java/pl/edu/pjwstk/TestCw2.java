package pl.edu.pjwstk;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.result.*;
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
import pl.edu.pjwstk.interpreter.qres.QresStack;
import pl.edu.pjwstk.result.*;

/**
 * Unit test for simple App.
 */
public class TestCw2
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCw2(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestCw2.class );
    }

    /**
     * 1+2*3-4
     */
    public void test0(){
        QresStack qres = new QresStack();
        qres.push(new IntegerResult(1));
        qres.push(new IntegerResult(2));
        qres.push(new IntegerResult(3));
        IntegerResult multiRight = (IntegerResult) qres.pop(); //3
        IntegerResult multiLeft = (IntegerResult) qres.pop(); //2
        IntegerResult multiRes = new IntegerResult(multiLeft.getValue() * multiRight.getValue());
        qres.push(multiRes);
        IntegerResult plusRight = (IntegerResult) qres.pop(); //6
        IntegerResult plusLeft = (IntegerResult) qres.pop(); //1
        IntegerResult plusRes = new IntegerResult(plusLeft.getValue() + plusRight.getValue());
        qres.push(plusRes);
        qres.push(new IntegerResult(4));
        IntegerResult minusRight = (IntegerResult) qres.pop(); //4
        IntegerResult minusLeft = (IntegerResult) qres.pop(); //7
        IntegerResult minusRes = new IntegerResult(minusLeft.getValue() - minusRight.getValue());
        qres.push(minusRes);
        assertEquals((int)((IntegerResult) qres.pop()).getValue(),3);
    }

    /**
     * (bag(1, 2.1), bag(3+4, "test")) as nazwa;
     */
    public void test1()
    {
        QresStack qresStack = new QresStack();
        qresStack.push(new IntegerResult(1));
        qresStack.push(new DoubleResult(2.1));
        ISingleResult resultRight = (ISingleResult) qresStack.pop();
        ISingleResult resultLeft = (ISingleResult) qresStack.pop();
        qresStack.push(new BagResult(
                resultLeft,
                resultRight
        ));
        qresStack.push(new IntegerResult(3));
        qresStack.push(new IntegerResult(4));
        IIntegerResult intResultRight = (IIntegerResult) qresStack.pop();
        IIntegerResult intResultLeft = (IIntegerResult) qresStack.pop();
        qresStack.push(new IntegerResult(
                intResultLeft.getValue() + intResultRight.getValue()
        ));
        qresStack.push(new StringResult("test"));
        ISingleResult rightResultRight = (ISingleResult) qresStack.pop();
        ISingleResult rightResultLeft = (ISingleResult) qresStack.pop();
        qresStack.push(new BagResult(rightResultLeft,rightResultRight));


        //TODO OBLICZANIE NOWEGO BAGA Z DWÓCH BAGÓW I WEPCHNIĘCIE NA STACK WYNIKU KARTEZJANA JAKO BAG

        qresStack.push(new StringResult("nazwa"));

        qresStack.push(
                new BinderResult(
                    ((IStringResult) qresStack.pop()).getValue(),
                     qresStack.pop()  //TUTAJ BAG Z WYNIKIEM KARTEZJANA
                )
        );

        assertTrue(true);
    }

    /**
     * (bag("ala", "ma", "kota"), (8*10, false));
     */
    public void test2()
    {
        QresStack qresStack = new QresStack();

        qresStack.push(new StringResult("ala"));
        qresStack.push(new StringResult("ma"));
        qresStack.push(new StringResult("kota"));
        IStringResult kota = (IStringResult) qresStack.pop();
        IStringResult ma = (IStringResult) qresStack.pop();
        IStringResult ala = (IStringResult) qresStack.pop();
        qresStack.push(new BagResult(
                ala,
                ma,
                kota
        ));
        qresStack.push(new IntegerResult(8));
        qresStack.push(new IntegerResult(10));
        IIntegerResult mulRight = (IIntegerResult)qresStack.pop();   //10
        IIntegerResult mulLeft = (IIntegerResult)qresStack.pop();   //8

        qresStack.push(new IntegerResult(mulLeft.getValue()*mulRight.getValue()));  //80
        qresStack.push(new BooleanResult(false)); //false
        ISingleResult singleResultRight = (ISingleResult)qresStack.pop(); //BOOL
        ISingleResult singleResultLeft = (ISingleResult)qresStack.pop(); //INT
        qresStack.push(new BagResult(
                singleResultLeft,
                singleResultRight
        ));


        //TODO OBLICZANIE BAGA I WEPCHNIĘCIE NA STACK WYNIKU JAKO BAG






        assertTrue( true );
    }

    /**
     * (((bag("JPS", "rules")) groupas x), 2.2, true);
     */
    public void test3()
    {
       //TODO

        assertTrue( true );
    }

}
