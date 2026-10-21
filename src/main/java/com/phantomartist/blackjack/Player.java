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

	private Card cardAt(int i) {
		if (cards.size() > i) {
			return cards.get(i);
		}
		throw new IllegalArgumentException();
	}

	public Card showFirst() {
		return cardAt(0);
	}

	public Card showSecond() {
		return cardAt(1);
	}

	public Card showLastCard() {
		return cards.getLast();
	}

	public void drawNextCard(final Deck deck) {
		cards.add(deck.drawNext());
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
		if (total > GameLogic.TWENTY_ONE && aces > 0) {
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
