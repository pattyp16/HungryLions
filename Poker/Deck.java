// Patty Popp
// February 23rd, 2015

import java.util.*;

public class Deck {
   
   
   /** This variable is an array that holds the deck of Card.MAX_CARDS cards */
   private Card[] deckOfCards;
	
	/** This variable holds the number of cards that are left in the deck, after they have been dealt.
	 *  Can only go up to Cards.MAX_CARDS */
   private int numCards;
   
   /** 
	 *  Constructor.  Creates and initializes an unshuffled deck of cards using a doubly nested for loop over the 
	 *  the card suits (Card.SPADES .. Card.CLUBS) and the values (Card.ACE.. Card.KING). 
	 *  Then it adds the two jokers to the end, giving them value 1 and 2 respectively. 
	 *  The variable holding the number of cards left is set appropriately, then 
	 *  Finally it shuffles the deck using the DeckShuffler.shuffle method, if the parameter passed in is true. 
	 *  @param shuffle determines whether or not the deck should be shuffled. 
	 */
   
   public Deck(boolean shuffle)
   {
      deckOfCards = new Card [Card.MAX_CARDS];
      for (int ii = Card.SPADES; ii<= Card.CLUBS; ii++)
      {
         for (int jj = Card.ACE; jj<= Card.KING; jj++)
         {
            Card c = new Card (jj, ii);
            addCard(c);
         }
      }
      Card firstJoker = new Card();
      Card secondJoker = new Card (2, Card.JOKER);
      addCard(firstJoker);
      addCard(secondJoker);
      if (shuffle == true)
      {
         DeckShuffler.shuffle(deckOfCards, numCards);
      }
   }
	
	/**
	 * Adds a card to the top of the deck. This adds the card to the array and increments the 
	 * total number of cards. It will throw an IllegalArgumentException if the maxiumum 
	 * number of cards has already been added or if the card being passed in is null
	 * @param c The card to be added. 
	 */
	public void addCard(Card c) 
	{
      if (numCards == Card.MAX_CARDS && c == null)
      {
         throw new IllegalArgumentException();
      }
	   else
      {
         deckOfCards[numCards] = c;
         numCards++;
      }
	}
   
   /**
	 * As cards are dealt from the deck, the number of 
    * cards left decreases.  This function returns the 
    * number of cards that are still left in the deck.
	 * @return the number of cards still left in the deck
	 */ 
   public int cardsLeft() 
	{
      return numCards;
   }
   
   /**
	 * Deals one card from the "top" of the deck and returns it. (The bottom of the deck is 0, 
	 * The top of the deck is the highest card). Sets the "top" card in the deck to null, 
	 * and decrements the number of cardsLeft to keep track. 
    * Throws an IllegalArgumentException if no more cards are left.
	 */
   public Card dealCard()
   {
      if (numCards == 0)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         Card topCard = deckOfCards[numCards-1];
         deckOfCards[numCards-1] = null;
         numCards--;
         return topCard;
      }
   }
   
   /**
	 * Returns a string representation of the current state of the deck, what's left of it. 
	 * each card is separated by a new line. 
    * The cards are printed in order from the bottom first of the deck to the top of the deck last. 
	 * @return a string representation of the current state what's left of the deck - 
    * with each card on a new line
	 */
	 
   public String toString()
   {
      String stringOfDeck = "";
      for (int ii = 0; ii<numCards; ii++)
      {
         Card cardAtIndex = deckOfCards[ii];
         stringOfDeck += cardAtIndex + "\n";
      }
      return stringOfDeck;
   }
}
