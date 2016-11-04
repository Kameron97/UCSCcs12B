//Simultation.java

import java.io.*;
import java.util.Scanner;

public class Simulation{
  public static void main(String[] args){

      Scanner inputFile = null;   //file being computed
      PrintWriter trace = null;
      PrintWriter report = null;
      Queue Storage = new Queue();

      int time,m,n = 0;

      if (args.length < 3){
        System.err.println("Usage: Simulation fileIn fileOut");
        System.exit(1);
      }
inputFile = new Scanner(new File(args[0]));
report = new PrintWriter(new FileWriter(args[1]+".rpt"));
trace = new PrintWriter(new FileWriter(args[2]+".trc"));


m = numOfJobs;


  }
}
