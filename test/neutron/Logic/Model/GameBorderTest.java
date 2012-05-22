/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.Logic.Model;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameBorderGenerator;
import neutron.Utils.Position;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marcin
 */
public class GameBorderTest {
    
    public GameBorderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void get_border() {
        IGameBorderGenerator generator = new GameBorderGenerator();
        IGameBorder instance = generator.generateNewGame(5);
        
        BorderElementType[][] result = instance.getBorder();
        assertNotNull(result);
        assertEquals(5, result.length);
    }

    @Test
    public void get_neutron_position() {
        IGameBorderGenerator generator = new GameBorderGenerator();
        IGameBorder instance = generator.generateNewGame(5);

        Position result = instance.getNeutronPosition();

        assertNotNull(result);
        assertEquals(2, result.getX());
        assertEquals(2, result.getY());
    }

    @Test
    public void get_border_size() {
        
        IGameBorderGenerator generator = new GameBorderGenerator();
        IGameBorder instance = generator.generateNewGame(5);

        int expResult = 5;
        int result = instance.getBorderSize();
        assertEquals(expResult, result);
    }

    @Test
    public void get_element() {
        IGameBorderGenerator generator = new GameBorderGenerator();
        IGameBorder instance = generator.generateNewGame(5);

        BorderElementType result = instance.getElement(0, 0);
        assertEquals(BorderElementType.White, result);
        
        result = instance.getElement(2, 2);
        assertEquals(BorderElementType.Neutron, result);
        
        result = instance.getElement(1, 1);
        assertEquals(BorderElementType.Blank, result);
    }
}
