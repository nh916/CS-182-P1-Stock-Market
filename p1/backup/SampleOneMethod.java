// One method Sample class


import java.util.ArrayList;
import java.util.Collections;

public class SampleOneMethod {

    private ArrayList <Double> data;
    private double mean;
    private double median;
    private double stdev;
    private double max;
    private double min;
    private String name;


    public Sample(String name){
        this.name = name;
    }






// One method to set min,max,mean,median,
    
    public void computeStats(){
    	
    	Collections.sort(this.data);
        this.min = Collections.min(this.data);
        this.max = Collections.max(this.data);
       
        
        // Calculates mean
        private double sum;
        
        for (int i = 0; i < data.size(); i++) {
            this.sum = this.sum + data.get(i);
        }
        mean = sum/data.size();
        this.mean = mean;
        // Calculates mean END

        // calculates Standard Deviation
        double sumSquares = 0;
        for (int i = 0; i <data.size() ; i++) {
            sumSquares = sumSquares + Math.pow(data.get(i) - this.mean, 2);
        }
        stdev = Math.sqrt(sumSquares/data.size());
        this.stdev = stdev;
        // calculates Standard Deviation

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