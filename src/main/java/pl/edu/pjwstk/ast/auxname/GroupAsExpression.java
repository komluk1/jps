package pl.edu.pjwstk.ast.auxname;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IGroupAsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 11.10.13
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public class GroupAsExpression implements IGroupAsExpression {


    String auxiliaryName;
    IExpression innerExpression;

    public GroupAsExpression(String auxiliaryName, IExpression innerExpression) {
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
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
