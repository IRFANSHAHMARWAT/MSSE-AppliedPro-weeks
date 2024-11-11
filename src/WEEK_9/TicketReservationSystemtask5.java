package WEEK_9;

public class TicketReservationSystemtask5 {
	    private int[] queue;             // Array to hold passenger IDs
	    private int front, rear, size;    // Front and rear pointers, and current queue size
	    private int maxCapacity;          // Maximum capacity of the circular queue
	    private int totalTicketsSold;     // Total tickets booked
	    private int totalCancellations;   // Total cancellations

	
	    public TicketReservationSystemtask5(int capacity) {
	        maxCapacity = capacity;
	        queue = new int[capacity];
	        front = 0;
	        rear = -1;
	        size = 0;
	        totalTicketsSold = 0;
	        totalCancellations = 0;
	    }

	    
	    public void bookTicket(int passengerId) {
	        if (size == maxCapacity) {
	            System.out.println("No available seats. Booking failed for Passenger " + passengerId);
	            return;
	        }
	        rear = (rear + 1) % maxCapacity;
	        queue[rear] = passengerId;
	        size++;
	        totalTicketsSold++;
	        System.out.println("Passenger " + passengerId + " booked a ticket.");
	    }

	    public void cancelTicket() {
	        if (size == 0) {
	            System.out.println("No passengers to cancel.");
	            return;
	        }
	        int cancelledPassenger = queue[front];
	        front = (front + 1) % maxCapacity;
	        size--;
	        totalCancellations++;
	        System.out.println("Passenger " + cancelledPassenger + " cancelled their ticket.");
	    }


	    public int getAvailableSeats() {
	        return maxCapacity - size;
	    }

	    public int getTotalTicketsSold() {
	        return totalTicketsSold;
	    }


	    public int getTotalCancellations() {
	        return totalCancellations;
	    }

	    public static void main(String[] args) {
	    	TicketReservationSystemtask5 reservationSystem = new TicketReservationSystemtask5(5); // Assuming 5 seats


	        reservationSystem.bookTicket(1); // Passenger 1 books a ticket
	        reservationSystem.bookTicket(2); // Passenger 2 books a ticket
	        reservationSystem.bookTicket(3); // Passenger 3 books a ticket

	        reservationSystem.cancelTicket(); // Passenger 1 cancels their ticket


	        reservationSystem.bookTicket(4); // Passenger 4 books a ticket
	        reservationSystem.bookTicket(5); // Passenger 5 books a ticket

	        System.out.println("Total tickets sold: " + reservationSystem.getTotalTicketsSold());
	        System.out.println("Total cancellations: " + reservationSystem.getTotalCancellations());
	        System.out.println("Available seats: " + reservationSystem.getAvailableSeats());
	    }
	}
