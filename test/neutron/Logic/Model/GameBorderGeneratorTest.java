/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.Logic.Model;

import java.util.List;
import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameBorderGenerator;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.Moves.NWMove;
import neutron.Logic.Model.Moves.SMove;
import neutron.Utils.Position;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marcin
 */
public class GameBorderGeneratorTest {
    
    public GameBorderGeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void generate_new_game() {
        
        IGameBorderGenerator instance = new GameBorderGenerator();
        IGameBorder result = instance.generateNewGame(3);
        
        assertNotNull(result);
        assertEquals(3, result.getBorderSize());

        BorderElementType[][] border = result.getBorder();
        
        assertEquals(BorderElementType.White, border[0][0]);
        assertEquals(BorderElementType.White, border[0][1]);
        assertEquals(BorderElementType.White, border[0][2]);
        
        assertEquals(BorderElementType.Blank, border[1][0]);
        assertEquals(BorderElementType.Neutron, border[1][1]);
        assertEquals(BorderElementType.Blank, border[1][2]);

        assertEquals(BorderElementType.Black, border[2][0]);
        assertEquals(BorderElementType.Black, border[2][1]);
        assertEquals(BorderElementType.Black, border[2][2]);
    }
}
