/*
Normal Distribution generation example

Mike Barnes  8/21/2018
*/

import java.util.Random;

public class NormalDistribution {
   private double mean, stdDev; // primitive instance variables
   private Random random; // reference instance variable
   private double [] data; // reference instance variable
   
   // constructor
   public NormalDistribution(int size, double theMean, double theStdDev) {
      data = new double[size];
      random = new Random();     // make an instance of Random
      System.out.printf("Make normal distribution: size = %d, mean %.2f, standard deviation = %.2f %n",
         size, theMean, theStdDev);
      for(int i = 0; i < size; i++) // sample from normal distribution
         data[i] = theMean + random.nextGaussian() * theStdDev;
      mean = getMean();
      stdDev = getStdDev(mean);
      System.out.println(this);
      }
      
   private double getMean() { 
      double sum = 0;
      for(int i = 0; i < data.length; i++)
         sum += data[i];
      return sum / data.length;
      }
 
   private double getStdDev(double mean) {
      double sumOfSquares = 0;
      for(int i = 0; i < data.length; i++)
         sumOfSquares += Math.pow(data[i] - mean, 2);
      return Math.pow(sumOfSquares / data.length, 0.5);
      }
    
   public String toString() {
      return String.format("Distribution:  size = %d, mean = %.2f, stdDev = %.2f",
         data.length, mean, stdDev);
      }
      
   public static void main(String [] arg) {
      NormalDistribution normal;
      if (arg.length == 3) 
         normal = new NormalDistribution(Integer.parseInt(arg[0]), Double.parseDouble(arg[1]), Double.parseDouble(arg[2]));
      else {
         System.out.println("invalid usage, use:");
         System.out.println("   java NormalDistribution size, mean, standard_deviation");
         System.out.println("   java NormalDistribution 1000 50.5 10.25");
         }
      }
   
   } 
      
      