//Tom Butler, CS III, Spring 2015
//Client program to test Complex class


public class TestComplex
{
   /**
    * Carry out various tests of the Complex class to see that it works and does useful things
    */
   public static void main(String[] args)
   {
      Complex z1 = new Complex(1,2);  //Construct a complex number object
      System.out.println(z1);  //Print a string representation of the complex number

      System.out.println(z1.getReal());  //Get the real part of the complex number
      System.out.println(z1.getImaginary());  //Get the imaginary part of the complex number
      
      Complex z2 = new Complex();  //Construct a complex number set to "zero"
      System.out.println(z2);  //Check to see if construction was successful
      z2.setReal(-1.5);  //Set the real part to a non-zero number
      z2.setImaginary(-4);  //Set the imaginary part to something non-zero
      System.out.println(z2);  //Check to see that the values are set correctly
      
      
      System.out.println(z1.magnitude());  //Get the magnitude of z1
      System.out.println(z1.argument());  //Get the angle of z1 (in radians)
      System.out.println(z2.magnitude());  //Get the magnitude of z2
      System.out.println(z2.argument());  //Get the angle of z2 (in radians)
      
      System.out.println(z1.equals(z2));  //Check to see if the numbers are the same
      Complex z3 = new Complex(-1.5, 4);  //Construct another comples number with same values as z3
      System.out.println(z2 == z3);  //Compare references of the objects
      System.out.println(z2.equals(z3));  //Compare values stored in the objects 
      
      Complex z4 = z1.sum(z2);  //Find the sum of two complex numbers
      System.out.println(z4);  //Print the result
      
      Complex z5 = Complex.sum(z1, z2);
      System.out.println (z5);
      
      System.out.println ("Complex Useless = " + Complex.useless );
      z1.useless = 45;
      System.out.println ("z2 Useless = " + z2.useless);
      z4.useless = 1000;
      System.out.println ("z5 Useless = " + z5.useless);
   }
}
