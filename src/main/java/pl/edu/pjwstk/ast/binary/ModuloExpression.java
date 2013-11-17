package pl.edu.pjwstk.ast.binary;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.binary.IModuloExpression;
import edu.pjwstk.jps.visitor.ASTVisitor;

public class ModuloExpression extends BinaryExpression implements IModuloExpression {

    public ModuloExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitModuloExpression(this);
    }

}
