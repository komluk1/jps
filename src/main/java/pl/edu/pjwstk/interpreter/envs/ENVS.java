package pl.edu.pjwstk.interpreter.envs;

import edu.pjwstk.jps.datastore.IComplexObject;
import edu.pjwstk.jps.datastore.IOID;
import edu.pjwstk.jps.datastore.ISBAObject;
import edu.pjwstk.jps.datastore.ISBAStore;
import edu.pjwstk.jps.interpreter.envs.IENVS;
import edu.pjwstk.jps.interpreter.envs.IENVSBinder;
import edu.pjwstk.jps.interpreter.envs.IENVSFrame;
import edu.pjwstk.jps.result.*;
import pl.edu.pjwstk.datastore.ComplexObject;
import pl.edu.pjwstk.datastore.SBAStore;
import pl.edu.pjwstk.interpreter.qres.BagResult;
import pl.edu.pjwstk.interpreter.qres.ReferenceResult;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 09:24
 * To change this template use File | Settings | File Templates.
 */
public class ENVS implements IENVS {


    private List<IENVSFrame> stacks = new ArrayList<IENVSFrame>();
    private int currentStack = -1;


    @Override
    public void init(IOID rootOID, ISBAStore store) {
        stacks = new ArrayList<IENVSFrame>();
        currentStack=-1;
        ISBAObject isbaObject = store.retrieve(rootOID);
        List<IENVSBinder> ienvsBinders = new ArrayList<IENVSBinder>();
        if (isbaObject instanceof IComplexObject){
            for (IOID ioid: ((IComplexObject)isbaObject).getChildOIDs()){
                ISBAObject isbaObject1 = store.retrieve(ioid);
                ienvsBinders.add(new ENVSBinder(isbaObject1.getName(), new ReferenceResult(isbaObject1.getOID())));
            }
        }
        push(new ENVSFrame(ienvsBinders));
    }


    @Override
    public IENVSFrame pop() {
        if (currentStack<0){
            throw new RuntimeException("Empty stack");
        }
        IENVSFrame ienvsFrame =  stacks.get(currentStack);
        stacks.remove(currentStack);
        currentStack--;
        return ienvsFrame;
    }

    @Override
    public void push(IENVSFrame frame) {
        ++currentStack;

        stacks.add(frame);
    }

    @Override
    public IBagResult bind(String name) {

        List<ISingleResult> singleResults = new ArrayList<ISingleResult>();
        for (int i=currentStack; i>=0 && singleResults.isEmpty(); i--){
            IENVSFrame ienvsFrame = stacks.get(i);
            Collection<IENVSBinder> ienvsBinders = ienvsFrame.getElements();
            for (IENVSBinder ienvsBinder: ienvsBinders){
                if (name.equals(ienvsBinder.getName())){
                    singleResults.add((ISingleResult)ienvsBinder.getValue());

                    //Signle czy collection
                }
            }
        }
        return new BagResult(singleResults);
    }

    @Override
    public IENVSFrame nested(IAbstractQueryResult result, ISBAStore store) {
        List<IENVSBinder> envsBinders = new ArrayList<IENVSBinder>();
        if (result instanceof IBagResult){
            for (ISingleResult singleResult:  ((IBagResult) result).getElements()){
                envsBinders.addAll(nested(singleResult,store).getElements());
            }
        } else if (result instanceof ISequenceResult){
            for (ISingleResult singleResult:  ((ISequenceResult) result).getElements()){
                envsBinders.addAll(nested(singleResult,store).getElements());
            }
        }
        if (result instanceof IStructResult){
            for (ISingleResult singleResult:  ((IStructResult) result).elements()){
                envsBinders.addAll(nested(singleResult,store).getElements());
            }
        } else if (result instanceof IReferenceResult){
            ISBAObject isbaObject = store.retrieve(((IReferenceResult)result).getOIDValue());
            if (isbaObject instanceof ComplexObject){
               for (IOID ioid: ((ComplexObject) isbaObject).getChildOIDs()){
                   ISBAObject isbaObject1 = store.retrieve(ioid);
                   envsBinders.add(new ENVSBinder(isbaObject1.getName(),new ReferenceResult(ioid)));
               }
            } else{
                envsBinders.add(new ENVSBinder(isbaObject.getName(),new ReferenceResult(isbaObject.getOID())));
            }
        } else if (result instanceof IBinderResult){
            IBinderResult resultCasted = (IBinderResult) result;
            envsBinders.add(new ENVSBinder(resultCasted.getName(),resultCasted.getValue()));
        }
        return new ENVSFrame(envsBinders);
    }


}
