/*
Kameronjeet Singh GIll
kgill2@ucsc.edu
1476833
Lab 4
this program will take in a text file and put out an analysis of the text file of its letters, number, punctuation and spaces used
*/


#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#include<assert.h>

#define MAX_STRING_LENGTH 100

//Based extract_chars on given example in alpha_char.

void extract_chars(char* s, char*a , char* d, char* p, char* w){
		int i = 0,j = 0,k = 0, l =0, m = 0;        // this is used to keep track of certain char used like numbers.

		while(s[i] != '\0' && i<MAX_STRING_LENGTH){ 				// while there is sumthing in in array S, which is the text file....
			if(isupper((int)s[i])){														//if its a Upper case alphabet, it gets added to the array for it
				a[j]=s[i];
				j++;
			}
			else if (isalpha((int)(s[i]))){										//if its lower case, gets added to the alphabet array
				a[j] = s[i];
				j++;																						//keeps track of inputs added to array/char
			}
			else if(ispunct ((int)(s[i]))){										//if its puncutation, it gets added to array p.
				p[k] = s[i];
				k++;
			}
			else if (isdigit((int)(s[i]))){										// if its a number, it gets added to array d
				d[l] = s[i];
				l++;
			}
			else{
				w[m] = s[i];																		//else, it must be a space, so gets added to array w.
				m++;
			}
			i++;

		}
		a[j] = '\0';																		//sets the ends of each array to null.
		p[k] = '\0';
		d[l] = '\0';
		w[m] = '\0';
}

int main(int argc, char *argv[]){
	 FILE* in;        // handle for input file
   FILE* out;       // handle for output file
   char* line;      // string holding input line
	 char* word;			// string that h
   char* alpha; 		//string holding alphabet chars
	 char* num;				//string holding number chars
	 char* punc;			//string hold puncutation chars
	 char* whitespace; 	//string holding spaces.
	 int numLine = 1;		//this will keep track of what line it is on.

   // the below is mostly copied from the example given to us.
   if( argc != 3 ){
      printf("Usage: %s input-file output-file\n", argv[0]);
      exit(EXIT_FAILURE);
   }

   // open input file for reading
   if( (in=fopen(argv[1], "r"))==NULL ){
      printf("Unable to read from file %s\n", argv[1]);
      exit(EXIT_FAILURE);
   }

   // open output file for writing
   if( (out=fopen(argv[2], "w"))==NULL ){
      printf("Unable to write to file %s\n", argv[2]);
      exit(EXIT_FAILURE);
   }

   // allocate strings line and alpha_num on the heap
   line = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
	 word = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
   alpha= calloc(MAX_STRING_LENGTH+1, sizeof(char) );
	 num = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
	 punc = calloc(MAX_STRING_LENGTH+1, sizeof(char) );
	 whitespace = calloc(MAX_STRING_LENGTH+1, sizeof(char) );



   assert( line!=NULL && alpha!=NULL && num != NULL && punc != NULL && whitespace != NULL );

   // read each line in input file, extract alpha-numeric characters
   while( fgets(line, MAX_STRING_LENGTH, in) != NULL ){
	 		extract_chars(line,word,num,punc,whitespace);		//sort out the text file.
	 		fprintf(out,"line %d contains: \n",numLine);

	 		if(strlen(word)>1){
				fprintf(out,"%d alphabetic characters: %s\n",(int)strlen(word),word);
	 }
	 		else{
		 		fprintf(out,"%d alphabetic character: %s\n",(int)strlen(word),word);
	 }
	 		if(strlen(num)>1){
		 		fprintf(out,"%d numeric characters: %s\n",(int)strlen(num),num);
	 }
	 		else{
		 		fprintf(out,"%d numeric character: %s\n",(int)strlen(num),num);
	 }
	 		if(strlen(punc)>1){
		 		fprintf(out,"%d punctuation characters: %s\n",(int)strlen(punc),punc);
	 }
	 		else{
		 		fprintf(out,"%d punctuation character: %s\n",(int)strlen(punc),punc);
	 }
	 		if(strlen(whitespace)>1){
		 		fprintf(out,"%d whitespace characters: %s\n",(int)strlen(whitespace),whitespace);
	 }
	 		else{
		 		fprintf(out,"%d whitespace character: %s\n",(int)strlen(whitespace),whitespace);
	 }
	 numLine++;			//increments the line number

   // free heap memory
   free(line);
	 free(word);
   free(alpha);
	 free(num);
	 free(punc);
	 free(whitespace);

   // close input and output files
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;
	}
}
