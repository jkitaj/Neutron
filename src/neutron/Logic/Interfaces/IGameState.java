package neutron.Logic.Interfaces;

/**
 * In general IGameState describes specific state of the game.
 * @author Marcin
 */
public interface IGameState {
    IGameBorder getGameBorder();

    Player getActualPlayer();
}
