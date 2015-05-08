public class Player implements Comparable<Player>
{
   protected String playerName;
   protected boolean playerStatus;
   public Player (String playerName, boolean playerStatus)
   {
      this.playerName = playerName;
      this.playerStatus = playerStatus;
   }
   public Player (String name)
   {
      playerName = name;
      playerStatus = false;
   }
   public Player()
   {
      this("", false);
   }
   public String getName ()
   {
      return playerName;
   }
   public void setName (String newName)
   {
      playerName = newName;
   }
   public boolean getStatus ()
   {
      return playerStatus;
   }
   public void setStatus (boolean newStatus)
   {
      playerStatus = newStatus;
   }
   public boolean equals (Object other)
   {
      if (other instanceof Player)
      {
         Player p = (Player) other;
         return ((playerName.equals(p.playerName)) && (playerStatus==p.playerStatus));
      }
      return false;
   } 
   public String toString()
   {
      return ("Name: " + playerName + ", Availability: " + playerStatus);
   }
   public int compareTo(Player other)
   {
      return(playerName).compareTo(other.getName());
   }
}