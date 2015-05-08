public class RecordWithTiesAndElo extends RecordWithTies
{
   private double elo;
   public RecordWithTiesAndElo()
   {
      super();
      elo = 0;
   }
   public double getElo()
   {
      return elo;
   }
   public void setElo (double newElo)
   {
      elo = newElo;
   }
   public String toString()
   {
      return (super.toString() + ", " + Math.round(elo) + " Elo Rating");
   }
   public boolean equals(Object other)
   {
      if (other instanceof RecordWithTiesAndElo)
      {
         RecordWithTiesAndElo r = (RecordWithTiesAndElo) other;
         return((super.equals(r)) && (elo==r.elo));
      }
      return false;
   }
   public void updateElo (RecordWithTiesAndElo other, double outcome)
   {
      double change = EloChangeCalculator.getRatingChange(elo, other.elo, outcome);
      other.elo -= change;
      elo += change;
   }
   /** 
    * @param outcome 1 if r1 won; 0 if r1 lost; 0.5 if r2 tied
    */
   public static void updateElo(RecordWithTiesAndElo r1, RecordWithTiesAndElo r2, double outcome)
   {
      double change = EloChangeCalculator.getRatingChange(r1.elo, r2.elo, outcome);
      r2.elo -= change;
      r1.elo += change;
   }
   public int isBetterThan(Record r)
   {
      if (r instanceof RecordWithTiesAndElo)
      {
         RecordWithTiesAndElo rr = (RecordWithTiesAndElo) r;
 
         if (elo > rr.elo)
         {
            return 1;
         }
         else if (elo < rr.elo)
         {
            return -1;
         }
         else // if (elo == rr.elo)
         {
            return 0;
         }
      }
      else // if (!r instanceof RecordWithTiesAndElo)
      {
         return (super.isBetterThan(r));
      }
   } 
}