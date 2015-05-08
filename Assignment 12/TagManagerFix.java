//Patty Popp
//Tag Manager
//
//Version 1.0
//April 1st, 2015


/** "TagManager" is a program that allows the user to manipulate TagNodes and to alter the linked node list. This class keeps 
 * track of who is stalking whom and the history of who tagged whom within two distinct linked lists. As people are tagged, per
 * user's request, the players will move from the tagRing to the "losers" list, by rearranging the links between nodes. The game
 * ends when only one player remains in the tag ring, representing the winner. TagMain, the client program, calls methods within
 * TagManager in order to carry out tasks involved in administering the game. This class has been javadoc'd for clarity.
 */
import java.util.*;
public class TagManagerOLD
{

/** frontTagRing - a TagNode object representing the front node in the tag ring
 */
   private TagNode frontTagRing;
   
/** frontLosers - a TagNode object representing the front node in the losers list
 */
   private TagNode frontLosers;

/** This method contructs an object of type "TagManager" and initializes a new TagManager over the given list of people that is
 * passed in as a parameter. If the list of names is null, the method will throw an illegal argument exception, else, the method
 * will initialize frontTagRing and frontLosers to the first name in the list and null, respectively. The method then creates a
 * new TagNode called "current" which stores the reference to frontTagRing. By parsing through the list of names, the program
 * is able to create a tag ring comprised of n linked TagNode objects for each of the n names in the list, in the appropriate
 * order.
 * @param names the list of strings containing the names of all of the people playing tag
 */
   public TagManager(List<String> names)
   {
      if (names.size() == 0)
      {
         throw new IllegalArgumentException();
      }
      else //if (names.size() != 0)
      {
         this.frontTagRing = new TagNode(names.get(0)); 
         this.frontLosers = null; //initialized to null since initially, there are no losers
         TagNode current = frontTagRing; 
         for (int ii = 1; ii<names.size(); ii++)//starts from 1 because the front tag node has already been established
         {
            current.next = new TagNode(names.get(ii)); //creating a new TagNode for each name in the list
            current = current.next; //current node is now the next node (i.e. walking the list)
         } 
      }
   }

/** This method prints the names of the people in the tag ring, one per line, indented by 2 spaces, as "name is stalking name".
 * This method creates a temporary variable called "temp" which stores the reference to the instance variable "frontTagRing".
 * While the element following the current TagNode is not null, print the name of the current TagNode, followed by the next
 * TagNode, and then iterate the linked list in order to store the temp variable as the next TagNode (to walk the list). If the
 * TagNode that follows the current TagNode is null, then print out that the current TagNode is stalking the frontTagNode.
 */
   public void printTagRing()
   {
      TagNode temp = frontTagRing;
      while (temp.next != null)
      {
         System.out.println ("  " + temp.name + " is stalking " + (temp.next).name);
         temp = temp.next;
      }
      System.out.println("  " + temp.name + " is stalking " + frontTagRing.name); //if temp.next == null
   }

/** This method prints the names of the people in the losers list, one per line, indented by 2 spaces, as "name was tagged by
 * name". The method first checks whether frontLosers is null (i.e. if the losers list is empty), and if it is, no output is
 * printed, else, the method creates a temporary variable which stores the reference to the field "frontLosers". While the
 * element at the current index is not null, the method prints the name of the current loser followed by the loser's respective
 * tagger, and then the method walks the list using a "temp = temp.next" statement in order to acquire the next node's content.
 */
   public void printLosers()
   {
      if (frontLosers != null)
      {
         TagNode temp = frontLosers;
         while (temp != null)
         {
            System.out.println ("  " + temp.name + " was tagged by " + temp.tagger);
            temp = temp.next;
         }
      }
   }

/** This method verifies whether the name that is passed in as a parameter is part of the linked list of active TagNodes who
 * are "playing" in the tagRing, and will return either true or false based on the results of the search. This method creates a
 * temporary variable which is initialized to the first node in the tag ring, so that through using ".next", we can obtain the
 * contents of the other nodes. The method then changes "name" to be all upper case letters since ".equals" is a case sensitive
 * operation, and then parses through the linked nodes using a while loop, an if statement testing for equal strings, and a
 * "temp = temp.next" statement which walks the list in order to perform the same search on the next node. If no nodes are 
 * found with the name passed in, the method returns false.
 * @param name the name of the player that the user wants to search for within the tagRing list
 * @return a boolean representing whether or not the tagRing list contains a node of the specified name
 */
   public boolean tagRingContains(String name)
   {
      TagNode temp = frontTagRing;
      String nameLower = name.toLowerCase();
      while (temp != null)
      {
         if (((temp.name).toLowerCase()).equals(nameLower))
         {
            return true;
         }
         temp = temp.next;
      }
      return false; //if node with corresponding name is not found within list
   }

/** This method verifies whether the name that is passed in as a parameter is part of the linked list of TagNodes who are in 
 * the losers list, and will return either true or false based on the results of the search. This method creates a temporary
 * variable which is initialized to the first node in the losers list, so that through using ".next", we can obtain the 
 * contents of the other nodes. The method then changes "name" to be all upper case letters since ".equals" is a case sensitive
 * operation, and then parses through the linked nodes using a while loop, an if statement testing for equal strings, and a
 * "temp = temp.next" statement which walks the list in order to perform the same search on the next node. If no nodes are 
 * found with the name passed in, the method returns false.
 * @param name the name of the player that the user wants to search for within the losers list
 * @return a boolean representing whether or not the losers list contains a node of the specified name
 */
   public boolean losersContains(String name)
   {
      TagNode temp = frontLosers;
      String nameLower = name.toLowerCase();
      while (temp != null)
      {
         if (((temp.name).toLowerCase()).equals(nameLower))
         {
            return true;
         }
         temp = temp.next;
      }
      return false; //if node with corresponding name is not found within list
   }

/** This method returns true if there is only one player in the tagRing list (i.e. the game is over, as a winner was found) and
 * false if there is more than one player in the ring. The method first creates a temporary variable which stores the reference
 * to the front node in the tagRing list and initializes the counter to be 0. While the current tagNode is not null, the
 * counter is incremented and then the "temp = temp.next" statement walks the list to obtain the information for the next
 * tagNode in the linked list. Once the list is exhausted, the method then checks to see whether counter is equal to 1 or not,
 * and based on the result, will return either true or false.
 * @return a boolean representing whether or not the game is over (i.e if there is only one player in the ring, or not)
 */
   public boolean isGameOver()
   {
      TagNode temp = frontTagRing;
      int counter = 0;
      while (temp != null)
      {
         counter++;
         temp = temp.next;
      }
      if (counter == 1)
         return true;
      else //if (counter != 1)
         return false;
   }

/** This method returns a String representation of the name of the winner of the game if the game is over, and if the game is 
 * not over, the method returns null. The method first checks to see whether isGameOver() returns true or false. If the game is
 * indeed over, the method returns the name attached to the frontTagRing node (since there is only one tagNode in the tagRing),
 * and if the game is not over, the method returns a null value.
 * @return the String representation of the winner of the game, and null if the game is not over
 */
   public String winner()
   {
      if (isGameOver()) //if game is over
      {
         return (frontTagRing.name);
      }
      return null; //if game is not over
   }

