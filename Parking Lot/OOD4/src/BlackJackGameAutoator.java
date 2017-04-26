import java.util.*;

public class BlackJackGameAutoator {
	private Deck deck;
	private BlackJackHand[] hands;
	private static final int HIT_UNTIL = 16;
	// constructor
	public BlackJackGameAutoator(int numPlayers){
		hands = new BlackJackHand[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			hands[i] = new BlackJackHand();
		}
	}
	// get new deck and shuffle
	void initializeDeck() {
		deck = new Deck();
		deck.shuffle();
	} 
	// first-round dealHand
	boolean dealInitial() {
		for (BlackJackHand hand: hands) {
			Card[] cards = deck.dealHand(2);
			if (cards == null) {
				return false;
			} else {
				hand.addCards(cards);
			}
		}
		return true;
	}
	
	// after first round, check if there is blackjack winners
	List<Integer> getBlackJacks() {
		List<Integer> winners = new ArrayList<Integer>();
		for (int i = 0; i < hands.length; i++) {
			if (hands[i].isBlackJack()) {
				winners.add(i);
			}
		}
		return winners;
	}
	// add cards until game over(everyone busted or score over 16)
	boolean playHand(BlackJackHand hand) {
		while(hand.score() < HIT_UNTIL) {
			Card card = deck.dealCard();
			if (card == null) {
				return false;
			}
			hand.addCards(new Card[] {card});
		}
		return true;
	}
	
	// play all the hands
	boolean playAllHands() {
		for (BlackJackHand hand : hands) {
			if (!playHand(hand)) {
				return false;
			}
		}
		return true;
	}
	
	// get winners
	List<Integer> getWinners() {
		List<Integer> winners = new ArrayList<Integer>();
		int winningScore = 0;
		for (int i = 0; i < hands.length; i++) {
			if(!hands[i].busted()) {
				if (hands[i].score() > winningScore) {
					winners.clear();
					winners.add(i);
					winningScore = hands[i].score();
				} else if (hands[i].score() == winningScore) {
					winners.add(i);
				}
			}
		}
		return winners;
	}
	
	// print all hands and their corresponding score
	void printHandAndScore() {
		for (int i = 0; i < hands.length; i++) {
			System.out.print("Hand " + i + " (" + hands[i].score() + "): ");
			hands[i].print();
			System.out.println();	
		}
	}
	
	// simulate!
	public void simulate() {
		initializeDeck();
		boolean success = dealInitial();
		if (!success) {
			System.out.println("Error! Out of cards.");
		} else {
			System.out.println("-----Simulation starts, cards ready-----");
		}
		printHandAndScore();
		List<Integer> blackJacks = getBlackJacks();
		if (blackJacks.size() == 0) {
			System.out.print("First round deal hand over. There is no Black Jack winner.");
		} else {
			System.out.print("\nBlack Jack at: ");
			for (int i = 0; i < blackJacks.size(); i++) {
				System.out.print(blackJacks.get(i) + " ");
			}
		}
		System.out.println("\n-----Play all hands-----");
		success = playAllHands();
		if (!success) {
			System.out.println("Error! Out of cards.");
		} else {
			System.out.println("-----Game Complete-----");
			printHandAndScore();
			List<Integer> winners = getWinners();
			if (winners.size() > 0) {
				System.out.print("Winners are : ");
				for (int i = 0; i < winners.size(); i++) {
					System.out.print("Player " + winners.get(i) + " ");
				}
			} else {
				System.out.println("Draw. All players are busted");
			}
		}
	}
	
	public static void main(String[] args) {
		BlackJackGameAutoator automator = new BlackJackGameAutoator(5);
		automator.simulate();
	}
}
