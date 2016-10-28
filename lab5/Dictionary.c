/*Kameronjeet Singh GIll
kgill2@ucsc.edu
1476833

Dictionary.c
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"


typedef struct NodeObj{
  int key;
  int value;
  struct NodeObj* next;
} NodeObj;

typedef NodeObj* Node;

Node newNode(int k, int v){
  Node N = malloc(sizeof(NodeObj));
  assert(n!=NULL);
  N->key = k;
  N->value = v;
  N->next = NULL;
  return(N);
}

void freeNode (Node* pN){
    if(pN !=NULL && *pN != NULL){
      free(*pN);
      *pN = NULL;
    }
}

typedef struct Dictionary{
    Node top;
    int numItems;
}Dictionary;


Dictionary newDictionary(void){
    Dictionary S = malloc(sizeof(DictionaryObj));
    assert(S != NULL);
    S->top = NULL;
    S->numItems = 0;
    return S;
}

void freeDictionary(Dictionary* pD){
    if(pD != NULL && *pD != NULL){
      if( !isEmpty(*pD)) makeEmpty(*pD);
        free(*pD);
      *pD = NULL;
    }
}
