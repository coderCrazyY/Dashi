import java.util.*;

public class BlackJackHand extends Hand {
	@Override
	public int score() {
		// cards
		List<Integer> scores = allPossibleScores();
		int minOver = Integer.MAX_VALUE;
		int maxUnder = Integer.MIN_VALUE;
		for (int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score <= 21 && score > maxUnder) {
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder; 
	}
	private List<Integer> allPossibleScores() {
		List<Integer> scores = new ArrayList<Integer>();
		for (Card card : cards) {
			updateScores(card, scores);
		}
		return scores;
	}
	
	private void updateScores(Card card, List<Integer> scores) {
		final int[] toAdd = getScores(card);
		if (scores.size() == 0) {
			for (int i = 0 ; i < toAdd.length; i++) {
				scores.add(toAdd[i]);
			}
		} else {
			for (int i = 0; i < scores.size(); i++) {
				scores.set(i, scores.get(i) + toAdd[0]);
				for (int j = 1; j < toAdd.length; j++) {
					scores.add(scores.get(i) + toAdd[j]);
				}
			}
		}
	}
	
	private int[] getScores(Card card) {
		if (card.value() == 1) {
			return new int[] {1,11};
		} else {
			return new int[] {Math.min(10, card.value())};
		}
	}
	
	public boolean busted() {
		return score() > 21;
	}
	
	public boolean isBlackJack() {
		if (cards.size() != 2) {
			return false;
		}
		Card first = cards.get(0);
		Card second = cards.get(1);
		return isAce(first) && isFace(second) || isAce(second) && isFace(first);
	}
	
	private boolean isAce(Card card) {
		return card.value() == 1;
	}
	private boolean isFace(Card card) {
		return card.value() <= 13 && card.value() >= 11;
	}
	
}
