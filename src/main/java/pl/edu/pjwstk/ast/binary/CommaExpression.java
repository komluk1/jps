package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.ICommaExpression;

public class CommaExpression extends BinaryExpression implements ICommaExpression {
    public CommaExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }


}
