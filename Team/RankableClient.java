public class RankableClient
{
   public static void main(String[] args)
   {
     //Rankable r = new Rankable();
      
      Record r1 = new Record(4,3);
      Record r2 = new Record(5,5);
      Record r3 = new Record(9,6);
      whichIsBetterThanWhich(r1, r2, r3);
      
      IndividualPlayer Roger = new IndividualPlayer("Roger", true, new Record(100, 100));
      IndividualPlayer Rafael = new IndividualPlayer("Rafael", true, new Record(88, 88));
      IndividualPlayer Novak = new IndividualPlayer("Nivak", false, new Record(76, 70));
      whichIsBetterThanWhich(Roger, Rafael, Novak);
      
      CodingTeam team8AM = createCodingTeamFromFirstPeriod();
      CodingTeam teamAlexRyan = createCodingTeamFromThirdPeriod(); 
      CodingTeam teamOtherClasses = createCodingTeamFrom4thAnd5thPeriods();
      whichIsBetterThanWhich(team8AM, teamAlexRyan, teamOtherClasses);
      
   }
  
   public static void whichIsBetterThanWhich(Rankable item1, Rankable item2, Rankable item3)
   {
      String[] messages = {"ranks behind", "ranks equal to", "ranks ahead of"};
      System.out.println("item1 - " + item1);
      System.out.println("item2 - " + item2);
      System.out.println("item3 - " + item3);
      System.out.println("item1 " + messages[item1.isBetterThan(item2)+1] + " item2");
      System.out.println("item1 " + messages[item1.isBetterThan(item3)+1] + " item3");
      System.out.println("item2 " + messages[item2.isBetterThan(item3)+1] + " item3");
      System.out.println();
   }
   
   /**
    *Create a CodingTeam with some students from first period
    *@return The CodingTeam
    */
   public static CodingTeam createCodingTeamFromFirstPeriod()
   {
      CodingTeam theTeam = new CodingTeam(6, 3);
      theTeam.addPlayer( new TeamPlayer("Rohit", true, "coder") );
      theTeam.addPlayer( new TeamPlayer("Marla", false, "designer") );
      theTeam.addPlayer( new TeamPlayer("Claire", true, "kibbitzer") );
      theTeam.addPlayer( new TeamPlayer("Carter", true, "designer") );
      theTeam.addPlayer( new TeamPlayer("Patty", false, "kibbitzer") );
      theTeam.setRecord(new Record(20,15));
      return theTeam;
   }
   
   /**
    *Create a CodingTeam with some students from third period
    *@return The CodingTeam
    */
   public static CodingTeam createCodingTeamFromThirdPeriod()
   {
      CodingTeam theTeam = new CodingTeam(6, 3);
      theTeam.addPlayer( new TeamPlayer("Ryan", true, "coder") );
      theTeam.addPlayer( new TeamPlayer("Other Ryan", false, "coder") );
      theTeam.addPlayer( new TeamPlayer("Alex C.", true, "designer") );
      theTeam.addPlayer( new TeamPlayer("Alex M.", true, "designer") );
      theTeam.setRecord(new Record(50,0));
      return theTeam;
   }
   
   /**
    *Create a CodingTeam with some students from 4tha nd 5th periodsd
    *@return The CodingTeam
    */
   public static CodingTeam createCodingTeamFrom4thAnd5thPeriods()
   {
      CodingTeam theTeam = new CodingTeam(6, 3);
      theTeam.addPlayer( new TeamPlayer("Karsten", true, "coder") );
      theTeam.addPlayer( new TeamPlayer("Kate", false, "coder") );
      theTeam.addPlayer( new TeamPlayer("Sadie", true, "designer") );
      theTeam.addPlayer( new TeamPlayer("Anna", true, "designer") );
      theTeam.addPlayer( new TeamPlayer("Jackson", false, "kibbitzer") );
      theTeam.addPlayer( new TeamPlayer("Gabe", true, "kibbitzer") );
      theTeam.setRecord(new Record(20,25));
      return theTeam;
   }
}

