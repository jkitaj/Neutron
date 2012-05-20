package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorderFactory;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class NWMove implements IMove {

    @Override
    public IGameBorder Move(IGameBorder border, BorderElementType type, Position pos) {
       
        if(pos.getX() == 0) {
            return null; 
        }
        
        BorderElementType[][] b = border.copyBorder();
        
        // jezeli nie napotkano przeszkody to oznacza, ze element mozna polozyc na samej gorze.
        b[pos.getX()][pos.getY()] = BorderElementType.Blank;
        b[0][0] = type;
                
        return GameBorderFactory.Create(b);
    }
    
}
