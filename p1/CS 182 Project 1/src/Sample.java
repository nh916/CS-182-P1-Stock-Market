import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Sample {

    public ArrayList<Double> data;
    private double mean;
    private double median;
    private double stdev;
    private double max;
    private double min;
    private String name;


    //    Constructor in case model is called which does not need to pass anything into the constructor
    public Sample() {

    }

    //  Constructor for sample in case there is no file being passed in
    public Sample(String name) {
        this.name = name;
        data = new ArrayList<Double>();
    }


    // One method to calculate and set the min, max, mean, standard deviation, median, and then send the results to toString
    public String computeStats() {

        Collections.sort(data);
        this.min = Collections.min(data);
        this.max = Collections.max(data);

        // Calculates mean
        double sum = 0;

        for (int i = 0; i < data.size(); i++) {
            sum = sum + data.get(i);
        }
        mean = sum / data.size();
        // Calculates mean END


        // calculates Standard Deviation
        double sumSquares = 0;
        for (int i = 0; i < data.size(); i++) {
            sumSquares = sumSquares + Math.pow(data.get(i) - this.mean, 2);
        }
        stdev = Math.sqrt(sumSquares / data.size());
        // calculates Standard Deviation END


        // Calculates Median
        if (data.size() % 2 == 0) {

            // Finds the two index in the middle. The first index and the previous one
            int rightIndex = data.size() / 2;
            int leftIndex = ((data.size() / 2) - 1);

            // adds together the two numbers and divides them by 2 to get the even median
            median = (data.get(rightIndex) + data.get(leftIndex)) / 2;
        } else {
            // if the amounts of value in the ArrayList is odd, it finds the index of the middle value and sets the value as the median
            int indexMiddle = data.size() / 2;

            median = data.get(indexMiddle);
        }

        //      Calls toString to print out the statistics in a meaningful way
        return toString();
    }


    public String toString() {
        return String.format("Name: %s  size = %d, mean = %.2f, median = %.2f stdDev = %.2f",
                name, data.size(), mean, median, stdev);

    }

    //    this method reads the file. Discards the dates and puts the stock market values in the ArrayList
    public double readFile() {
        BufferedReader br = null;

//      the file is assigned relative path
        File file = new File("SP500-Weekly.txt");
        Scanner CurrentLine = null;
        String nextLine = null;

//        try catch exception in case the file could not be found
        try {
            CurrentLine = new Scanner(file);
        }
//        In case the file is not found, the exception will be caught and will alert the user that the file is missing.
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File was not found. Please make sure the file is not missing and is in the correct directory");
        }

        try {
            while ((CurrentLine.hasNextLine())) {
                nextLine = CurrentLine.nextLine();

//          splits the line on any white space and separates the date and numbers into two numbers
                String[] Stored = nextLine.split("\\s+");

//          then the second of the two numbers, which is the stock market value, will be parsed from a string into a double and placed into the ArrayList
                data.add(Double.parseDouble(Stored[1]));
            }

//          In case there is a null pointer exception this will catch it and alert the user know.
        } finally {
            if (CurrentLine != null) {
                CurrentLine.close();
            }
        }


        //  Generates a new number that model instance of sample could use
        public double randomModelNumber () {
            Random random = new Random();
            double value = data.get(random.nextInt(data.size()));
            return value;
        }

    }
}