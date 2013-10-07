package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IUnaryExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

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
