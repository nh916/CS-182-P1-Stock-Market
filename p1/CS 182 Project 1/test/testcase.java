import java.util.ArrayList;
import java.util.Random;

public class Simulate {
    private final double investment = 100;
    final private int weeks = 3582;
    private double meanGiven = 0.0016;
    private double medianGiven = 0.0029;
    private double stDevGiven = 0.0205;
    private int size = 0;

    //the user can pass in the arguments needed for the mean or median.
    public Simulate(int size, double meanOrMedian, double stDev) {
        this.size = size;
        this.meanGiven = meanOrMedian;
        this.medianGiven = meanOrMedian;
        this.stDevGiven = stDev;
    }

    public void linear(){
        double investmentForMean = 100;
        double investmentForMedian = 100;
        meanGiven = 0.0016;
        medianGiven = 0.0029;


        for (int i = 0; i < weeks; i++) {
            investmentForMean = investmentForMean + (meanGiven * investmentForMean);
            investmentForMedian = investmentForMedian + (medianGiven * investmentForMedian);
        }
        System.out.println("Linear Simulation for mean is: " + investmentForMean + "\n");
        System.out.println("Linear Simulation for median is: " + investmentForMedian + "\n");
    }

//mean = 30693.00663594
//median = 3197682.6490655718





    public void distributional(){
        Random random = new Random();

        Sample equity = new Sample("Normal Distribution Mean");
//        Sample secondEquity = new Sample("Normal Distribution Median");

        for (int i = 0; i < size; i++) {
            double meanDist = 0;
            double medianDist = 0;
            meanDist = medianDist = investment;


            for (int j = 0; j < weeks; j++) {
                meanDist = meanDist + ((random.nextGaussian() * stDevGiven + meanGiven)*meanDist);
//                medianDist = medianDist + ((random.nextGaussian() * stDevGiven + medianGiven) *medianDist);
            }
            equity.add(meanDist);
//            secondEquity.add(medianDist);
        }
//        Sample takes in each arrayList and compute the statistics on it and spits them out
        System.out.println(equity.computeStats());
//        System.out.println(secondEquity.computeStats());
    }







    public void monteCarlo(){
        Sample equity = new Sample("Monte Carlo simulation equity Mean");

        Sample model = new Sample("Monte Carlo simulation Model");
        model.readFile();

        for (int i = 0; i < size; i++) {
            double invest = investment;

            for (int j = 0; j < weeks; j++) {
                invest = invest + ((model.randomModelNumber() * invest));
            }
            equity.add(invest);
        }
        System.out.print(equity.computeStats());
    }






    public static void main (String[] args){
        Simulate stuff = new Simulate(1000, 0.0016, 0.0205);
        stuff.linear();
       stuff.distributional();
       stuff.monteCarlo();

//        Simulate normal;
//        if (args.length == 3)
//            normal = new Simulate(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
//        else {
//            System.out.println("invalid usage, use:");
//            System.out.println("   java NormalDistribution size, mean, standard_deviation");
//            System.out.println("   java NormalDistribution 1000 50.5 10.25");
        }
    }
