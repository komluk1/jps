package pl.edu.pjwstk.ast.terminal;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.terminal.IStringTerminal;
import edu.pjwstk.jps.ast.terminal.ITerminalExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTerminal implements ITerminalExpression<IExpression[]> {
    private IExpression[] value;

    public CollectionTerminal(IExpression val,IExpression... value){
        List<IExpression> list = new ArrayList();
        list.add(val);
        int count=1;
        if (value!=null){
            count = value.length;
            list.addAll(Arrays.asList(value));
        }
        this.value=list.toArray(new IExpression[count]);
    }
    public CollectionTerminal(IExpression[] value) {
        this.value = value;
    }

    @Override
    public IExpression[] getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
