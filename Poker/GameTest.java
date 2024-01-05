package Poker2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GameTest {
	
	@Test public void test01eachPlayerStartsWithCorrectAmountOfChips() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player01);
		game.start();
		
		assertTrue((player01.chips() == 50 && player02.chips() == 60));
	}
	
	@Test public void test02rolesAreCorrectlyAssignedTWOPEOPLE() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player02);
		game.start();
		
		assertTrue(game.dealer() == player01
				&& game.smallBlinder() == player02
				&& game.bigBlinder() == player01
				&& game.playerToPlay() == player02);
	}
	
	@Test public void test03rolesAreCorrectlyAssignedTHREEPEOPLE() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		Player player03 = new Player("Walter", 60);
		
		game.addPlayer(player01).addPlayer(player02).addPlayer(player03);
		game.start();
		
		assertTrue(game.dealer() == player01
				&& game.smallBlinder() == player02
				&& game.bigBlinder() == player03
				&& game.playerToPlay() == player01);
	}
	
	@Test public void test04rolesAreCorrectlyAssignedTHREEORMOREPEOPLE() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		Player player03 = new Player("Walter", 60);
		Player player04 = new Player("Jesse", 60);
		
		game.addPlayer(player01).addPlayer(player02).addPlayer(player03).addPlayer(player04);
		game.start();
		
		assertTrue(game.dealer() == player01
				&& game.smallBlinder() == player02
				&& game.bigBlinder() == player03
				&& game.playerToPlay() == player04);
	}
	
	@Test public void test05BlindsAreCorrectlyAssigned() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player02);
		game.start();
		
		assertTrue(game.smallBlind() == 5 && game.bigBlind() == 10);
	}
	
	@Test public void test06GameDoesNotStartWithOneOrLessPLayers() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		
		game.addPlayer(player01);
		
		assertThrowsLike(() -> game.start(), "Not enough players to begin the game");
	}
	
	@Test public void test07MustInsertValidRatio() {
		assertThrowsLike(() -> new Game(5, new int[]{2, 1, 3}), "Ratio must have two numbers");
	}
	
	@Test public void test08deckHasAllCards() {
		Deck deck = Deck.completeDeck();
		
		assertTrue(deck.cards().size() == 52);
	}
	
	@Test public void test09deckStartsInOrder() {
		Deck deck = Deck.completeDeck();
		
		assertTrue(deck.getCardAt(0).equals(new Card(Rank.ACE, Suit.HEARTS)) 
				&& deck.getCardAt(1).equals(new Card(Rank.TWO, Suit.HEARTS)));
	}
	
	@Test public void test10deckSortsRandomly() {
		Deck deck01 = Deck.completeDeck();
		Deck deck02 = Deck.completeDeck().sort();
		
		assertFalse(deck01.getCardAt(0).equals(deck02.getCardAt(0)) 
				 || deck01.getCardAt(1).equals(deck02.getCardAt(1))
				 || deck01.getCardAt(2).equals(deck02.getCardAt(2))
				 || deck01.getCardAt(3).equals(deck02.getCardAt(3)));
	}
	
	@Test public void test11eachPlayerGetsTwoCards() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player02);
		game.start();
		game.dealCards();
		
		assertTrue(player01.deck().cards().size() == 2 && player02.deck().cards().size() == 2);
	}
	
	@Test public void test12eachPlayerGetsTwoCardsMORETHANTWO() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		Player player03 = new Player("Walter", 60);
		Player player04 = new Player("Jesse", 60);
		
		game.addPlayer(player01).addPlayer(player02).addPlayer(player03).addPlayer(player04);
		game.start();
		game.dealCards();
		
		assertTrue(player01.deck().cards().size() == 2 
				&& player02.deck().cards().size() == 2
				&& player03.deck().cards().size() == 2
				&& player04.deck().cards().size() == 2);
	}
	
	@Test public void test12eachPlayerGetsDifferentCards() {
		Game game = new Game(5, new int[]{2, 1});
		Player player01 = new Player("Gustavo", 50);
		Player player02 = new Player("Saul", 60);
		
		game.addPlayer(player01).addPlayer(player02);
		game.start();
		game.dealCards();
		
		assertFalse(player01.deck().getCardAt(0).equals(player02.deck().getCardAt(0))
				 || player01.deck().getCardAt(0).equals(player02.deck().getCardAt(1))
				 || player01.deck().getCardAt(1).equals(player02.deck().getCardAt(0))
				 || player01.deck().getCardAt(1).equals(player02.deck().getCardAt(1)));
	}
	
	private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message, assertThrows(Exception.class, executable).getMessage());
	}
	
}
