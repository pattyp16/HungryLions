import java.awt.*;
public class Planet
{
   private String name;
   private int quadrant;
   private double miles;
   private Color color;
   
   public String getName()
   {
      return name;
   }
   public void setName (String newName)
   {
      name = newName;
   }
   public Color getColor()
   {
      return color;
   }
   public void setColor (Color newColor)
   {
      color = newColor;
   }
   public Planet (String name, int quadrant, double miles, Color color)
   {
      this.name = name;
      this.quadrant = quadrant;
      this.miles = miles;
      this.color = color;
   }
   public Planet()
   {
      this ("Earth", 0, 0, Color.BLUE);
   }
   public String toString()
   {
      return "Planet " + name + " is in quadrant " + quadrant + " and " + miles + " billion miles from the earth, and it appears " + color;
   }
   public boolean equals (Object other)
   {
      if (other instanceof Planet)
      {
         Planet p = (Planet) other;
         return (name.equals(p.name)) && (quadrant == p.quadrant) && (Math.abs(miles-p.miles)<0.01) && (color.equals(p.color)); 
      }
      return false;
   }
}