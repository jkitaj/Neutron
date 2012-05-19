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

    /*
     * Genretates all possible moves for player which is described by parameter.
     * player - BorderElementType.Black or BorderElementType.White.
     * Return null if any move is possible.
     */
    List<IGameBorder> generatePossibleMoves(
            IGameBorder gameBorder, BorderElementType player) throws NeutronBlockedException; 
}
