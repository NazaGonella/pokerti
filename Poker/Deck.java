package Poker2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<>();
	
	public static Deck completeDeck() {
        Deck deck = new Deck();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.cards.add(new Card(rank, suit));
            }
        }
        return deck;
    }
	
	public Deck addCard(Card card) {
		cards.add(card);
		return this;
	}
	
	public Deck sort() {
		Collections.shuffle(cards);
		return this;
	}

	public ArrayList<Card> cards() {
		return cards;
	}
	
	public Card getCardAt(int index) {
		return cards.get(index);
	}
	
	public Card removeRandomCard() {
		return cards.remove(new Random().nextInt(cards.size()));
	}
}
