package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IInExpression;

public class InExpression extends BinaryExpression implements IInExpression {
    public InExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }


}
