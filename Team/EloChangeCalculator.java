import java.util.*;

public class EloChangeCalculator
{
   public static final int[] RATING_DIFFERENCES =   {-400, -350, -300, -250, -200, -150, -100, -50, 0,
                                                       50,  100,  150,  200,  250,  300,  350,  400};
   public static final double[] WIN_PROBABILITIES = {0.02, 0.04, 0.07, 0.11, 0.16, 0.23, 0.31, 0.40, 0.50,
                                                     0.60, 0.69, 0.77, 0.84, 0.89, 0.93, 0.96, 0.98};
                                                     
   public static final int MAX_POINTS = 30;
   
   public static void main(String[] args)
   {
      double yourRating = 1523;
      double theirRating = 1400;
      double result = 1;
      double yourRatingChange = getRatingChange(yourRating, theirRating, result); 
      System.out.println(yourRatingChange);
   }
   
   public static double getRatingChange(double yours, double theirs, double result)
   {
      int roundToNearest = RATING_DIFFERENCES[1]-RATING_DIFFERENCES[0];  
      int ratingDifference = (int)(Math.round((yours - theirs)/roundToNearest)*roundToNearest);
      if (ratingDifference < RATING_DIFFERENCES[0])
         return MAX_POINTS;
      else if (ratingDifference > RATING_DIFFERENCES[RATING_DIFFERENCES.length-1])
         return 0;
      else
      {
         int index = Arrays.binarySearch(RATING_DIFFERENCES,ratingDifference);
         double winProbability = WIN_PROBABILITIES[index];
         double change = MAX_POINTS*(result - winProbability);
         return change; 
      } 
   }
                                                     
}

