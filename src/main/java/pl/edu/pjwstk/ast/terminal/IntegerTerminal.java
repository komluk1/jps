package pl.edu.pjwstk.ast.terminal;

import edu.pjwstk.jps.ast.terminal.IIntegerTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class IntegerTerminal implements IIntegerTerminal {
    private Integer value;

    public IntegerTerminal(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ASTVisitor visitor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
