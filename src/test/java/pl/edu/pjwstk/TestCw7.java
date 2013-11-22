package pl.edu.pjwstk;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.result.*;
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
public class TestCw7 {

    private static Interpreter interpreter = null;
    private static SBAStore store = null;
    private static QresStack stack = null;

    static {
        URL url = TestCw7.class.getClassLoader().getResource("TestCw7_dane.xml");
        store = new SBAStore();
        store.loadXML(url.getPath());
    }
    private static final String[] queries = {
            "booleanValue as wartoscNazwana",
            "all 1 true",
            "all (bag(1, bag(2,3) group as wew) as num) (num == 2)",
            "all emp married",
            "true and false",
            "booleanValue and true",
            "false and true and 1",
            "any 1 true",
            "any emp married",
            "1 as liczba",
            "bag(1,2) as num",
            "(1,2) as num",
            "bag(1)",
            "bag(1,2,3)",
            "bag(1+2,3)",
            "bag(bag(1,2,3))",
            "integerNumber",
            "realNumber",
            "booleanValue",
            "stringValue",
            "pomidor",
            "sampleComplexObj",
            "(1,2)",
            "(bag(1,2),3)",
            "bag(1,2),bag(3,4)",
            "10/5",
            "5/3.50",
            "3.50/5",
            "3.50/5.50",
            "(1 as x).(x)",
            "(1,2).(\"Ala\")",
            "emp.book.author",
            "bag(1,2).(\"Ala\")",
            "1 == 2",
            "integerNumber == 10",
            "bag(1,2) == 2",
            "booleanValue == true",
            "stringValue == \"Ala\"",
            "1 == true",
            "5 == \"5\"",
            "5.50 == 5",
            "1 > 1",
            "3 > 2.99",
            "24.35 > 24.34",
            "1 >= 1",
            "3 >= 2.99",
            "24.35 >= 24.34",
            "bag(1,2,3) group as num",
            "1 group as liczba",
            "bag(1,2,3) intersect bag(2,3)",
            "1 intersect 1",
            "(1,2) intersect (2,3)",
            "(1,2) intersect (1,2)",
            "bag(\"ala\",2,3) intersect bag(2,3.40)",
            "1 join 2",
            "(1 as n) join n",
            "(emp) join (married)",
            "(emp as e) join (e.married)",
            "1 <= 1",
            "24.34 <= 24.35",
            "2.99 <= 3",
            "1 < 1",
            "24.34 < 24.35",
            "2.99 < 3",
            "max(1)",
            "max (bag(1,3.35,3))",
            "min(1)",
            "min (bag(1.01,2.35,3))",
            "10-5",
            "5-3.50",
            "3.50-5",
            "3.50-5.50",
            "10%5",
            "5%3.50",
            "3.50%5",
            "3.50%5.50",
            "10*5",
            "5*3.50",
            "3.50*5",
            "3.50*5.50",
            "true or false",
            "booleanValue or false",
            "true or false or 1",
            "10+5",
            "5+3.50",
            "3.50+5",
            "3.50+5.50",
            "3+\"Ala\"",
            "3.5+\"Ala\"",
            "\"Ala\"+3.7",
            "true+\"Ala\"",
            "struct(1)",
            "struct(1,2,3)",
            "struct(1+2,3)",
            "struct(struct(1,2,3))",
            "1 union 2",
            "bag(1,2) union bag(3,4)",
            "(1,2) union (3,4)",
            "unique(bag(1,2,1))",
            "unique(bag(1.01,2,1.01,\"ala\"))",
            "bag(1,2) where true",
            "bag(1,2,3) as n where n == 1",
            "emp where married",
            "sum(1)",
            "sum(bag(1.01,2.35,3))",
            "count(1)",
            "count(bag(1.01,2.35,3))",
            "count(1.01,2.35,3)",
            "empty(1)",
            "empty (bag(1.01,2.35,3))",
            "empty (1 where false)",
            "not true",
            "not false",
            "true xor false",
            "true xor true",
            "false xor true",
            "booleanValue xor true",
            "true nand false",
            "false nand true",
            "false nand false",
            "true nand true",
            "booleanValue nand true",
            "bag(2,3) in bag(1,2,3)",
            "1 in 1",
            "(1,2) in (2,3)",
            "(1,2) in (1,2)",
            "bag(1,2,3) minus bag(2,3)",
            "1 minus 1",
            "(1,2) minus (2,3)",
            "(1,2) minus (1,2)",
            "bag(\"ala\",2,3) minus bag(2,3.40)"
    };


