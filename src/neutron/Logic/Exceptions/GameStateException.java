package neutron.Logic.Exceptions;

/**
 *
 * @author Marcin
 */
public class GameStateException extends Exception {

    private String message;
    
    public GameStateException(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
