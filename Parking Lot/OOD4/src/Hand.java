import java.util.*;

public class Hand {
	protected final List<Card> cards = new ArrayList<Card>();
	
	// method include ask for new cards, count score, can get current hand card size
	public int score() {
		int score = 0;
		for(Card c : cards) {
			score += c.value();
		}
		return score;
	}
	public void addCards(Card[] c) {
		// put the given cards into hand cards
		Collections.addAll(cards, c);
	}
	public int size() {
		return cards.size();
	}
	
	public void print() {
		for (Card c : cards) {
			System.out.print(c.value() + " ");
		}
	}
}
