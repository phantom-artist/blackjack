package com.phantomartist.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Card> cards;

	public Player(Card card1, Card card2) {
		cards = new ArrayList<>();
		cards.add(card1);
		cards.add(card2);
	}

	public Card cardAt(int i) {
		if (cards.size() > i) {
			return cards.get(i);
		}
		throw new IllegalArgumentException();
	}

	public Card showLastCard() {
		return cards.getLast();
	}

	public void drawNextCard(final List<Card> deck) {
		cards.add(deck.removeFirst());
	}

	public int calculateTotal() {
		int total = 0;
		short aces = 0;
		for (Card card : cards) {
			total += card.type().getValue();
			if (CardType.ACE == card.type()) {
				aces++;
			}
		}
		if (total > 21 && aces > 0) {
			//System.out.println("Total = " + total + " Aces = " + aces);
			// Subtract 10 for each ace and check if within total
			for ( ; (aces > 0 && total > 21) ; aces--) {
				total -= 10;
				//System.out.println("Total = " + total + " Aces = " + aces);
			}
		}
		return total;
	}
}
