//class for traffic operation
// This class is the implementation of the traffic simulation and the traffic lights operation
public class TrafficOperations{	
	// main method to execute the program
	public static void main(String[] args) throws InterruptedException {
		// creates an instance of the CarQueue class
		CarQueue carsQueue = new CarQueue();
		//creates an instance of the TrafficSimulation class
		TrafficSimulation traffic = new TrafficSimulation(carsQueue);
		// creates a thread for the traffic object of the TrafficSimulation class
		Thread trafficThread = new Thread(traffic);
		// starts the thread hence calls the run method
		trafficThread.start();
		// lets the other thread run at the same time as the traffic thread after 1 second to allow some 
		//cars into the queue
		trafficThread.join(1000); 
		
		// loop to keep switching between lights until the car queue is empty
		while (!carsQueue.isEmpty()) {
			// creates green light instance object of the TrafficLight class.
			TrafficLight greenLight = new TrafficLight("green", carsQueue, 30000, 1000);
			// creates red light instance object of the TrafficLight class.
			TrafficLight redLight = new TrafficLight("red", carsQueue, 20000, 1000);
			// creates yellow light instance object of the TrafficLight class.
			TrafficLight yellowLight = new TrafficLight("yellow", carsQueue, 10000, 2000);
			
			// creates a thread for the redLight object of the TrafficLight class.
			Thread redLightOn = new Thread(redLight);
			// creates a thread for the yellowLight object of the TrafficLight class.
			Thread yellowLightOn = new Thread(yellowLight);
			// creates a thread for the greenLight object of TrafficLight class.
			Thread greenLightOn = new Thread(greenLight);
			
			System.out.println("\n-----------------------------------------");
			System.out.println("🚦RED LIGHT_____🟥🟥🟥🟥🟥🟥🟥_");
			System.out.println("🚦RED LIGHT___+_🟥🟥🟥🟥🟥🟥🟥_");
			System.out.println("-----------------------------------------\n");
			// starts the thread redLightOn hence calls the run method of the TrafficLight class
			redLightOn.start();
			// lets the yellowLightOn thread run after the redLightOn thread finished running
			redLightOn.join();
			
			System.out.println("\n-----------------------------------------");
			System.out.println("🚦YELLOW LIGHT__🟨🟨🟨🟨🟨🟨🟨__");
			System.out.println("🚦YELLOW LIGHT__🟨🟨🟨🟨🟨🟨🟨__");
			System.out.println("-----------------------------------------\n");
			// starts the yellowLightOn thread hence calls the run method of the TrafficLight class
			yellowLightOn.start();
			// lets the greenLightOn thread run after the yellowLightOn thread finished running
			yellowLightOn.join();
			
			System.out.println("\n-----------------------------------------");
			System.out.println("🚦GREEN LIGHT___🟩🟩🟩🟩🟩🟩🟩__");
			System.out.println("🚦GREEN LIGHT___🟩🟩🟩🟩🟩🟩🟩__");
			System.out.println("-----------------------------------------");
			// starts the greenLightOn thread hence calls the run method of the TrafficLight class
			greenLightOn.start();
			// lets the redLightOn thread run after the greenLightOn thread finished running
			greenLightOn.join();
		}
		
		// Displays the message when the all the cars passed i.e the queue is empty
		System.out.println("\nThere no  CAR left in the Queue");

	}

}
