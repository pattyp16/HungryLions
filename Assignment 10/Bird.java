//Patty Popp
//Bird
//
//Version 1.0
//March 3rd, 2015


/** This class defines the methods and behavior necessary for a bird to function in the critter world. The "Bird" class extends
 * the "Critter" class, and overrides many of the methods, in order to accurately represent a bird.
 */
import java.awt.*;
public class Bird extends Critter
{

/** previousDirection - a Direction object which is used in order to let the bird move in a square pattern
 */
   private Direction previousDirection;

/** counter - an integer that gets incremented and reset with each unique move
 */
   private int counter;

/** max - the maximum number of steps in a given direction (side length of square path)
 */
   private final static int max = 3;

/** reset - the number that the counter is always reset to, in order to keep an up-to-date counter
 */
   private final static int reset = 0;

/** This method constructs an object of type "Bird" and takes no parameters. Inside the body of the constructor, this bird's
 * previousDirection is initialized to be the center direction and counter gets initialized to 0 (meaning that it is ready
 * to be incremented after a new bird object is constructed).
 */
   public Bird()
   {
      this.previousDirection = Direction.CENTER;
      this.counter = 0;
   }

/** This method returns the color blue for the color of the Bird object.
 * @return the color blue
 */
   public Color getColor()
   {
      return Color.BLUE;
   }

/** This method always returns false since the bird will always chose to abstain from eating after encountering food.
 * @return the boolean false since the bird never eats
 */
   public boolean eat()
   {
      return false;
   }

/** This method takes one parameter: the toString value of the bird's critter opponent. If the bird's opponent is a "%", then
 * the method returns a battle move of ROAR, and if the bird's opponent is anything else, the method returns a battle move of
 * POUNCE.
 * @param opponent the toString representation of the bird's opponent
 * @return the chosen attack of the bird based off of the toString value of its opponent
 */
   public Attack fight(String opponent)
   {
      if (opponent.equals("%"))
      {
         return Attack.ROAR;
      }
      else //if (opponent is anything other than an ant)
      {
         return Attack.POUNCE;
      }
   }

/** This method first checks to see what the previous direction was (center, north, east, south or west), and based on the
 * previous direction, the method would increment the counter. After the counter is incremented, the method would check to see
 * if the counter is equal to the max value (if so, the counter would be reset and the direction would be changed), and if not,
 * the counter would get incremented and the same direction would be returned (i.e. North-North-North-East-East-East...).
 * @return the direction of the bird for the particular move
 */
   public Direction getMove()
   {
      if (previousDirection == Direction.CENTER)
      {
         previousDirection = Direction.NORTH;
      }
      else //if (previousDirection is anything other than center)
      {
         counter++;
         if (counter == max)
         {
            counter = reset;
            if (previousDirection == Direction.NORTH)
            {
               previousDirection = Direction.EAST;
            }
            else if (previousDirection == Direction.EAST)
            {
               previousDirection = Direction.SOUTH;
            }
            else if (previousDirection == Direction.SOUTH)
            {
               previousDirection = Direction.WEST;
            }
            else //if (previousDirectioon == Direction.WEST)
            {
               previousDirection = Direction.NORTH;
            }
         }
      }
      return previousDirection;
   }

/** This method returns a String representation of the bird object based on what the current direction of the bird is.
 * @return the String representation of the bird at that particular moment
 */
   public String toString()
   {
      if (previousDirection == Direction.NORTH || previousDirection == Direction.CENTER)
      {
         return("^");
      }
      else if (previousDirection == Direction.EAST)
      {
         return(">");
      }
      else if (previousDirection == Direction.SOUTH)
      {
         return("V");
      }
      else // if (previousDirection == Direction.WEST)
      {
         return("<");
      }
   }
}