import java.awt.*;
public class PlanetTester
{
   public static void main (String[]args)
   {
      Planet jupiter = new Planet();
      jupiter.setName ("Jupiter");
      jupiter.setColor (Color.ORANGE);
      System.out.println ("Planet " + jupiter.getName() + " appears " + jupiter.getColor());
      
      Planet earth = new Planet();
      System.out.println(earth);
      
      Planet earth2 = new Planet ("Earth", 0, 0.0, Color.BLUE);
      Planet pluto = new Planet ("Pluto", 0, 4.67, Color.GRAY);
      
      System.out.println ("Earth == Earth2 is " + earth.equals(earth2));
      System.out.println ("Earth == Pluto is " + earth.equals(pluto));
   }
}