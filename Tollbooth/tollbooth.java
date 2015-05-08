//tollbooth
public class tollbooth{

	//Create private data here
   public int numCars;
   public double moneyCollected;
   public double toll;

	/** construct a tollbooth object.
	 *  at this point there have been 0 cars and 0 dollars
	 *  have been collected.
	 **/
	public tollbooth() {
   numCars = 0;
   moneyCollected = 0;
   toll = 2.00;
	}

	/** Accesses the number of cars that have
	 *  passed through our tollbooth
	 *  @return the number of cars that have come
	 *  through the tollbooth
	 **/
	public int numCars(){
   return numCars;
	}

	/**Accesses the amount of money collected by the tollbooth
	 * @return the amount of money collected
	 **/
	public double moneyCollected(){
   moneyCollected = (numCars *= toll);
   return moneyCollected;
	}

	/** A car passes through the tollbooth and state variables are
	 *  updated accordingly.
	 **/
	public void addCar(){
   numCars ++;
	}
}


