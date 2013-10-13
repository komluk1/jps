package pl.edu.pjwstk.interpreter.envs;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IAsExpression;
import edu.pjwstk.jps.ast.auxname.IGroupAsExpression;
import edu.pjwstk.jps.ast.binary.*;
import edu.pjwstk.jps.ast.terminal.*;
import edu.pjwstk.jps.ast.unary.*;
import edu.pjwstk.jps.interpreter.envs.IInterpreter;
import edu.pjwstk.jps.result.IAbstractQueryResult;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 09:37
 * To change this template use File | Settings | File Templates.
 */
public class Interpreter implements IInterpreter {
    @Override
    public IAbstractQueryResult eval(IExpression queryTreeRoot) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitAsExpression(IAsExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitGroupAsExpression(IGroupAsExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitAllExpression(IForAllExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitAndExpression(IAndExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitAnyExpression(IForAnyExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitCloseByExpression(ICloseByExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitCommaExpression(ICommaExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitDivideExpression(IDivideExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitDotExpression(IDotExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitEqualsExpression(IEqualsExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitGreaterThanExpression(IGreaterThanExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitGreaterOrEqualThanExpression(IGreaterOrEqualThanExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitInExpression(IInExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitIntersectExpression(IIntersectExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitJoinExpression(IJoinExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitLessOrEqualThanExpression(ILessOrEqualThanExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitLessThanExpression(ILessThanExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitMinusExpression(IMinusExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitMinusSetExpression(IMinusSetExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitModuloExpression(IModuloExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitMultiplyExpression(IMultiplyExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitNotEqualsExpression(INotEqualsExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitOrderByExpression(IOrderByExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitOrExpression(IOrExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitPlusExpression(IPlusExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitUnionExpression(IUnionExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitWhereExpression(IWhereExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitXORExpression(IXORExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitBooleanTerminal(IBooleanTerminal expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitDoubleTerminal(IDoubleTerminal expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitIntegerTerminal(IIntegerTerminal expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitNameTerminal(INameTerminal expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitStringTerminal(IStringTerminal expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitBagExpression(IBagExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitCountExpression(ICountExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitExistsExpression(IExistsExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitMaxExpression(IMaxExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitMinExpression(IMinExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitNotExpression(INotExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitStructExpression(IStructExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitSumExpression(ISumExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitUniqueExpression(IUniqueExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitAvgExpression(IAvgExpression expr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

