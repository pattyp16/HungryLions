import java.util.*; 

public class RecordClient
{

   /** How many records to test */
   private static final int MAX_RECORDS = 4; 
   
   /** Maxiumum number of games in the "season" for a record (for testing) */
   private static final int MAX_GAMES = 100; 
   
   /**
    * Entry point for the program 
    */
   public static void main(String[] args)
   {
      Random r = new Random(); 
      testRecords(r); 
      testRecordWithTies(r); 
      testRecordWithTiesAndElo(r);
      testUpdateElo();
   }
   
   /**
    *  Method to test plain ol' records with wins and losses. 
    */
   public static void testRecords(Random r)
   {
      System.out.println("Testing Record");
      Record[] records = new Record[MAX_RECORDS]; 
      
      // Randomly set the wins and losses. 
      for ( int ii = 0; ii < records.length; ii++)
      {
         records[ii] = new Record();
         int wins = r.nextInt(MAX_GAMES);
         int losses = MAX_GAMES - wins; 
         records[ii].setWins(wins);
         records[ii].setLosses(losses);
      }
      
      // Print out the records just to see what's there. 
      printRecords("Initial records", records); 
   
      // See if the wins and losses works
      // The first half won and the second half lost. 
      for ( int ii = 0; ii < records.length / 2; ii++)
      {
         records[ii].won(); 
         records[records.length - ii - 1].lost(); 
      }  
      
      // Print out the records just to see what's there. Did it work? 
      printRecords("\nRecords after winning and losing", records); 

      printBetterThan(records);
      
      // last test: check for equality
      Record newRecord = new Record(); 
      newRecord.setWins(records[0].getWins()); // tests get and set at the same time
      newRecord.setLosses(records[0].getLosses()); // tests get and set at the same time
      printEquals(newRecord, records[0]); 
   }
   
   /**
    *  Method to test records with wins and losses and ties. 
    */
   public static void testRecordWithTies(Random r)
   {
      System.out.println("\nTesting RecordWithTies");
      RecordWithTies[] records = new RecordWithTies[MAX_RECORDS]; 
      
      // Randomly set the wins and losses. 
      for ( int ii = 0; ii < records.length; ii++)
      {
         records[ii] = new RecordWithTies();
         int wins = r.nextInt(MAX_GAMES);
         int losses = r.nextInt(MAX_GAMES - wins);
         int ties = MAX_GAMES - wins - losses;  
         records[ii].setWins(wins);
         records[ii].setLosses(losses);
         records[ii].setTies(ties);
      }
      
      //Print out the records just to see what's there. 
      printRecords("Initial records with ties", records); 
   
      // See if the wins and losses works. The first 3rd of the 
      // records are wins, the second third are losses, the last third are ties. 
      for ( int ii = 0; ii < records.length / 3; ii++)
      {
         records[ii].won(); 
         records[2 * records.length / 3 - ii - 1].lost(); 
         records[records.length - ii - 1].tied(); 
      }  
      
      // Print out the records just to see what's there. Did it work? 
      printRecords("\nRecords after winning, losing, and tieing", records); 

      printBetterThan(records);
      
      // last test: check for equality
      RecordWithTies newRecord = new RecordWithTies(); 
      newRecord.setWins(records[0].getWins()); // tests get and set at the same time
      newRecord.setLosses(records[0].getLosses()); // tests get and set at the same time
      newRecord.setTies(records[0].getTies()); 
      printEquals(newRecord, records[0]);   
   
   }
   
   
   /**
    *  Method to test records with with wins, losses, ties and an elo ranking. 
    */
   public static void testRecordWithTiesAndElo(Random r)
   {
      int MAX_ELO = 2000; 
      
      System.out.println("\nTesting RecordWithTiesAndElo");
      RecordWithTiesAndElo[] records = new RecordWithTiesAndElo[MAX_RECORDS]; 
      
      for ( int ii = 0; ii < records.length; ii++)
      {
         records[ii] = new RecordWithTiesAndElo();
      }
      
      // Print out the records just to see what's there. 
      printRecords("Initial records with Elos", records); 
   
      // Randomly have the "records" play each other. One will randomly win. 
      int ii = 0; 
      while (ii < MAX_GAMES)
      {
         int p1 = r.nextInt(MAX_RECORDS); 
         int p2 = r.nextInt(MAX_RECORDS); 
         if ( p1 == p2 )  // can't play yourself, try again
            continue; 
         
         // now randomly pick the winner, or a tie
         int whoWins = r.nextInt(2);
         eloUpdate(records, p1, p2, whoWins); 
         ii++;
      }  
      
      // Print out the records just to see what's there. Did it work? 
      printRecords("\nRecords after games played", records); 

      printBetterThan(records);
      
      // last test: check for equality
      RecordWithTiesAndElo newRecord = new RecordWithTiesAndElo(); 
      newRecord.setWins(records[0].getWins()); // tests get and set at the same time
      newRecord.setLosses(records[0].getLosses()); // tests get and set at the same time
      newRecord.setTies(records[0].getTies()); 
      newRecord.setElo(records[0].getElo());
      printEquals(newRecord, records[0]);   
   
   
   }
   
