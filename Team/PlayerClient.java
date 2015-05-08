public class PlayerClient
{


   public static void main(String[] args)
   {
      testPlayers();
      // testIndividualPlayers(); 
      // testRecords();            
   
   }
   
   /** Method to test the Player class
    *
    */
   public static void testPlayers()
   {
      // Create a blank Player, 
      // then set the name and status using mutator methods.
      // Print out the result. 
      Player footballPlayer = new Player(); 
      footballPlayer.setName("Russel Wilson"); 
      footballPlayer.setStatus(false); 
      System.out.println(footballPlayer); 
      
      // Create a new Player with the one parameter constructor
      // do not set the status
      // print the result. 
      Player ultimatePlayer = new Player("Khalif El-salaam"); 
      System.out.println(ultimatePlayer);       
            
      // Create a new Player with the one parameter constructor
      // set the status to true. 
      // print the result. 
      Player soccerPlayer = new Player("Lionel Messi"); 
      soccerPlayer.setStatus(true); 
      System.out.println(soccerPlayer); 
      
      // Create a new Player with the two parameter constructor
      // print the result. 
      Player baseballPlayer = new Player("Edgar Martinez", false); 
      System.out.println(baseballPlayer); 
      
      // Create a new Player using the accessor methods to get the name and status from another Player. 
      // Print whether two objects are identical. 
      Player testPlayer = new Player(baseballPlayer.getName(), baseballPlayer.getStatus()); 
      System.out.print(testPlayer + " is"); 
      if ( !testPlayer.equals(baseballPlayer) )
         System.out.print(" not"); 
      System.out.println(" equal to " + baseballPlayer); 
      
      TeamPlayer superstar = new TeamPlayer();
      superstar.setName("Marshawn Lynch");
      superstar.setStatus(true);
      superstar.setPosition("running back");
      System.out.println (superstar);
      
      TeamPlayer beast = new TeamPlayer("Marshawn Lynch", true, "running back");
      System.out.print (beast + " is");
      if (!beast.equals(superstar))
         System.out.print(" not");
      System.out.println (" equal to " + superstar); 
      
      TeamPlayer John = new TeamPlayer("John Doe", "quarterback");
      System.out.println (John);
      
      Record perfect = new Record();
      perfect.setWins(10);
      perfect.setLosses(0);
      System.out.println(perfect);
      System.out.println ("Percentage is: " + perfect.getPercent());
      Record lessThanPerfect = new Record();
      lessThanPerfect.setWins(4);
      lessThanPerfect.setLosses(5);
      System.out.println(lessThanPerfect);
      System.out.println("Percentage is: " + lessThanPerfect.getPercent());
      System.out.println("Less than perfect is better than perfect? " + lessThanPerfect.isBetterThan(perfect));
      
      IndividualPlayer Serena = new IndividualPlayer ();
      Serena.setName ("Serena Williams");
      Serena.setStatus (true);
      Serena.setWins (5);
      Serena.setLosses(2);
      System.out.println(Serena);
      System.out.println("Percentage is: " + Serena.getPercent());
      
   }    
      
      

}
