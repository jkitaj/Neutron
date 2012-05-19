package neutron.Logic.Model.Moves;

import java.util.LinkedList;
import java.util.List;
import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IMove;
import neutron.Utils.Position;

/**
 * @author Marcin
 */
public class MovesRunner {
    
    public static List<IGameBorder> ExecuteMoves(IGameBorder border, BorderElementType type, Position pos) {
        
        List<IGameBorder> list = new LinkedList<IGameBorder>();
        
        ExecuteMove(new NMove(), list, border, type, pos);
        ExecuteMove(new SMove(), list, border, type, pos);
        ExecuteMove(new EMove(), list, border, type, pos);
        ExecuteMove(new WMove(), list, border, type, pos);
        ExecuteMove(new NEMove(), list, border, type, pos);
        ExecuteMove(new NWMove(), list, border, type, pos);
        ExecuteMove(new SEMove(), list, border, type, pos);
        ExecuteMove(new SWMove(), list, border, type, pos);
        
        return list;
    }
    
    private static void ExecuteMove(IMove m, List<IGameBorder> list, IGameBorder border, BorderElementType type, Position pos) {
        IGameBorder b = m.Move(border, type, pos);
        if(b != null) {
            list.add(b);
        }
    }    
}
