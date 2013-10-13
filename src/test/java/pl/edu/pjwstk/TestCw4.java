package pl.edu.pjwstk;

import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.interpreter.envs.IENVS;
import edu.pjwstk.jps.interpreter.envs.IENVSBinder;
import edu.pjwstk.jps.interpreter.envs.IENVSFrame;
import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.IReferenceResult;
import edu.pjwstk.jps.result.ISingleResult;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.edu.pjwstk.datastore.IntegerObject;
import pl.edu.pjwstk.datastore.SBAStore;
import pl.edu.pjwstk.datastore.StringObject;
import pl.edu.pjwstk.interpreter.envs.ENVS;
import pl.edu.pjwstk.interpreter.envs.ENVSBinder;
import pl.edu.pjwstk.interpreter.envs.ENVSFrame;
import pl.edu.pjwstk.interpreter.qres.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class TestCw4
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCw4(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestCw4.class );
    }

    /*
    * Zaliczenie mini-projektu 3 polega na zaimplementowaniu diagramu UML
    * i wszystkich potrzebnych metod (bind, nested – tu należy uwzględnić
    * wszystkie rodzaje rezultatów) i zasymulowaniu w kodzie (np. w main())
    * poprzez sekwencję komend pop i push na stosie QRES oraz ENVS
    * wykonania następujących operacji:
    * */


    /*
     * emp.fName
     *
     * 1. Zainicjalizować dotres = bag()
     * 2. Wykonać eval(emp) i zrobić empres = QRES.POP()
     * 3. Dla każdego elementu x ze zbioru q1res wykonać:
     * 3.1. Utworzyć nową sekcję na ENVS
     * 3.2. Wykonać nested(x). Wynik wprowadzić do sekcji utworzonej w poprzednim
     * kroku
     * 3.3. Wykonać eval(fName) i zrobić fNameres = QRES.POP()
     * 3.4. Dodać q2res do dotres (dotres ∪ fNameres)
     * 3.5. Zamknąć sekcję ENVS
     * 4. Zrobić QRES.PUSH(dotres)
     */
    public void test0(){
        URL url =  getClass().getClassLoader().getResource("TestCw4_dane.xml");
        SBAStore sbaStore = new SBAStore();
        sbaStore.loadXML(url.getPath());
        ENVS envs = new ENVS();
        envs.init(sbaStore.getEntryOID(),sbaStore);
        QresStack qresStack = new QresStack();
        qresStack.push(envs.bind("emp"));
        IBagResult fNameEmpResult = (IBagResult) qresStack.pop();

        List<ISingleResult> singleResults = new ArrayList<ISingleResult>();
        for (ISingleResult singleResult: fNameEmpResult.getElements()){
            envs.push(envs.nested(singleResult, sbaStore));
            singleResults.addAll(envs.bind("fName").getElements());
            envs.pop();
        }
        qresStack.push(new BagResult(singleResults));

        assertTrue(true);
    }
     /*
    * Dla osób z nazwiskami zaczynającymi na litery od A do J:
    * (emp where (address.number) = 50).lName;
    * */
    public void test1(){
        URL url =  getClass().getClassLoader().getResource("TestCw4_dane.xml");
        SBAStore sbaStore = new SBAStore();
        sbaStore.loadXML(url.getPath());


        ENVS envs = new ENVS();
        envs.init(sbaStore.getEntryOID(),sbaStore);
        QresStack qresStack = new QresStack();
        qresStack.push(envs.bind("emp"));
        IBagResult empResult = (IBagResult) qresStack.pop();     //emps




        List<ISingleResult> singleResults = new ArrayList<ISingleResult>();
        for (ISingleResult singleResult: empResult.getElements()){

            envs.push(envs.nested(singleResult,sbaStore));     //emp's values
            qresStack.push(envs.bind("address"));
            IBagResult adressEmpResult = (IBagResult) qresStack.pop();
            envs.push(envs.nested(adressEmpResult,sbaStore));
            qresStack.push(envs.bind("number"));
            IBagResult numberAddessEmpResult = (IBagResult) qresStack.pop();

            for (ISingleResult number: numberAddessEmpResult.getElements()){
                if (number instanceof IReferenceResult){
                    IReferenceResult referenceResult = (IReferenceResult)number;
                    ISBAObject isbaObject = sbaStore.retrieve(referenceResult.getOIDValue());

                    qresStack.push(new IntegerResult(50));
                    qresStack.push(new BooleanResult(isbaObject instanceof IntegerObject &&  ((IntegerResult)qresStack.pop()).getValue().equals(((IntegerObject)isbaObject).getValue())));
                    if (((BooleanResult)qresStack.pop()).getValue()){
                        envs.pop();   //revert number
                        singleResults.addAll(envs.bind("lName").getElements());
                        envs.pop();   //revert address
                    }
                }

            }
        }

        qresStack.push(new BagResult(singleResults));
        assertTrue(true);

    }

    /*
   * Dla osób z nazwiskami zaczynającymi na litery od R do Z:
   * (emp where ((book.title) = “Pan Tadeusz”)) where fName = “Anna”;
   * */
    public void test3(){
        URL url =  getClass().getClassLoader().getResource("TestCw4_dane.xml");
        SBAStore sbaStore = new SBAStore();
        sbaStore.loadXML(url.getPath());

        ENVS envs = new ENVS();
        envs.init(sbaStore.getEntryOID(),sbaStore);

        QresStack qresStack = new QresStack();
        qresStack.push(envs.bind("emp"));
        IBagResult empResult = (IBagResult) qresStack.pop();     //emps




        List<ISingleResult> singleResults = new ArrayList<ISingleResult>();
        for (ISingleResult singleResult: empResult.getElements()){

            envs.push(envs.nested(singleResult,sbaStore));     //emp's values
            qresStack.push(envs.bind("book"));
            IBagResult adressEmpResult = (IBagResult) qresStack.pop();
            envs.push(envs.nested(adressEmpResult,sbaStore));
            qresStack.push(envs.bind("title"));
            IBagResult numberAddessEmpResult = (IBagResult) qresStack.pop();

            for (ISingleResult number: numberAddessEmpResult.getElements()){
                if (number instanceof IReferenceResult){
                    IReferenceResult referenceResult = (IReferenceResult)number;
                    ISBAObject isbaObject = sbaStore.retrieve(referenceResult.getOIDValue());
                    qresStack.push(new StringResult("Pan Tadeusz"));
                    qresStack.push(new BooleanResult(isbaObject instanceof StringObject &&  ((StringResult)qresStack.pop()).getValue().equals(((StringObject)isbaObject).getValue())));
                    if (((BooleanResult)qresStack.pop()).getValue()){
                        envs.pop();   //revert number
                        IBagResult bagResult = envs.bind("fName");
                        for (ISingleResult singleResultFName: bagResult.getElements()){
                            IReferenceResult fNameReferenceResult = (IReferenceResult) singleResultFName;
                            ISBAObject fName =  sbaStore.retrieve(fNameReferenceResult.getOIDValue());
                            qresStack.push(new StringResult("Anna"));
                            qresStack.push(new BooleanResult(fName instanceof StringObject &&  ((StringResult)qresStack.pop()).getValue().equals(((StringObject)fName).getValue())));
                            if (((BooleanResult)qresStack.pop()).getValue()){
                                singleResults.add(singleResult);
                            }
                        }
                        envs.pop();   //revert address
                    }
                }

            }
        }

        qresStack.push(new BagResult(singleResults));

        assertTrue(true);

    }

}
