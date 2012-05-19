package neutron.Logic.Interfaces;

/**
 * Represents Alpha-beta algorithm.
 * @author Marcin
 */
public interface IAlgorithm {
    /*
     * Calculates new game state.
     * 
     * gameState - initial game state
     * depth - max depth searched in the tree
     */
    IGameState alfabeta(IGameState gameState, int depth);    
}
