package WEEK_9;

public class LinearSearch_task1 {

    
    public static int searchEmployeeID(int[] employeeIDs, int targetID) {
        for (int i = 0; i < employeeIDs.length; i++) {
            if (employeeIDs[i] == targetID) {
                return i;
            }
        }
        return -1;
    }


    public static int countAboveThreshold(int[] employeeIDs, int threshold) {
        int count = 0;
        for (int id : employeeIDs) {
            if (id > threshold) {
                count++;
            }
        }
        return count;
    }

 
    public static int findSmallestID(int[] employeeIDs) {
        int minID = employeeIDs[0];
        for (int id : employeeIDs) {
            if (id < minID) {
                minID = id;
            }
        }
        return minID;
    }

    public static int findLargestID(int[] employeeIDs) {
        int maxID = employeeIDs[0];
        for (int id : employeeIDs) {
            if (id > maxID) {
                maxID = id;
            }
        }
        return maxID;
    }


    public static double calculateAverageID(int[] employeeIDs) {
        int sum = 0;
        for (int id : employeeIDs) {
            sum += id;
        }
        return (double) sum / employeeIDs.length;
    }

    public static void main (String[] args) {
    	//To achieve the same output, use following array, target and threshold values in  drivers code:
    	 int[] employeeIDs = {102, 1500, 2023, 4098, 2500, 1700, 3200}; // Sample employee ID array
    	 int targetID = 2023; // Example target employee ID
    	 int threshold = 2000; // Threshold for counting IDs]
       
    
        int index = searchEmployeeID(employeeIDs, targetID);
        if (index != -1) {
            System.out.println("Employee ID found at index " + index + ".");
        } else {
            System.out.println("Employee ID not found.");
        }

        int countAboveThreshold = countAboveThreshold(employeeIDs, threshold);
        int smallestID = findSmallestID(employeeIDs);
        int largestID = findLargestID(employeeIDs);
        double averageID = calculateAverageID(employeeIDs);

        System.out.println("Total number of employees above threshold ID " + threshold + ": " + countAboveThreshold + ".");
        System.out.println("Smallest Employee ID: " + smallestID + ".");
        System.out.println("Largest Employee ID: " + largestID + ".");
        System.out.printf("Average Employee ID: %.0f.%n", averageID);
    }
}
