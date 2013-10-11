package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.interpreter.qres.IQResStack;
import edu.pjwstk.jps.result.IAbstractQueryResult;

import java.util.Stack;

public class QresStack implements IQResStack {

    private Stack<IAbstractQueryResult> stack = new Stack<IAbstractQueryResult>();

    public QresStack() {
    }

    @Override
    public IAbstractQueryResult pop() {
        return stack.pop();
    }

    @Override
    public void push(IAbstractQueryResult value) {
        stack.push(value);
    }


    @Override
    public String toString() {
        String out = "";
        for (IAbstractQueryResult abstractQueryResult:stack){
            out+=abstractQueryResult.toString();
        }
        return out;
    }
}
