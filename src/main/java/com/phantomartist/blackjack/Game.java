package com.phantomartist.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Single deck blackjack.
 * Dealer stands on 16.
 */
public class Game {

	public Game() {
	}

	public void play() {

		final Deck deck = Deck.newDeck();
		final List<Card> cards = deck.getCards();
		
//			Output.print("Deck contains " + cards.size() + " cards");
//			Output.print(cards.toString());
		
		// Burn one
		final Card burn = cards.removeFirst();
		Output.print("Burn card was");
		Output.print(burn);

		// Deal cards
		final Player player = new Player(cards.removeFirst(), cards.removeFirst());
		final Player dealer = new Player(cards.removeFirst(), cards.removeFirst());

		// Show cards
		Output.print("Dealer has");
		Output.print(dealer.card1());

		Output.print("Player has");
		Output.print(player.card1());
		Output.print(player.card2());

		// Stick or twist?
		final List<Card> playerCards = new ArrayList<>();
		playerCards.add(player.card1());
		playerCards.add(player.card2());

		boolean turnComplete = false;
		int playerTotal = 0;

		while (!turnComplete) {
			final String response = Output.ask("Stick or twist?");
			if ("stick".equalsIgnoreCase(response)) {
				turnComplete = true;
			} else {
				final Card card = cards.removeFirst();
				playerCards.add(card);
				playerTotal = GameLogic.calculateTotal(playerCards);
				Output.print("Drew " + card + " total " + playerTotal);
				if (playerTotal > 21) {
					turnComplete = true;
				}
			}
		}

		// Dealer turn
		Output.print("Dealer has");
		Output.print(dealer.card1());
		Output.print(dealer.card2());

		final List<Card> dealerCards = new ArrayList<>();
		dealerCards.add(dealer.card1());
		dealerCards.add(dealer.card2());
		int dealerTotal = GameLogic.calculateTotal(dealerCards);
		
		// Did player bust?
		if (playerTotal > 21) {

			GameLogic.determineWinner(playerTotal, dealerTotal);
			
		} else {

			boolean dealerStop = false;
			while (!dealerStop) {
				if (dealerTotal >= 16) {
					GameLogic.determineWinner(playerTotal, dealerTotal);
					dealerStop = true;
				} else {
					final Card nextCard = cards.getFirst();
					Output.print("Dealer drew " + nextCard);
					dealerCards.add(nextCard);
				}
			}
		}
	}
}
