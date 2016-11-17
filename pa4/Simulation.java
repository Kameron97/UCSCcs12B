//-----------------------------------------------------------------------------
// SimulationStub.java
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Simulation {
public static void main(String[] args) throws IOException {
        Scanner scan = null;
        PrintWriter report = null;
        PrintWriter trace = null;
        Queue Storage = new Queue();

//checks to see if command line is write
//#1 on list
        if (args.length != 1) {
                System.err.println("Invalid Form. Forgot to use valid file to read from. Try again.");
                System.exit(1);

        }
        //#2 on list. creating file: report and trace.
        scan = new Scanner(new File(args[0]));
        report = new PrintWriter(new FileWriter(args[1] + ".rpt"));
        trace = new PrintWriter(new FileWriter(args[2] + ".trc"));

        //#3 on list.  get the input of m Jobs
        int m = Integer.parseInt(scan.nextLine);
        while(scan.hasNext()){
            Storage.enqueue((Job)getJob(scan));
        }

        //#4 on the list. iterate n->m-1
        for ( int n = 1; n<m-1; n++) {
                //#5 on list. but might need to do something else.
                Queue processor = new Queue(n);
                for ( int i = 0 ; i<n; i++){
                  processor[i] = new Queue();
                }
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
}
