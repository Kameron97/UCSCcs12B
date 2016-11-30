//Kameron Gill
//kgill2@ucsc.edu
//1476833

//this proram will create a Dictionary on a Binary Search Tree
//Used Dictionary.c that Charlie provided us

public class Dictionary implements DictionaryInterface {

//private class for Nodes.
private class Node {
String key;
String value;
Node left;
Node right;

Node(String key, String value){
  this.key = key;
  this.value = value;
  left = null;
  right = null;
}
}

private Node root;
private int numPairs;

public Dictionary(){
        root = null;
        numPairs = 0;
}

// findKey()
// returns the Node containing key k in the subtree rooted at R, or returns
// NULL if no such Node exists
private Node findKey(Node R, String key){
        if(R == null || R.key.equals(key)) {
                return R;
        }
        if(R.key.compareToIgnoreCase(key)>0) {
                return findKey(R.left,key);
        }
        else{
                return findKey(R.right,key);
        }
}


// findParent()
// returns the parent of N in the subtree rooted at R, or returns NULL
// if N is equal to R. (pre: R != NULL)
Node findParent(Node N,Node R){
        Node P = null;

        if(N != R) {
                P = R;
                while(P.left != N && P.right != N) {
                        if(N.key.compareToIgnoreCase(P.key) < 0) {
                                P = P.left;
                        }
                        else{
                                P = P.right;
                        }
                }
        }
        return P;
}
// findLeftmost()
// returns the leftmost Node in the subtree rooted at R, or NULL if R is NULL
Node findLeftmost(Node R){
        Node L = R;

        if(L != null) {
                for(; L.left != null; L = L.left) ;


        }
        return L;
}

// printInOrder()
// prints the (key, value) pairs belonging to the subtree rooted at R in order
// of increasing keys to file pointed to by out.
void printInOrder(Node R){
        if( R != null ) {
                printInOrder(R.left);
                System.out.println(R.key + " " + R.value);
                printInOrder(R.right);
        }
}

// deleteAll()
// deletes all Nodes in the subtree rooted at N.
void deleteAll(Node N){
        if( N != null) {
                deleteAll(N.left);
                deleteAll(N.right);

        }
}

// isEmpty()
// pre: none
// returns true if this Dictionary is empty, false otherwise
public boolean isEmpty(){
        return numPairs == 0;
}

// size()
// pre: none
// returns the number of entries in this Dictionary
public int size(){
        return numPairs;
}

// lookup()
// pre: none
// returns value associated key, or null reference if no such key exists
public String lookup(String key){
        Node N;
        N = findKey(root,key);

        if(N == null) {
                return null;
        }
        else{
                return N.value;
        }
}

// insert()
// inserts new (key,value) pair into this Dictionary
// pre: lookup(key)==null
public void insert(String key, String value) throws DuplicateKeyException {
        Node N, A, B;

        if (lookup(key)== null) {
                N = new Node(key, value);
                A = null;
                B = root;

                while(B != null) {
                        A = B;

                        if(B.key.compareToIgnoreCase(key)>0) {
                                B = B.left;
                        }
                        else{
                                B = B.right;
                        }
                }
                if(A ==null) {
                        root = N;
                }
                else if(A.key.compareToIgnoreCase(key)>0) {
                        A.left = N;
                }
                else{
                        A.right = N;
                }
                numPairs++;

        }

        else{
                throw new DuplicateKeyException("Error! Cannot use insert on duplicate key");
        }
}

// delete()
// deletes pair with the given key
// pre: lookup(key)!=null
public void delete(String key) throws KeyNotFoundException {
        Node N, P, S;

        if(lookup(key) != null) {
                N = findKey(root, key);

                if(N.left == null && N.right == null) {
                        if(N == root) {
                                root = null;
                        }
                        else{
                                P = findParent(N, root);
                                if(P.right == N) {
                                        P.right = null;
                                }
                                else{
                                        P.left = null;
                                }

                        }
                }
                else if(N.right == null) {
                        if(N == root) {
                                root = N.left;
                        }
                        else{
                                P = findParent(N,root);

                                if(P.right ==N) {
                                        P.right = N.left;
                                }
                                else{
                                        P.left = N.left;
                                }
                        }
                }
                else if(N.left == null) {
                        if(N == root) {
                                root = N.right;
                        }
                        else{
                                P = findParent(N,root);
                                if(P.right == N) {
                                        P.right = N.right;
                                }
                                else{
                                        P.left = N.right;
                                }
                        }

                }
                else{
                        S = findLeftmost(N.right);
                        N.key = S.key;
                        N.value = S.value;
                        P = findParent(S,N);
                        if(P.right ==S) {
                                P.right = S.right;

                        }
                        else{
                                P.left = S.right;
                        }
                }
                numPairs--;
        }
        else{
                throw new KeyNotFoundException("Error! Cannot use delete on an invalid key");
        }

}

// makeEmpty()
// pre: none
public void makeEmpty(){
        deleteAll(root);
        root = null;
        numPairs =0;
}

// toString()
// returns a String representation of this Dictionary
// overrides Object's toString() method
// pre: none
public String toString(){
        printInOrder(root);
        return "";
}
}
