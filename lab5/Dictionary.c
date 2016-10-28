/*Kameronjeet Singh GIll
   kgill2@ucsc.edu
   1476833

   Dictionary.c
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "Dictionary.h"


typedef struct NodeObj {
        char* key;
        char* value;
        struct NodeObj* next;
} NodeObj;

typedef NodeObj* Node;

Node newNode(char* k, char* v){
        Node N = malloc(sizeof(NodeObj));
        assert(N!=NULL);
        N->key = k;
        N->value = v;
        N->next = NULL;
        return(N);
}

void freeNode (Node* pN){
        if(pN !=NULL && *pN != NULL) {
                free(*pN);
                *pN = NULL;
        }
}

typedef struct DictionaryObj {
        Node top;
        int numItems;
}DictionaryObj;


Dictionary newDictionary(void){
        Dictionary D = malloc(sizeof(DictionaryObj));
        assert(D != NULL);
        D->top = NULL;
        D->numItems = 0;
        return D;
}

void freeDictionary(Dictionary* pD){
        if( pD!=NULL && *pD!=NULL) {
                if( !isEmpty(*pD) ) makeEmpty(*pD);
                free(*pD);
                *pD = NULL;
        }
}
int isEmpty(Dictionary D){
        if (D == NULL) {
                fprintf(stderr,"Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
                exit(EXIT_FAILURE);
        }
        return (D->numItems== 0);
}

int size(Dictionary D){
        return D->numItems;
}

char* lookup(Dictionary D, char* k){
        Node N = D->top;
        while( N != NULL) {
                if(strcmp(N->key,k)==0)
                        return N->value;
                N = N->next;
        }
        return NULL;
}

void insert(Dictionary D, char* k, char* v){
        Node N = D->top;
        if (lookup(D, k)== NULL) {

                if(D->top == NULL) {
                        N = newNode(k,v);
                        D->top = N;
                        D->numItems++;
                }
                else{
                        while(N!= NULL) {
                                if(N->next==NULL) {
                                        break;
                                }
                                N = N->next;
                        }
                        N->next = newNode(k,v);
                        D->numItems++;
                }
        }

        else{
                fprintf(stderr, "Dictionary Error: calling insert() on duplicate key\n");
                exit(EXIT_FAILURE);
        }
}

void delete(Dictionary D, char* k){
        Node N = D->top;
        if (lookup(D,k) != NULL) {
                if (strcmp (N->key, k)==0) {
                        Node A = D->top;
                        Node B = A->next;
                        D->top = B;
                        freeNode(&A);
                        D->numItems--;
                }
                else{
                        while (N != NULL && N->next != NULL) {
                                while(N !=NULL && N->next != NULL) {
                                        if(strcmp(N->next->key, k)==0) {
                                                Node G = N;
                                                Node C = N->next;
                                                G->next = C->next;
                                                N=G;
                                                freeNode(&C);
                                        }
                                        N = N->next;
                                }
                        }
                        D->numItems--;
                }
        }else{
                fprintf(stderr, "Stack Error: deleting non-existant key\n");
                exit(EXIT_FAILURE);
        }
}

void makeEmpty(Dictionary D){
        D->top = NULL;
        D->numItems = 0;
}

void printDictionary(FILE* out,Dictionary D){
        Node N = D->top;
        while( N != NULL) {
                fprintf(out,"%s %s \n",N->key,N->value);
                N = N->next;
        }
}
