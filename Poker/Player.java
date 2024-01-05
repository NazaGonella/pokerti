package Poker;

public class Player {
	
	private String name;
	
	private int chips = 0;
	
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}

	public int chips() {
		return chips;
	}
	
	public String name() {
		return name;
	}

}
