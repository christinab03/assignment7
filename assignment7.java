import java.io.*;
import java.util.*;

public class assignment7 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in); {
            System.out.println("Choose an option:");
            System.out.println("1. Generate an array of random integers and store it in a file");
            System.out.println("2. Read an existing file containing a list of integers, sort it, and store the sorted array in another file");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int[] randomArray = createRandomArray(10); // You can specify the desired length here
                    writeArrayToFile(randomArray, "random_numbers");
                    System.out.println("Random array has been generated and stored in random_numbers");
                    break;
                case 2:
                    int[] arrayFromFile = readFileToArray("random_numbers");
                    bubbleSort(arrayFromFile);
                    writeArrayToFile(arrayFromFile, "sorted_numbers");
                    System.out.println("File has been read, sorted, and stored in sorted_numbers");
                    break;
                default:
                    System.out.println("Invalid choice.");
                }

                scanner.close(); 
            }
        }

    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101); // Generates random integers between 0 and 100
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename + ".txt"))) {
            for (int num : array) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFileToArray(String filename) {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename + ".txt"))) {
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
