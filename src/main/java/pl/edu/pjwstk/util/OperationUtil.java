package pl.edu.pjwstk.util;

import edu.pjwstk.jps.result.IAbstractQueryResult;
import edu.pjwstk.jps.result.IBagResult;
import edu.pjwstk.jps.result.ISingleResult;
import edu.pjwstk.jps.result.IStructResult;
import pl.edu.pjwstk.interpreter.qres.BagResult;
import pl.edu.pjwstk.interpreter.qres.BinderResult;
import pl.edu.pjwstk.interpreter.qres.StructResult;

import java.util.ArrayList;
import java.util.List;


public class OperationUtil {

    public static BinderResult as(String name, IAbstractQueryResult singleResult) {
        if (singleResult instanceof BagResult) {
            List<ISingleResult> singleResults = new ArrayList<ISingleResult>();
            for (ISingleResult result : ((BagResult) singleResult).getElements()) {
                singleResults.add(new BinderResult(name, result));
            }
            return new BinderResult(name, new StructResult(singleResults));

        } else {
            return new BinderResult(name, singleResult);
        }
    }

    public static BinderResult groupAs(String name, IAbstractQueryResult singleResult) {
        return new BinderResult(name, singleResult);
    }

    public static IStructResult comma(IAbstractQueryResult singleResultLeft, IAbstractQueryResult singleResultRight) {
        if (singleResultLeft instanceof IBagResult) {
            if (singleResultRight instanceof IBagResult) {
                return comma((IBagResult) singleResultLeft, (IBagResult) singleResultRight);
            }
            return comma((IBagResult) singleResultLeft, singleResultRight);
        } else if (singleResultRight instanceof IBagResult) {
            return comma(singleResultLeft, (IBagResult) singleResultRight);
        }


        List<ISingleResult> singleResults = new ArrayList<ISingleResult>();
        if (singleResultLeft instanceof StructResult) {
            singleResults.addAll(((StructResult) singleResultLeft).elements());
        } else if (singleResultLeft instanceof ISingleResult) {
            singleResults.add((ISingleResult) singleResultLeft);
        }
        if (singleResultRight instanceof StructResult) {
            singleResults.addAll(((StructResult) singleResultRight).elements());
        } else if (singleResultRight instanceof ISingleResult) {
            singleResults.add((ISingleResult) singleResultRight);
        }
        return new StructResult(singleResults);
    }

    public static IStructResult comma(IBagResult singleResultLeft, IAbstractQueryResult singleResultRight) {
        List<ISingleResult> resultsForbag = new ArrayList<ISingleResult>();
        for (ISingleResult singleResult : singleResultLeft.getElements()) {
            List<ISingleResult> resultsForStruct = new ArrayList<ISingleResult>();
            resultsForStruct.add(singleResult);
            if (singleResultRight instanceof StructResult) {
                resultsForStruct.addAll(((StructResult) singleResultRight).elements());
            } else if (singleResultRight instanceof ISingleResult) {
                resultsForStruct.add((ISingleResult) singleResultRight);
            }
            resultsForbag.add(new StructResult(resultsForStruct));
        }
        return new StructResult(resultsForbag);
    }

    public static IStructResult comma(IAbstractQueryResult singleResultLeft, IBagResult singleResultRight) {
        List<ISingleResult> resultsForbag = new ArrayList<ISingleResult>();
        for (ISingleResult singleResult : singleResultRight.getElements()) {
            List<ISingleResult> resultsForStruct = new ArrayList<ISingleResult>();
            if (singleResultLeft instanceof StructResult) {
                resultsForStruct.addAll(((StructResult) singleResultLeft).elements());
            } else if (singleResultRight instanceof ISingleResult) {
                resultsForStruct.add((ISingleResult) singleResultLeft);
            }
            resultsForStruct.add(singleResult);
            resultsForbag.add(new StructResult(resultsForStruct));
        }
        return new StructResult(resultsForbag);
    }

    public static IStructResult comma(IBagResult bagLeft, IBagResult bagRight) {
        List<ISingleResult> resultsForbag = new ArrayList<ISingleResult>();
        for (ISingleResult singleResultLeft : bagLeft.getElements()) {
            for (ISingleResult singleResultRight : bagRight.getElements()) {
                List<ISingleResult> resultsForStruct = new ArrayList<ISingleResult>();
                resultsForStruct.add(singleResultLeft);
                resultsForStruct.add(singleResultRight);
                resultsForbag.add(new StructResult(resultsForStruct));
            }
        }
        return new StructResult(resultsForbag);
    }
}
