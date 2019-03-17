// the code from what i got so far for distributional

    private void distributional(int size, double mean, double stdev, ArrayList<Double> data) {
        data = new ArrayList<Double>();

        Sample equity = new Sample("Normal Distribution");
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {

            for (int i = 0; i < weeks; i++) {
                data.add((mean + (random.nextGaussian() * stdev));
            }

        }
            mean = equity.computeMean(data, mean);
            stdev = equity.computeStandardDeviation(data, stdev, mean);

//        print data,mean, equity
    }