// Average Temperature using Single Dimension Arrays
// Rob Vatcher
// May 14th, 2024



public class SingleDimensionArray {
    int arr[] = null;

    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int valueToInsert) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToInsert;
                System.out.println("Successfully inserted");
            } else {
                System.out.println("This position is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array" + e);
        }
    }

    public double calculateAverage() {
        int sum = 0;
        int count = 0;
        for (int value : arr) {
            if (value != Integer.MIN_VALUE) {
                sum += value;
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0;
    }

    public int countAboveAverage(double average) {
        int count = 0;
        for (int value : arr) {
            if (value != Integer.MIN_VALUE && value > average) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Create the object of the class
        SingleDimensionArray singleDimensionArray = new SingleDimensionArray(8);

        // Insert temperatures into the array
        int[] temperatures = {23, 25, 20, 22, 24, 26, 19, 21};
        for (int i = 0; i < temperatures.length; i++) {
            singleDimensionArray.insert(i, temperatures[i]);
        }

        // Calculate the average temperature
        double averageTemperature = singleDimensionArray.calculateAverage();
        System.out.println("Average Temperature: " + averageTemperature);

        // Count how many temperatures are above the average
        int countAboveAverage = singleDimensionArray.countAboveAverage(averageTemperature);
        System.out.println("Number of days with above average temperature: " + countAboveAverage);
    }
}


