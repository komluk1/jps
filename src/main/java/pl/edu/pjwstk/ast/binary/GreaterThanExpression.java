package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IGreaterThanExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class GreaterThanExpression extends BinaryExpression implements IGreaterThanExpression {

    public GreaterThanExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitGreaterThanExpression(this);
    }

}
