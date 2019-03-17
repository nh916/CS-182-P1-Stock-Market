import java.util.ArrayList;
import java.util.Collections;

public class SampleMultiMethod {

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
    
    
    protected double add(ArrayList<Double> data){
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum = sum + data.get(i);
        }
        return sum;
    }

// Calculates Mean and sets it since Standard deviation will need to use mean
    public double computeMean(ArrayList<Double> data, double mean){

        for (int i = 0; i < data.size(); i++) {
            this.sum = this.sum + data.get(i);
        }
        mean = sum/data.size();
        return mean;
    }


// Calculates Standard Deviation
    public double computeStandardDeviation(ArrayList<Double> data, double stdev, double mean){
        double sumSquares=0;
        for (int i = 0; i <data.size() ; i++) {
            sumSquares = sumSquares + Math.pow(data.get(i) - this.mean, 2);
        }
        stdev = Math.sqrt(sumSquares/data.size());
        return stdev;
    }


// Calculates Median
    private double computeMedian(ArrayList<Double> data, double median){
        Collections.sort(data);

        if(data.size()%2 == 0){
            double indexOne = (data.get(data.size() / 2));
            int indexOneCasted = (int)indexOne;

            double indexTwo = data.get((  (data.size()/2) -1)  );
            int indexTwoCasted = (int)indexTwo;

    //            this gets the index of those 2
    //            this calculates the value
            median = (data.get(indexOneCasted) + data.get(indexTwoCasted))/2;
        }
        else{
            int indexMiddle = data.size()/2;
            median = data.get(indexMiddle);
        }
        return median;
    }

// One method to set all the statistical variables
    public void computeStats(){
        this.min = Collections.min(this.data);
        this.max = Collections.max(this.data);
        this.median = computeMedian(this.data, this.median);

        this.mean = computeMean(this.data, this.mean);

        this.stdev = computeStandardDeviation(this.data, this.stdev, this.mean);
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