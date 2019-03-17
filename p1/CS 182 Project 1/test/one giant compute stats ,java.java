// this is finished with complicated computestats() before its been changed to method based
// all in one compute stats method


import java.util.ArrayList;
import java.util.Collections;

public class Sample {

    protected ArrayList <Double> data;
    private double mean;
    private double median;
    private double stdev;
    private double max;
    private double min;
    private String name;

    public Sample(String name){
        this.name = name;
    }

    
    
    
    
    
    


    public void computeStats(){
        Collections.sort(data);
        
//        Calculates the min and max
        min = Collections.min(data);
        max = Collections.max(data);

        
//      Calculates the mean
        double sum = 0;

        for (int i = 0; i < data.size(); i++) {
            sum = sum + data.get(i);
        }
        mean = sum/data.size();
//        End of calculating the mean
        
        
//        Calculates the standard deviation
        for (int i = 0; i <data.size() ; i++) {
            stdev = stdev + Math.pow(data.get(i) - mean, 2);
        }
        stdev = Math.sqrt(stdev/data.size());
//      End of calculating Standard Deviation
        
        
//        Calculates Median
        if(data.size()%2 == 0){
            int indexOne =(data.get(data.size() / 2);
            int indexTwo = (data.get(((data.size()/2)-1));

//            this gets the index of those 2
//            this calculates the value
            median = (data.get(indexOne) + data.get(indexTwo))/2;
        }
        else{
            int indexMiddle = data.size()/2;
            median = data.get(indexMiddle);
        }
    
    }

























    public String toString(){
        return "Name: " + name + "\n" +
                "Size: " + data.size() + "\n"+
                "Min: " + min + "\n" +
                "Max: " + max + "\n" +
                "Mean: " + mean + "\n" +
                "Median: " + median + "\n" +
                "Standard Deviation: " + stdev + "\n";
    }



    public static void main(String[] args){

    }

}