package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.result.ISingleResult;
import edu.pjwstk.jps.result.IStructResult;

import java.util.ArrayList;
import java.util.List;

public class StructResult extends SingleResult implements IStructResult {

    private List<ISingleResult> elements = new ArrayList<ISingleResult>();

    public StructResult(List<ISingleResult> list) {
        elements().addAll(list);
    }

    @Override
    public List<ISingleResult> elements() {
        return elements;
    }

    // nie wiem jeszcze jak to ma wygladac
    public String toString() {
        String elements ="";
        String comma="";
        for(ISingleResult singleResult: elements()){
            elements+=comma+singleResult.toString();
            comma=",";
        }

        return   "StructResult{" +
                "elements=" + elements +
                '}';
    }
}
