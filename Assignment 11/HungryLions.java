public class HungryLions
{
   public static void main (String[] args)
   {
      extractPDFData();
   }
   public static void extractPDFData()
   {
      Document luceneDocument = LucenePDFDocument.getDocument("May2015");
   }
}