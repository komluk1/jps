package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.ISingleResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BagResult extends CollectionResult implements IBagResult {

    private Collection<ISingleResult> elements = new ArrayList<ISingleResult>();

    protected BagResult(List<ISingleResult> list) {
        getElements().addAll(list);
    }

    protected BagResult() {

    }

    @Override
    public Collection<ISingleResult> getElements() {
        return elements;
    }

    // nie wiem jeszcze jak to ma wygladac
    public String toString() {
        return "BagResult{" +
                "elements=" + getElements().toString() +
                '}';
    }
}
