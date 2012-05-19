package neutron.Logic.Model;

import java.util.List;
import neutron.Logic.Exceptions.GameStateException;
import neutron.Logic.Interfaces.*;

/**
 * @author Marcin
 */
public class Algorithm implements IAlgorithm {

    private IHeuristics heuristics;
    private IGameStateGenerator gameStateGenerator;
    private ILogger logger;
    
    public Algorithm(IHeuristics heuristics, IGameStateGenerator gameStateGenerator, ILogger logger) {
        this.heuristics = heuristics;
        this.gameStateGenerator = gameStateGenerator;
        this.logger = logger;
    }
    
    @Override
    public IGameState alfabeta(IGameState gameState, int depth) throws GameStateException {        
        
        logger.writeMessage("Obliczenie ruchu dla stanu gry:");
        logger.writeMessage(gameState.toString());
        
        List<IGameState> moves = gameStateGenerator.getNexts(gameState);
        if(moves == null || moves.isEmpty()) {
            String msg = "Nie można wykonać kolejnych ruchów.";
            throw new GameStateException(msg);
        }
        
        // wyszukujemy i zwracamy ruch ktory jest maxem dla gracza ktory wywolal metode
        // to jest do refaktoryzacji, bo mozna od razu skorzystac z prywatenj metody alfa-beta,
        // ale tak bylo mi latwiej na pierwszy ogien zlapac odpowiedni nowy ruch
        
        double max = Double.MIN_VALUE;
        IGameState bestState = null;
        
        for(IGameState gs : moves) {
            double val = Math.max(max, alfabeta(gs, depth - 1, Double.MIN_VALUE, Double.MAX_VALUE));
            if(val >= max) {
                bestState = gs;
                max = val;
            }
        }

        logger.writeMessage("Najlepszy znaleziony ruch dla gracza to:");
        logger.writeMessage(bestState.toString()); // null argument exception nie ma prawa sie wydarzyc
        
        return bestState;
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
