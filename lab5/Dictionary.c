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

N