   public void tag(String name)
   {
      if (isGameOver()) //if game is over
      {
         throw new IllegalStateException();
      }
      else if (!tagRingContains(name))
      {
         throw new IllegalArgumentException();
      }
      else //if game is not over and the tagRing contains the given name
      {
         TagNode temp = frontTagRing;
         String nameLower = name.toLowerCase();
         if (nameLower.equals((frontTagRing.name).toLowerCase()))
         {
            while (temp.next != null)
               temp = temp.next;
            if (temp.next == null)//NOT NECESSARY
            {
               TagNode current = new TagNode(frontTagRing.name);
               current.tagger = temp.name;
               if (frontLosers != null)
                  {
                     TagNode tempLoser = new TagNode(current.name);
                     tempLoser.tagger = temp.name;
                     tempLoser.next = frontLosers;
                     frontLosers = tempLoser;
                  }
                  else if (frontLosers == null)
                  {
                     frontLosers = current;
                     //frontLosers.next = null;
                  }
               frontTagRing = frontTagRing.next;
            }
         }
         else //if (name does not equal the frontTagRing
         {
            while (temp.next != null)
            {
               if ((((temp.next).name).toLowerCase()).equals(nameLower))
               {
                  TagNode current = temp.next;
                  if (frontLosers != null)
                  {
                     TagNode tempLoser = new TagNode(current.name);
                     tempLoser.tagger = temp.name;
                     tempLoser.next = frontLosers;
                     frontLosers = tempLoser;
                  }
                  else if (frontLosers == null)
                  {
                     frontLosers = current;
                  }
                  TagNode currentTagger = temp;
                  TagNode taggedPerson = temp.next;
                  (taggedPerson).tagger = currentTagger.name;
                  currentTagger.next = taggedPerson.next;
                  taggedPerson.next = null;
               }
               if (temp.next == null)
               {
                  continue;
               }
               temp = temp.next;
            }
         }
      }
   }
}