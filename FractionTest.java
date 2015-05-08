/**
 * This class is the main entry point for the Fraction test case. 
 */   
public class FractionTest 
{
  /**
   * The main entry point for the test
   *
   * @param args - The command line arguments passed to the program 
   */   
  public static void main( String[] args )
  {
    final int MAX_TEST = 5; 
    Fraction f; 

    f = new Fraction(); 
    TestFraction( f ); 
    
    f = new Fraction( MAX_TEST ); 
    TestFraction( f ); 
    
    for ( int ii = 0; ii <= MAX_TEST; ii++ )
    {
      for ( int jj = 0; jj <= MAX_TEST; jj++ )
      {
        f = TestFractionCreate( ii, jj ); 
        if ( f != null )
        {
          TestFraction( f ); 
        }
      } 
    }
  }
  
  /**
   * A method to test the fraction once it's created by printing out the fraction and showing it's value as a double. 
   *
   * @param f - The fraction to test. 
   */   
  public static void TestFraction( Fraction f )
  {
    System.out.println("Fraction() = " + f.toString() + " = " +  f.asDouble());
  }

  
  /**
   * This method tests creating a fraction from a numerator and denominator. It catches any exceptions and shows them to the user. 
   *
   * @param num - the numerator of the fraction to create. 
   * @param den - the denominator of the fraction to create. 
   */   
  public static Fraction TestFractionCreate( int num, int den )
  {
    Fraction f = null; 
    try
    {
      f = new Fraction( num, den ); 
    }
    catch ( ArithmeticException e )
    {
      System.out.println("Error creating the fraction " + num + " / " + den + " because " + e.toString() );
    }
    return f; 
  }
}
