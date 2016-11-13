
public class ListTest {

public static void main(String[] args) {

  List<String> A = new List<String>();

  System.out.println(A.isEmpty());// print true
  System.out.println(A.size()); //print 0

//System.out.println(  A.get(2)); //throw error
A.add(1, "one");
A.add(2,"two");
System.out.println(  A.get(2)); //print two
System.out.println(A.size()); //print 2

A.remove(2);

//System.out.println(  A.get(2)); //print errors

A.removeAll();

System.out.println(A.isEmpty());// print true


}
}
