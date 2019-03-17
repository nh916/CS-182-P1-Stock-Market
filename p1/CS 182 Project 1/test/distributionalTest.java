        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < weeks; j++) {
                meanDist = random.nextGaussian() * stDevGiven + meanGiven;
                medianDist =  random.nextGaussian() * stDevGiven + medianGiven;
            }
            meanDist = equity.computeMean(dataForMean,meanDist);
            stDevMeanDist = equity.computeMean(dataForMean,stDevMeanDist);

            medianDist = equity.computeMedian(dataForMedian,medianDist);
            stDevMedianDist = equity.computeMedian(dataForMedian,stDevMedianDist);

            summingMean = equity.add(dataForMean);
            summingMedian = equity.add(dataForMedian);

        }
//        System.out.print();
    }

