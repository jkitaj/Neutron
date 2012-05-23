/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neutron.Logic.Model;

import neutron.Logic.Interfaces.*;
import neutron.Logic.Model.Moves.SMove;
import neutron.Utils.Position;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Marcin
 */
public class AlgorithmTest {
    
    public AlgorithmTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void prosty_alfa_beta() throws Exception {
        
        //test sprawdza tylko 1 ruch
        IGameBorderGenerator gbg = new GameBorderGenerator();
        IGameBorder gameBorder = gbg.generateNewGame(5);
        
        IMove m = new SMove();
        m.Move(gameBorder, BorderElementType.White, new Position(0, 0));
        
        IGameState gameState = new GameState(gameBorder, Player.Player);
        
        int depth = 1;

        IHeuristics heuristics = null;
        IGameStateGenerator gameStateGenerator = null;
        ILogger logger = new Logger();
        
        IAlgorithm instance = new Algorithm(heuristics, gameStateGenerator, logger);
        
        IGameState expResult = null;
        IGameState result = instance.alfabeta(gameState, depth);
        
        assertEquals(expResult, result);
    }
}
