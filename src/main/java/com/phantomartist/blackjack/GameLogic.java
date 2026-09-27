package com.phantomartist.blackjack;

import java.util.List;

public class GameLogic {

	public static int calculateTotal(final List<Card> cards) {
		int total = 0;
		for (Card card : cards) {
			total += card.type().getValue();
			if (CardType.ACE == card.type() && total > 21) {
				total -= 10; // Make Ace count as 1
			}
		}
		return total;
	}

	public static void determineWinner(final int playerTotal, final int dealerTotal) {

		String winner = "PLAYER";
		if (playerTotal > 21 || dealerTotal == 21 || dealerTotal > playerTotal) {
			winner = "DEALER";
		} else if (dealerTotal == playerTotal) {
			winner = "PUSH";
		}

		Output.print("Winner is " + winner);
	}
}