package neutron.Logic.Model;

import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameState;
import neutron.Logic.Interfaces.Player;

/**
 * @author Marcin
 */
public class GameState implements IGameState {

    private IGameBorder gameBorder;
    private Player actualPlayer;
    
    public GameState(IGameBorder gameBorder, Player actualPlayer) {
        this.gameBorder = gameBorder;
        this.actualPlayer = actualPlayer;
    }
    
    @Override
    public IGameBorder getGameBorder() {
        return gameBorder;
    }

    @Override
    public Player getActualPlayer() {
        return actualPlayer;
    }    
}
