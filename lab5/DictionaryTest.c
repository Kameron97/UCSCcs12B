#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Dictionary.h"

#define MAX_LEN 180

int main(int argc, char* argv[]){
        Dictionary A = newDictionary();
        char* k;
        char* v;


        printf("%s\n", (isEmpty(A) ? "true" : "false"));
        printf("%d\n", size(A));
        }
