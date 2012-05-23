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
                
        if(pos.getX() >= border.getBorderSize() - 1 || pos.getY() == 0) {
            return null; 
        }
        
        BorderElementType[][] b = border.copyBorder();
        
        int i = pos.getX() + 1;
        int j = pos.getY() - 1;
        
        while(true) {
            
            if(i < border.getBorderSize() && j >= 0 && border.getElement(i, j) != BorderElementType.Blank) {
                
                b[i - 1][j + 1] = type;
                b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                
                return GameBorderFactory.Create(b);
            }
            
            if(i >= border.getBorderSize() || j < 0) {
                
                b[i - 1][j + 1] = type;
                b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                
                return GameBorderFactory.Create(b);
            }
            
            ++i;
            --j;
        }
    }
    
}
