package neutron.Logic.Exceptions;

import neutron.Logic.Interfaces.BorderElementType;

/**
 * @author Marcin
 */
public class NeutronBlockedException extends Exception {

    private BorderElementType looser;
    
    public NeutronBlockedException(BorderElementType looser) {
        this.looser = looser;
    }    
}
