public class ScratchPaper
{
   public static void main (String[] args)
   {
      int pt1 = 70;
      int pt2 = 83;
      if (((pt1 - pt2) <= 100) && ((pt1 - pt2) >= -100))
      {
         System.out.println ("false");
      }
      else
         System.out.println("true");
      System.out.println (randomMath());
   }
   public static int randomMath()
   {
      if (Math.random() < 1.0/3.0)
         return 1;
      else if (Math.random() < 2.0/3.0)
         return 2;
      else
         return 3;
   }
}