import java.util.*;
public abstract class Team implements Rankable
{
   private List<Player> roster;
   private int MAX_ROSTER_SIZE;
   private int MIN_PLAYING_NUM;
   private Record teamRecord;
      
   public Team (int max, int min)
   {
      if (max <= 0 || min <= 0)
      {
         throw new IllegalArgumentException();
      }
      MAX_ROSTER_SIZE = max;
      MIN_PLAYING_NUM = min;
      this.roster = new LinkedList<Player>();
   }
   public String toString()
   {
      String finalStr = "";
      for (int ii = 0; ii<roster.size(); ii++)
      {
            Player p = roster.get(ii);
            finalStr += (p + "\n");
      }
      return finalStr;
   }
   public void addPlayer (Player p)
   {
      if (roster.size()>=MAX_ROSTER_SIZE)
      {
         throw new IllegalArgumentException();
      }
      else //if (roster.size() < MAX_ROSTER_SIZE)
      {
         roster.add(p);
      }
   }
   public boolean removePlayer(String name)
   {
      if (roster.size() < MIN_PLAYING_NUM)
      {
         throw new IllegalArgumentException();
      }
      else //if(roster.size() >= MIN_PLAYING_NUM)
      {
         roster.remove(name);
         return true;
      }
   }
   public Player findPlayer(String name)
   {
      for (int ii = 0; ii<roster.size(); ii++)
      {
         if ((roster.get(ii)).getName().equals(name))
         {
            return roster.get(ii);
         }
      }
      return null;
   }
   public int getRosterSize()
   {
      return roster.size();
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
      int numAvailablePlayer = 0;
      for (int ii = 0; ii<(roster.size()-1); ii++)
      {
         if ((roster.get(ii)).getStatus()==true)
         {
            numAvailablePlayer++;
         }
      }
      if (numAvailablePlayer >= MIN_PLAYING_NUM)
      {
         return true;
      }
      else //if (numAvailablePlayer < MIN_PLAYING_NUM)
      {
         return false;
      }
   }
   public abstract boolean shouldFieldATeam();
   public Record getRecord()
   {
      return teamRecord;
   }
   public List<Player> getRoster()
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
   public void sort()
   {
      Collections.sort(roster);
   }
}