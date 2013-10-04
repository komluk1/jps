package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IBinaryExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 04.10.13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class BinaryExpression implements IBinaryExpression {


    private IExpression leftExpression;
    private IExpression rightExpression;


    public BinaryExpression(IExpression leftExpression, IExpression rightExpression) {
        super();
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public IExpression getLeftExpression() {
        return this.leftExpression;
    }

    @Override
    public IExpression getRightExpression() {
        return this.rightExpression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
