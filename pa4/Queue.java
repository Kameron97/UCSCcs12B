//Queue.java
//Kameronjeet Gill
//1476833
//kgill2@ucsc.edu

//this program helps create the Node Queue and also has functions to manipulate it



public class Queue implements QueueInterface {

//private class for Queue
private class Node {
Object item;
Node next;


Node(Object item) {
        this.item = item;
        next = null;
}
}


private Node head;
private int numItems;

public Queue() {
        head = null;
        numItems = 0;
}

//checks to see if the Node is empty by checking to see if numItems is 0
public boolean isEmpty(){
        if(numItems ==0)
                return true;
        else
                return false;
}
//check to see how many inputs are in the Node by returning numItems
public int length(){
        return numItems;
}

//places an object at the top of the Node
public void enqueue(Object newItem){
        if( head != null) {
                Node temp = head;
                while(temp.next != null)    //iterates through Node temo until its finds a null.
                        temp= temp.next;

                temp.next = new Node(newItem);
                numItems++;

        }else{
                head = new Node(newItem);
                numItems++;
        }
}



//remove item from the top of the Node
//also return Object.
public Object dequeue() throws QueueEmptyException {
        if(head != null) {
                Node temp = head;
                head = temp.next;   //deletes head and replaces with the next Object in Node
                numItems--;
                return temp.item;

        }else{   //if the Queue Node is empy, and error occurs.
                throw new QueueEmptyException("Cannot use dequeue on empty Queue.");

        }
}
//return object found at top of the Node.
//if the Node Queue is empty, an error gets thrown
public Object peek() throws QueueEmptyException {
        if (head != null) {
                return head.item;
        }else
                throw new QueueEmptyException("cannot use peek on empty Queue");

}

//Just causes the Node Queue to be emptied and null
//checks to see if the queue is already null
public void dequeueAll() throws QueueEmptyException {
        if (head != null) {
                head = null;
                numItems = 0;
        }else
                throw new QueueEmptyException("cannot use dequeueAll on empty Queue");
}

//this function will print out the Node Queue.
public String toString(){
        String word ="";
        Node temp = head;

        while( temp != null) {
                word+= temp.item+" ";
                temp = temp.next;
        }
        return word;
}



}