    private static final String[] resultsShouldBe ={
            "binder",
            "TRUE",
            "FALSE",
            "TRUE",
            "FALSE",
            "TRUE",
            "FALSE",
            "TRUE",
            "TRUE",
            "<liczba,1>",
            "bag(<num,1>,<num,2>)",
            "<num,struct(1,2)>",
            "bag(1)",
            "bag(1,2,3)",
            "bag(3,3)",
            "bag(1,2,3)",
            "ref(10)",
            "ref(234.35)",
            "ref(true)",
            "ref(\"Ala\")",
            "bag(ref(\"Pan pomidor wlazł na tyczkę\"), ref(\"I przedrzeźnia ogrodniczkę.\"), ref(\"Jak pan może,\"), ref(\"Panie pomidorze?!\"))",
            "ref(sampleComplexObj)",
            "struct(1,2)",
            "bag(struct(1,3), struct(2,3))",
            "bag(struct(1,3), struct(1,4), struct(2,3), struct(2,4))",
            "2",
            "1,4285714285714286",
            "0,7",
            "0,63636363636364",
            "1",
            "\"Ala\"",
            "bag(ref(\"Juliusz Słowacki\"),ref(\"Adam Mickiewicz\"),ref(\"Aleksander Dumas (syn)\"))",
            "bag(\"Ala\",\"Ala\")",
            "FALSE",
            "TRUE",
            "<wyjątek przed ewaluacją ==>",
            "TRUE",
            "TRUE",
            "FALSE",
            "FALSE",
            "FALSE",
            "FALSE",
            "TRUE",
            "TRUE",
            "TRUE",
            "TRUE",
            "TRUE",
            "<num, bag(1,2,3)>",
            "<liczba, 1>",
            "bag(2,3)",
            "bag(1)",
            "pusty bag",
            "bag(struct(1,2))",
            "bag(2)",
            "struct(1,2)",
            "struct(<n,1>,1)",
            "bag(struct(ref(emp1), true), struct(ref(emp2), true))",
            "bag(struct(<e,ref(emp1)>, true), struct(<e,ref(emp2)>, true))",
            "TRUE",
            "TRUE",
            "TRUE",
            "FALSE",
            "TRUE",
            "TRUE",
            "1",
            "3.35",
            "1",
            "1.01",
            "5",
            "1,50",
            "-1,5",
            "-2",
            "0",
            "1,5",
            "3,5",
            "3,5",
            "50",
            "17,5",
            "17,5",
            "19.25",
            "TRUE",
            "TRUE",
            "TRUE",
            "15",
            "8,50",
            "8,50",
            "9",
            "\"3Ala\"",
            "\"3.5Ala\"",
            "\"Ala3.7\"",
            "\"trueAla\"",
            "struct(1)",
            "struct(1,2,3)",
            "struct(3,3)",
            "struct(1,2,3)",
            "bag(1,2)",
            "bag(1,2,3,4)",
            "bag(struct(1,2), struct(3,4))",
            "bag(1,2)",
            "bag(1.01,2,\"ala\")",
            "bag(1,2)",
            "bag(<n,1>)",
            "bag(ref(emp1), ref(emp2))",
            "1",
            "6,36",
            "1",
            "3",
            "1",
            "false",
            "false",
            "true",
            "false",
            "true",
            "true",
            "false",
            "true",
            "false",
            "true",
            "true",
            "true",
            "false",
            "false",
            "true",
            "true",
            "false",
            "true",
            "bag(1)",
            "pusty bag",
            "struct(1,2)",
            "pusty bag",
            "bag(\"Ala\", 3)"
};

    public static String toString(IAbstractQueryResult abstractQueryResult) {

        if (abstractQueryResult instanceof IBagResult){
            String out = "bag(";
            String comma ="";
            for ( ISingleResult singleResult : ((IBagResult) abstractQueryResult).getElements()){
                out += comma + toString(singleResult);
                comma=",";
            }

            return out+")";
        } else if (abstractQueryResult instanceof ISequenceResult){
            String out = "sequence(";
            String comma ="";
            for ( ISingleResult singleResult : ((ISequenceResult) abstractQueryResult).getElements()){
                out += comma + toString(singleResult);
                comma=",";
            }

            return out+")";
        }   else if (abstractQueryResult instanceof IReferenceResult) {
            ISBAObject o = store.retrieve(((IReferenceResult)abstractQueryResult).getOIDValue());
            return "ref("+o.toString()+")";

         } else {
            return abstractQueryResult.toString();
        }
    }


    public static void main(String[] args) {
        for (int i=0; i<queries.length;i++){
            stack = new QresStack();
            interpreter = new Interpreter(stack, store, new ENVS());
            String query = queries[i];
            String out = query + " -> ";
            ParserCup cup = new ParserCup(query);
            IExpression expression  =null;
            IAbstractQueryResult result = null;
            try {
                expression  = (IExpression)cup.parse().value;
                expression.accept(interpreter);
                result = stack.pop();
                out += toString(result) +" -> "+ resultsShouldBe[i];
            } catch (Throwable e) {
                out+=" EXCEPTION "+e.getLocalizedMessage();
                synchronized (TestCw7.class){
                   e.printStackTrace();
                }
            }
            synchronized (TestCw7.class){
                System.out.println(out);
            }
        }
    }



}
