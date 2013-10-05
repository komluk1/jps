package pl.edu.pjwstk.interpreter.qres;

import edu.pjwstk.jps.interpreter.qres.IQResStack;
import edu.pjwstk.jps.result.IAbstractQueryResult;

import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 05.10.13
 * Time: 22:14
 * To change this template use File | Settings | File Templates.
 */
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
}
