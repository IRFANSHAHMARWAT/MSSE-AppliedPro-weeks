package WEEK_9;

public class BinarySearch_task2 {
    public static int binarySearch(int[] serialNumbers, int targetSerial) {
        int left = 0;
        int right = serialNumbers.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (serialNumbers[mid] == targetSerial) {
                return mid; 
            }
            
            if (serialNumbers[mid] < targetSerial) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static int countAboveThreshold(int[] serialNumbers, int threshold) {
        int count = 0;
        for (int serial : serialNumbers) {
            if (serial > threshold) {
                count++;
            }
        }
        return count;
    }

    public static int findMedian(int[] serialNumbers) {
        int n = serialNumbers.length;
        if (n % 2 != 0) {
            return serialNumbers[n / 2]; 
        } else {
            return (serialNumbers[(n - 1) / 2] + serialNumbers[n / 2]) / 2;
        }
    }
    public static int calculateDifference(int[] serialNumbers) {
        int maxSerial = serialNumbers[serialNumbers.length - 1];
        int minSerial = serialNumbers[0];
        return maxSerial - minSerial;
    }

    public static void main(String[] args) {
        int[] serialNumbers = {102, 1500, 2543, 2789, 3000, 3200, 4000};
        int targetSerial = 3000;
        int threshold = 3000;


        int index = binarySearch(serialNumbers, targetSerial);
        if (index != -1) {
            System.out.println("Book serial number found at index " + index + ".");
        } else {
            System.out.println("Book serial number not found.");
        }

        int countAboveThreshold = countAboveThreshold(serialNumbers, threshold);
        int medianSerial = findMedian(serialNumbers);
        int difference = calculateDifference(serialNumbers);

        System.out.println("Books with serial numbers above " + threshold + ": " + countAboveThreshold + ".");
        System.out.println("Median serial number: " + medianSerial + ".");
        System.out.println("Difference between highest and lowest serial number: " + difference + ".");
    }
}
