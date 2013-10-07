package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IWhereExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class WhereExpression extends BinaryExpression implements IWhereExpression {

    public WhereExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }


    @Override
    public void accept(ASTVisitor visitor) {


    }
}
