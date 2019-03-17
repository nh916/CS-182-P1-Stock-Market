// simulate market when it could still handel any arguments given and it used only one instance of sample

import java.util.Random;

public class SimulateMarket {
    private final double investment = 100;
    final private int weeks = 3582;
    private double meanGiven = 0.0016;
    private double medianGiven = 0.0029;
    private double stDevGiven = 0.0205;
    private int size = 1000;

    //    the user can pass in the arguments needed for the mean or median.
    public SimulateMarket(int size, double meanOrMedianIn, double stDev) {
        this.size = size;
        this.meanGiven = meanOrMedianIn;
        this.medianGiven = meanOrMedianIn;
        this.stDevGiven = stDev;
    }

    private void linear() {
        double theInvestment = 100;
        for (int i = 0; i < weeks; i++) {
            theInvestment = theInvestment + (meanGiven * theInvestment);
        }
        System.out.print("Name: Linear Simulation: " + theInvestment + "\n");
    }

//mean = 30693.00663594
//median = 3197682.6490655718


    private void distributional() {
        Random random = new Random();
        Sample equity = new Sample("Normal Distribution Simulation: ");

        for (int i = 0; i < size; i++) {
            double distributionalInvestment = investment;

            for (int j = 0; j < weeks; j++) {
                distributionalInvestment = distributionalInvestment + ((random.nextGaussian() * stDevGiven + meanGiven) * distributionalInvestment);
            }
            equity.data.add(distributionalInvestment);
        }
//        Sample takes in each arrayList and compute the statistics on it and spits them out
        System.out.println(equity.computeStats());
    }


    private void monteCarlo() {
        Sample equity = new Sample("Monte Carlo simulation: ");
        Sample model = new Sample("Monte Carlo simulation Model");
        model.readFile();

        for (int i = 0; i < size; i++) {
            double monteCaroloinvest = investment;

            for (int j = 0; j < weeks; j++) {
                monteCaroloinvest = monteCaroloinvest + ((model.randomModelNumber() * monteCaroloinvest));
            }
            equity.data.add(monteCaroloinvest);
        }
        System.out.print(equity.computeStats());
    }


    public static void main(String[] args) {
        SimulateMarket stuff = new SimulateMarket(1000, 0.0016, 0.205);

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
