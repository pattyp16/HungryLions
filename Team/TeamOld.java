public abstract class TeamOld implements Rankable
{
   private Player[] roster;
   private int MAX_ROSTER_SIZE;
   private int MIN_PLAYING_NUM;
   private Record teamRecord;
      
   public TeamOld (int max, int min)
   {
      if (max <= 0 || min <= 0)
      {
         throw new IllegalArgumentException();
      }
      MAX_ROSTER_SIZE = max;
      MIN_PLAYING_NUM = min;
      this.roster = new Player[MAX_ROSTER_SIZE];
   }
   public String toString()
   {
      String finalStr = "";
      for (int ii = 0; ii<roster.length; ii++)
      {
         if (roster[ii]!= null)
         {
            Player p = roster[ii];
            finalStr += (p + "\n");
         }
      }
      return finalStr;
   }
   public void addPlayer (Player p)
   {
      boolean playerAdded = false;
      for (int ii = 0; ii<roster.length; ii++)
      {
         if (roster[ii] == null)
         {
            roster[ii] = p;
            playerAdded = true;
            break;
         }
      }
      if (!playerAdded)
      {
         throw new IllegalArgumentException();
      }
   }
   public boolean removePlayer(String name)
   {
      boolean playerRemoved = false;
      for (int ii = 0; ii<roster.length; ii++)
      {
         if (roster[ii] != null && roster[ii].getName().equals(name))
         {
            roster[ii] = null;
            playerRemoved = true;
            break;
         }
      }
      if (!playerRemoved)
      {
         throw new IllegalArgumentException();
      }
      return playerRemoved;
   }
   public Player findPlayer(String name)
   {
      for (int ii = 0; ii<roster.length; ii++)
      {
         if (roster[ii]!= null && roster[ii].getName().equals(name))
         {
            return roster[ii];
         }
      }
      return null;
   }
   public int getRosterSize()
   {
      return roster.length;
   }
   public void updatePlayerStatus(String name, boolean newStatus)
   {
      Player p = findPlayer(name);
      if (p != null)
      {
         p.setStatus(newStatus);
      }
   }
   public boolean canFieldATeam ()
   {
      int availablePlayer = 0;
      for (int ii = 0; ii<(roster.length-1); ii++)
      {
         if (roster[ii]!=null && roster[ii].getStatus()==true)
         {
            availablePlayer++;
         }
      }
      if (availablePlayer >= MIN_PLAYING_NUM)
      {
         return true;
      }
      else //if (availablePlayer < MIN_PLAYING_NUM)
      {
         return false;
      }
   }
   public abstract boolean shouldFieldATeam();
   public Record getRecord()
   {
      return teamRecord;
   }
   public Player[] getRoster()
   {
      return roster;
   }
   public void setRecord (Record other)
   {
      this.teamRecord = other;
   }
   public int isBetterThan(Rankable other)
   {
      Record r = other.getRecord();
      return teamRecord.isBetterThan(r); 
   }
}