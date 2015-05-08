//Patty Popp
//Tag Manager
//
//Version 1.0
//April 1st, 2015


/** "TagManager" is a program that allows the user to manipulate TagNodes and to alter the linked node list. This class keeps 
 * track of who is stalking whom and the history of who tagged whom within two distinct lists. As people are tagged, per the
 * user's request, the players will move from tagRing to the "losers" list, by rearranging the links between nodes. The game
 * ends when only one player remains in the tag ring, representing the winner. TagMain, the client program, calls methods 
 * within TagManager in order to carry out tasks involved in administering the game. This class has been javadoc'd for 
 * clarity.
 */
import java.util.*;
public class TagManager
{

/** frontTagRing - a TagNode object representing the front node in the tag ring
 */
   private TagNode frontTagRing;
   
/** frontLosers - a TagNode object representing the front node in the losers list
 */
   private TagNode frontLosers;

/** This method contructs an object of type "TagManager" and initializes a new TagManager over the given list of people that
 * is passed in as a parameter. If the list of names is null, the method will throw an illegal argument exception, else, the
 * method will initialize frontTagRing and frontLosers to the first name in the list and null, respectively. The method then
 * creates a new TagNode called "current" which stores the reference to frontTagRing. By parsing through the list of names, 
 * the program is able to create a tag ring comprised of n linked TagNode objects for each of the n names in the list, in the
 * appropriate order.
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

/** This method prints the names of the people in tagRing, one per line, indented by 2 spaces, as "name is stalking name".
 * This method creates a temporary variable called "temp" which stores the reference to the instance variable "frontTagRing".
 * While the element following the current TagNode is not null, print the name of the current TagNode, followed by the next
 * TagNode, and then iterate the linked list in order to store the temp variable as the next TagNode (to walk the list). If 
 * the TagNode that follows the current TagNode is null, then print out that the current TagNode is stalking the 1st node.
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
 * element at the current index is not null, the method prints the name of the current loser followed by the loser's 
 * respective tagger, and then the method walks the list using a "temp = temp.next" statement in order to acquire the next 
 * node's contents.
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
 * are "playing" in the tagRing, and will return either true or false based on the results of the search. This method creates
 * a temporary variable which stores the reference of the first node in the tag ring, so that through using ".next", we can 
 * obtain the contents of the other nodes. The method then changes "name" to be all lower case letters since ".equals" is a 
 * case sensitive operation, parses through the linked nodes using a while loop, and uses an if statement testing for equal 
 * strings, and a "temp = temp.next" statement which walks the list in order to perform the same search on the following 
 * node. If no nodes are found with the name passed in, the method returns false.
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
 * variable which stores the reference to the first node in the losers list, so that through using ".next", we can obtain the 
 * contents of the other nodes. The method then changes "name" to be all lower case letters since ".equals" is a case
 * sensitive operation, and then parses through the linked nodes using a while loop, an if statement testing for equal 
 * strings, and a "temp = temp.next" statement which walks the list in order to perform the same search on the next node. If 
 * no nodes are found with the given name, the method returns false.
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

/** This method returns true if there is only one player in tagRing (i.e. the game is over, as a winner was found) and false
 * if there is more than one player in the ring. The method first creates a temporary variable which stores the reference
 * to the front node in the tagRing list and initializes the counter to be 0. While the current tagNode is not null, the
 * counter is incremented and then the "temp = temp.next" statement walks the list to obtain the information for the next
 * tagNode in the linked list. Once the list is exhausted, the method then checks to see whether counter equals 1 or not, and
 * based on the result, the method will return either true or false.
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
 * not over, the method returns null. The method first checks to see whether isGameOver() returns true or false. If the game 
 * is indeed over, the method returns the name attached to the frontTagRing node (since there is only one tagNode in the 
 * tagRing), and if the game is not over, the method returns a null value.
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

/** This method records the tagging of the person that is passed in via the parameter, by transferring the person from the
 * tag ring to the losers list. If the game is over, the method throws an illegal state exception and if the tag ring does
 * not contain the given name, the method throws an illegal argument exception (with the IllegalStateException taking
 * precedence). If the game is not over and tagRing contains the given name, the method will proceed to create a temporary
 * variable which points to the frontTagRing's reference (used in order to walk the list) and will change the name to lower
 * case so that the user will not have to worry about case sensitivity. If the name passed in is the name of the first person
 * in the tag ring, the method will acquire the last node in the list and set that node to tagger of the frontTagRing node. 
 * The method moves the node to the front of the losers list and shifts frontTagRing to the correct node. If the name passed 
 * in does not match frontTagRing, the method will find the node that matches the name and will remove, add, and shift 
 * accordingly. 
 * @param name the String representation of the name of the person that the user wants to tag
 */
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
            {
               temp = temp.next; //obtain last node in tagRing
            }
            TagNode current = frontTagRing;
            current.tagger = temp.name;
            TagNode tempLoser = frontLosers;
            frontTagRing = current.next; //shift frontTagRing
            frontLosers = current; //current node becomes front of loser list
            frontLosers.next = tempLoser; //other losers shift
         }
         else //if (name does not match the name of the first person in frontTagRing)
         {
            while (temp.next != null)
            {
               if ((((temp.next).name).toLowerCase()).equals(nameLower))
               {
                  TagNode tempLoser = temp.next; 
                  temp.next = temp.next.next; //shifts nodes to skip over recently removed node
                  tempLoser.next = frontLosers; //frontLosers shifts
                  tempLoser.tagger = temp.name; //tagger becomes previous tagger
                  frontLosers = tempLoser;
                  break;
               }
               temp = temp.next; //walk the list
            }
         }
      }
   }
}