package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IBagExpression;

public class BagExpression extends UnaryExpression implements  IBagExpression {
    public BagExpression(IExpression innerExpression) {
        super(innerExpression);
    }
}
