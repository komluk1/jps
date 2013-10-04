package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IUnaryExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 04.10.13
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class UnaryExpression implements IUnaryExpression {
    private IExpression innerExpression;


    protected UnaryExpression(IExpression innerExpression) {
        this.innerExpression = innerExpression;
    }

    @Override
    public IExpression getInnerExpression() {
        return innerExpression;
    }

    @Override
    public void accept(ASTVisitor visitor) {

    }
}
