package WEEK_9;

public class CarParkingManagementtask6 {

	    private String[] deque;        // Array to hold parked cars
	    private int front, rear, size; // Front and rear pointers, and current size
	    private int maxCapacity;       // Maximum capacity of the deque

	    // Constructor to initialize the deque
	    public CarParkingManagementtask6(int capacity) {
	        maxCapacity = capacity;
	        deque = new String[capacity];
	        front = -1;  // Initialize front and rear to -1 (indicating empty deque)
	        rear = -1;
	        size = 0;
	    }

	    // Method to park a car at the rear
	    public void parkAtRear(String car) {
	        if (size == maxCapacity) {
	            System.out.println("Parking lot is full. Cannot park " + car);
	            return;
	        }
	        if (rear == -1) { // First car being parked
	            front = 0;
	            rear = 0;
	        } else {
	            rear = (rear + 1) % maxCapacity; // Circular increment
	        }
	        deque[rear] = car;
	        size++;
	        System.out.println(car + " parked at rear.");
	    }

	    // Method to park a car at the front
	    public void parkAtFront(String car) {
	        if (size == maxCapacity) {
	            System.out.println("Parking lot is full. Cannot park " + car);
	            return;
	        }
	        if (front == -1) { // First car being parked
	            front = 0;
	            rear = 0;
	        } else {
	            front = (front - 1 + maxCapacity) % maxCapacity; // Circular decrement
	        }
	        deque[front] = car;
	        size++;
	        System.out.println(car + " parked at front.");
	    }

	    // Method to remove a car from the front
	    public void removeFromFront() {
	        if (size == 0) {
	            System.out.println("Parking lot is empty. No car to remove.");
	            return;
	        }
	        System.out.println(deque[front] + " left from front.");
	        front = (front + 1) % maxCapacity;
	        size--;
	    }

	    // Method to remove a car from the rear
	    public void removeFromRear() {
	        if (size == 0) {
	            System.out.println("Parking lot is empty. No car to remove.");
	            return;
	        }
	        System.out.println(deque[rear] + " left from rear.");
	        rear = (rear - 1 + maxCapacity) % maxCapacity;
	        size--;
	    }

	    // Method to get the total number of cars parked
	    public int getTotalCars() {
	        return size;
	    }

	    // Method to check if the parking lot is full
	    public boolean isFull() {
	        return size == maxCapacity;
	    }

	    // Method to check if the parking lot is empty
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    // Method to get the car at the front
	    public String getFrontCar() {
	        return size > 0 ? deque[front] : "No cars parked.";
	    }

	    // Method to get the car at the rear
	    public String getRearCar() {
	        return size > 0 ? deque[rear] : "No cars parked.";
	    }

	    public static void main(String[] args) {
	    	CarParkingManagementtask6 parkingLot = new CarParkingManagementtask6(5); // Assuming a capacity of 5 cars

	        // Simulate parking cars
	        parkingLot.parkAtRear("Car A"); // Park at rear
	        parkingLot.parkAtFront("Car B"); // Park at front

	        // Display parking lot status
	        System.out.println("Total cars parked: " + parkingLot.getTotalCars());
	        System.out.println("Front car: " + parkingLot.getFrontCar());
	        System.out.println("Rear car: " + parkingLot.getRearCar());
	        System.out.println("Parking lot full: " + (parkingLot.isFull() ? "Yes" : "No"));

	        // Simulate car removals
	        parkingLot.removeFromFront(); // Remove from front
	        parkingLot.removeFromRear(); // Remove from rear

	        // Final parking lot status
	        System.out.println("Total cars parked after removals: " + parkingLot.getTotalCars());
	    }
	}
