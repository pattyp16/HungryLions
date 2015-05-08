//Tom Butler, CSIII, Spring 2015
//Example <Sport>Team class to extend abstract class Team
//Used with Worksheets 32 and 33

/**
 *Class to represent a coding team that competes in programming contests
 */
public class CodingTeam extends Team
{
   /**
    *Construct the coding team
    *@param maxOnRoster The most players that can be on the roster
    *@param numNeededToCompete The minimum number of AVAILABLE players needed to compete in a contest
    */
   public CodingTeam(int maxOnRoster, int numNeededToCompete)
   {
      super(maxOnRoster, numNeededToCompete);  //Use constructor in Team
      this.setRecord( new Record() );  //Record initialized here in subclass because type of Record depends on type of team
   }
   
   /**
    *Add a player to the teams roster
    *@param p The Player to be added.  
    *Note that parameter p delcared as Player, but aargument must be TeamPlayer to be put in the roster 
    */
   public void addPlayer(Player p)
   {
      if (!(p instanceof TeamPlayer))  //This ensures that the roster of a CodingTeam will contain TeamPlayers
         throw new IllegalArgumentException("Only TeamPlayers can be added to CodingTeams");
      super.addPlayer(p);
   }
   
   /**
    *Looks at roster and decides if a competative team can be fielded.
    *A competative CodingTeam has at least one available player for each postion. 
    */
   public boolean shouldFieldATeam()
   {
      if (!this.canFieldATeam())
         return false;  //If you can't field a team, then you shouldn't
         
      //Flags for the three positions
      boolean haveCoder = false;
      boolean haveDesigner = false;
      boolean haveKibbitzer = false;
      
      for ( Player p : this.getRoster() )
      {
         TeamPlayer thePlayer = (TeamPlayer)p;  //Cast as TeamPlayer to use getPosition() method
         if ( thePlayer != null && thePlayer.getStatus() )  //Only look at the player if they are available
         {
            switch ( thePlayer.getPosition() )
            {
               case "coder":
                  haveCoder = true;
                  break;
               case "designer":
                  haveDesigner = true;
                  break;
               case "kibbitzer":
                  haveKibbitzer = true;
                  break;
            }
         } 
      }
      return (haveCoder && haveDesigner && haveKibbitzer);
   }
   
   /**
    *Update the position of a player in the roster
    *@param name The player's name
    *@param newPosition The player's new position
    */
   public void updatePosition(String name, String newPosition)
   {
      TeamPlayer p = (TeamPlayer) this.findPlayer(name);  //Must cast to TeamPlayer to use setPosition()
      if ( p != null )
         p.setPosition(newPosition);
   }
   
   /**
    *Get the number of wins
    *@return The number of wins
    */
   public int getWins()
   {
      return this.getRecord().getWins();
   }
   
   /**
    *Set the number of wins
    *@param numWins The number of wins
    */
   public void setWins(int numWins)
   {
      this.getRecord().setWins(numWins);
   }
   
   /**
    *Get the number of losses
    *@return The number of losses
    */  
   public int getLosses()
   {
      return this.getRecord().getLosses();
   }
   
   /**
    *Set the number of losses
    *@param numLosses The number of losses
    */
   public void setLosses(int numLosses)
   {
      this.getRecord().setLosses(numLosses);
   }
   
   /**
    *Increment the number of wins
    */
   public void won()
   {
      this.getRecord().won();
   }
   
   /**
    *Increment the number of losses
    */
   public void lost()
   {
      this.getRecord().lost();
   }
   
}
