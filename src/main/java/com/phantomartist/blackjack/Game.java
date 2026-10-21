package com.phantomartist.blackjack;

/**
 * Single deck blackjack.
 * Dealer stands on 16.
 */
public class Game {

	public Game() {
	}

	public void play() {

		final Deck deck = Deck.newDeck();
		
//			Output.print("Deck contains " + cards.size() + " cards");
//			Output.print(cards.toString());
		
		// Burn one
		final Card burn = deck.drawNext();
		Output.print("Burn card was");
		Output.print(burn.toShortString());
		Output.print("");

		// Deal initial cards in the order the dealer would pull them
		final Card playerCard1 = deck.drawNext();
		final Card dealerCard1 = deck.drawNext();
		final Card playerCard2 = deck.drawNext();
		final Card dealerCard2 = deck.drawNext();

		final Player player = new Player(playerCard1, playerCard2);
		final Player dealer = new Player(dealerCard1, dealerCard2);

		// Show cards
		Output.print("Dealer has");
		Output.print(dealer.showFirst().toShortString() + " and ?");
		Output.print("");
		Output.print("Player has");
		Output.print(player.showFirst().toShortString() + " and " + player.showSecond().toShortString() + " total " + player.calculateTotal());

		// Stick or twist?
		boolean turnComplete = false;

		while (!turnComplete) {
			final String response = Output.ask("Stick or twist?");
			if ("stick".equalsIgnoreCase(response)) {
				turnComplete = true;
			} else if ("twist".equalsIgnoreCase(response)) {
				player.drawNextCard(deck);
				int playerTotal = player.calculateTotal();
				Output.print("Drew " + player.showLastCard().toShortString() + " total " + playerTotal);
				if (GameLogic.hasBust(player)) {
					turnComplete = true;
					Output.print("Player BUST, winner is DEALER");
					return;
				}
			} else {
				Output.print("Didn't understand you?");
			}
		}

		// Dealer turn
		Output.print("");
		Output.print("Dealer has");
		Output.print(dealer.showFirst().toShortString() + " and " + dealer.showSecond().toShortString() + " total " + dealer.calculateTotal());
		
		boolean dealerStop = false;
		while (!dealerStop) {
			if (dealer.calculateTotal() >= GameLogic.DEALER_STAY) {
				dealerStop = true;
				Output.print("Winner is " + GameLogic.determineWinner(player, dealer));
			} else {
				dealer.drawNextCard(deck);
				Output.print("Dealer drew " + dealer.showLastCard().toShortString() + " total " + dealer.calculateTotal());
			}
		}
	}
}
