package neutron.Logic.Interfaces;

/**
 * @author Marcin
 */
public interface IGameBorderGenerator {
    /*
     * Generates game border for new game.
     * borderSize - describes border size, it have to be odd.
     */
    IGameBorder generateNewGame(int borderSize);
}
