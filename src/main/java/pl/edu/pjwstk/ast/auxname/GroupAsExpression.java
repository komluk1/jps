package pl.edu.pjwstk.ast.auxname;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IGroupAsExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;
import pl.edu.pjwstk.ast.terminal.NameTerminal;


public class GroupAsExpression implements IGroupAsExpression {

    String auxiliaryName;
    IExpression innerExpression;

    public GroupAsExpression(String auxiliaryName, IExpression innerExpression) {
        this.auxiliaryName = auxiliaryName;
        this.innerExpression = innerExpression;
    }
    public GroupAsExpression(NameTerminal auxiliaryName, IExpression innerExpression) {
        this(auxiliaryName.getName(),innerExpression);
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
        visitor.visitGroupAsExpression(this);
    }
}
