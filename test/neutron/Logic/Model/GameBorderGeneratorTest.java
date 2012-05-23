/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.Logic.Model;

import java.util.List;
import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameBorderGenerator;
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

    @Test
    public void new_game_generate_possible_moves() throws Exception {
        
        IGameBorderGenerator instance = new GameBorderGenerator();
        IGameBorder game = instance.generateNewGame(5);
        
        List result = instance.generatePossibleMoves(game, BorderElementType.Black);
        
        // wszystkich wygenerowanych ruchow powinno byc 95
        assertEquals(95, result.size());
    }
}
