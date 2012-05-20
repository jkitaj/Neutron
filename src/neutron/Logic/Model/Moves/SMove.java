package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorderFactory;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class SMove implements IMove {

    @Override
    public IGameBorder Move(IGameBorder border, BorderElementType type, Position pos) {
        
        BorderElementType[][] b = border.copyBorder();
        
        if(pos.getX() == b.length - 1) {
            return null; // ruch w kierunku S nie jest mozliwy
        }
        
        for(int j = pos.getX() + 1; j < b.length; ++j) {  
            if(b[j][pos.getY()] != BorderElementType.Blank) {
                if(j - 1 != pos.getX()) {
                    // jezeli napotkano element, i poprzednik tego elementu na osi y, nie jest
                    // elementem wejsciowym funkcji, to znaczy ze znaleziono ruch N.
                    
                    b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                    b[j - 1][pos.getY()] = type;
                
                    return GameBorderFactory.Create(b);
                }
                else {
                    return null;
                }
                    
            }
        }            
        
        // jezeli nie napotkano przeszkody to oznacza, ze element mozna polozyc na samym dole.
        b[pos.getX()][pos.getY()] = BorderElementType.Blank;
        b[b.length-1][pos.getY()] = type;
                
        return GameBorderFactory.Create(b);
    }
    
}
