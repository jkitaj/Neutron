package neutron.Logic.Interfaces;

import java.util.List;
import neutron.Logic.Exceptions.NeutronBlockedException;

/**
 * @author Marcin
 */
public interface IGameBorderGenerator {
    /*
     * Generates game border for new game.
     * borderSize - describes border size, it have to be odd.
     */
    IGameBorder generateNewGame(int borderSize);
}
