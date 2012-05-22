package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorderFactory;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class SWMove implements IMove {

    @Override
    public IGameBorder Move(IGameBorder border, BorderElementType type, Position pos) {
                
        if(pos.getX() == 0 || pos.getY() >= border.getBorderSize() - 1) {
            return null; 
        }
        
        BorderElementType[][] b = border.copyBorder();
        
        int i = pos.getX() - 1;
        int j = pos.getY() + 1;
        
        while(true) {
            
            if(i > 0 && j < border.getBorderSize() && border.getElement(i, j) != BorderElementType.Blank) {
                
                b[i + 1][j - 1] = type;
                b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                
                return GameBorderFactory.Create(b);
            }
            
            if(i <= 0 || j >= border.getBorderSize()) {
                
                b[i + 1][j - 1] = type;
                b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                
                return GameBorderFactory.Create(b);
            }
            
            --i;
            ++j;
        }
    }
    
}
