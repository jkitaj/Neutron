package neutron.Logic.Model;

import neutron.Logic.Interfaces.ILogger;

/**
 * @author Marcin
 */
public class Logger implements ILogger {

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }
    
}
