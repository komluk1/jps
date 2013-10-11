package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.result.ISequenceResult;
import edu.pjwstk.jps.result.ISingleResult;

import java.util.ArrayList;
import java.util.List;

public class SequenceResult extends CollectionResult implements ISequenceResult {

    private List<ISingleResult> elements = new ArrayList<ISingleResult>();

    public SequenceResult(List<ISingleResult> list) {
        getElements().addAll(list);
    }

    public SequenceResult() {

    }

    @Override
    public List<ISingleResult> getElements() {
        return elements;
    }

    // nie wiem jeszcze jak to ma wygladac
    public String toString() {
        return "SequenceResult{" +
                "elements=" + getElements().toString() +
                '}';
    }
}
