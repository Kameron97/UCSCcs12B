public class Dictionary implements DictionaryInterface {
private class Node {
String key;
String value;
Node next;

Node (String key, String value){
        this.key = key;
        this.value = value;
        next = null;
}
}

private Node head;
private int items;

public Dictionary(){
        head = null;
        items = 0;
}

private Node findKey(String key){
        Node temp = head;
        while( temp != null) {
                if(temp.key != key) {
                        temp = temp.next;
                }
                else{
                        return temp;
                }
        }
        return null;
}

public boolean isEmpty(){
        if(items ==0) {
                return false;
        }
        else
                return true;
}

public int size(){
        return items;
}

public String lookup(String key){
        Node temp = findKey(key);

        while(temp != null) {
                if (temp.key.equals(key)) {
                        return temp.value;
                }
        }
        return null;
}

public void insert(String key, String value) throws DuplicateKeyException {
        if(lookup(key) == null) {
                throw new DuplicateKeyException("cannot insert duplicate keys");
        }
        else{
                if(head == null) {
                        Node temp = new Node(key,value);
                        head = temp;
                        items++;
                }
                else{
                        Node temp = head;
                        while( temp != null) {
                                if(temp.next != null)
                                        break;
                                temp.next = new Node(key,value);
                                items++;
                        }
                }
        }

}
}
