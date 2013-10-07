package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IGreaterThanExpression;

public class GreaterThanExpression extends BinaryExpression implements IGreaterThanExpression {
    public GreaterThanExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }


}
