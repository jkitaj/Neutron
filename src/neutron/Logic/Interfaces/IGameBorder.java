package neutron.Logic.Interfaces;

import neutron.Utils.Position;

/**
 * It describes game border. Contains information about actual
 * each players soldiers positions and neutron position.
 * @author Marcin
 */
public interface IGameBorder {
    
    int getBorderSize();
    BorderElementType getElement(int i, int j);
    
    BorderElementType[][] getBorder();

    BorderElementType[][] copyBorder();
    
    Position getNeutronPosition();

    void write();
}
