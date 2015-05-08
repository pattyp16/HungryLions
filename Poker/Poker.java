public class Poker
{

	/** A class constant to define the number of players in the game */
	public static final int NUM_PLAYERS = 4; 
	
	/** A class constant to define the size of the hand for the game */
	public static final int HAND_SIZE = 5; 
	
	public static void main(String[] args)
	{
		test(false); 
      test(true); 
	}
	
	/* This method will run the tests either shuffled or unshuffled
	 * @param shuffle - whether or not to run the tests with a shuffled deck
	 */
	public static void test(boolean shuffle)
	{
		System.out.println("Testing " + (shuffle ? "" : "un") + "shuffled"); 
		Card[][] players = new Card[NUM_PLAYERS][HAND_SIZE];		// 4 players, 5 cards each.
		Deck d = new Deck(shuffle); 										// creates, deals and shuffles the deck
		
		deal(d, players); 
		checkCardsLeft(d);
		printHands(players); 
		checkEquals(players); 
		printCardsLeft(d); 
	}
	
	/* This method deals out the deck to the players hands
	 * @param d the deck of cards
	 * @param players the array of players hands
	 */
	public static void deal(Deck d, Card[][] players)
	{
		System.out.println("Dealing " + HAND_SIZE + " cards to " + NUM_PLAYERS + " players"); 
		
		for (int cc = 0; cc < players[0].length; cc++) 		// loop over the number of cards 
		{
			for(int player = 0; player < players.length; player++ )
			{
				players[player][cc] = d.dealCard(); 			// Deals a card to each player, going around the circle of players. 
			}
		}
		System.out.println("Cards dealt\n");
	}
	
	/* This checks the number of cards left in the deck to make sure we're not getting an invalid deck
	 * @param d the deck of cards
	 */
	public static void checkCardsLeft(Deck d)
	{
		int purportedCardsLeft = Card.MAX_CARDS - (HAND_SIZE * NUM_PLAYERS); 
		System.out.println("Checking cards left over = " +  purportedCardsLeft + ": " + (d.cardsLeft() == purportedCardsLeft ? "yup!" : "nope :(") + "\n"); 
	}
	
	
	/* This method prints out all the players hands. 
	 * @param players the array of players hands
	 */
	public static void printHands(Card[][] players)
	{
		for (int player = 0; player < players.length; player++) 		// loop over the number of players 
		{
			System.out.print("Player " + (player + 1) + " has cards: ");
			for ( int cc = 0; cc < players[0].length - 1; cc++ ) 			// loop over the number of cards
			{
				System.out.print(players[player][cc] + ", " ); 
			}
			System.out.println(players[player][players[0].length - 1]); 
		}
		System.out.println(); 
	}
	
	/* This method picks the first two cards in player 1's hands and just checks if the cards are equal to each other
	 * @param players the array of players hands
	 */
	public static void checkEquals(Card[][] players)
	{
		boolean check = players[0][0].equals(players[0][1]); 
		System.out.println("Card 1: " + players[0][0] + " " + (check ? "=" : "!") + "= Card 2: " + players[0][1]); 
		System.out.println(); 
	}

	
	/* This method prints out all of the cards left in the deck. 
	 * @param d the deck of card
	 */
	public static void printCardsLeft(Deck d)
	{
		System.out.println("The cards left in the deck are: ");
		System.out.println(d);	
	}
	
	
}