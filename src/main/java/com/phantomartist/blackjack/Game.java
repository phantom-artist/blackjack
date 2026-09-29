package com.phantomartist.blackjack;

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
		Output.print(burn.toShortString());
		Output.print("");

		// Deal initial cards
		final Player player = new Player(cards.removeFirst(), cards.removeFirst());
		final Player dealer = new Player(cards.removeFirst(), cards.removeFirst());

		// Show cards
		Output.print("Dealer has");
		Output.print(dealer.cardAt(0).toShortString() + " and ?");
		Output.print("");
		Output.print("Player has");
		Output.print(player.cardAt(0).toShortString() + " and " + player.cardAt(1).toShortString() + " total " + player.calculateTotal());

		// Stick or twist?
		boolean turnComplete = false;

		while (!turnComplete) {
			final String response = Output.ask("Stick or twist?");
			if ("stick".equalsIgnoreCase(response)) {
				turnComplete = true;
			} else if ("twist".equalsIgnoreCase(response)) {
				player.drawNextCard(cards);
				int playerTotal = player.calculateTotal();
				Output.print("Drew " + player.showLastCard().toShortString() + " total " + playerTotal);
				if (playerTotal > 21) {
					turnComplete = true;
				}
			} else {
				Output.print("Didn't understand you?");
			}
		}

		// Dealer turn
		Output.print("");
		Output.print("Dealer has");
		Output.print(dealer.cardAt(0).toShortString() + " and " + dealer.cardAt(1).toShortString() + " total " + dealer.calculateTotal());
		
		// Did player bust?
		if (player.calculateTotal() > 21) {

			Output.print("Player BUST, winner is DEALER");
			
		} else {

			boolean dealerStop = false;
			while (!dealerStop) {
				if (dealer.calculateTotal() >= 16) {
					dealerStop = true;
					Output.print("Winner is " + GameLogic.determineWinner(player, dealer));
				} else {
					dealer.drawNextCard(cards);
					Output.print("Dealer drew " + dealer.showLastCard().toShortString() + " total " + dealer.calculateTotal());
				}
			}
		}
	}
}
