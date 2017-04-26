import java.util.*;

public class Deck {
	private static final Random random = new Random();
	private final List<Card> cards = new ArrayList<Card>();
	private int dealtIndex = 0;
	public Deck() {
		for (int i = 1; i <= 13; i++) {
			for (Suit s : Suit.values()) {
				cards.add(new Card(i, s));
			}
		}
	}
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			int j = random.nextInt(cards.size() - i) + i;
			Card card1 = cards.get(i);
			Card card2  =cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	public Card[] dealHand(int num) {
		if (remainingCards() < num) {
			return null;
		}
		Card[] cards = new Card[num];
		for (int i = 0; i < num; i++) {
			cards[i] = dealCard();
		}
		return cards;
	}
	
	private int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public Card dealCard() {
		return remainingCards() == 0 ? null : cards.get(dealtIndex++);
	}
}
