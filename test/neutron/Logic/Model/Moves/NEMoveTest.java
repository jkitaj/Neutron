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
public class NEMoveTest {
    
    public NEMoveTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void move_ne_czysta_plansza_neutron() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new NEMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.Neutron, new Position(2, 2));
    
        assertEquals(BorderElementType.Blank, newBorder.getElement(2, 2));
        assertEquals(BorderElementType.Neutron, newBorder.getElement(1, 3));
        
        assertEquals(BorderElementType.Neutron, border.getElement(2, 2));
        assertEquals(BorderElementType.Blank, border.getElement(1, 3));
    }
    
    @Test
    public void move_ne_czysta_plansza_brak_ruchu() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new NEMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.White, new Position(0, 0));
    
        assertEquals(null, newBorder);
    }
    
    @Test
    public void move_ne_czysta_plansza_ruchy_czarnych() {
        
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder border = gbg.generateNewGame(5); 
    
        IMove m = new NEMove();       
        IGameBorder newBorder = m.Move(border, BorderElementType.Black, new Position(4, 0));
    
        assertEquals(BorderElementType.Black, newBorder.getElement(3, 1));
        assertEquals(BorderElementType.Blank, newBorder.getElement(4, 0));
        
        newBorder = m.Move(border, BorderElementType.Black, new Position(4, 1));

        assertEquals(BorderElementType.Black, newBorder.getElement(1, 4));
        assertEquals(BorderElementType.Blank, newBorder.getElement(4, 1));
        
        newBorder = m.Move(border, BorderElementType.Black, new Position(4, 2));
        
        assertEquals(BorderElementType.Black, newBorder.getElement(2, 4));
        assertEquals(BorderElementType.Blank, newBorder.getElement(4, 2));
        
        newBorder = m.Move(border, BorderElementType.Black, new Position(4, 3));
        
        assertEquals(BorderElementType.Black, newBorder.getElement(3, 4));
        assertEquals(BorderElementType.Blank, newBorder.getElement(4, 3));
        
        newBorder = m.Move(border, BorderElementType.Black, new Position(4, 4));
    
        assertEquals(null, newBorder);
    }
}
