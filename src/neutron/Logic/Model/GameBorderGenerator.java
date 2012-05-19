package neutron.Logic.Model;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameBorderGenerator;

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
            for(int j = 0; j < borderSize; ++j) {
                if(i == 0) {
                    border[0][j] = BorderElementType.White;
                }
                else if(i == borderSize - 1) {
                    border[i][j] = BorderElementType.Black;
                }
                else {
                    border[i][j] = BorderElementType.Blank;
                }
            }
        }
        
        int pos = (int)Math.ceil(borderSize / 2);
        border[pos][pos] = BorderElementType.Neutron;
        
        return new GameBorder(border);
    }
}
