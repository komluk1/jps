package pl.edu.pjwstk.interpreter.envs;

import edu.pjwstk.jps.interpreter.envs.IENVSBinder;
import edu.pjwstk.jps.interpreter.envs.IENVSFrame;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Piotr Sukiennik
 * Date: 13.10.13
 * Time: 09:35
 * To change this template use File | Settings | File Templates.
 */
public class ENVSFrame implements IENVSFrame {

    private Collection<IENVSBinder> elements;

    public ENVSFrame(Collection<IENVSBinder> elements) {
        this.elements = elements;
    }

    @Override
    public Collection<IENVSBinder> getElements() {
        return elements;
    }
}
