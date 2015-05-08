public class CircleBug extends BoxBug
{
   public CircleBug (int length)
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
         steps = 0;
      }
   }
}