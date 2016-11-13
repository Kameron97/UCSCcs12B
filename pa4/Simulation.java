//-----------------------------------------------------------------------------
// SimulationStub.java
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Simulation{
  public static void main(String[] args) throws IOException{
    Scanner scan = null;
    PrintWriter report = null;
    PrintWriter trace = null;
    Queue Storage1 = new Queue();

//checks to see if command line is write
//#1 on list
    if (args.length != 1){
      System.err.println("Invalid input. Please use input");
      System.exit(1);

    }
    //open files for reading/writing
    //#2 on list
    scan = new Scanner(new File(args[0]));
    report = new PrintWriter( new FileWriter(args[1]+".rpt");
    trace = new PrintWriter(new FileWriter(args[2]+".trc"));
    //#3 on list
    //reads in "m" jobs
    int m = Integer.parseInt(scan.nextLine());
    while(scan.hasNext()){
        Storage1.enqueue((Job)getJob(scan));
    }


    //#4 on list
    //goes from n->m-1
    trace.println("Trace file: "+args[0]+".trc");
    trace.println(m+ " Jobs:");
    trace.println(Storage);


    for(int n = 1; n<m-1; n++){
      //#5 on list.
      //create new queue array
      Queue[] array = new Queue[n];


    }



    //gotten from example.
    //returns a new job from a scanner file.
    public static Job getJob(Scanner in) {
     String[] s = in.nextLine().split(" ");
     int a = Integer.parseInt(s[0]);
     int d = Integer.parseInt(s[1]);
     return new Job(a, d);
  }

  }
