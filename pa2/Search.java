/*
PA2
Kameronjeet Singh Gill
1476833
kgill@ucsc.edu

This program will take in a text file, put the word in an array
then alphabetize it. It will then look for the word specified and find
out if it is in the file text and what line it is on.

Partners: none.
*/




import java.io.*;
import java.util.Scanner;


class Search{
  public static void main(String[] args) throws IOException{

//most of the code here is gotten from the given LC.java file provided
//by Charlie as an example for this assignment

    if (args.length <0) {     //if there is nothing in the file, then there is nothing
      System.out.println("Usage: Not enough data"); //for the function to compare to
      System.exit(1);                           //and the function will print error messages and exit
        }
        int lineCount =0;       //will keep track of how many lines he text file spans
        String word = null;     //this is the word from the file text that will be assigned to
    Scanner in = new Scanner(new File(args[0]));

while (in.hasNextLine()){         //while there is still more words on the filetext....
      word = in.nextLine();       //word will be assigned the word on the current line
      lineCount++;                //counter for line will go up by one
        }

    String[] wordCount = new String[lineCount];     //array to store the words in filetest
    int[] count = new int[lineCount];               //array to store how many lines there are
    in = new Scanner (new File(args[0]));

    for (int i = 1; i <= count.length; i++){      //this for loop assigns the index from [0...x]
      count[i-1] = i;                             // to the array count.
    }
      for( int i = 0; in.hasNextLine(); i++){   //this for loops assigns the word on the filetext
        word = in.nextLine();                    //to the array of wordCount
        wordCount[i] = word;

        }


    mergeSort(wordCount, count, 0, count.length-1);     //this will split up and also order the filetext in alphabetical order
    for (int i = 1; i<args.length; i++)   //this will iterate the function from 1 all the way to the end of the line
      System.out.println(binarySearch(wordCount, count, 0, wordCount.length-1,args[i]));
                                            //binarySearch will try to find the requested word and
                                            //its line number on the text file.
    in.close();



}




//the below code is based off on the programs mergeSort and binarySearch
//which Charlie gave us access to use, I modified it according to the
// guidelines of the assignment.


public static void mergeSort(String[] A, int[] B, int p, int r){
   int q;
   if(p < r) {    //base case, must find out if r (length of array) is basically
                  // not 0.

      q = (p+r)/2;    //mid point of number of lines the text file has.

      mergeSort(A, B, p, q);
      mergeSort(A, B, q+1, r);
      merge(A, B, p, q, r);
   }
}

// merge()
// merges sorted subarrays A[p..q] and A[q+1..r]
public static void merge(String[] A, int[] B, int p, int q, int r){
   int n1 = q-p+1; //length of first half of array
   int n2 = r-q;    //length of second half of the array

   String[] L = new String[n1]; //this is the word array for the left half
   int[] L1 = new int[n1];      //number array used to count lines for the left half

   String[] R = new String[n2];   //word array for the right half
   int[] R1 = new int[n2];        //int array for the right half

   int i, j, k;

   for(i=0; i<n1; i++){     //this will iterate from poistion of 0 all the half to
      L[i] = A[p+i];        // halfway point and assigns words/int value to the arrays
      L1[i] = B[p+i];
   }
   for(j=0; j<n2; j++){     //this is will iterate from position q all the way to the end
      R[j] = A[q+j+1];      //also assigns words/int values to the respective arrays
      R1[j] = B[q+j+1];
   }

   i = 0; j = 0;
   for(k=p; k<=r; k++){
      if( i<n1 && j<n2 ){       //both of these requirements must be met
         if( L[i].compareTo(R[j])>0){     //this begins the sorting of the words in the array
            A[k] = L[i];                  //if  the word at poistion I is bigger than the word at
            B[k] = L1[i];                 //position J, then word/index i will be recorded.
            i++;
         }else{
            A[k] = R[j];        //basically the opposite of the above code but now the right side
            B[k] = R1[j];         //is bigger and its value is recorded
            j++;
         }
      }else if( i<n1 ){   // if i <n1 then the f
         A[k] = L[i];     // A at poistion k is assigned the word at L[i]
         B[k] = L1[i];    // Array B is given index at i
         i++;
      }else{ // j<n2    //same as above except with j instead of i and
         A[k] = R[j];   //at the right side of the split
         B[k] = R1[j];
         j++;
      }
   }

}



static int binarySearch(String [] A, int[] B, int p, int r,  String target){
   int q;

   if(p  > r) {         // will check the basecase, if 0>length of array return -1
      return -1;        // meaning there is no target in array A
    }
   else{
      q = (p+r)/2;      //q is the midway point of the length of the array
      if(A[q].compareTo(target) == 0){      //if the word at poistion Q is equal to the target
         return B[q];                       //that means its the same word and return the index of it
      }else if(A[q].compareTo(target)< 0){  //if A[q] is before target word, then
         return binarySearch(A, B, p, q-1, target);  //recursive go down the leftside of the array
      }else{                                          //if its larger than it wil
         return binarySearch(A, B,q+1, r, target);    //will recursively go from the middle to the rightside
      }
   }
}
}
