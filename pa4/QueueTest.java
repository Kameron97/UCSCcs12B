class QueueTest {
public static void main(String[] args){
  Queue test = new Queue();


  System.out.println(test.isEmpty());//print true

  System.out.println(test.length());//print 0

  test.enqueue((int)2);
  test.enqueue((int)3);
  System.out.println(test.isEmpty());//print false

  System.out.println(test.length());//print 2;


 test.dequeue();
  System.out.println(test.isEmpty());//print false

  System.out.println(test.length());//print 1




}
}