   /** 
    * Helper method to update the elos of two records, based on who won
	* @param records The array containing all of the records
	* @param p1 the first record to modify
	* @param p2 the second record to modify
	* @param whoWon 0 if they tied, 1 if p1 won, and 2 if p2 won
	*/
   public static void eloUpdate(RecordWithTiesAndElo[] records, int p1, int p2, int whoWon)
   {
      double outcome = 0.0;
      int winner = p1; 
      int loser = p2; 
      if ( whoWon == 0 ) // we'll call this a tie and for our purposes, p1 "won"
      {
         records[p1].tied();
         records[p2].tied(); 
         outcome = 0.5; 
      }
      else 
      {
         if ( whoWon == 1 ) // player 1 won... 
            outcome = 1.0; 
         else 
         {
            winner = p2; 
            loser = p1; 
            outcome = 0;
         }
         records[winner].won(); 
         records[loser].lost(); 
      } 
      //records[p1].updateElo(records[p2], outcome); 
      RecordWithTiesAndElo.updateElo (records[p1], records[p2], outcome);
    }
   
   
   
   /** 
    * Helper method to print out the records, first showing an informational string
    * @param information A string telling giving some information about the state of the records
    *  @param records The records to be tested
    */
   public static void printRecords(String information, Record[] records)
   {
      System.out.println(information); 
      for ( int ii = 0; ii < records.length; ii++)
      {
         System.out.println("Record " + ii + " is " + records[ii]); 
      }   
      
   }
   
   /**
    *  A method to test the "isBetterThan" method in a record
    *  @param records The records to be tested
    */
   public static void printBetterThan(Record[] records)
   {
      // Now check if one is better than the other
      // Print out the records just to see what's there. Did it work? 
      System.out.println("\nChecking if \"isBetterThan\" works"); 
      for ( int ii = 0; ii < records.length - 1; ii++)
      {
         System.out.print("Record " + records[ii] + " is " );
         int rating = records[ii].isBetterThan(records[ii + 1]);
         if ( rating < 0 )
            System.out.print("not better than "); 
         else if ( rating > 0 )
            System.out.print("better than "); 
         else if ( rating == 0 )
            System.out.print("tied with "); 
         System.out.println("record " + records[ii+1]); 
      }    
   }

   public static void printEquals(Record record1, Record record2)
   {
      System.out.println("\nChecking if \".equals\" works");     
      if ( record1.equals(record2) ) // they should be equivalent
         System.out.println("The records are equal"); 
      else
         System.out.println("The records aren't equal, something went wrong...");
   }
   
   public static void testUpdateElo()
   {
      RecordWithTiesAndElo r1 = new RecordWithTiesAndElo();
      r1.setElo(1400);
      RecordWithTiesAndElo r2 = new RecordWithTiesAndElo();
      r2.setElo(1800);
      
      r1.updateElo(r2, 0.5);
      System.out.println("r1: " + r1);
      System.out.println("r2: " + r2);
      
      r1.setElo(1400);
      r2.setElo(1800);
      RecordWithTiesAndElo.updateElo(r1, r2, 0.5);
      System.out.println("r1(static): " + r1);
      System.out.println("r2(static): " + r2);
   }

}
