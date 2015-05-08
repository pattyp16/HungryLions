public class IndividualPlayer extends Player implements Rankable
{
   private Record playerRecord;
   public IndividualPlayer(String name, boolean status, Record winsLosses)
   {
      super(name, status);
      this.playerRecord = winsLosses;
   }
   public IndividualPlayer(String name, Record winsLosses)
   {
      this (name, false, winsLosses);
   }
   public IndividualPlayer()
   {
      this("", false, new Record());
   }
   public String toString()
   {
      return("Name: " + playerName + ", Availability: " + playerStatus + ", Record: " + playerRecord.toString());
   }
   public int getWins()
   {
      return playerRecord.wins;
   }
   public int getLosses()
   {
      return playerRecord.losses;
   }
   public double getPercent()
   {
      return ((double)playerRecord.wins/(playerRecord.wins+playerRecord.losses)*100);
   }
   public void setWins(int newWin)
   {
      playerRecord.wins=newWin;
   }
   public void setLosses(int newLoss)
   {
      playerRecord.losses = newLoss;
   }
   public void won()
   {
      playerRecord.wins++;
   }
   public void lost()
   {
      playerRecord.losses++;
   }
   public boolean equals (Object other)
   {
      if (other instanceof IndividualPlayer)
      {
         IndividualPlayer ip = (IndividualPlayer) other;
         return ((playerName.equals(ip.playerName)) && (playerStatus==ip.playerStatus) && (playerRecord == ip.playerRecord));
      }
      return false;
   }
   public int isBetterThan(Rankable other)
   {
      Record r = other.getRecord();
      return playerRecord.isBetterThan(r);
   }
   public Record getRecord()
   {
      return playerRecord;
   }
}