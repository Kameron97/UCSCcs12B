class DictionaryTest {
public static void main(String[] args){
  Dictionary test = new Dictionary();
  System.out.println(test.isEmpty());

  System.out.println(test.size());

  test.insert("dfdsfdsfds", "1");
  System.out.println(test.isEmpty());

  //System.out.println(test.size());
  //System.out.println(test.lookup("dfd"));
  //System.out.println(test.lookup("dfdsfdsfds"));
  test.insert("daaaaaaaaa", "3");
  test.insert("a","4");
  System.out.println(test.size());
  test.insert("ab","2");
  test.insert("bb","fffff");

  //test.delete("dddddddddddd");
  test.delete("daaaaaaaaa");
  //test.makeEmpty();
  System.out.println(test.size());

  System.out.println(test);


}
}
