/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.Logic.Model.Moves;

import neutron.Logic.Interfaces.BorderElementType;
import neutron.Logic.Interfaces.IGameBorder;
import neutron.Logic.Interfaces.IGameBorderGenerator;
import neutron.Logic.Interfaces.IMove;
import neutron.Logic.Model.GameBorderGenerator;
import neutron.Utils.Position;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Marcin
 */
public class SWMoveTest {
    
    public SWMoveTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

        @Test
    public void move_sw_czysta_plansza_neutron() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new SWMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.Neutron, new Position(2, 2));
    
        assertEquals(BorderElementType.Blank, newBorder.getElement(2, 2));
        assertEquals(BorderElementType.Neutron, newBorder.getElement(3, 1));
        
        assertEquals(BorderElementType.Neutron, border.getElement(2, 2));
        assertEquals(BorderElementType.Blank, border.getElement(3, 1));
    }
    
    @Test
    public void move_se_czysta_plansza_brak_ruchu() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new SWMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.Black, new Position(4, 4));
    
        assertEquals(null, newBorder);
    }
    
    @Test
    public void move_se_czysta_plansza_ruchy_bialych() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new SWMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.White, new Position(0, 0));
    
        assertEquals(null, newBorder);
        
        newBorder = m.Move(border, BorderElementType.White, new Position(0, 1));

        assertEquals(BorderElementType.White, newBorder.getElement(1, 0));  
        assertEquals(BorderElementType.Blank, newBorder.getElement(0, 1));
        
        newBorder = m.Move(border, BorderElementType.White, new Position(0, 2));
        
        assertEquals(BorderElementType.White, newBorder.getElement(2, 0));
        assertEquals(BorderElementType.Blank, newBorder.getElement(0, 2));
        
        newBorder = m.Move(border, BorderElementType.White, new Position(0, 3));
        
        assertEquals(BorderElementType.White, newBorder.getElement(3, 0));
        assertEquals(BorderElementType.Blank, newBorder.getElement(0, 3));
        
        newBorder = m.Move(border, BorderElementType.White, new Position(0, 4));
    
        assertEquals(BorderElementType.White, newBorder.getElement(1, 3));
        assertEquals(BorderElementType.Blank, newBorder.getElement(0, 4));
    }
}
