//Queue.java


public class Queue implements QueueInterface {

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

//checks to see if the Node is empty
public boolean isEmpty(){
        return numItems == 0;
}
//check to see how many inputs are in the Node
public int length(){
        return numItems;
}

//places an object at the top of the Node
public void enqueue(Object newItem){
        if( head == null) {
                head = new Node(newItem);
                numItems++;
        }
        else{
                Node temp = head;
                while( temp.next !=null)
                        temp= temp.next;

                temp.next = new Node(newItem);
                numItems++;
        }
}



//remove item from the top of the Node
//also return Object.
public Object dequeue() throws QueueEmptyException {

        if(head == null) {
                throw new QueueEmptyException("Cannot use dequeue on empty Queue.");
        }
        else{
                Node temp = head;
                head = temp.next;
                numItems--;
                return temp.item;

        }
}
//return object found at top of the Node.
public Object peek() throws QueueEmptyException{
  if (head ==null){
      throw new QueueEmptyException("cannot use peek on empty Queue");
  }
    Node temp = head;
  return temp.item;
}

public void dequeueAll() throws QueueEmptyException{
    if (head == null){
        throw new QueueEmptyException("cannot use dequeueAll on empty Queue");
    }
    head = null;
    numItems = 0;
}

public String toString(){
    String word ="";

    while( head != null){
        word+= head.item+" ";
        head = head.next;
    }
    return word;
}



}
