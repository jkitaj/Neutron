package neutron.Logic.Interfaces;

/**
 * @author Marcin
 */
public interface IHeuristics {
    /*
     * Computes heuristics value for the specified game state.
     */
    double heuristicsValue(IGameState gameState);
}
