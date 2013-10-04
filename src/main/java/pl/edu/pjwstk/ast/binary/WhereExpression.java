package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IWhereExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 04.10.13
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */
public class WhereExpression extends BinaryExpression implements IWhereExpression {

    public WhereExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression,rightExpression);
    }


    @Override
    public void accept(ASTVisitor visitor) {


    }
}
