//indicates the package under which the class is 


//imports ArrayList class from java.util
import java.util.ArrayList;
//imports Random class from java.util
import java.util.Random;

// class for Traffic simulation which implements Runnable class
//Runnable will help with creating threads in the program so that some codes can run at the same time
public class TrafficSimulation implements Runnable {
	// declares properties of traffic
	CarQueue carsQueue;
	
	//constructor for TrafficSimulation class which initiates the properties of traffic
	public TrafficSimulation(CarQueue carsQueue){
		this.carsQueue = carsQueue;
	}
	
	// run method that overrides the run method of the Runnable class
	// this method will the executes as the thread is started
	@Override
	public void run() {
		
		// Array list to store various car brands that will be used to set properties of the cars 
		//being generated
		ArrayList<String> carBrands = new ArrayList<String>();
		carBrands.add("Hyundai");
		carBrands.add("Honda");
		carBrands.add("Toyota");
		carBrands.add("Ford");
		carBrands.add("Toyota");
		
		// Array list to store various car brands that will be used to set properties of the cars 
		//being generated
		ArrayList<String> carColors = new ArrayList<String>();
		carColors.add("White");
		carColors.add("Silver");
		carColors.add("Black");
		carColors.add("Silver");
		carColors.add("Red");
		
		// Array list to store various initial plate letter in the plate number that will be used to 
		//set properties of the cars being generated		
		ArrayList<String> plateLetters = new ArrayList<String>();
		plateLetters.add("RAA");
		plateLetters.add("RAB");
		plateLetters.add("RAC");
		plateLetters.add("RAD");
		plateLetters.add("RAE");
		
		// variable representing the delay between generation of cars
		int carGenerationInterval = 1000;
		
		// creates instance of the Random class
		Random random = new Random();
		
		// loop that will keep generating cars until the max number of cars in the queue (100)
		while (carsQueue.arrivedCars != carsQueue.maxCarsInQueue) {
			// a variable that determine the random number of cars between 1-5 to be generated
			int randomNumberOfCars = random.nextInt(5) + 1;
			System.out.println("\n-----------------------------------------");
			// displays the number of cars generated and added to the queue
			System.out.println("Number of cars arriving: " + randomNumberOfCars + " Cars");
			
			// loop to add the cars to the cars to the queue
			// the loop will run n timed depending on the random number of cars to be added to the queue
			for (int i = 1; i<= randomNumberOfCars; i++) {
				// checks if the max number of cars in the queue hasn't reached 100
				if (carsQueue.arrivedCars != carsQueue.maxCarsInQueue) {
					// picks a random brand from the carBrands array list
					String randomBrand = carBrands.get(random.nextInt(carBrands.size()));
					// picks a random color from the carColors array list
					String randomColor = carColors.get(random.nextInt(carColors.size()));
					// picks a random plate letters from the platedLetters array list
					String randomPlateLetter = plateLetters.get(random.nextInt(plateLetters.size()));
					
					// creates a car object of the Car class and gives it the randomly generated properties
					Car randCar = new Car(randomBrand, randomColor, randomPlateLetter + 
							carsQueue.nextPlatenumber);
					
					// adds the car to the queue
					carsQueue.addCar(randCar);
					// displays the car added to the queue
					System.out.println("   " + randCar.getBrand() + " " + randCar.getColor() + " "
					+ randCar.getPlateNumber());
				}
			}
			try {
				System.out.println("-----------------------------------------\n");
				//sleeps the Thread to implement a delay between the generation of cars
				Thread.sleep(carGenerationInterval);
			// catches errors i.e. InterruptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
		
}
