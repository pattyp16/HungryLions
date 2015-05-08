import java.util.*; 

public class IteratorTest
{
   public static void main(String[] args)
   {  
      List<Integer> list = new ArrayList<Integer>(); 
      test(list, "ArrayList"); 
   
      System.out.println(); 
      list = new LinkedList<Integer>(); 
      test(list, "LinkedList"); 
   }

   /** Method to run a test. This includes printing which test, 
    *  loading the list with integers, testing the "get" method with the list
    *  then testin the iterator version of visiting each node of the list
    *  @param list The list to traverse
    *  @param whichTest Basically "ArrayList" or "LinkedList"
   */   
   public static void test(List<Integer> list, String whichTest)
   {
      System.out.println(whichTest);       
      int sizes[] = {10000, 20000, 40000, 80000, 160000, 320000}; 
      for (int ii = 0; ii < sizes.length; ii++)
      {
      
         test(list, sizes[ii]); 
         list.clear();        // clean up on aisle 1. 
      }
   }
   
   /** Method to run a test with a certain number of integers. 
    *  @param list The list to traverse
    *  @param size How many items to load in the list
   */   
   public static void test(List<Integer> list, int size)
   {
      System.out.println("Size = " + size); 
      loadList(list, size); 
      testGet(list); 
      testIterator(list); 
   }

   
   
   /** Load the list passed into this method to the maximum integer
    *  @param list The list to load up. Note that this is a pass by reference so it gets filled up nicely. 
    *  @param max The max number to load up to 
    */
   public static void loadList(List<Integer> list, int max)
   {
      for (int ii = 0; ii < max; ii++)
      {
         list.add(ii); 
      }
   }
   
   /** Empirical test of the get method on the list. Put on your white gloves and return a time. 
    *  @param list The list to test
    */   
   public static void testGet(List<Integer> list)
   {
      Integer theInt;
      System.gc();  
      long starttime = System.currentTimeMillis(); 
      for (int ii = 0; ii < list.size(); ii++) 
      {
         theInt = list.get(ii);
      }
      long endtime = System.currentTimeMillis(); 
      long time = endtime - starttime; 
      System.out.println("List traversed using get in: " + time + " milliseconds"); 
   }
   
   
   /** Empirical test of the iterator method on the list. Put on your white gloves and return a time. 
    *  @param list The list to test
    */ 
   public static void testIterator(List<Integer> list)
   {
      Integer theInt;
      System.gc();  
      Iterator<Integer> iter = list.iterator(); 
      long starttime = System.currentTimeMillis(); 
      while ( iter.hasNext() )
      {
         theInt = iter.next();       
      }
      long endtime = System.currentTimeMillis(); 
      long time = endtime - starttime; 
      System.out.println("List traversed using iterator in: " + time + " milliseconds"); 
   }
   
   
}
