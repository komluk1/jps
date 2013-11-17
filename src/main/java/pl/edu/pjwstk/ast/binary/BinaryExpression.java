package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IBinaryExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public abstract class BinaryExpression implements IBinaryExpression {


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
    }
}
