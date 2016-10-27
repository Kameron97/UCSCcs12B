/*
   Kameronjeet Gill
   Kgill2@ucsc.edu
   1476833

   This program will create an ADT list and do various functions.
 */



public class Dictionary implements DictionaryInterface {
private class Node {
String key;
String value;
Node next;
//Creating the imputs of the ADT, will take in two String inputs. and also a Node that is equal to null.
Node (String key, String value){
        this.key = key;
        this.value = value;
        next = null;
}
}
//two private value for the ADT that will control the Node and size.
private Node head;
private int items;

//pre-sets the ADT equal to null and size to 0.
public Dictionary(){
        head = null;
        items = 0;
}

//function that will check if the ADT is empty or equal to zero.
public boolean isEmpty(){
        return items ==0;
}
//This function returns items, which keeps tracks of stuff inside the ADT and reutrns it.
public int size(){
        return items;
}
//this function will see if a certain word is in the ADT and return the value it is located or null.
public String lookup(String key){
        Node temp = head;

        while(temp != null) {   //checks to see if the ADT is null, base case.
                if (temp.key.equals(key)) {   //if current place of temp is equal to key, it returns the value it is located at.
                        return temp.value;
                }
                temp= temp.next;          //moves the ADT forward f temp.key is not equal to key.
        }
        return null;
}
//this function will insert  the two String values at the end of the ADT.
public void insert(String key, String value) throws DuplicateKeyException {
        if(lookup(key) == null) { //checks to see if the ADT already has the key value
                if(head == null) {    //inserts the key and value at the head of the ADT if its empty.
                        Node temp = new Node(key,value);
                        head = temp;
                        items++;
                }
                else{
                        Node temp = head;
                        while( temp != null) {    //goes through the ADT until it reaches the end
                                if(temp.next == null) {
                                        break;
                                }
                                temp = temp.next;

                        }
                        temp.next = new Node (key,value);   //inserts new value for the ADT
                        items++;                            //increments the size counter for this function.
                }
        }
        else
                throw new DuplicateKeyException("cannot insert duplicate keys");  //since key is already there, throws DuplicateKeyException error


}
//this function will delete a key in the ADT
public void delete(String key) throws KeyNotFoundException {
        if (lookup(key) != null) {      //checks to see is the key value is in the ADT
                if (items == 1) { ///if the size of the list is 1, then it will delete that key.
                        Node temp = head;
                        head = head.next;
                        temp.next = null;
                        items--;
                }
                else {
                        Node temp = head;
                        if(temp.key.equals(key)) {    //checks to see if current position of temp equals key.
                                head = temp.next;

                        }
                        else{
                                while(!temp.next.key.equals(key)) { //while key is not found in the ADT it will go through the ADT
                                        temp = temp.next;
                                }
                                temp.next = temp.next.next;   //once temp.next is equal to the key, it will skip over the next value to the one next to it



                        }
                        items--;    //increments the size of the ADT to the correct size once delete finishes.
                }


        }
        else
                throw new KeyNotFoundException("cannot insert dublicate key");
}


//this function will empty the ADT
public void makeEmpty(){
        items =0;     //sets size to 0 and makes the ADT equal to null.
        head =null;

}
//print style for the ADT
public String toString(){
        String list = "";     //empty String list, which will keep track of values/keys
        Node temp = head;
        while(temp !=null) {
                list+= temp.key + " "+ temp.value + "\n";   //basically print it with key  value on different lines.
                temp = temp.next;
        }
        return list;
      }

}
