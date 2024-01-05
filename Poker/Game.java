package Poker2;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<Player> players = new ArrayList<>();
	
	private Player dealer;
	private Player sBlinder;
	private Player bBlinder;
	
	private Player playerToPlay;
	
	private int currentRound = 0;
	
	private int pot;
	private int smallBlind;
	private int bigBlind;
	
	private Deck deck = Deck.completeDeck();
	
	/**
	 * 
	 * @param smallBlind - Small blind to be played with
	 * @param ratio - Ratio between small and big blinds. For example, if ratio = {2, 1}, it means 2:1, 
	 *          so the big blind will be double the small blind.
	 */
	public Game(int smallBlind, int[] ratio) {
		if (ratio.length > 2) {
		    throw new IllegalArgumentException("Ratio must have two numbers");
		}
		this.smallBlind = smallBlind * ratio[1];
		this.bigBlind = smallBlind * ratio[0];
	}

	public Game addPlayer(Player player) {
		players.add(player);
		return this;
	}

	public void start() {
		if (!(players.size() >= 2)) {
			throw new RuntimeException("Not enough players to begin the game");
		}
		
		assignRoles(currentRound);
		
		deck.sort();
	}

	private void assignRoles(int dealer) {
		this.dealer = players.get(dealer);
		this.sBlinder = players.get((dealer + 1) % players.size());
		this.bBlinder = players.get((dealer + 2) % players.size());
		this.playerToPlay = players.get((dealer + 3) % players.size());
	}
	
	public Player dealer() {
		return this.dealer;
	}
	
	public Player smallBlinder() {
		return this.sBlinder;
	}
	
	public Player bigBlinder() {
		return this.bBlinder;
	}
	
	public Player playerToPlay() {
		return this.playerToPlay;
	}

	public int pot() {
		return this.pot;
	}
	
	public int smallBlind() {
		return this.smallBlind;
	}
	
	public int bigBlind() {
		return this.bigBlind;
	}

	public void dealCards() {
		for (Player player : players) {
			player.receiveCardFrom(deck).receiveCardFrom(deck);
        }
	}

}
