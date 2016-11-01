#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Dictionary.h"

#define MAX_LEN 180

int main(int argc, char* argv[]){
        Dictionary A = newDictionary();
        char* k;
        char* v;


        printf("%s\n", (isEmpty(A) ? "true" : "false")); //print flase
        printf("%d\n", size(A));


        insert(A, "one", "fgfdgdf");

        printf("%s\n", (isEmpty(A) ? "true" : "false")); //print flase
        printf("%d\n", size(A));

        //insert(A, "one", "dsfdsfs"); //erroe thrown
        insert(A, "two", "aa");
        insert(A, "three", "bb");

        delete(A, "two");
        printf("%d\n", size(A));

        //delete(A, "four");   error
        printf("%d\n", size(A));

        printDictionary(stdout, A);

        makeEmpty(A);

        printf("%s\n", (isEmpty(A) ? "true" : "false")); //print flase



}
