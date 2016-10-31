/*Kameronjeet Singh GIll
   kgill2@ucsc.edu
   1476833

   Dictionary.c
   this program will create an ADT in C. It has certain functions tied to it that do various functions like delete or add.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "Dictionary.h"

//the methods from NodeObj all the way to newDictionary were based off of ImageStack which Charlie provided as an example

//private functions**
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

//end of private functions


//public functions **
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


//Start of methods of Dictionary

//isEmpty checks if the Node is empty by calling numItems.
//if the Node if empty, an error occurs, otherwise checks to see if numItems ==0
int isEmpty(Dictionary D){
        if (D == NULL) {
                fprintf(stderr,"Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
                exit(EXIT_FAILURE);
        }
        return (D->numItems== 0);
}
//size checks the size of the Node by returning the numItems.
//if the node is empty, an error gets thrown, otherwise numItems is returned.
int size(Dictionary D){
        if (D == NULL) {
                fprintf(stderr,"Dictionary Error: calling size() on NULL Dictionary reference\n");
                exit(EXIT_FAILURE);
        }
        return D->numItems;
}

//lookup will see if the Node has a certain char stored.
//if the Node has it, it returns where it is located by returning the "value"
//if its not in there, NULL is returned other wise.
char* lookup(Dictionary D, char* k){
        Node N = D->top;
        while( N != NULL) {
                if(strcmp(N->key,k)==0)   //compares current place of N to k to see if they are similiar.
                        return N->value;
                N = N->next;
        }
        return NULL;
}


//insert will insert a key and value at the end of the Node
//if the Node already has the value, it throws an error
//otherwise the key/value is put at the top of the Node

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

//delete will delete certain char k in the Node
//if the key does not exist in the value, it throws an Error
//otherwise it gets deleted and patches Node to move to next item on list.
void delete(Dictionary D, char* k){
        Node N = D->top;
        if (lookup(D,k) != NULL) {    //that means k is inside Dictionary
                if (strcmp(N->key, k)==0) {   //k is found in Dictionary
                        Node temp1 = D->top;
                        Node temp2 = temp1->next;
                        D->top = temp2;
                        freeNode(&temp1);   //deletes previous memory of temp1.
                        D->numItems--;
                }
                else{
                        while (N != NULL && N->next != NULL) {
                                while(N !=NULL && N->next != NULL) {
                                        if(strcmp(N->next->key, k)==0) {
                                                Node temp1 = N;
                                                Node temp2 = N->next;
                                                temp1->next = temp2->next;
                                                N=temp1;
                                                freeNode(&temp2);
                                        }
                                        N = N->next;
                                }
                        }
                        D->numItems--;
                }
        }else{
                fprintf(stderr, "Dictionary Error: deleting non-existant key\n");
                exit(EXIT_FAILURE);
        }
}

//makeEmpty will make the Node empty
//makes Node NULL and sets numItems equal to 0
void makeEmpty(Dictionary D){
        D->top = NULL;
        D->numItems = 0;
}
//printDictionary will print out the key and value for the Node.
//uses a while look to go through the Node to print.
void printDictionary(FILE* out,Dictionary D){
        Node N = D->top;
        while( N != NULL) {
                fprintf(out,"%s %s \n",N->key,N->value);
                N = N->next;
        }
}
