package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorderFactory;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class WMove implements IMove {

    @Override
    public IGameBorder Move(IGameBorder border, BorderElementType type, Position pos) {
        BorderElementType[][] b = border.copyBorder();
        
        if(pos.getY() == 0) {
            return null; // ruch w kierunku E nie jest mozliwy
        }
        
        for(int j = pos.getY() - 1; j >= 0; --j) {  
            if(b[pos.getX()][j] != BorderElementType.Blank) {
                if(j + 1 != pos.getY()) {

                    b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                    b[pos.getX()][j + 1] = type;
                
                    return GameBorderFactory.Create(b);
                }
                else {
                    return null;
                }
                    
            }
        }            
        
        b[pos.getX()][pos.getY()] = BorderElementType.Blank;
        b[pos.getX()][0] = type;
                
        return GameBorderFactory.Create(b);
    }    
}
