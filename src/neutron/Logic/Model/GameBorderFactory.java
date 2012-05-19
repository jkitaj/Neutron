package neutron.Logic.Model;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;

/**
 * @author Marcin
 */
public class GameBorderFactory {

    public static IGameBorder Create(BorderElementType[][] border) {   
        return new GameBorder(border);
    }
}
