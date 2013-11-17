package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IExistsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class ExistExpression extends UnaryExpression implements IExistsExpression {


    public ExistExpression(IExpression innerExpression) {
        super(innerExpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitExistsExpression(this);
    }
}
