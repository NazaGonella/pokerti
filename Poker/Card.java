package Poker2;

public class Card {
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String name() {
		return rank.name().charAt(0) + rank.name().substring(1).toLowerCase() + "Of" + suit.name().charAt(0) + suit.name().substring(1).toLowerCase();
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Card)) {
            return false;
        }

        Card c = (Card) obj;

        return (this.rank == c.rank() && this.suit == c.suit());
       
    }
	
	public Rank rank() {
		return this.rank;
	}
	
	public Suit suit() {
		return this.suit;
	}
}
