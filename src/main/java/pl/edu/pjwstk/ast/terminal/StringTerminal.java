package pl.edu.pjwstk.ast.terminal;

import edu.pjwstk.jps.ast.terminal.IStringTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class StringTerminal implements IStringTerminal {
    private String value;

    public StringTerminal(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ASTVisitor visitor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
