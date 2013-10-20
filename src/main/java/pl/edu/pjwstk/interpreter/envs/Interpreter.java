package pl.edu.pjwstk.interpreter.envs;

import edu.pjwstk.jps.ast.IExpression;
import edu.pjwstk.jps.ast.auxname.IAsExpression;
import edu.pjwstk.jps.ast.auxname.IGroupAsExpression;
import edu.pjwstk.jps.ast.binary.*;
import edu.pjwstk.jps.ast.terminal.*;
import edu.pjwstk.jps.ast.unary.*;
import edu.pjwstk.jps.interpreter.envs.IInterpreter;
import edu.pjwstk.jps.result.*;
import pl.edu.pjwstk.interpreter.exception.WrongTypeException;
import pl.edu.pjwstk.interpreter.qres.DoubleResult;
import pl.edu.pjwstk.interpreter.qres.IntegerResult;
import pl.edu.pjwstk.interpreter.qres.QresStack;
import pl.edu.pjwstk.interpreter.qres.StringResult;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class Interpreter implements IInterpreter {

    private QresStack stack;

    protected Interpreter() {
        stack = new QresStack();
    }

    @Override
    public IAbstractQueryResult eval(IExpression queryTreeRoot) {
        return null;
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
        expr.getLeftExpression().accept(this);
        expr.getRightExpression().accept(this);

        IAbstractQueryResult right = stack.pop();
        IAbstractQueryResult left = stack.pop();

        //TODO dereferencja dla right, left

        try {
            right = getResult(right);
            left = getResult(left);
        } catch (RuntimeException e) {
            throw new WrongTypeException("Unable to retrieve a single value");
        }

        if (left instanceof IStringResult || right instanceof IStringResult) {
            stack.push(new StringResult(((IStringResult) left).getValue() + ((IStringResult) right).getValue()));
        }

        boolean isDoubleInstance = false;
        Double result = 0.0;
        if (left instanceof IIntegerResult) {
            result += ((IIntegerResult) left).getValue();
        } else if (left instanceof IDoubleResult) {
            result += ((IDoubleResult) left).getValue();
            isDoubleInstance = true;
        } else {
            throw new WrongTypeException("Only Integer or Double are allowed. " + left.getClass() + " was used");
        }

        if (right instanceof IIntegerResult) {
            result += ((IIntegerResult) right).getValue();
        } else if (right instanceof IDoubleResult) {
            result += ((IDoubleResult) right).getValue();
            isDoubleInstance = true;
        } else {
            throw new WrongTypeException("Only Integer or Double are allowed. " + right.getClass() + " was used");
        }

        if (isDoubleInstance) {
            stack.push(new DoubleResult(result));
        } else {
            stack.push(new IntegerResult(result.intValue()));
        }
    }

    private ISingleResult getResult(IAbstractQueryResult result) {
        if (result instanceof ISingleResult) {
            if (result instanceof IStructResult) {
                List<ISingleResult> list = ((IStructResult) result).elements();
                if (list.size() == 1) {
                    ISingleResult singleResult = list.get(0);

                    if (singleResult instanceof IStructResult) {
                        return getResult(singleResult);
                    }

                    return singleResult;
                } else {
                    throw new WrongTypeException();
                }
            }

            return (ISingleResult) result;
        }

        if (result instanceof IBagResult) {
            Collection<ISingleResult> collection = ((IBagResult) result).getElements();
            Iterator<ISingleResult> iterator = collection.iterator();
            if (iterator.hasNext()) {
                ISingleResult singleResult = iterator.next();
                if (singleResult instanceof IStructResult) {
                    return getResult(singleResult);
                }
                return singleResult;
            } else {
                throw new WrongTypeException();
            }
        }

        if (result instanceof ISequenceResult) {
            List<ISingleResult> list = ((ISequenceResult) result).getElements();
            if (list.size() == 1) {
                ISingleResult singleResult = list.get(0);

                if (singleResult instanceof IStructResult) {
                    return getResult(singleResult);
                }

                return singleResult;
            } else {
                throw new WrongTypeException();
            }
        }
        throw new WrongTypeException();
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
    }
}

