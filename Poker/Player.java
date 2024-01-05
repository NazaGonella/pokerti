package Poker2;

public class Player {
	
	private String name;
	private Deck deck;
	
	private boolean isPlaying = false;
	
	private int chips = 0;
	
	public Player(String name, int chips) {
		this.deck = new Deck();
		this.name = name;
		this.chips = chips;
	}

	public int chips() {
		return chips;
	}
	
	public String name() {
		return name;
	}

	public Deck deck() {
		return this.deck;
	}
	
	public Player receiveCardFrom(Deck otherDeck) {
		deck.addCard(otherDeck.removeRandomCard());
		return this;
	}
}
