package neutron.Logic.Model;

import java.util.LinkedList;
import java.util.List;
import neutron.Logic.Exceptions.NeutronBlockedException;
import neutron.Logic.Interfaces.*;
import neutron.Logic.Model.Moves.MovesRunner;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class GameStateGenerator implements IGameStateGenerator {

    @Override
    public List<IGameState> getNexts(IGameState gameState) {

        IGameBorder gameBorder = gameState.getGameBorder();
        Player player = gameState.getActualPlayer();
        
        List<IGameBorder> neutronMoves = generatePossibleNeutronMoves(gameBorder);
            
        if(neutronMoves.isEmpty()) {
            return null; // dla tego gameBorder nie da sie zrobic ruchu, neutron zablokowany
        }
        
        List<IGameState> allMoves = generatePossibleMoves(neutronMoves, player);

        if(allMoves.isEmpty()) {
            return null; // dla tego gameBorder nie da sie zrobic ruchu, neutron zablokowany
        }
                
        return allMoves;
    }
   
    private List<IGameState> generatePossibleMoves(List<IGameBorder> neutronMoves, Player player) {
        
        BorderElementType t = player == Player.Player ? 
                BorderElementType.White : 
                BorderElementType.Black;
        Player nextPlayer = player == Player.Player ?
                Player.Enemy :
                Player.Player;
        
        List<IGameState> list = new LinkedList<IGameState>();
        int borderSize = neutronMoves.get(0).getBorderSize();
        
        for(IGameBorder nm: neutronMoves) {
            for(int i = 0; i < borderSize; ++i) {
                for(int j = 0; j < borderSize; ++j) {
                    if(nm.getElement(i, j) == t) {
                        List<IGameBorder> states =  MovesRunner.ExecuteMoves(nm, t, new Position(i, j));
                        for(IGameBorder s : states) {
                            list.add(new GameState(s, nextPlayer));
                        }
                    }
                }
            }            
        }
        
        return list;
    }
    
    private List<IGameBorder> generatePossibleNeutronMoves(IGameBorder gameBorder) {

        Position currentNeutronPosition = gameBorder.getNeutronPosition();
        return MovesRunner.ExecuteMoves(gameBorder, BorderElementType.Neutron, currentNeutronPosition);
    }
}
