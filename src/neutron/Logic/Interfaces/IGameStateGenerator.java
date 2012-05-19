package neutron.Logic.Interfaces;

import java.util.List;

/**
 * @author Marcin
 */
public interface IGameStateGenerator {
    /*
     * Calculates a list of possible moves.
     * Returnes empty list if any move is possible.
     */
    List<IGameState> getNexts(IGameState gameState);
}
