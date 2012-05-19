package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorderFactory;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class NMove implements IMove {
    
    @Override
    public IGameBorder Move(IGameBorder border, BorderElementType type, Position pos) {
        
        //@todo - sprawdzic czy w javie te tablice sa przez referencje czy przez wartosc
        //jezeli przez wartosc to to nizej nie dziala
        
        BorderElementType[][] b = border.getBorder();
        
        if(pos.getY() == 0) {
            return null; // ruch w kierunku N nie jest mozliwy
        }
        
        for(int j = pos.getY() - 1; j >= 0; --j) {  
            if(b[pos.getX()][j] != BorderElementType.Blank) {
                if(j - 1 != pos.getY()) {
                    // jezeli napotkano element, i poprzednik tego elementu na osi y, nie jest
                    // elementem wejsciowym funkcji, to znaczy ze znaleziono ruch N.
                    
                    b[pos.getX()][pos.getY()] = BorderElementType.Blank;
                    b[pos.getX()][j - 1] = type;
                
                    return GameBorderFactory.Create(b);
                }
                else {
                    return null;
                }
                    
            }
        }            
        
        // jezeli nie napotkano przeszkody to oznacza, ze element mozna polozyc na samej gorze.
        b[pos.getX()][pos.getY()] = BorderElementType.Blank;
        b[pos.getX()][0] = type;
                
        return GameBorderFactory.Create(b);
    }    
}
