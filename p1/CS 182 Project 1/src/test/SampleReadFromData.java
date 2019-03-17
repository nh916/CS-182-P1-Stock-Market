//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class SampleReadFromData extends Sample {
//    private ArrayList<Double> data = new ArrayList<Double>();
//
//    public SampleReadFromData() {
//        super("Monte Carlo");
//
//    }
//
//    private void ReadFile(){
//
//        BufferedReader br = null;
//        File file = new File("C:\\Users\\Navid\\Desktop\\CS 182 Project 1\\src\\SP500-Weekly.txt");
//        Scanner CurrentLine = null;
//        String nextline = null;
//        try {
//            CurrentLine = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//
//            while ((CurrentLine.hasNextLine())) {
//                nextline = CurrentLine.nextLine();
//               String[] Stored = nextline.split("\\s+");
//
//               data.add(Double.parseDouble(Stored[1]));
//            }
//            System.out.println(data);
//        } finally {
//            if (CurrentLine != null) {
//                CurrentLine.close();
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//        SampleReadFromData blah = new SampleReadFromData();
//        blah.ReadFile();
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}