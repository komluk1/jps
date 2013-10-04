package pl.edu.pjwstk.ast.terminal;

import edu.pjwstk.jps.ast.auxname.IAuxiliaryNameExpression;
import edu.pjwstk.jps.ast.terminal.INameTerminal;
import edu.pjwstk.jps.visitor.ASTVisitor;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 04.10.13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class NameTerminal  implements INameTerminal{
    private String name;


    public NameTerminal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ASTVisitor visitor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
