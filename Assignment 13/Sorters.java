//Patty Popp
//Sorters
//
//Version 1.0
//April 28th, 2015


/** This program sorts a number of int arrays and then tests the effectiveness of the following sorts: selection sort, 
 * insertion sort, and merge sort.
 */
import java.util.*;
import java.awt.*;
public class Sorters
{

/** arraySize - an integer that stores the size of the array
 */
   public static final int arraySize = 12;

/** inc - a String containing the word "Increasing" for the increasing sort arrangement
 */
   public static final String inc = "Increasing";

/** dec - a String containing the word "Decreasing" for the decreasing sort arrangement
 */
   public static final String dec = "Decreasing";

/** rand - a String containing the word "Random" for the random sort arrangement
 */
   public static final String rand = "Random";

/** baseArray - the return value of createArray: a randomly arranged array that can be used for testing Random, without
* having to create a new array each time you want to test the sorts (eliminates variables)
 */
   public static final int[] baseArray = createArray(50000);

/** This method is the main method; where it all begins. In this program, main is used to test all of the sorts and whether
 * or not each method throws the correct exceptions.
 * @param args the arguments of the program
 */
   public static void main (String[] args)
   {
      System.out.println("Testing createArray for increasing...");
      int [] createdArray = createArray (arraySize, "Increasing");
      System.out.println(Arrays.toString(createdArray));
      System.out.println("Testing createArray for decreasing...");
      int [] createdArray2 = createArray (arraySize, "Decreasing");
      System.out.println(Arrays.toString(createdArray2));
      System.out.println("Testing createArray for random...");
      int [] createdArray3 = createArray (arraySize, "Random");
      System.out.println(Arrays.toString(createdArray3));
      System.out.println("Testing swap...");
      try
      {
         System.out.println ("Testing null list...");
         swap (null, 1, 1);
      }
      catch (IllegalArgumentException e)
      {
         System.out.println ("Null list threw the correct exception");
      }
      try
      {
         System.out.println ("Testing out-of-bound indices...");
         swap (createdArray, -1, 5);
      }
      catch (IllegalArgumentException e)
      {
         System.out.println ("Out-of-bound indices threw the correct exception");
      }
      System.out.println("Testing swap with equivalent indices...");
      System.out.println ("Array Before Swap w/ Equivalent Indices: " + Arrays.toString(createdArray));
      swap (createdArray, 3, 3);
      System.out.println ("Array After Swap w/ Equivalent Indices: " + Arrays.toString(createdArray));
      System.out.println ("Testing swap...");
      System.out.println ("Array Before Legitimate Swap: " + Arrays.toString(createdArray));
      swap (createdArray, 3, 5);
      System.out.println ("Array After Legitimate Swap: " + Arrays.toString(createdArray));
      System.out.println ("Testing selectionSort...");
      int[] array1 = createArray(9, rand);
      System.out.println ("Array Before Selection Sort: " + Arrays.toString(array1));
      selectionSort(array1);
      System.out.println ("Array After Selection Sort: " + Arrays.toString(array1));
      try
      {
         System.out.println ("Testing selectionSort for length = 0...");
         int[] array2 = new int[0];
         System.out.println("0 length Array Before Selection Sort: " + Arrays.toString(array2));
         selectionSort(array2);
         System.out.println ("0 length Array After Selection Sort: " + Arrays.toString(array2));
      }
      catch (IllegalArgumentException e)
      {
         System.out.println ("0 length array threw the correct exception");
      }
      System.out.println ("Testing selectionSort for length = 1...");
      int[] array3 = createArray(1, rand);
      System.out.println ("Array of length 1 Before Selection Sort: " + Arrays.toString(array3));
      selectionSort(array3);
      System.out.println ("Array of length 1 After Selection Sort: " + Arrays.toString(array3));
      System.out.println ("Testing insertionSort...");
      int[] array4 = createArray(10, rand);
      System.out.println ("Array Before Insertion Sort: " + Arrays.toString(array4));
      insertionSort(array4);
      System.out.println ("Array After Insertion Sort: " + Arrays.toString(array4));
      try
      {
         System.out.println ("Testing insertionSort for length = 0...");
         int[] array5 = new int [0];
         System.out.println("0 length Array Before Insertion Sort: " + Arrays.toString(array5));
         insertionSort(array5);
         System.out.println ("0 length Array After Insertion Sort: " + Arrays.toString(array5));
      }
      catch (IllegalArgumentException e)
      {
         System.out.println ("0 length array threw the correct exception");
      }
      System.out.println ("Testing insertionSort for length = 1...");
      int[] array6 = createArray(1, rand);
      System.out.println ("Array of length 1 Before Insertion Sort: " + Arrays.toString(array6));
      insertionSort(array6);
      System.out.println ("Array of length 1 After Insertion Sort: " + Arrays.toString(array6));
      System.out.println ("Testing merge...");
      System.out.println ("First Sorted Array: " + Arrays.toString(array4));
      System.out.println ("Second Sorted Array: " + Arrays.toString(array1));
      int[] resultArray = new int [array4.length + array1.length];
      merge (resultArray, array4, array1);
      System.out.println ("Array After Merge: " + Arrays.toString(resultArray));
      try
      {
         System.out.println("Testing merge for null array...");
         int[] emptyArray = null;
         int[] result = new int[array1.length];
         merge(result, emptyArray, array1);
         System.out.println ("0 length Array Ater Merge: " + Arrays.toString(result));
      }
      catch (IllegalArgumentException e)
      {
         System.out.println ("Null array threw the correct exception");
      }
      try
      {
         System.out.println ("Testing merge for incorrect result array length...");
         int[] badResult = new int[4];
         merge (badResult, array4, array1);
      }
      catch (IllegalArgumentException e)
      {
         System.out.println ("Incorrect result array length threw the correct exception");
      }
      System.out.println ("Testing mergeSort...");
      int[] array7 = createArray(10, rand);
      System.out.println ("Array Before Merge Sort: " + Arrays.toString(array7));
      mergeSort(array7);
      System.out.println ("Array After Merge Sort: " + Arrays.toString(array7));
      try
      {
         System.out.println ("Testing mergeSort for length = 0...");
         int[] array8 = new int [0];
         System.out.println("0 length Array Before Merge Sort: " + Arrays.toString(array8));
         mergeSort(array8);
         System.out.println ("0 length Array After Merge Sort: " + Arrays.toString(array8));
      }
      catch (IllegalArgumentException e)
      {
         System.out.println ("0 length array threw the correct exception");
      }
      System.out.println ("Testing mergeSort for length = 1...");
      int[] array9 = createArray(1, rand);
      System.out.println ("Array of length 1 Before Merge Sort: " + Arrays.toString(array9));
      mergeSort(array9);
      System.out.println ("Array of length 1 After Merge Sort: " + Arrays.toString(array9));
   }

/** This method takes two parameters: an int parameter for the size of the array to create and a String representing the 
 * the arrangement you are using for the array, in order to return the newly created array. The method first checks to see 
 * whether the size of the desired array is greater than 0 or not and then based on the arrangement, the method will load the
 * array with either increasing integers, decreasing integers, or will make a copy of the base array, for the random 
 * arrangement.
 * @param size the size of the array that you wish to create
 * @param arrangement a String containing the arrangement of the array that you want (increasing, decreasing, or random)
 * @return the newly created array
 */
   public static int[] createArray(int size, String arrangement)
   {
      if (size > 0)
      {
         int [] newArray = new int [size];
         for (int ii = 0; ii < size; ii++)
         {
            if (arrangement.equals(inc))//if you want it to be an increasing array
               newArray[ii] = ii;
            else if (arrangement.equals(dec))//if you want it to be a decreasing array
               newArray[ii] = (size - ii);
            else if (arrangement.equals(rand))//if you want it to be a random array
               newArray = Arrays.copyOf(baseArray, size);//so that you aren't creating a new random array each time
         }
         return newArray;
      }
      throw new IllegalArgumentException(); //if size <= 0
   }
   
/** This version of createArray takes one parameter: the desired size of the array, and returns the newly created array
 * comprised of random integers ranging from -MAX_VALUE (inclusive) to MAX_VALUE (exclusive). The method first verifies that
 * size is greater than 0 (else, throws an exception) and then creates a new array of length "size", which it fills with 
 * random integers.
 * @param size the size of the array that you wish to create
 * @return the base array that you use when you want to test a randomly arranged array
 */  
   public static int[] createArray (int size)
   {
      if (size > 0)
      {
         int [] newArray = new int[size];
         Random r = new Random();
         for (int ii = 0; ii < size; ii++)
         {
            int randValue = r.nextInt(); //range from [-MAX_INT, MAX_INT)
            newArray[ii] = randValue;
         }
         return newArray;
      }
      throw new IllegalArgumentException(); //if size <= 0
   }

/** This method takes three parameters: the array you are looking at and the indices of the terms you would like to swap and
 * swaps the terms. The method first checks to see whether the list is null or not and then checks to see whether the indices
 * are within the bounds of the array. The method then checks to see if i and j are the same value, resulting in no swap, 
 * and the method will simply swap the two values, otherwise.
 * @param list the array that you want to look at
 * @param i the index of the first term you want to swap
 * @param j the index of the second term you want to swap 
 */
   private static void swap (int[] list, int i, int j)
   {
      if (list == null)
         throw new IllegalArgumentException();
      else // if (list != null)
      {
         if (i >= 0 && i < arraySize && j >= 0 && j < arraySize)
         { 
            if (i == j)
               return;
            else //if (i != j)
            {
               int temp = list[i];
               list[i] = list[j];
               list[j] = temp; //swap values at i and j
            }
         }
         else // if (i and j are not within bounds of array)
            throw new IllegalArgumentException();
      }  
   }

/** This method performs the well-known sort called selection sort. The method takes one parameter: the array that you wish
 * to sort. The method scans through the array and finds the smallest value in the list, swaps that term with the value in
 * the first position, and proceeds to do that until you get to the end of the list. This way, the list is constantly 
 * getting updated with a new min value each time you scan through the list.
 * @param list the array that you wish to sort
 */
   public static void selectionSort(int[] list)
   {
      for (int ii = 0; ii < list.length; ii++)
      {
         int smallest = ii; //set smallest to the first element in the list
         for (int jj = ii+1; jj < list.length; jj++)
         {
            if (list[jj] < list[smallest])
            {
               smallest = jj; //update smallest
            }
         }
         int temp = list[ii];
         list[ii] = list[smallest];
         list[smallest] = temp; //swap values at the index and the smallest index
      }
   }

/** This method performs the well-known sort, insertion sort, on the array that is passed in as a parameter. This method
 * scans the list from left to right and finds the first value that is smaller than the adjacent value to the left. When the
 * method finds that value, the method pulls it out of the list and shifts everything previously to the left of this value
 * one position to the right until the correct position is found. The method then continues to scan the list until you find
 * the next, even smaller value.
 * @param list the array that you wish to sort
 */
   public static void insertionSort(int[] list)
   {
      int index;
      int shift;
      int tempValue;
      for (index = 1; index < list.length; index++)
      {
         if (list[index] < list[index-1])
         {
            tempValue = list[index];
            shift = index;
            do
            {
               list[shift] = list[shift-1];
               shift--;
            }
            while (shift > 0 && list[shift-1] > tempValue);
            list[shift] = tempValue;
         }
      }
   }
 
/** This method takes two arrays and merges them into one array. The method takes three parameters: the resulting merged
 * array and the two arrays that you wish to merge. The method first ensures that the arrays are not null and that the length
 * of the result list is the sum of the lengths of list1 and list2. If the parameters pass the tests, the method continues
 * to merge and actively sort the arrays whilst feeding the sorted terms into the result array.
 * @param result the resulting, merged array
 * @param list1 the first array that you wish to merge
 * @param list2 the second array that you wish to merge
 */
   private static void merge (int[] result, int[] list1, int[] list2)
   {
      if (list1 == null || list2 == null || result.length != (list1.length + list2.length))
         throw new IllegalArgumentException();
      else //if lists are not null and length of result array is the sume of the lengths of list1 and list2
      {
         int i1 = 0;
         int i2 = 0;
         for (int ii = 0; ii < result.length; ii++)
         {
            if (i2 >= list2.length || (i1 < list1.length && list1[i1] < list2[i2]))
            {
               result[ii] = list1[i1];
               i1++;
            }
            else //if (i2 < list2.length && (i1 >= list1.length || list1[i1] >= list2[i2]))
            {
               result[ii] = list2[i2];
               i2++;
            }
         }
      } 
   }

/** This method first splits the array that is passed in into two halves, mergeSorts the left half (recursively), mergeSorts
 * the right half (recursively), and then combines the two halves into a sorted whole, using the merge method.
 * @param list the array that you wish to sort and merge 
 */
   public static void mergeSort (int[] list)
   {
      if (list.length > 1)
      {
         int size1 = (list.length)/2;
         int size2 = list.length - size1;
         int[] list1 = new int[size1];
         int[] list2 = new int[size2];
         list1 = Arrays.copyOf(list, size1); //copies first half of list into list1
         list2 = Arrays.copyOfRange(list, size1, list.length); //copies second half of list into list2
         mergeSort(list1);
         mergeSort(list2); //recursion
         merge(list, list1, list2); //merge lists
      }
   }
}