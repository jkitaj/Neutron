package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorderFactory;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class SEMove implements IMove {

    @Override
    public IGameBorder Move(IGameBorder border, BorderElementType type, Position pos) {
            
        if(pos.getY() == border.getBorderSize() - 1) {
            return null; 
        }
        
        BorderElementType[][] b = border.copyBorder();
        
        b[pos.getX()][pos.getY()] = BorderElementType.Blank;
        b[border.getBorderSize() - 1][border.getBorderSize() - 1] = type;
                
        return GameBorderFactory.Create(b);
    }
    
}
