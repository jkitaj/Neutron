package neutron.Logic.Model;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;

/**
 * @author Marcin
 */
public class GameBorder implements IGameBorder {
    
    private BorderElementType[][] border;
    
    public GameBorder(BorderElementType[][] border){
        this.border = border;
    }

    @Override
    public BorderElementType[][] getBorder() {
        return border;
    }
}
