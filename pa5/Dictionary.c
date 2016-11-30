//Kameron Gill
//1476833
//kgill2@ucsc.edu

//this program will create a Dictionary ADT in hash data structure,
//Based off on Lab5 Dictionary.c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "Dictionary.h"

//for hash or something.
const int tableSize = 101;

//the below is based off of Dictionary.c from lab 5.


//private functions
typedef struct NodeObj {
        char* key;
        char* value;
        struct NodeObj* next;
} NodeObj;

typedef NodeObj* Node;



Node newNode(char* k, char* v) {
        Node N = malloc(sizeof(Node));
        assert(N!=NULL);
        N->key = k;
        N->value = v;
        N->next = NULL;
        return(N);
}

void freeNode(Node* pN) {
        if (pN != NULL && *pN != NULL) {
                free(*pN);
                *pN = NULL;
        }
}
//end of private functions

typedef struct DictionaryObj {
        Node *table;
        int numItems;
} DictionaryObj;

Dictionary newDictionary() {
        Dictionary D = malloc(sizeof(Dictionary));
        assert(D!=NULL);
        D->table = calloc(tableSize,sizeof(Node));
        assert(D->table !=NULL);
        D->numItems = 0;
        return D;
}

void freeDictionary(Dictionary* pD) {
        if (pD != NULL && *pD != NULL) {
                makeEmpty(*pD);
                free((*pD)->table);
                free(*pD);
                *pD = NULL;
        }
}

//below functions are given to us

// rotate_left()
// rotate the bits in an unsigned int
unsigned int rotate_left(unsigned int value, int shift) {
        int sizeInBits = 8*sizeof(unsigned int);
        shift = shift & (sizeInBits - 1);
        if ( shift == 0 )
                return value;
        return (value << shift) | (value >> (sizeInBits - shift));
}
// pre_hash()
// turn a string into an unsigned int
unsigned int pre_hash(char* input) {
        unsigned int result = 0xBAE86554;
        while (*input) {
                result ^= *input++;
                result = rotate_left(result, 5);
        }
        return result;
}
// hash()
// turns a string into an int in the range 0 to tableSize-1
int hash(char* key){
        return pre_hash(key)%tableSize;
}

//checks to see if Dictionary is empty or not
//if it does not exist error gets printed.
//isEmpty();
int isEmpty(Dictionary D){

        return D->numItems==0;
}

//returns the size of the Dictionary by returning numItems
//if Dictionary does not exist error gets printed
//size()
int size(Dictionary D){

        return D->numItems;
}

//checks to see if a Dictionary has a certain key
//if Dictionary does not exist, errors gets printed
//returns value at certain part of value in Dictionary
//lookup()
char* lookup(Dictionary D, char* k){
        if(D == NULL) {
                fprintf(stderr, "Must call lookup() on valid Dictionary!\n");
                exit(EXIT_FAILURE);

        }
        Node temp = D->table[hash(k)];

        while(temp != NULL) {
                if(strcmp(temp->key,k) == 0) {
                        return temp->value;
                }
                temp = temp->next;
        }
        return NULL;
}

//this function will insert a key/value in a Dictionary.
//key must not be in the Dictionary already or error prints
//insert()
void insert(Dictionary D, char* k, char* v){

        Node temp = newNode(k,v);
        int i = hash(k);

        if(lookup(D,k) == NULL) {   //checks to see if the key is not in there already
                if(D->table[i] == NULL) {
                        D->table[i] = temp;

                }
                else{
                        temp->next = D->table[i];
                        D->table[i] = temp;
                }
                D->numItems++;
        }
        else{ //lookup(D,k) != NULL
                fprintf(stderr, "Cannot call insert() on duplicate key.\n");

        }
}

//this function will delete a key and its value from a Dictionary.
//if key does not exist, error happens.
//delete()
void delete(Dictionary D, char* k){
        int i = hash(k);
        Node temp = D->table[i];
        Node tempNode = NULL;

        if( lookup(D,k) != NULL) {
                if (temp->key == k) {
                        tempNode = temp;
                        D->table[i] = temp->next;
                }
                else{
                        while(temp->next->key != k) {
                                temp = temp->next;
                        }
                        tempNode = temp->next;
                        temp->next = tempNode->next;
                }
                D->numItems--;
        }
        else{ //key aint there.

                fprintf(stderr,"Cannot use delete()  on a non-existant key\n");
        }
}

//this function will make a Dictionary empty
//checks to see if it exists
//makeEmpty()
void makeEmpty(Dictionary D){
        for(int i = 0; i<tableSize; i++) {
                while(D->table[i] != NULL) {
                        Node temp;
                        temp = D->table[i];
                        D->table[i]=temp->next;
                        freeNode(&temp);
                        temp = NULL;
                }
        }
        D->numItems = 0;

}

//this function will print out the Dictionary
//checks to see if Dictionary is valid
//printDictionary();
void printDictionary(FILE* out, Dictionary D){
        Node temp;
        for(int i = 0; i < tableSize; i++) {
                temp = D->table[i];
                while(temp != NULL) {
                        fprintf(out, "%s %s \n", temp->key, temp->value);
                        temp = temp->next;
                }
        }
}
