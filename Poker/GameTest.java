package Poker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GameTest {
	
	@Test public void test01eachPlayerStartsWithCorrectAmountOfChips() {
		Game game = new Game();
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player01);
		game.start();
		
		assertTrue((player01.chips() == 50 && player02.chips() == 60));
	}
	
	@Test public void test02rolesAreCorrectlyAssignedTWOPEOPLE() {
		Game game = new Game();
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player02);
		game.start();
		
		assertTrue(game.dealer() == player01
				&& game.smallBlind() == player02
				&& game.bigBlind() == player01
				&& game.playerToPlay() == player02);
	}
	
	@Test public void test03rolesAreCorrectlyAssignedTHREEPEOPLE() {
		Game game = new Game();
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		Player player03 = new Player("Walter", 60);
		
		game.addPlayer(player01).addPlayer(player02).addPlayer(player03);
		game.start();
		
		assertTrue(game.dealer() == player01
				&& game.smallBlind() == player02
				&& game.bigBlind() == player03
				&& game.playerToPlay() == player01);
	}
	
	@Test public void test04rolesAreCorrectlyAssignedTHREEORMOREPEOPLE() {
		Game game = new Game();
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		Player player03 = new Player("Walter", 60);
		Player player04 = new Player("Jesse", 60);
		
		game.addPlayer(player01).addPlayer(player02).addPlayer(player03).addPlayer(player04);
		game.start();
		
		assertTrue(game.dealer() == player01
				&& game.smallBlind() == player02
				&& game.bigBlind() == player03
				&& game.playerToPlay() == player04);
	}
	
	@Test public void test05PotStartsEmpty() {
		Game game = new Game();
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player02);
		game.start();
		
		assertEquals(0, game.pot());
	}
	
}
