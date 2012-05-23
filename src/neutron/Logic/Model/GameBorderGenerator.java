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
}
