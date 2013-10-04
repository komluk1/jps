package pl.edu.pjwstk.ast.terminal;

import edu.pjwstk.jps.ast.terminal.IIntegerTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 04.10.13
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
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
