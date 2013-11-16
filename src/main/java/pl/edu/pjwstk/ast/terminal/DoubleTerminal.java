package pl.edu.pjwstk.ast.terminal;

import edu.pjwstk.jps.ast.terminal.IDoubleTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class DoubleTerminal implements IDoubleTerminal {
    private Double value;

    public DoubleTerminal(Double value) {
        this.value = value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitDoubleTerminal(this);
    }
}
