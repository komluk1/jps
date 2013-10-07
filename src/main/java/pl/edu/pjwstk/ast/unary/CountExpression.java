package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.ICountExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class CountExpression extends UnaryExpression implements ICountExpression {


    public CountExpression(IExpression innerExpression) {
        super(innerExpression);
    }


    @Override
    public void accept(ASTVisitor visitor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
