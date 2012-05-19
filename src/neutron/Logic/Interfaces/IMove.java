package neutron.Logic.Interfaces;

import neutron.Utils.Position;

/**
 * @author Marcin
 */
public interface IMove {
    /*
     * Returns game border after change specific element position.
     */
    IGameBorder Move(IGameBorder border, BorderElementType type, Position pos);
}
