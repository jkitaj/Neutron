/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameBorderGenerator;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorder;
import neutron.Logic.Model.GameBorderGenerator;
import neutron.Utils.Position;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marcin
 */
public class EMoveTest {
    
    public EMoveTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void move_e_czysta_plansza_neutron() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new EMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.Neutron, new Position(2, 2));
        
        assertEquals(BorderElementType.Blank, newBorder.getElement(2, 2));
        assertEquals(BorderElementType.Neutron, newBorder.getElement(2, 4));
        
        assertEquals(BorderElementType.Neutron, border.getElement(2, 2));
        assertEquals(BorderElementType.Blank, border.getElement(2, 4));
    }
    
    @Test
    public void move_e_czysta_plansza_brak_ruchu() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new EMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.White, new Position(0, 4));
    
        assertEquals(null, newBorder);
    }
    
    @Test
    public void brak_ruchu_w_kierunku_e() {

        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new EMove();       
        IGameBorder firstStep = m.Move(border, BorderElementType.Neutron, new Position(2, 2));
    
        BorderElementType[][] b = firstStep.getBorder();
        b[2][3] = BorderElementType.Black;
        
        IGameBorder secondStep = new GameBorder(b);
        secondStep.write();
        
        m = new EMove();
        IGameBorder newBorder = m.Move(secondStep, BorderElementType.Black, new Position(2, 3));
        
        assertNull(newBorder);
   }
}
