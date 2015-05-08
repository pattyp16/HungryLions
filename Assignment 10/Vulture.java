//Patty Popp
//Vulture
//
//Version 1.0
//March 3rd, 2015


/** This class defines the methods and behavior necessary for a vulture to function in the critter world. The "Vulture" class
 * extends the "Bird" class (which extends "Critter") and overrides many of the methods, in order to accurately represent a 
 * vulture.
 */
import java.awt.*;
public class Vulture extends Bird
{

/** numFights - the number of fights that the vulture has been in a given moment
 */
   private int numFights;

/** reset - the number that the counter is always reset to, in order to keep an up-to-date counter
 */
   private final static int reset = 0;

/** isHungry - a boolean value that stores whether or not the vulture is hungry or not
 */
   private boolean isHungry;

/** This method constructs an object of type "Vulture" and takes 0 parameters. Inside the body of the constructor, this vulture's
 * numFights is initialized to 0 and this vulture's isHungry boolean is initialized to true.
 */
   public Vulture()
   {
      this.numFights = 0;
      this.isHungry = true;
   }
 
/** This method first increments the number of fights whenever this method is called, and isHungry is re-initialized to true
 * (since the vulture gets hungry after getting into a fight, so even if the vulture was originally not hungry, by calling fight,
 * isHungry gets changed). The method then returns the return value of the superclass' fight method (i.e. Bird.
 * @param opponent the toString representation of the vulture's opponent
 * @return the return value of Bird's fight method
 */
   public Attack fight (String opponent)
   {
      numFights++;
      isHungry = true;
      return (super.fight(opponent));
   }

/** The method returns the color black for the color of the vulture.
 * @return the color black
 */
   public Color getColor()
   {
      return Color.BLACK;
   }

/** This method first checks to see whether or not the vulture is hungry. If the vulture is hungry, then the number of fights is
 * reset to 0, and isHungry is set to false (because the vulture is no longer fighting after eating once. Then the method
 * returns true (the vulture will eat after encountering food). If the vulture is not hungry, then the method returns false.
 * @return a boolean storing whether or not the vulture will eat after encountering food
 */
   public boolean eat()
   {
      if (isHungry == true)
      {
         numFights = reset;
         isHungry = false;
         return true;
      }
      else // if (isHungry == false)
      {
         return false;
      }
   }
}