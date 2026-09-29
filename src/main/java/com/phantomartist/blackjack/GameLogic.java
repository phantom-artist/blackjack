package com.phantomartist.blackjack;

public class GameLogic {

	public static String determineWinner(final Player player, final Player dealer) {

		final int playerTotal = player.calculateTotal();
		final int dealerTotal = dealer.calculateTotal();

		String winner = "PLAYER";
		if ( playerTotal > 21 || dealerTotal == 21 || (dealerTotal <= 21 && dealerTotal > playerTotal)) {
			winner = "DEALER";
		} else if (dealerTotal == playerTotal) {
			winner = "PUSH";
		}

		return winner;
	}
}