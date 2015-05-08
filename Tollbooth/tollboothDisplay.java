// tollboothDisplay.java
import objectdraw.WindowController;
import objectdraw.Text;
import objectdraw.Location;

import java.awt.Color;

public class tollboothDisplay extends WindowController{

	tollbooth myBooth;
	Text carCount;
	Text money;

	public void begin(){
		myBooth = new tollbooth();
		carCount = new Text("Number of Cars " + myBooth.numCars(), 100, 100, canvas);
		money = new Text("Money Collected " + myBooth.moneyCollected(), 100, 200, canvas);

	}

	public void onMouseClick(Location point){
		myBooth.addCar();
		carCount.setText("Number of Cars " + myBooth.numCars());
		money.setText("Money Collected " + myBooth.moneyCollected());
	}
}


