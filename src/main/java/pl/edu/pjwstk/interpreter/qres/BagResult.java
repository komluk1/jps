package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.ISingleResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BagResult extends CollectionResult implements IBagResult {

    private Collection<ISingleResult> elements = new ArrayList<ISingleResult>();

    public BagResult(List<ISingleResult> list) {
        getElements().addAll(list);
    }

    public BagResult() {

    }

    @Override
    public Collection<ISingleResult> getElements() {
        return elements;
    }

    public String toString() {
        String elements = "";
        String comma = "";
        for (ISingleResult singleResult : getElements()) {
            elements += comma + singleResult.toString();
            comma = ",";
        }
        return "BagResult{" +
                "elements=" + elements +
                '}';
    }
}
