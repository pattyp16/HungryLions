import java.util.*;

public class TollboothTest
{
   public static void main (String [] args)
   {
      tollbooth t1 = new tollbooth();
      tollbooth t2 = new tollbooth();
      Random r = new Random();
      int max1 = r.nextInt(10);
      int max2 = r.nextInt(10);
      
      for (int ii = 1; ii < max1; ii++)
         t1.addCar();
      for (int ii = 1; ii < max2; ii++)
         t2.addCar();
         
      System.out.println("Booth 1 number of cars = " + t1.numCars() + " cash collect = $" + t1.moneyCollected() + "0");
      System.out.println("Booth 2 number of cars = " + t2.numCars() + " cash collect = $" + t2.moneyCollected() + "0");
      
   }
}