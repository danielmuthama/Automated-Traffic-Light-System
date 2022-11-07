// class for the TrafficLight which implements Runnable class
// Runnable will help with creating threads in the program so that some codes can run at the same time
public class TrafficLight implements Runnable {
	//declares the Traffic light properties
	String color;
	int duration;
	int carPassDuration;
	CarQueue carsQueue;
	
	// constructor for Traffic light which initiates the traffic light properties
	public TrafficLight(String color, CarQueue carsQueue, int duration, int carPassDuration){
		this.color = color;
		this.duration = duration;
		this.carPassDuration = carPassDuration;
		this.carsQueue = carsQueue;
	}
	
	// run method that overrides the run method of the Runnable class
	// this method will the executes as the thread is started
	@Override
	public void run() {
		// variable to record the starting time of the run method
		long startTime = System.currentTimeMillis();
		// variable that will used for the count down of lights duration
		int countdown = duration/1000;
		
		// creates a loop to keep removing cars in the duration period as the light is on 
		while ((System.currentTimeMillis() - startTime < duration) && !carsQueue.isEmpty()) {
			// displays the count down for the light
			System.out.println(color.toUpperCase() + " Light Countdown: " + (--countdown));
			
			// checks if the car queue is not empty and the color of the light is green
			if (!carsQueue.isEmpty() && color.equals("green")) {
				//removes a car from the car queue
				carsQueue.removeCar();
				//displays the number of cars in the queue
				System.out.println("Number of cars in Queue: " + carsQueue.size());
				try {
					// sleeps the thread to implement the delay between the removal of cars
					Thread.sleep(carPassDuration);
					// catches errors i.e. InterruptedException
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			
			// when the light color is red 
			else if (color.equals("red")) {
				//displays the number of cars in the queue
				System.out.println("Number of cars in Queue: " + carsQueue.size());
				
				try {
					// sleeps the thread to implement a delay
					Thread.sleep(carPassDuration);
					
				// catches errors i.e. InterruptedException
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// when the light color is yellow and the queue is not empty
			else if (!carsQueue.isEmpty() && color.equals("yellow")) {
				// removes car after a delay
				if (countdown % 2 == 0){
					//removes a car from the car queue
					carsQueue.removeCar();
				}
				
				//displays the number of cars in the queue
				System.out.println("Number of cars in Queue: " + carsQueue.size());
				
				try {
					// sleeps the thread to implement a delay
					Thread.sleep((carPassDuration/2));
					
				// catches errors i.e. InterruptedException
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}