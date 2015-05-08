public class Record implements Rankable
{
   protected int wins;
   protected int losses;
   public Record()
   {
      wins=0;
      losses=0;
   }
   public Record(int initialWins, int initialLosses)
   {
      this.wins = initialWins;
      this.losses = initialLosses;
   }
   public int getWins()
   {
      return wins;
   }
   public int getLosses()
   {
      return losses;
   }
   public Record getRecord()
   {
      return this;
   }
   public void setWins(int newWins)
   {
      wins = newWins;
   }
   public void setLosses(int newLosses)
   {
      losses = newLosses;
   }
   public void won()
   {
      wins++;
   }
   public void lost()
   {
      losses++;
   }
   public double getPercent()
   {
      return (((double)wins/(wins+losses))*100);
   }
   public String toString()
   {
      return (wins + " wins, " + losses + " losses");
   }
   public boolean equals(Object other)
   {
      if (other instanceof Record)
      {
         Record r = (Record) other;
         return ((wins==r.wins) && (losses==r.losses));
      }
      return false;
   }
   public int isBetterThan(Rankable other)
   {
      if (other instanceof Record)
      {
         Record r = (Record) other;
         if (this.getPercent() > r.getPercent())
         {
            return 1;
         }
         else if (this.getPercent() < r.getPercent())
         {
            return -1;
         }
         else //if (this.getPercent() == r.getPercent())
         {
            return 0;
         }
      }
      else //if (!other instanceof Record)
      {
         throw new IllegalArgumentException();
      } 
   }
}