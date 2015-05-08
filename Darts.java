import java.awt.*;
import java.util.*;
public class Darts
{
   public static void main (String[] args)
   {
      Set<Point> tosses = new HashSet<Point>(); //Create set
      Point p = new Point (10,10);
      //tosses.add(p);
      tosses.add(new Point(10,10)); //Add some elements
      tosses.add(new Point(-58,100));
      tosses.add(new Point(15,-30));
      tosses.add(new Point(100,-45));
      tosses.add(new Point(2,-4));
      System.out.println(tosses); //Print the set
      tosses.remove(new Point (10,10));
      //tosses.remove(p);
      System.out.println(tosses);
      System.out.println(tosses.contains(new Point (-58,100)));
      System.out.println(tosses.size());
      
      System.out.println("Iterating through the Set:");
      Iterator<Point> tossesIter = tosses.iterator();
      while(tossesIter.hasNext())
      {
         Point toss = tossesIter.next();
         System.out.println(toss);
      }
      
      Iterator<Point> tossesIter2 = tosses.iterator();
      for (int ii = 0; tossesIter2.hasNext(); ii++)
      {
         Point toss = tossesIter2.next();
         System.out.println("Toss " + ii + ": " + toss);
      }
      
      System.out.println("Removing bad throws:");
      Iterator<Point> iter = tosses.iterator();
      while (iter.hasNext())
      {
         Point toss = iter.next();
         double distance = Math.sqrt(toss.getX() * toss.getX() * toss.getY() * toss.getY());
         if (distance > 100)
            iter.remove();
      }
      System.out.println(tosses);
   }
}