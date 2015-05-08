//Patty Popp
//Empirical
//
//Version 1.0
//April 28th, 2015


/** This program creates int arrays of different sizes, ranging from 1000 terms to 50000 and tests and compares the running 
 * times of the following sorts: selectionSort, insertionSort, mergeSort, and Arrays.sort, for arrays that are either in
 * increasing order, decreasing order, or in a random arrangement (i.e. best case scenario, worst case scenario, and random
 * scenario, respectively). 
 */
import java.util.*;
public class Empirical
{

/** size - an int array containing the different potential sizes of the arrays that you are looking into
 */
   public static final int[] size = {1000, 5000, 10000, 20000, 50000};

/** sortName - a String array containing the names of the sorts that you are testing
 */
   public static final String[] sortName = {"selectionSort", "insertionSort", "mergeSort", "Arrays.sort"};
   
/** sortArr - a String array containg the sorting arrangements that you are testing (increasing, decreasing, or random)
 */
   public static final String[] sortArr = {"Increasing", "Decreasing", "Random"};

/** This is the main method; where it all begins. The main method contains three nested for-loops in order to improve program
 * efficiency and to decrease redundancy. The for-loops parse through the sortArr array, the sortName array, and the size
 * array, respectively, in order to print the output using printf in a concise manner. The method acquires the amount of time
 * it takes each method to complete the sort, by calling the checkAndTestSort method.
 * @param args the arguments of the program
 */
   public static void main (String[] args)
   {
      for (int ii = 0; ii < sortArr.length; ii++) //parse through sortArr array
      {
         System.out.printf("%15s\t%d\t%d\t%d\t%d\t%d\t\n", sortArr[ii], size[0], size[1], size[2], size[3], size[size.length-1]);
         for (int jj = 0; jj < sortName.length; jj++) //parse through sortName array
         {
            System.out.printf("%15s\t", sortName[jj]);
            for (int kk = 0; kk < size.length; kk++) //parse through size array
            {
               if (sortArr[ii].equals("Random")) //requires own array so as to eliminate variables pertaining to randomness
               {
                  int[] randArray = Sorters.createArray(size[kk]);
                  long randTime = checkAndTestSort (sortName[jj], randArray);
                  System.out.printf("%d\t", randTime);
               }
               else //if(!sortName[jj].equals("Random"))
               {
                  int[] array = Sorters.createArray(size[kk], sortArr[ii]);
                  long time = checkAndTestSort(sortName[jj], array);
                  System.out.printf("%d\t", time);
               }
            }
            System.out.printf("\n"); //new line
         }
         System.out.printf("\n"); //new line
      }
   }

/** This method checks and tests each sort by calling the methods created in Sorters.java. The method takes two parameters:
 * the type of sort that you want to test and the array that you want to sort. The method first checks to see which sort the
 * user wants and then performs the sort, while keeping track of the time. The method then returns the final amount of time 
 * it took for the program to perform that sort.
 * @param sortName the sort type that you are testing
 * @param array the array that you wish to sort
 * @return the amount of time it took to perform said sort
 */
   public static long checkAndTestSort (String sortName, int[] array)
   {
      System.gc();
      long beginTime = System.currentTimeMillis(); //start time
      if (sortName.equals("selectionSort"))
         Sorters.selectionSort(array);
      else if (sortName.equals("insertionSort"))
         Sorters.insertionSort(array);
      else if (sortName.equals("mergeSort"))
         Sorters.mergeSort(array);
      else if (sortName.equals("Arrays.sort"))
         Arrays.sort(array);
      long endTime = System.currentTimeMillis(); //end time
      return (endTime - beginTime); //amount of time
   }
}