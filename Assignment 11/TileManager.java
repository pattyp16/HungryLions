//Patty Popp
//Tile Manager
//
//Version 1.0
//March 17th, 2015


/** This class utilizes "Tile" objects in order to manipulate the display of tiles visible to the user in the drawing panel. By
 * pressing different keys on their keyboard and using different mouse clicks, the user can change the number of tiles, the 
 * position, and the layering of tiles that contain the same point(x, y). This class has been javadoc'd for convenience.
 */
import java.util.*;
import java.awt.*;
public class TileManager
{

/** listOfTiles - an array list containing a collection of tile objects that are manipulated within this program
 */
   private ArrayList<Tile> listOfTiles;

/** r - a random object that is used in the shuffle method
 */
   private static Random r = new Random();
   
/** This method constructs an object of type "TileManager". Within the constructor, listOfTiles is initialized to be a new 
 * array list composed of tile objects.
 */
   public TileManager()
   {
      this.listOfTiles = new ArrayList<Tile>();
   }

/** This method adds the given tile that is passed in as a parameter to the end of this program's list of tiles.
 * @param rect a new tile object that will be added to the Drawing Panel
 */
   public void addTile(Tile rect)
   {
      listOfTiles.add(rect);
   }

/** This method takes in a graphics object as a parameter and draws each element in "listOfTiles" by parsing through each tile
 * in the array list and calling the draw method in "Tile".
 * @param g a graphics object that is used to draw tiles in the Drawing Panel
 */
   public void drawAll(Graphics g)
   {
      for (int ii = 0; ii<listOfTiles.size(); ii++)
      {
         Tile currentTile = listOfTiles.get(ii);
         currentTile.draw(g);
      }
   }

/** This method takes in x and y coordinates of the point that the user clicked as parameters, and acquires the first instance
 * of a tile that contains the point (using "getTile") in order to "raise" the tile to the end of the list. If the tile is not 
 * null, the tile is first removed in order to take it out of the array list and then the tile is added to the end of the array
 * list, so that it is "raised" up to the top.
 * @param x the x coordinate of the point that the user clicked
 * @param y the y coordinate of the point that the user clicked
 */
   public void raise (int x, int y)
   {
      Tile currentTile = getTile(x, y);
      if (currentTile != null)
      {
         listOfTiles.remove(currentTile); //remove tile from current location in array list
         listOfTiles.add(currentTile); //add tile to the end of the array list
      }
   }

/** This method takes in x and y coordinates of the point that the user clicked as parameters, and acquires the first instance
 * of a tile that contains the point (using "getTile") in order to "lower" the tile to the start of the list. If the tile is 
 * not null, the tile is first removed from its current location in the list and then inserted at the beginning of the array list 
 * (when the index = 0).
 * @param x the x coordinate of the point that the user clicked
 * @param y the y coordinate of the point that the user clicked
 */
   public void lower (int x, int y)
   {
      Tile currentTile = getTile(x, y);
      if (currentTile != null)
      {
         listOfTiles.remove(currentTile); //remove tile from current location in the array list
         listOfTiles.add(0, currentTile); //insert the tile to the very beginning of the list (at the starting index)
      }
   }

/** This method takes in x and y coordinates of the point that the user clicked as parameters, and acquires the first instance
 * of a tile that contains the point (using "getTile"), in order to delete it from the array list. If the tile is not null, the
 * tile gets removed from the array list, and all of the other tiles in the list automatically get shifted to compensate for 
 * the removal. 
 * @param x the x coordinate of the point that the user clicked
 * @param y the y coordinate of the point that the user clicked
 */
   public void delete (int x, int y)
   {
      Tile currentTile = getTile(x, y);
      if (currentTile != null)
      {
         listOfTiles.remove(currentTile); //remove tile from current location in ArrayList, followed by an automatic shift
      }
   }

/** This method takes in x and y coordinates of the point that the user clicked as parameters, and acquires all instances of
 * tiles that contain the given points via a for loop in order to delete all of the tiles that correspond to that specific
 * point. The method then removes all of the tiles that contain that point using ".remove".
 * @param x the x coordinate of the point that the user clicked
 * @param y the y coordinate of the point that the user clicked
 */
   public void deleteAll (int x, int y)
   {
      for (int ii = (listOfTiles.size()-1); ii >= 0; ii--)
      {
         Tile currentTile = listOfTiles.get(ii);
         if (containsPoint (x, y, currentTile))
         {
            listOfTiles.remove(currentTile); //remove all tiles that contain the given point
         }
      }
   }

/** This method takes in two parameters: the width and the height of the Drawing Panel and shuffles the array list and tiles on
 * the Drawing Panel. The first part of the method shuffles the array list using the .shuffle method and the second part parses
 * through the array list and stores the current tile in a variable. The method then stores the width and height of the tile 
 * into two separate variables and creates two other random integers for the new x and y coordinates that are between 0 and 
 * (the height/width of the Drawing Panel - the height/width of the actual tile). Then the method sets the x and y coordinates
 * for each tile to the newly created coordinates.
 * @param width the width of the Drawing Panel
 * @param height the height of the Drawing Panel
 */
   public void shuffle (int width, int height)
   {
      Collections.shuffle(listOfTiles);
      for (int ii = 0; ii<(listOfTiles.size()-1); ii++)
      {
         Tile currentTile = listOfTiles.get(ii);
         int widthOfTile = currentTile.getWidth();
         int heightOfTile = currentTile.getHeight();
         int randomX = r.nextInt((width + 1) - widthOfTile); //random integer between 0 and width - widthOfTile
         int randomY = r.nextInt((height + 1) - heightOfTile); //random integer between 0 and height - heightOfTile
         currentTile.setX(randomX); //set new x coordinate
         currentTile.setY(randomY); //set new y coordinate
      }
   }

/** This private method takes in three parameters: the x coordinate, the y coordinate, and the current tile that the method is 
 * analyzing and checks to see if the tile contains the points specified. The method stores the currentTile's x, y, width, and 
 * height, and then tests to see if the point fits within the range of xOfTile (or yOfTile) and xOfTile (or yOfTile) + 
 * widthOfTile (or heightOfTile). If yes, return true, if not, return false.
 * @param xCoordinate the x coordinate of the point that the user clicked
 * @param yCoordinate the y coordinate of the point that the user clicked
 * @param currentTile the current tile that the user is checking
 * @return whether or not the current tile contains the point that is passed in
 */ 
   private boolean containsPoint (int xCoordinate, int yCoordinate, Tile currentTile)
   {
      int xOfTile = currentTile.getX();
      int yOfTile = currentTile.getY();
      int widthOfTile = currentTile.getWidth();
      int heightOfTile = currentTile.getHeight();
      if ((xCoordinate >= xOfTile) && (xCoordinate < (xOfTile + widthOfTile))) //if x coordinate is within range
      {
         if ((yCoordinate >= yOfTile) && (yCoordinate < (yOfTile + heightOfTile))) //if y coordinate is within range
         {
            return true; // if current tile contains the specified point
         }
      }
      return false; // if current tile does not contain the specified point
   }

/** The method takes in two parameters: the x and y coordinates of the point the program is looking at and if the tile contains
 * the point, the method will return a Tile object. The method parses through the array list and stores the current tile object.
 * If the tile contains the specified  point then the method will return a tile, else, the method returns null.
 * @param x the x coordinate that the program is looking at
 * @param y the y coordinate that the program is looking at
 * @return the tile that contains the specified point
 */
   private Tile getTile (int x, int y)
   {
      for (int ii = (listOfTiles.size()-1); ii >= 0; ii--)
      {
         Tile currentTile = listOfTiles.get(ii);
         if (containsPoint (x, y, currentTile))
         {
            return currentTile;
         }
      }
      return null; //if the tile does not contain the specified point, return null
   }
}