package neutron.Logic.Model;

import java.util.List;
import neutron.Logic.Interfaces.*;

/**
 *
 * @author Marcin
 */
public class Algorithm implements IAlgorithm {

    private IHeuristics heuristics;
    private IGameStateGenerator gameStateGenerator;
    
    public Algorithm(IHeuristics heuristics, IGameStateGenerator gameStateGenerator)
    {
        this.heuristics = heuristics;
        this.gameStateGenerator = gameStateGenerator;
    }
    
    @Override
    public IGameState alfabeta(IGameState gameState, int depth) {

        
        
        
        return null;
    }
    
    private double alfabeta(IGameState gameState, int depth, double alpha, double beta) {

        if(depth == 0) {
            return heuristics.heuristicsValue(gameState);
        }
        
        List<IGameState> moves = gameStateGenerator.getNexts(gameState);
        if(moves == null || moves.isEmpty()) {
            return heuristics.heuristicsValue(gameState);
        }

        if(gameState.getActualPlayer() == Player.Enemy) {
            for(IGameState gs : moves) {
                beta = Math.min(beta, alfabeta(gs, depth - 1, alpha, beta));
                if(alpha >= beta)
                {
                    return alpha;
                }
            }
            return beta;
        }
        else {
            for(IGameState gs : moves) {
                alpha = Math.max(alpha, alfabeta(gs, depth - 1, alpha, beta));
                if(alpha >= beta)
                {
                    return beta;
                }
            }
            return alpha;
        }
    }
}
