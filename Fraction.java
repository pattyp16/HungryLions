// Lauren Bricker
// This class encapsulates the state and behavior of a fraction object
// Based on a post to an email list by Lon Levy, Computer Science Teacher at Oregon High School. 

// Fraction
// Version 1.0 
// 12/10/07

/**
 * This class encapsulates the state and behavior of a fraction - including checking for a 0 in the denominator at construction time. 
 */   
public class Fraction 
{

   /** The values for the numerator and denominator of the fraction */
   final int NUMERATOR, DENOMINATOR; 
   
   /**
    * This constructs an object of type Fraction, but first checks if the denominator is 0... and throws and ArithmeticException if it is. 
    *
    * @param       numerator - the top of the fraction
    * @param       denominator - the bottom of the fraction
    */   
   public Fraction ( int numerator, int denominator )
   {
      if ( denominator == 0 )
      {
         throw new ArithmeticException("The denominator can not be zero");
      }
      NUMERATOR = numerator; 
      DENOMINATOR = denominator; 
   }
   
   /**
    * This constructs a whole number as an object of type Fraction
    *
    * @param       numerator - the whole number
    */   
   public Fraction( int numerator )
   {
      this( numerator, 1 ); 
   }
   
   /**
    * This constructs a the number 0 as an object of type Fraction
    */   
   public Fraction(  )
   {
      this( 0, 1 ); 
   }
   
   /**
    * Returns the fraction as the double representation ... in other word, does the division and returns the value.
    *
    * @return      The value of the fraction as a double - i.e. the result of the division. 
    */   
   public double asDouble( )
   {
      return (double)NUMERATOR / DENOMINATOR; 
   }
   
   /**
    * Returns the fraction as a String representation 
    *
    * @return    The nicely printed string of the fraction. 
    */   
   public String toString()
   {
      return Integer.toString(NUMERATOR) + " / " + Integer.toString(DENOMINATOR);
   }
   
}


