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
    private ILogger logger;
    
    public Algorithm(IHeuristics heuristics, IGameStateGenerator gameStateGenerator, ILogger logger)
    {
        this.heuristics = heuristics;
        this.gameStateGenerator = gameStateGenerator;
        this.logger = logger;
    }
    
    @Override
    public IGameState alfabeta(IGameState gameState, int depth) {        
        
        logger.writeMessage("Obliczenie ruchu dla stanu gry:");
        logger.writeMessage(gameState.toString());
        
        return null;
    }
    
    private double alfabeta(IGameState gameState, int depth, double alpha, double beta) {

        if(depth == 0) {
            logger.writeMessage("Osiągnięto maksymalną głębokość przeszukiwania.");
            return heuristics.heuristicsValue(gameState);
        }
        
        List<IGameState> moves = gameStateGenerator.getNexts(gameState);
        if(moves == null || moves.isEmpty()) {
            logger.writeMessage("Nie ma więcej ruchów do przeglądania.");
            return heuristics.heuristicsValue(gameState);
        }

        if(gameState.getActualPlayer() == Player.Enemy) {
            logger.writeMessage("Ruch przeciwnika.");
            for(IGameState gs : moves) {
                beta = Math.min(beta, alfabeta(gs, depth - 1, alpha, beta));
                if(alpha >= beta)
                {
                    logger.writeMessage("Alfa-obcięcie.");
                    return alpha;
                }
            }
            return beta;
        }
        else {
            logger.writeMessage("Ruch aktualnego gracza.");
            for(IGameState gs : moves) {
                alpha = Math.max(alpha, alfabeta(gs, depth - 1, alpha, beta));
                if(alpha >= beta)
                {
                    logger.writeMessage("Beta-obcięcie.");
                    return beta;
                }
            }
            return alpha;
        }
    }
}
