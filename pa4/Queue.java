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
                Node n = new Node(newItem);
                head = n;
                head.next = null;
                numItems++;
        }
        else{
                while (head != null)
                head = head.next;

                        if( head == null) {
                                Node n = new Node(newItem);
                                head = n;
                                head.next = null;
                                numItems++;
                        }
                //head = head.next;
        }

}

public void dequeue()throws QueueEmptyException{
  //  Node n = head;

    if(head == null){
      throw new QueueEmptyException("Cannot use dequeue on empty Queue.");
    }

    else {
      while(!(head.next == null)){
        head = head.next;

      }
      if (head.next == null){
        head = head.next;
        numItems--;

      }

    }
}


}
