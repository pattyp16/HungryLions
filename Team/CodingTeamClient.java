//Tom Butler, CS III, 3/1/15
//Client to test Team hierarchy
//Creats and tests a BasketballTeam


/**
 *Create and test a CodingTeam object
 */
public class CodingTeamClient
{
   public static int ROSTER_SIZE = 6;
   public static int NUM_IN_CONTEST = 3;
   
   //Create the CodingTeams and call various methods
   public static void main(String[] args)
   {
      //Create CodingTeams
      CodingTeam team8AM = createCodingTeamFromFirstPeriod();
      CodingTeam teamAlexRyan = createCodingTeamFromThirdPeriod(); 
      System.out.println(team8AM);
      System.out.println(teamAlexRyan);
      
      //Check canFieldATeam, shouldFieldATeam
      System.out.println("Can team8AM field a team? " + team8AM.canFieldATeam());
      System.out.println("Should they? " + team8AM.shouldFieldATeam());
      System.out.println("Can teamAlexRyan field a team? " + teamAlexRyan.canFieldATeam());
      System.out.println("Should they? " + teamAlexRyan.shouldFieldATeam());
      System.out.println();
      
      //Find, remove players and change status and positions
      System.out.println("Looking for Rohit... " + team8AM.findPlayer("Rohit") );
      team8AM.removePlayer("Claire");
      team8AM.updatePlayerStatus("Patty", true);
      teamAlexRyan.updatePosition("Alex M.", "kibbitzer");
      //Print teams and can/should results again to see if changes worked
      System.out.println(team8AM);
      System.out.println(teamAlexRyan);
      System.out.println("Can team8AM field a team? " + team8AM.canFieldATeam());
      System.out.println("Should they? " + team8AM.shouldFieldATeam());
      System.out.println("Can teamAlexRyan field a team? " + teamAlexRyan.canFieldATeam());
      System.out.println("Should they? " + teamAlexRyan.shouldFieldATeam());
      System.out.println();
      
      //Update and access the Records, test isBetterThan
      team8AM.setWins(5);
      team8AM.setLosses(6);
      System.out.println("team8AMs record: " + team8AM.getRecord());
      team8AM.won();
      System.out.println("team8AMs new record: " + team8AM.getRecord());
      teamAlexRyan.setWins(9);
      teamAlexRyan.setLosses(9);
      System.out.println("teamAlexRyans record: " + teamAlexRyan.getRecord());
      System.out.println("Is team8AM better than teamAlexRyan? " + 
                         team8AM.isBetterThan(teamAlexRyan) + "\n");
      
      
      team8AM.sort();
      System.out.println(team8AM);
  
   }
   
   /**
    *Create a CodingTeam with some students from first period
    *@return The CodingTeam
    */
   public static CodingTeam createCodingTeamFromFirstPeriod()
   {
      CodingTeam theTeam = new CodingTeam(ROSTER_SIZE, NUM_IN_CONTEST);
      theTeam.addPlayer( new TeamPlayer("Rohit", true, "coder") );
      theTeam.addPlayer( new TeamPlayer("Marla", false, "designer") );
      theTeam.addPlayer( new TeamPlayer("Claire", true, "kibbitzer") );
      theTeam.addPlayer( new TeamPlayer("Carter", true, "designer") );
      theTeam.addPlayer( new TeamPlayer("Patty", false, "kibbitzer") );
      return theTeam;
   }
   
   /**
    *Create a CodingTeam with some students from third period
    *@return The CodingTeam
    */
   public static CodingTeam createCodingTeamFromThirdPeriod()
   {
      CodingTeam theTeam = new CodingTeam(ROSTER_SIZE, NUM_IN_CONTEST);
      theTeam.addPlayer( new TeamPlayer("Ryan", true, "coder") );
      theTeam.addPlayer( new TeamPlayer("Other Ryan", false, "coder") );
      theTeam.addPlayer( new TeamPlayer("Alex C.", true, "designer") );
      theTeam.addPlayer( new TeamPlayer("Alex M.", true, "designer") );
      return theTeam;
   }
}
