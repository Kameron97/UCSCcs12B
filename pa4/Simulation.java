//Kameronjeet Gill
//1476833
//kgill2@ucsc.edu

//this program stimulates a grocery line.

import java.io.*;
import java.util.Scanner;

public class Simulation {

// Given function. getJob will make jobs for Storage Queue.
public static Job getJob(Scanner in) {
        String[] s = in.nextLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        return new Job(a, d);
}


public static void main(String[] args) throws IOException {
        Scanner in = null;
        PrintWriter report = null;    //report output file
        PrintWriter trace = null;     //trace output file

        //storage Queues for jobs.
        Queue storTemp = new Queue();
        Queue storage = new Queue();
        Queue finished = new Queue();

        Job j = null;
        Queue[] processorQueues = null;
        int time = 0;
        int m;

        //    1.  check command line arguments

        if(args.length < 1) {
                System.out.println("Usage: Simulation infile");
                System.exit(1);
        }

        //    2.  open files for reading and writing

        in = new Scanner(new File(args[0]));
        report = new PrintWriter(new FileWriter(args[0] + ".rpt"));
        trace = new PrintWriter(new FileWriter(args[0] + ".trc"));

        //    3.  read in m jobs from input file
        //number from top of file.
        m = Integer.parseInt(in.nextLine());

        //stores the numbers on the line into storTemp
        while (in.hasNext()) {
                j = getJob(in);
                storTemp.enqueue(j);
        }

        //prints the header for both Trace+report file.
        //trace file.
        trace.println("Trace file: " + (args[0] + ".trc"));
        trace.println(m + " Jobs:");
        trace.println(storTemp.toString());
        trace.println();

        //report file
        report.println("Report file: " + (args[0] + ".rpt"));
        report.println(m + " Jobs:");
        report.println(storTemp.toString());
        report.println();
        report.println("*****************************************************************************");

        // Main program loop for running simulations n=1 to n=(m-1)
        for(int n = 1; n < m; n++) {
                //time units to keep track of.
                int totalWait = 0;
                int maxWait = 0;
                double averageWait = 0.00;

                //    5.      declare and initialize an array of n processor Queues and any
                //            necessary storage Queues
                for(int i = 1; i<storTemp.length()+1; i++) {
                        j = (Job)storTemp.dequeue();    //store top of storTemp into J.
                        j.resetFinishTime();
                        storage.enqueue(j);             //add it back
                        storTemp.enqueue(j);
                }

                int processors = n;
                processorQueues = new Queue[n+2];
                processorQueues[0] = storage;
                processorQueues[n+1] = finished;
                for (int i = 1; i < n+1; i++) {
                        processorQueues[i] = new Queue();
                }

                //trace file
                //prints out between processors

                trace.println("*****************************");
                if(processors==1) {
                        trace.println(processors + " processor:");
                }else{
                        trace.println(processors + " processors:");
                }
                trace.println("*****************************");

                trace.println("time=" + time);
                trace.println("0: " + storage.toString()+ finished.toString());
                for(int i = 1; i < processors+1; i++) {
                        trace.println(i + ": " + processorQueues[i]);
                }


                //    6.      while unprocessed jobs remain  {

                while(finished.length()!=m) {
                        int finalComp = Integer.MAX_VALUE;
                        int lastIndex = 1;
                        int comp = -1;
                        int length = -1;
                        int lengthFinal = -1;
                        Job compare = null;

                        //    7.          determine the time of the next arrival or finish event and
                        //                update time

                        if(!storage.isEmpty()) {    //checks to see if storage is not empty
                                compare = (Job)storage.peek();    //recieves top Job of storage
                                finalComp = compare.getArrival(); //arrival.
                                lastIndex = 0;
                        }
                        //got some help from a tutor for the below

                        for(int i = 1; i < processors+1; i++) {   //iterates i-> n+1
                                if(processorQueues[i].length() != 0) {
                                        compare = (Job)processorQueues[i].peek();
                                        comp = compare.getFinish();
                                }
                                if(comp == -1) {
                                }else if(comp<finalComp) {
                                        finalComp = comp;
                                        lastIndex = i;
                                }
                                time = finalComp;
                        }

                        if(lastIndex == 0) {
                                int tempIndex = 1;
                                lengthFinal = processorQueues[tempIndex].length();
                                for(int i = 1; i < processors+1; i++) {
                                        length = processorQueues[i].length();
                                        if(length<lengthFinal) {
                                                lengthFinal = length;
                                                tempIndex = i;
                                        }
                                }

                                compare = (Job)storage.dequeue();
                                processorQueues[tempIndex].enqueue(compare);
                                if(processorQueues[tempIndex].length()==1) {
                                        compare = (Job)processorQueues[tempIndex].peek();
                                        compare.computeFinishTime(time);
                                }
                        }

                        else{
                                compare = (Job)processorQueues[lastIndex].dequeue();
                                finished.enqueue(compare);
                                int tempWait = compare.getWaitTime();
                                if(tempWait > maxWait) {
                                        maxWait = tempWait;
                                }
                                totalWait += tempWait;

                                if(processorQueues[lastIndex].length() >= 1) {
                                        compare = (Job)processorQueues[lastIndex].peek();
                                        compare.computeFinishTime(time);
                                }

                        }

                        //prints to trace file
                        trace.println();
                        trace.println("time=" + time);
                        trace.println("0: " + storage.toString()+ finished.toString());
                        for(int i = 1; i < processors+1; i++) {
                                trace.println(i + ": " + processorQueues[i]);
                        }


                }

                //    11.     compute the total wait, maximum wait, and average wait for
                //            all Jobs, then reset finish times
                averageWait = ((double)totalWait/m);
                averageWait = (double)Math.round(averageWait*100)/100;
                trace.println();
                report.println();
                if(processors==1) {
                        report.print(processors + " processor: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + averageWait);
                }else{
                        report.print(processors + " processors: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + averageWait);
                }

                time = 0;
                finished.dequeueAll();
        }

        //    13. close input and output files

        in.close();
        report.close();
        trace.close();

}
}
