package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IAvgExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class AvgExpression extends UnaryExpression implements IAvgExpression {

    public AvgExpression(IExpression innerExpression) {
        super(innerExpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitAvgExpression(this);
    }
}
