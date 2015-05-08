public class Complex
{
   private double real;
   private double imaginary;
   public static int useless = 0;
   public Complex (double real, double imaginary)
   {
      this.real = real;
      this.imaginary = imaginary;
   }
   public Complex ()
   {
      real = 0;
      imaginary = 0;
   }
   public double getReal()
   {
      return real;
   }
   public double getImaginary()
   {
      return imaginary;
   }
   public double magnitude()
   {
      double distance = Math.sqrt((real*real) + (imaginary*imaginary));
      return distance;
   }
   public void setReal (double newReal)
   {
      real = newReal;
   }
   public void setImaginary (double newImaginary)
   {
      imaginary = newImaginary;
   }
   public double argument ()
   {
      double angle = (Math.atan2(imaginary,real));
      return angle;
   }
   public Complex sum (Complex z)
   {
      Complex zResult = new Complex();
      zResult.setReal (this.real + z.real);
      zResult.setImaginary (this.imaginary + z.imaginary);
      return zResult;
   }
   public String toString()
   {
      String retval = String.format ("%.2f + %.2fi", real, imaginary);
      return retval;
   }
   public static Complex sum (Complex z, Complex z1)
   {
      Complex zResult = new Complex();
      zResult.setReal (z.real + z1.real);
      zResult.setImaginary (z.imaginary + z1.imaginary);
      return zResult;
   }
}