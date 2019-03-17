import java.util.Random;

public class SimulateMarket {
    private final double investment = 100;
    final private int weeks = 3582;
    private double meanGiven = 0.0016;
    private double medianGiven = 0.0029;
    private double stDevGiven = 0.0205;

    private int trials = 1000;

    public SimulateMarket() {
    }

    public void linear(){
        double investmentForMean = 100;
        double investmentForMedian = 100;

        for (int i = 0; i < weeks; i++) {
            investmentForMean = investmentForMean + (meanGiven * investmentForMean);
            investmentForMedian = investmentForMedian + (medianGiven * investmentForMedian);
        }
        System.out.print("Linear Simulation for mean is: " + investmentForMean + "\n");
        System.out.print("Linear Simulation for median is: " + investmentForMedian + "\n");
    }

//mean = 30693.00663594
//median = 3197682.6490655718


    private void distributional() {
        Random random = new Random();

        Sample equity = new Sample("Distributional Simulation with mean");
        Sample equityMedian = new Sample("Distributional Simulation with median");

        for (int i = 0; i < trials; i++) {
            double distributionalMean = investment;
            double distributionalMedian = investment;

            for (int j = 0; j < weeks; j++) {
                distributionalMean = distributionalMean + ((random.nextGaussian() * stDevGiven + meanGiven)*distributionalMean);
                distributionalMedian = distributionalMedian + ((random.nextGaussian() * stDevGiven + medianGiven) *distributionalMedian);
            }
            equity.data.add(distributionalMean);
            equityMedian.data.add(distributionalMedian);
        }
//        Sample takes in each arrayList and compute the statistics on it and spits them out
        System.out.println(equity.computeStats());
        System.out.println(equityMedian.computeStats());
    }


    private void monteCarlo() {
        Sample equity = new Sample("Monte Carlo simulation: ");
        Sample model = new Sample("Monte Carlo Model");
        model.readFile();

        for (int i = 0; i < trials; i++) {
            double monteCaroloinvest = investment;
            for (int j = 0; j < weeks; j++) {
                monteCaroloinvest = monteCaroloinvest + ((model.randomModelNumber() * monteCaroloinvest));
            }
            equity.data.add(monteCaroloinvest);
        }
        System.out.print(equity.computeStats());
    }

//  main runs the entire program
    public static void main(String[] args) {
        SimulateMarket program = new SimulateMarket();
        program.linear();
        program.distributional();
        program.monteCarlo();

    }
}
