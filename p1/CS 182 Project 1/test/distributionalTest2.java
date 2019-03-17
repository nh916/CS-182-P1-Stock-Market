    private void distributional(int size, double mean, double stdev, ArrayList<Double> data) {
        data = new ArrayList<Double>();
        Sample equity = new Sample("Normal Distribution");
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            for (int i = 0; i < weeks; i++) {
                data.add((mean + (random.nextGaussian() * stdev));
            }
            for (int j = 0; j < ; j++) {
                
            }
        }
        mean = equity.computeMean(data, mean);
        stdev = equity.computeStandardDeviation(data, stdev, mean);

//        print data,mean, equity
    }

    // investment = (random.nextGaussian() * stDev) + mean);
    // investment = (random.nextGaussian() * stDev) + median);