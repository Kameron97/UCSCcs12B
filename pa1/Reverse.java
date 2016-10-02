/*
Kameron Gill 
ID: 1476833
Email:kgill2@ucsc.edu

Partner: Shashank Biradir
email:sbiradar@ucsc.edu

this program reverses an Array in 3 different ways and also
finds the largest, smallest value's index.
*/


class Reverse{
public static void main(String[] args){

 int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
 int[] B = new int[A.length];
 int[] C = new int[A.length];
 int minIndex = minArrayIndex(A, 0, A.length-1);
 int maxIndex = maxArrayIndex(A, 0, A.length-1);

 for(int x: A) System.out.print(x+" ");
 System.out.println();

 System.out.println( "minIndex = " + minIndex );
 System.out.println( "maxIndex = " + maxIndex );
 reverseArray1(A, A.length, B);
 for(int x: B) System.out.print(x+" ");
 System.out.println();

 reverseArray2(A, A.length, C);
 for(int x: C) System.out.print(x+" ");
 System.out.println();

 reverseArray3(A, 0, A.length-1);
 for(int x: A) System.out.print(x+" ");
 System.out.println();

 }

public static void reverseArray1(int[] A, int x, int[] b){
   //Array a reserve order into B

   if (x <1){
     return;
     //this means that once x becomes 0, the recursion will terminate after
     //it tries to loop again
   }
   else {
     b[b.length-x] = A[x-1]; // x starts at A.length-1, so this would start at 0 and go up
                            // A[x-1] would start at the very end of the array and go down all the way to A[0]
     reverseArray1(A,x-1,b);
   }
 }

  static void reverseArray2(int[] A, int x, int[] b){
     if (x<1){
       return;// servers the same function as in reverseArray1.
     }
     else {
       b[x-1] = A[b.length-x];// this time b start at the very right of the its Array
                              //A array starts at the very left and goes all the way to the right.
       reverseArray2(A,x-1,b);
     }
   }

 static void reverseArray3(int[] A, int n, int m){
       if( n > m){ //if n>m, then the program will stop, i set this because if n is greater than m, that means
                    // the reverseArray3 has already switched all values in array A.
         return;
       }
       else {
          int x = A[m]; //i set A[m] to a temporary value, so i know what A[m] was equal to
          A[m] = A[n]; // A[m] swap its value with the left most value in array A.
          A[n] = x;   // A[n] gets the value of the left most value of A by setting it equal to the temporary
                      //value of x.
          reverseArray3(A,n+1,m-1); //this reloop the function and make both the left and right side of the array
                                      // get closer together.

        }
       }



 static int maxArrayIndex(int[] A, int n, int m){
      if (n<m){               //once m becomes lower than n, the program terminates because it has finished
                              // reviewing all vlues in the array A.
        int q =(n+m)/2;        // this gets the midway point of array A

        int firstHalf = maxArrayIndex(A,n+1,q);     //finds the largest integer in the first half of A, also
                                                    // goes through n-q positions on A
        int secondHalf = maxArrayIndex(A,q,m-1);     //finds largest integer in the second half of A.
                                                    // goes through q-m poistions on A
        return findIndex1(A,firstHalf,secondHalf);   // this function will find the largest int between the two halves.
  }

  return findIndex1(A,n,m);                          //will return the index of the position of largest int
}

 static int minArrayIndex(int[] A, int n, int m){
    if (n<m){           //similiar function to maxArrayIndex

      int q = (n+m)/2;      //once again find the midpoint of A

      int firstHalf = minArrayIndex(A,n+1, q);    //will cycle through n-q poistions on A
      int secondHalf =minArrayIndex(A,q, m-1);    //will cycle through q-m poistions on A
      return findIndex2(A,firstHalf, secondHalf); //will find the smallest integer between the two halves.
  }
  return findIndex2(A,n,m);                         //will return the index of the position of smallest int
}

  static int findIndex1 (int[] A, int n, int m){
    int Index;                          //intialize int Index to take the place of the largest index spot

    if (A[n]>A[m])                      // this will check if A[n]  integer is larger than at A[m]
      Index = n;                          //if it is, it return n index.
    else
      Index = m;                          //otherwise, m is returned as largest index in A.

    return Index;
  }

  static int findIndex2 (int[] A, int n, int m){
                                    //this function is similiar to findIndex but tailored to finding smallest integer
    int Index;

    if (A[n]<A[m])                //this time it will see if A[m] is smaller than A[n].
      Index = n;                  //if it is, then index n is returned
    else
      Index = m;                    //otherwise, m is return as index.

    return Index;
  }
   }
