class QueueTest {
public static void main(String[] args){
  Queue test = new Queue();


  System.out.println(test.isEmpty());//print true

  System.out.println(test.length());//print 0

  test.enqueue((int)2);
  test.enqueue((int)3);
  System.out.println(test.isEmpty());//print false

  System.out.println(test.length());//print 2;


 System.out.println(test.dequeue()); //print 2
 System.out.println(test.length());//print 1;

  System.out.println(test.isEmpty());//print false

  System.out.println(test.dequeue()); //print 3

  test.enqueue((int)2);
  test.enqueue((int)3);

  System.out.println(test.peek()); //print 2

  test.dequeueAll();

  System.out.println(test.isEmpty());//print true


  for (int i =0; i<10; i++){
    test.enqueue((int)i);
  }

  System.out.println(test); //print0 1 2 3 4 5 6 7 8 9
  System.out.println(test.peek()); //print 9










}
}
