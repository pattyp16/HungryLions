public class TeamPlayer extends Player
{
   private String position;
   public TeamPlayer (String name, boolean status, String position)
   {
      super(name,status);
      setPosition(position);
   }
   public TeamPlayer (String name, String position)
   {
      this (name, false, position);
   }
   public TeamPlayer()
   {
      
   }
   public String getPosition()
   {
      return position;
   }
   public void setPosition (String newPosition)
   {
      position = newPosition;
   }
   public boolean equals(Object other)
   {
      if (super.equals(other) && other instanceof TeamPlayer)
      {
         TeamPlayer t = (TeamPlayer) other;
         return (position.equals(t.position));
      }
      return false;
   }
   public String toString()
   {
      return (super.toString()+ ", Position: " + position);
   }
}