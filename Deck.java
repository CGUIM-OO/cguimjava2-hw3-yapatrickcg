import java.util.*;

public  class Deck {
	public int c1 = 0;
	public int c2 = 0;
	private ArrayList<Card> cards;
	ArrayList<Card> usedCard = new ArrayList<Card>();
	public int nUsed = 0;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

		for (int i = 0; i < nDeck; i++) {
		for(int x=0;x<4;x++) {
				for (int y = 1; y < 14; y++) {
					if(x==0) {
						Card card1 = new Card(Card.Suit.Clubs, y);
						cards.add(card1);
					}else if(x==1) {
						Card card2=new Card(Card.Suit.Diamonds,y);
						cards.add(card2);
					}else if(x==2) {
						Card card3=new Card(Card.Suit.Hearts,y);
						cards.add(card3);
					}else if(x==3) {
						Card card4=new Card(Card.Suit.Spades,y);
						cards.add(card4);
					}
					
					

				}
		}
		}

	}

	public Deck() {
		// TODO Auto-generated constructor stub
	}

	public Card getOneCard() {
		Card z = new Card(null, 0);
		Random xy = new Random();
		if (nUsed == 52) {
			shuffle();
		}

		z  = cards.get(xy.nextInt(52));
		for (int j = 0; j < usedCard.size(); j++) {
			while (z .equals(usedCard.get(j))) {
				z  = cards.get(xy.nextInt(52));
			}
		}
		/*
		 * while(n.equals(usedCard)) { n=cards.get(nc.nextInt(52)); }
		 */
		usedCard.add(c1, z );
		nUsed++;
		c1++;

		return z ;
	}

//�洫 cards ����m
	public void shuffle() {
		Random rnd = new Random();
		int rp = rnd.nextInt(52);
		Card rtemp = new Card(null, 0);
		Card emp = new Card(null, 0);

		for (int i = 0; i < 52; i++) {
			while (i == rp) {
				rp = rnd.nextInt(52);
			}
			rtemp = cards.get(rp);
			cards.set(rp, cards.get(i));
			cards.set(i, rtemp);

		}

		usedCard.set(c2, emp);
		nUsed = 0;

	}

	// TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5 points)
		for (int i = 0; i < 52; i++) {
			//
			// Card n=cards.get(i);
			// //System.out.println(n.getSuit()+","+n.getRank());
			// n.printCard();
			Card n = new Card(null, 0);
			n = cards.get(i);
			n.printCard();

		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}