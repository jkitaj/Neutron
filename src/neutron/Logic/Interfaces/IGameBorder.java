package neutron.Logic.Interfaces;

import neutron.Utils.Position;

/**
 * It describes game border. Contains information about actual
 * each players soldiers positions and neutron position.
 * @author Marcin
 */
public interface IGameBorder {
    
    BorderElementType[][] getBorder();

    Position getNeutronPosition();
}
