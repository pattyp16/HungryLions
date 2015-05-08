//Patty Popp
//Hippo
//
//Version 1.0
//March 3rd, 2015


/** This class defines the methods and behavior necessary for a hippo to function in the critter world. The "Hippo" class
 * extends the "Critter" class, and overrides many of the methods, in order to accurately represent a hippo.
 */
import java.awt.*;
import java.util.*;
public class Hippo extends Critter
{

/** hunger - the number of pieces of food that a hippo must eat in order to no longer be hungry
 */
   private int hunger;

/** counter - an integer that gets incremented and reset with each unique move
 */
   private int counter;

/** direction - a Direction object that stores the hippo's current direction, and allows the hippo to move randomly
 */
   private Direction direction;

/** randomInt - a random integer between 1 and 4 (inclusive)
 */
   private int randomInt;

/** numSteps - the number of steps a hippo takes in a given direction
 */
   private final static int numSteps = 5;

/** numDirections - the number of unique directions (north, east, south, west)
 */
   private final static int numDirections = 4;

/** reset - the number that the counter is always reset to, in order to keep an up-to-date counter
 */
   private final static int reset = 0;

/** r - a random object that is used in order to obtain a random integer
 */
   private static Random r = new Random(); 

/** This method constructs an object of type "Hippo" and takes one parameter: the hunger level of the hippo (i.e. how many
 * pieces of food the hippo needs to eat in order to no longer be hungry. Inside the body of the constructor, this hippo's
 * hunger level is initialized to be equal to that of the parameter that is passed in, counter is initialized to 0, direction 
 * is initialized as the direction center, and randomInt is initialized to a random integer between 1 and 4.
 * @param hunger the number of pieces of food the hippo must eat in order for the hippo to no longer be hungry
 */
   public Hippo(int hunger)
   {
      this.hunger = hunger;
      this.counter = 0;
      this.direction = Direction.CENTER;
      this.randomInt = r.nextInt(numDirections)+1;
   }

/** This method returns either true or false, depending on whether or not the hippo is hungry or not. If the hippo is still 
 * hungry, the hunger level is decremented and the method returns true, but if the hippo is no longer hungry, then the method
 * returns false.
 * @return a boolean for whether or not the hippo is hungry or not
 */
   public boolean eat()
   {
      if (hunger > 0)
      {
         hunger--;
         return true;
      }
      else // if (hunger == 0)
      {
         return false;
      }
   }

/** This method returns the color gray if the hippo is hungry and white if the hippo is not hungry.
 * @return the color of the hippo
 */
   public Color getColor()
   {
      if (hunger > 0)
         return Color.GRAY;
      else //if (hunger == 0)
         return Color.WHITE;
   }

/** This method returns a SCRATCH battle move if the hippo is hungry and a POUNCE battle move if the hippo is not hungry.
 * @param opponent the toString representation of the hippo's opponent
 * @return the chosen attack of the hippo based off of the hippo's hunger level
 */
   public Attack fight(String opponent)
   {
      if (hunger > 0)
      {
         return Attack.SCRATCH;
      }
      else //if (hunger == 0)
      {
         return Attack.POUNCE;
      }
   }

/** This method returns the String representation of the hippo, which is the hippo's hunger level, concatenated as a String.
 * @return the String representation of the hippo
 */
   public String toString()
   {
      return ("" + hunger);
   }

/** This method first increments the counter and checks to see whether or not the counter is less than or equal to the number
 * of steps variable. If the counter is less than numSteps, the method will check whether the randomInt is the same as north,
 * east, south, or west, and will change "direction" to be the coinciding direction. If the counter is equal to numSteps, then
 * the method creates a new random integer between 1 and 4 and resets the counter.
 * @return the direction of the hippo for the move on which it is called
 */
   public Direction getMove()
   {
      int north = 1;
      int east = 2;
      int south = 3;
      int west = 4;
      counter++;
      if (counter < numSteps)
      {
         if (randomInt == north)
         {
            direction = Direction.NORTH;
         }
         else if (randomInt == east)
         {
            direction = Direction.EAST;
         }
         else if (randomInt == south)
         {
            direction = Direction.SOUTH;
         }
         else if (randomInt == west)
         {
            direction = Direction.WEST;
         }
      }
      else if (counter == numSteps)
      {
         r = new Random();
         randomInt = r.nextInt(numDirections)+1;
         counter = reset;
      }
      return direction;
   }
}