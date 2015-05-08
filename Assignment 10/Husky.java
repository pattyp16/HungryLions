//Patty Popp
//Husky
//
//Version 1.0
//March 3rd, 2015


/** This class defines the methods and behavior necessary for a husky to function in the critter world. The "Husky" class
 * extends the "Critter" class, and overrides many of the methods, in order to accurately represent a husky.
 */
import java.awt.*;
import java.util.*;
public class Husky extends Critter
{

/** counter - an integer that gets incremented and reset with each unique move of the husky
 */
   private int counter;

/** direction - a Direction object that stores the husky's current direction, and allows the husky to move about the world 
 */
   private Direction direction;

/** randomInt - a random integer between 1 and 4 (inclusive)
 */
   private int randomInt;

/** numSteps - the number of steps a husky takes in a given direction
 */
   private final static int numSteps = 6;

/** numDirections - the number of unique directions (north, east, south, west), excluding center
 */
   private final static int numDirections = 4;

/** reset - the number that the counter is always reset to, in order to keep an up-to-date counter
 */
   private final static int reset = 0;

/** r - a random object that is used in order to obtain a random integer
 */
   private static Random r = new Random(); 

/** This method will construct an object of type "Husky". Inside the body of this constructor, counter is initialized to 0, 
 * direction is initialized as the direction center, and randomInt is initialized to a random integer between 1 and 4.
 */
   public Husky()
   {
      this.counter = 0;
      this.direction = Direction.CENTER;
      this.randomInt = r.nextInt(numDirections)+1;
   }

/** This method will return a bright purple color (for UW, obviously) in order to represent the color of the Husky object.
 * @return the special color created for the Husky
 */
   public Color getColor()
   {
      Color UWPURPLE = new Color (200, 30, 255);
      return UWPURPLE;
   }

/** This method will return true only if there are no immediate opponents to the husky's North, East, South, or West. Otherwise,
 * it will return false, as I do not want the Husky to be vulnerable for too long. This way, the Husky will only eat once it is
 * relatively safe.
 * @return the boolean letting the Husky know whether or not it will eat when it encounters food
 */
   public boolean eat()
   {
      if (getNeighbor(Direction.NORTH).equals(" ") && getNeighbor(Direction.EAST).equals(" ") &&
      getNeighbor(Direction.SOUTH).equals(" ") && getNeighbor(Direction.WEST).equals(" "))
      {
         return true;
      }
      else //if (there is an imminent threat)
      {
         return false;
      }
   }

/** This method changes the husky's attack based on the opponent with which it is interacting with. Through checking for all of 
 * the (known) opponents, I have ensured that if my husky is paired up against either a stone, ant, bird, vulture, not hungry
 * hippo, or hungry hippo, it will have a high chance of winning the battle.
 * @param opponent the opponent with which the Husky is fighting with
 * @return the attack which the Husky has chosen in order to (hopefully) defeat its opponent
 */
   public Attack fight (String opponent)
   {
      if (opponent.equals("S"))
         return Attack.POUNCE;
      else if (opponent.equals("%"))
         return Attack.ROAR;
      else if (opponent.equals("^")||opponent.equals(">")||opponent.equals("V")||opponent.equals("<"))
         return Attack.POUNCE;
      else if (opponent.equals("0"))
         return Attack.SCRATCH;
      else //if (opponent is a hungry hippo)
         return Attack.ROAR;
   }

/** This method returns a String representation of a Husky object. I chose the % sign so as to potentially fool my opponent into
 * mistaking the husky for an ant.
 * @return the symbol that represents a Husky 
 */
   public String toString()
   {
      return ("%");
   }
   
/** This method determines the path which the Husky will take, and returns the respective direction. The method first 
 * increments the counter and checks to see whether or not the counter is less than or equal to the numSteps variable. If the 
 * counter is less than numSteps, the method will check whether the randomInt is the same as north, east, south, or west, and
 * will change "direction" to be the coinciding direction. If the counter is equal to numSteps, then the method creates a new
 * random integer between 1 and 4 and resets the counter. I chose to copy the hippo's movement pattern, because the hippo seems
 * to be very efficient in the critter world (i.e. w/ acquiring food, mating, fighting, etc.).
 * @return the direction of the Husky's next move
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