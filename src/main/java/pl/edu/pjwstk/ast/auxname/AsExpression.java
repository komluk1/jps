package pl.edu.pjwstk.ast.auxname;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IAsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;


public class AsExpression implements IAsExpression {


    String auxiliaryName;
    IExpression innerExpression;

    public AsExpression(String auxiliaryName, IExpression innerExpression) {
        this.auxiliaryName = auxiliaryName;
        this.innerExpression = innerExpression;
    }

    @Override
    public String getAuxiliaryName() {
        return auxiliaryName;
    }

    @Override
    public IExpression getInnerExpression() {
        return innerExpression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitAsExpression(this);
    }
}
