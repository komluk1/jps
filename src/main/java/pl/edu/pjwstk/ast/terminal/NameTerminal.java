package pl.edu.pjwstk.ast.terminal;

import edu.pjwstk.jps.ast.terminal.INameTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class NameTerminal implements INameTerminal {
    private String name;


    public NameTerminal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitNameTerminal(this);
    }
}
