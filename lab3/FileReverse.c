/*
Kameronjeet Gill
1476833
Lab 3

This program will take a text file and then  create a new text tile that outputs the word backwards
in C
*/



#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void stringReverse(char* s) {
	int i = 0, x, j = strlen(s)-1;

  for (i=0; i<j; i++) {   //this will cause an interation from the start of the char all the way to the end of it
		x = s[i];             //tempory value of x is given the value at s[i]
		s[i] = s[j];          //switchthe values at s[i] and s[j]
		s[j] = x;             //s[j] is given s[i]'s original value'
		j--;
	}
}


//the below is completely copied from the given File.io that was given to us in the lab instruction. I added one modificated to work
//with the lab instructions.

int main(int argc, char* argv[]){
  FILE* in; /* file handle for input */
  FILE* out; /* file handle for output */
  char word[256]; /* char array to store words from input file */
  /* check command line for correct number of arguments */
  if( argc != 3 ){
    printf("Usage: %s <input file> <output file>\n", argv[0]);
    exit(EXIT_FAILURE);
  }
  /* open input file for reading */
  in = fopen(argv[1], "r");
  if( in==NULL ){
    printf("Unable to read from file %s\n", argv[1]);
    exit(EXIT_FAILURE);
  }
  /* open output file for writing */
  out = fopen(argv[2], "w");
  if( out==NULL ){
    printf("Unable to write to file %s\n", argv[2]);
    exit(EXIT_FAILURE);
  }
  /* read words from input file, print on separate lines to output file*/
  while( fscanf(in, " %s", word) != EOF ){
    stringReverse(word);
    fprintf(out, "%s\n", word);
  }
  /* close input and output files */
  fclose(in);
  fclose(out);
  return(EXIT_SUCCESS);
}
