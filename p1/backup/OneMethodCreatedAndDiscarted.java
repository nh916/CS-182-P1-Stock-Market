// One method based Sample class but it was giving me problems so I went back to multiline sample compute
import java.util.ArrayList;
import java.util.Collections;

public class Sample {

    private ArrayList <Double> data;
    private double mean;
    private double median;
    private double stdev;
    private double max;
    private double min;
    private String name;

    private double sum;

    public Sample(String name){
        this.name = name;
        this.data = new ArrayList<Double>();
    }

//    Sorts the data. Calculates and sets min, max, mean, standard deviation, and median. Then Prints all of it out
    public void computeStats(ArrayList<Double> data){
        Collections.sort(this.data);
        this.min = Collections.min(data);
        this.max = Collections.max(data);


        // Calculates mean
        double sum = 0;

        for (int i = 0; i < data.size(); i++) {
            this.sum = this.sum + data.get(i);
        }
        mean = sum/data.size();
        this.mean = mean;
        // END Calculates mean


        // calculates Standard Deviation
        double sumSquares = 0;
        for (int i = 0; i <data.size() ; i++) {
            sumSquares = sumSquares + Math.pow(data.get(i) - this.mean, 2);
        }
        stdev = Math.sqrt(sumSquares/data.size());
        this.stdev = stdev;
        // END calculates Standard Deviation


        // Calculates Median
        if(data.size()%2 == 0){
            double indexOne = (data.get(data.size() / 2));
            int indexOneCasted = (int)indexOne;

            double indexTwo = data.get((  (data.size()/2) -1)  );
            int indexTwoCasted = (int)indexTwo;

            //            the 4 previous lines gets the index of the middle 2
            //            The bottom line calculates the value of the indexes added together and devided by 2
            median = (data.get(indexOneCasted) + data.get(indexTwoCasted))/2;
        }
        else{
            int indexMiddle = data.size()/2;
            median = data.get(indexMiddle);
        }
        this.median = median;
//        End Calculating median

        System.out.println(this);
    }




    // toString method to return all the statistics in a meaningful way
    public String toString(){
        return "Name: " + name + "\n" +
                "Size: " + data.size() + "\n"+
                "Min: " + min + "\n" +
                "Max: " + max + "\n" +
                "Mean: " + mean + "\n" +
                "Median: " + median + "\n" +
                "Standard Deviation: " + stdev + "\n";
    }






}