
public class Card {
	private int value;
	private Suit suit;
	public Card(int value, Suit suit) {
		this.value = value;// 1 for A, 11 for J, 12 for Q, 13 for K
		this.suit = suit;
	}
	public int value() {
		return value;
	}
	public Suit suit() {
		return suit;
	}
}
