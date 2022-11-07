//imports ArrayList class from java.util
import java.util.ArrayList;

//class for CarQueue
public class CarQueue {
	// creates array list to stores cars entering the queue
	ArrayList<Car> cars = new ArrayList<Car>();
	
	//variable to be used to give cars plate number
	int nextPlatenumber = 1;
	// counts the number of cars that passed in the queue
	int arrivedCars = 0;
	
	// variable representing the max number of cars that are in the queue
	int maxCarsInQueue = 100;
	
	//method to add car to the queue
	public void addCar(Car car) {
		// appends the car to the car array at the last index
		 cars.add(car);
		 //increments the number of cars that entered the queue
		 arrivedCars ++;
		 // increments next plate number so that the cars won't have same plate number
		 nextPlatenumber ++;
	}
	
	// method to remove car from car queue
	public void removeCar() {
		//removes first car in the array list (the working of a queue)
		cars.remove(0);
	}
	
	// gets the size of the array list at the moment
	public int size() {
		//returns the size of the queue
		return cars.size(); 
	}
	
	// checks if the queue is empty
	public boolean isEmpty() {
		// returns true if the car queue is empty and false if the car queue is not empty
		return cars.size() == 0;
	}
	
	// display all the car in the queue at the moment
	public void show() {
		System.out.println("Cars in queue:");
		//lops through the array list(queue) to display the cars in the queue
		for (int i=0; i<cars.size(); i++) {
			System.out.println(cars.get(i));
		}
	}
}