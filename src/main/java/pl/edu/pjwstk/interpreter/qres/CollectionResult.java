package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.result.ICollectionResult;

public class CollectionResult extends AbstractQueryResult implements ICollectionResult {

    protected CollectionResult(IOID ioid) {
        super(ioid);
    }

    protected CollectionResult() {

    }

}
