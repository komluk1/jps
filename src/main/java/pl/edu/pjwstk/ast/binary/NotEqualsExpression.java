package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.INotEqualsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class NotEqualsExpression extends BinaryExpression implements INotEqualsExpression {

    public NotEqualsExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitNotEqualsExpression(this);
    }

}
