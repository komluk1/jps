package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IOrExpression;

public class OrExpression extends BinaryExpression implements IOrExpression {
    public OrExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }


}
