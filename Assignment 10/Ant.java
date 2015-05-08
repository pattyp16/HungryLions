//Patty Popp
//Ant
//
//Version 1.0
//March 3rd, 2015


/** This class defines the methods and behavior necessary for an ant to function in the critter world. The "Ant" class extends
 * the "Critter" class, and overrides many of the methods, in order to accurately represent an ant.
 */
import java.awt.*;
public class Ant extends Critter
{

/** walkSouth - a boolean letting the ant know whether it will start walking south or north
 */
   private boolean walkSouth;
   
/** previousDirection - a Direction object which is used in order to let the ant move in a zig-zag pattern
 */
   private Direction previousDirection;

/** This method constructs an object of type "Ant" and takes one parameter: the boolean related to whether the ant will have a
 * South-East-South-East pattern or a North-East-North-East patern. The statement inside of the constructor essentially says 
 * that this ant's walkSouth is equal to that of the boolean coming in as a parameter, and previousDirection is originally
 * initialized to EAST.
 * @param walkSouth true or false value for whether the ant will start walking south or north
 */
   public Ant (boolean walkSouth)
   {
      this.walkSouth = walkSouth;
      this.previousDirection = Direction.EAST;
   }

/** This method returns the color red for the color of the Ant object.
 * @return the color red
 */
   public Color getColor()
   {
      return Color.RED;
   }

/** This method always returns true since the ant will always eat when given the chance (i.e. whenever it encounters food).
 * @return the boolean "true" since the ant always eats
 */
   public boolean eat()
   {
      return true;
   }

/** This method always returns scratch, since the ant's go-to battle move is to scratch. The "fight" method also takes a String
 * containing the critter's oppponent, however the ant always scratches, despite what critter it is paired up against.
 * @param opponent the String containing the Ant's opponent/battle mate
 * @return the attack "SCRATCH", since the ant always scratches
 */
   public Attack fight(String opponent)
   {
      return Attack.SCRATCH;
   }

/** This method first tests to see if walkSouth is true or false. If walkSouth is true, the method checks to see what the 
 * previous direction was (an instance variable created above which is originally set to Direction.EAST since that will allow
 * the previous direction to be either South or North by scanning through the conditionals. "previousDirection" is continuously
 * updated so as to keep up the repetitive zig-zag pattern. The method finally returns the previousDirection after each move.
 * @return the previous direction which is re-established after every move
 */
   public Direction getMove()
   {
      if (walkSouth == true)
      {
         if (previousDirection == Direction.SOUTH)
         {
            previousDirection = Direction.EAST;
         }
         else //if (previousDirection == Direction.EAST)
         {
            previousDirection = Direction.SOUTH;
         }
      }
      else //if (walkSouth == false)
      {
         if (previousDirection == Direction.NORTH)
         {
            previousDirection = Direction.EAST;
         }
         else //if (previousDirection == Direction.EAST)
         {
            previousDirection = Direction.NORTH;
         }
      }
      return previousDirection;
   }

/** This method returns a String representation of the Ant object.
 * @return a percent sign (%) since the ant's symbol is always a percent sign
 */
   public String toString()
   {
      return("%");
   }
}