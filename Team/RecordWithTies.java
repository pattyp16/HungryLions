public class RecordWithTies extends Record
{
   private int ties;
   public RecordWithTies()
   {
      ties = 0;
   }
   public int getTies()
   {
      return ties;
   }
   public void setTies(int newTies)
   {
      ties = newTies;
   }
   public void tied()
   {
      ties++;
   }
   public String toString()
   {
      return(super.toString() + ", " + ties + " ties");
   }
   public boolean equals (Object other)
   {
      if (other instanceof RecordWithTies)
      {
         RecordWithTies r = (RecordWithTies)other;
         return (super.equals(r) && (ties == r.ties));
      }
      return false;
   }
   public double getPercent()
   {
      return((double)wins/(wins+losses+ties)*100);
   }
}