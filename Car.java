// class for Car
public class Car {
	// declares the car's properties
	String brand; 
	String color; 
	String plateNumber;
	
	// constructor for the Car class which initiates the car's properties
	public Car(String brand, String color, String plateNumber) {
		this.brand = brand;
		this.color = color;
		this.plateNumber = plateNumber;
	}

	// get the car's brand 
	public String getBrand() {
		return brand;
	}

	//sets the call brand
	public void setBrand(String brand) {
		this.brand = brand;
	}

	// gets the car's color
	public String getColor() {
		return color;
	}

	// sets the car's color
	public void setColor(String color) {
		this.color = color;
	}
	
	// gets the car's plate number
	public String getPlateNumber() {
		return plateNumber;
	}
	
	//sets the car's plate number
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	

}
