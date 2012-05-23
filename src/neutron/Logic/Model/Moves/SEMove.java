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
            
        if(pos.getX() == border.getBorderSize() - 1 || pos.getY() == border.getBorderSize() - 1) {
            return null; 
        }
        
        BorderElementType[][] b = border.copyBorder();
        
        int i = pos.getX() + 1;
        int j = pos.getY() + 1;
        
        while(true) {
            
            if(i < border.getBorderSize() && j < border.getBorderSize() && border.getElement(i, j) != BorderElementType.Blank) {
                
                if(i - 1 == pos.getX() && j - 1 == pos.getY()) {
                    return null;
                } 
                
                b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                b[i - 1][j - 1] = type;
                
                return GameBorderFactory.Create(b);
            }
            
            if(i >= border.getBorderSize() || j >= border.getBorderSize()) {
                
                if(i - 1 == pos.getX() && j - 1 == pos.getY()) {
                    return null;
                }
                
                b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                b[i - 1][j - 1] = type;
                
                return GameBorderFactory.Create(b);
            }
            
            ++i;
            ++j;
        }
    }
}
