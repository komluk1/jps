package pl.edu.pjwstk.result;

import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.ISingleResult;

import java.util.Arrays;
import java.util.Collection;

public class BagResult implements IBagResult {
    private  Collection<ISingleResult> values;

    public BagResult(ISingleResult... values){
        this.values= Arrays.asList(values);
    }

    public BagResult(Collection<ISingleResult> values) {
        this.values = values;
    }

    @Override
    public Collection<ISingleResult> getElements() {
        return values;
    }
}
