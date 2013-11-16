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
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitIntegerTerminal(this);
    }
}
