package neutron.Logic.Model;

import java.util.LinkedList;
import java.util.List;
import neutron.Logic.Exceptions.NeutronBlockedException;
import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameBorderGenerator;
import neutron.Logic.Model.Moves.MovesRunner;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class GameBorderGenerator implements IGameBorderGenerator {

    @Override
    public IGameBorder generateNewGame(int borderSize) {
        
        if(borderSize % 2 == 0) {
            throw new IllegalArgumentException("BorderSize heve to be odd.");
        }
        
        BorderElementType[][] border = new BorderElementType[borderSize][borderSize];
        
        for(int i = 0; i < borderSize; ++i) {
            
            border[0][i] = BorderElementType.White;
            border[borderSize - 1][i] = BorderElementType.Black;            
            
            for(int j = 0; j < borderSize; ++j) {
                if(i != 0 && i != borderSize - 1) {
                    border[i][j] = BorderElementType.Blank;
                }
            }
        }
        
        int pos = (int)Math.ceil(borderSize / 2);
        border[pos][pos] = BorderElementType.Neutron;
        
        return GameBorderFactory.Create(border);
    }

    @Override
    public List<IGameBorder> generatePossibleMoves(
            IGameBorder gameBorder, BorderElementType player) throws NeutronBlockedException {
        
        if(player != BorderElementType.Black && player != BorderElementType.White) {
            throw new IllegalArgumentException();
        }
        
        List<IGameBorder> neutronMoves = generatePossibleNeutronMoves(gameBorder);
            
        if(neutronMoves.isEmpty()) {
            return null; // dla tego gameBorder nie da sie zrobic ruchu, neutron zablokowany
        }
        
        List<IGameBorder> allMoves = generatePossibleMoves(neutronMoves, player);

        if(allMoves.isEmpty()) {
            return null; // dla tego gameBorder nie da sie zrobic ruchu, neutron zablokowany
        }
                
        return allMoves;
    }
    
    private List<IGameBorder> generatePossibleMoves(List<IGameBorder> neutronMoves, BorderElementType player) {
        
        List<IGameBorder> list = new LinkedList<IGameBorder>();
        int borderSize = neutronMoves.get(0).getBorderSize();
        
        for(IGameBorder nm: neutronMoves) {
            for(int i = 0; i < borderSize; ++i) {
                for(int j = 0; j < borderSize; ++j) {
                    if(nm.getElement(i, j) == player) {
                        list.addAll(MovesRunner.ExecuteMoves(nm, player, new Position(i, j)));
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
