package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.ICountExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 04.10.13
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public class CountExpression extends UnaryExpression implements ICountExpression {


    public CountExpression(IExpression innerExpression) {
        super(innerExpression);
    }


    @Override
    public void accept(ASTVisitor visitor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
