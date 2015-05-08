public class SpiralBug extends BoxBug
{
   public SpiralBug (int length)
   {
      super(length);
      steps = 0;
   }
   public void act()
   {
      if (steps < sideLength && canMove())
      {
         move();
         steps++;
      }
      else
      {
         turn();
         turn();
         steps = 0;
         sideLength++;
      }
   }
}