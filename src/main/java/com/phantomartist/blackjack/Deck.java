package com.phantomartist.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards = new ArrayList<>();

	public static Deck newDeck() {
		return new Deck();
	}

	public List<Card> getCards() {
		return new ArrayList<Card>(cards);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	private Deck() {
		for (Suit suit : Suit.values()) {
			for (CardType cardType : CardType.values()) {
				cards.add(new Card(suit, cardType));
			}
		}
		shuffle();
	}
}
