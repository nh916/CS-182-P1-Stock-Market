// this is the previous code before optimized and with the calculation methods
// basically what i got from Jenniffer


import java.util.ArrayList;
import java.util.Collections;

public class Sample {

    private ArrayList <Double> data;
    private double mean;
    private double median;
    private double stdev;
    private double mean;
    private double max;
    private double min;
    private String name;

//    public Sample(ArrayList<Double> data, String name, double stdev, double mean, double median){
//        this.data = data;
//        this.mean = mean;
//        this.median = median;
//        this.stdev = stdev;
//        this.name = name;
//    }

    public Sample(String name){
        this.name = name;
    }



    public void computeStats(){
//        min = data[0];
//        for (int i = 0; i<data.size(); i++){
//            min = Math.min(data[0],data[1]);
//            max = Math.max(data[0], data[i]);
//        }
//        need to implement comparable interface for this


        Collections.sort(data);
//        min = data[0];
//        max = data[data.size() - 1];
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
}