import java.io.*;
import java.util.Scanner;
class FileReverse{
  public static void main(String[] args) throws IOException{
  int lineNumber = 0;
  if(args.length < 2){
    System.out.println("Usage: FileCopy <input file> <output file>");
    System.exit(1);
  }
  Scanner in = new Scanner(new File(args[0]));
  PrintWriter out = new PrintWriter(new FileWriter(args[1]));


  while(in.hasNext()){
    String line = in.nextLine().trim() + " ";
    String[] token = line.split("\\s+");

    for(int i =0; i<token.length; i++){
      lineNumber = token[i].length();
      out.println(stringReverse(token[i],lineNumber));
    }
    }

  in.close();
  out.close();
  }





  public static String stringReverse(String s, int n){
    if (n>0){
      return s.charAt(n-1)+stringReverse(s,n-1);
    }
    return "";
  }
 }
