package pl.edu.pjwstk.ast.unary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.unary.IBagExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 07.10.13
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
public class BagExpression extends UnaryExpression implements  IBagExpression {
    public BagExpression(IExpression innerExpression) {
        super(innerExpression);
    }
}
