package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IEqualsExpression;

public class EqualsExpression extends BinaryExpression implements IEqualsExpression {
    public EqualsExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }


}
