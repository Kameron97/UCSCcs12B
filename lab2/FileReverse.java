/*
Kameronjeet Singh Gill
1476833
kgill2@ucsc.edu
Partners:None

This program will take in any txt file in and output the strings backward

Most of main() was gotten from FileTokens which
Charlie provided
*/


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



// Everything above was taken directly from Charlie's provide "FileToken"

    for(int i =0; i<token.length; i++){               //this will iterate i from i all the way to the
                                                      // length of whatever string in order to flip it
      lineNumber = token[i].length();                 //this will give the length of tokaen at the index i.
      out.println(stringReverse(token[i],lineNumber)); //will print out the character at the index I poistion of the string
    }
    }

  in.close();     //copied from FileToken
  out.close();
  }





  public static String stringReverse(String s, int n){
    if (n>0){                                       //n must always be greater than 0 in this program
                                                    //because u cant be at a -1 position
      return s.charAt(n-1)+stringReverse(s,n-1);    //recursion method. Starts at right most poistion and works it way
                                                    // down to the left most.
    }
    return "";
  }
 }
