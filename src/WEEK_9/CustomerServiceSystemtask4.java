package WEEK_9;

public class CustomerServiceSystemtask4 {


	    private static final int MAX_SIZE = 10; // Maximum size of the queue
	    private Customer[] queue;               // Array to hold customers
	    private int front;                      // Index of the front customer in the queue
	    private int rear;                       // Index of the rear customer in the queue
	    private int size;                       // Current size of the queue

	    // Constructor to initialize the queue
	    public CustomerServiceSystemtask4() {
	        queue = new Customer[MAX_SIZE];
	        front = 0;
	        rear = -1;
	        size = 0;
	    }

	    // Nested Customer class to represent each customer
	    class Customer {
	        String name;
	        int waitTime; // Wait time for each customer

	        Customer(String name, int waitTime) {
	            this.name = name;
	            this.waitTime = waitTime;
	        }
	    }

	    // Method to add a customer to the queue
	    public void enqueue(String name, int waitTime) {
	        if (size == MAX_SIZE) {
	            System.out.println("Queue is full. Cannot add customer " + name);
	            return;
	        }
	        rear = (rear + 1) % MAX_SIZE;
	        queue[rear] = new Customer(name, waitTime);
	        size++;
	        System.out.println("Customer " + name + " added to the queue with a wait time of " + waitTime + " minutes.");
	    }

	    // Method to remove a customer from the queue
	    public void dequeue() {
	        if (size == 0) {
	            System.out.println("Queue is empty. No customer to serve.");
	            return;
	        }
	        System.out.println("Customer " + queue[front].name + " is being served and removed from the queue.");
	        front = (front + 1) % MAX_SIZE;
	        size--;
	    }

	    // Method to calculate the average wait time of the queue
	    public double calculateAverageWaitTime() {
	        if (size == 0) return 0;
	        
	        int totalWaitTime = 0;
	        for (int i = 0; i < size; i++) {
	            totalWaitTime += queue[(front + i) % MAX_SIZE].waitTime;
	        }
	        return (double) totalWaitTime / size;
	    }

	    // Method to display the position of each customer in the queue
	    public void displayQueuePositions() {
	        if (size == 0) {
	            System.out.println("Queue is empty.");
	            return;
	        }
	        System.out.println("Customer positions in the queue:");
	        for (int i = 0; i < size; i++) {
	            int position = i + 1;
	            System.out.println("Position " + position + ": " + queue[(front + i) % MAX_SIZE].name);
	        }
	    }

	    // Method to find the customer who has been waiting the longest
	    public String findLongestWaitingCustomer() {
	        if (size == 0) return "No customers in the queue.";
	        
	        int longestWaitTime = queue[front].waitTime;
	        String longestWaitingCustomer = queue[front].name;
	        
	        for (int i = 1; i < size; i++) {
	            int currentIndex = (front + i) % MAX_SIZE;
	            if (queue[currentIndex].waitTime > longestWaitTime) {
	                longestWaitTime = queue[currentIndex].waitTime;
	                longestWaitingCustomer = queue[currentIndex].name;
	            }
	        }
	        return longestWaitingCustomer;
	    }

	    public static void main(String[] args) {
	        CustomerServiceSystemtask4 queue = new CustomerServiceSystemtask4();

	        // Add customers to the queue
	        queue.enqueue("Alice", 5);
	        queue.enqueue("Bob", 10);
	        queue.enqueue("Charlie", 3);
	        queue.enqueue("Diana", 8);

	        // Display queue positions
	        queue.displayQueuePositions();

	        // Calculate average wait time
	        System.out.printf("Average wait time: %.2f minutes%n", queue.calculateAverageWaitTime());

	        // Find the longest waiting customer
	        System.out.println("Longest waiting customer: " + queue.findLongestWaitingCustomer());

	        // Serve a customer (dequeue)
	        queue.dequeue();

	        // Display queue positions again
	        queue.displayQueuePositions();

	        // Calculate average wait time again
	        System.out.printf("Average wait time after serving one customer: %.2f minutes%n", queue.calculateAverageWaitTime());
	    }
	}
