package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.ISumExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class SumExpression extends UnaryExpression implements ISumExpression {

    public SumExpression(IExpression innerExpression) {
        super(innerExpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitSumExpression(this);
    }
}
