import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {

    public static void main(String[] args) {
        // Task 1: Declare and initialize the array
        int[] dataPoints = new int[100];
        Random rnd = new Random();

        // Task 2: Fill array with random values between 1 and 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Task 3: Display array values separated by " | "
        for (int val : dataPoints) {
            System.out.print(val + " | ");
        }
        System.out.println();

        // Task 4: Calculate and display sum and average
        int sum = 0;
        for (int val : dataPoints) {
            sum += val;
        }
        double average = (double) sum / dataPoints.length;
        System.out.printf("The sum of the array is: %d\nThe average of the array is: %.2f\n", sum, average);

        // Task 5: Prompt for user input between 1 and 100
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 100: ");
        int userInput = getRangedInt(scanner, 1, 100);

        // Task 6: Count occurrences of user input in array
        int count = 0;
        for (int val : dataPoints) {
            if (val == userInput) {
                count++;
            }
        }
        System.out.printf("The value %d was found %d time(s) in the array.\n", userInput, count);

        // Task 7: Find the first position of the user input in array
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userInput) {
                System.out.printf("The value %d was found at array index %d.\n", userInput, i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.printf("The value %d was not found in the array.\n", userInput);
        }

        // Task 8: Find minimum and maximum values in the array
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int val : dataPoints) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        System.out.printf("The minimum value in the array is: %d\n", min);
        System.out.printf("The maximum value in the array is: %d\n", max);

        // Task 9: Call the getAverage method and display the average
        System.out.printf("Average of dataPoints is: %.2f\n", getAverage(dataPoints));
    }

    // Helper method to get a ranged int (Assuming this is from SafeInput)
    public static int getRangedInt(Scanner scanner, int min, int max) {
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter an integer: ");
                scanner.next();
            }
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.printf("Please enter a number between %d and %d.\n", min, max);
            }
        } while (input < min || input > max);
        return input;
    }

    // Task 9: Static method to calculate average
    public static double getAverage(int[] values) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return (double) sum / values.length;
    }
}

