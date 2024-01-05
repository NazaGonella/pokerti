package Poker;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<Player> players = new ArrayList<>();
	
	private Player dealer;
	private Player sB;
	private Player bB;
	
	private Player playerToPlay;
	
	private int currentRound = 0;
	
	private int pot = 0;

	public Game addPlayer(Player player) {
		players.add(player);
		return this;
	}

	public void start() {
		if (!(players.size() >= 2)) {
			throw new RuntimeException("Not enough players to begin the game");
		}
		
		assignRoles(currentRound);
	}

	private void assignRoles(int dealer) {
		this.dealer = players.get(dealer);
		this.sB = players.get((dealer + 1) % players.size());
		this.bB = players.get((dealer + 2) % players.size());
		this.playerToPlay = players.get((dealer + 3) % players.size());
	}
	
	public Player dealer() {
		return this.dealer;
	}
	
	public Player smallBlind() {
		return this.sB;
	}
	
	public Player bigBlind() {
		return this.bB;
	}
	
	public Player playerToPlay() {
		return this.playerToPlay;
	}

	public int pot() {
		return this.pot;
	}

}
