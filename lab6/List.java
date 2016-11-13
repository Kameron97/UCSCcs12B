//List.java

//this is based of  IntergerList Array
public class List<T> implements ListInterface<T> {
//private items

private static final int INITIAL_SIZE = 1;
private int physicalSize;
private T[] item;
private int numItems;

@SuppressWarnings("unchecked")
public List(){
        physicalSize = INITIAL_SIZE;
        item = (T[])new Object[physicalSize];

        numItems = 0;
}

private int arrayIndex(int listIndex){
        return listIndex-1;
}

@SuppressWarnings("unchecked")
private void doubleItemArray(){
        physicalSize *=2;
        T[] newArray = (T[])new Object[physicalSize];
        for(int i=0; i<numItems; i++) {
                newArray[i] = item[i];
        }
        item = newArray;
}
//checks to see if List is empty
public boolean isEmpty(){
        return numItems ==0;
}

//checks to see size by returning
public int size(){
        return numItems;
}
//gets the item at arraylist at a certain index
//if index is not greater than 1 and index is smaller than numitems, then u can get the item at index
//otherwise error is thrown
public T get(int index) throws ListIndexOutOfBoundsException {
        if (index <1 || index > numItems) {
                throw new ListIndexOutOfBoundsException("Cannot use get(). Index is not valid");
        }
        else {
                return item[arrayIndex(index)];



        }
}

public void add(int index, T newItem) throws ListIndexOutOfBoundsException {
        if( index<1 || index>(numItems+1) ) {
                throw new ListIndexOutOfBoundsException(
                              "Cannot use function add(). Index is not valid");
        }

        if( numItems == physicalSize ) {
                doubleItemArray();
        }

        for(int i=numItems; i>=index; i--) {
                item[arrayIndex(i+1)] = item[arrayIndex(i)];
        }
        item[arrayIndex(index)] = newItem;
        numItems++;
}

public void remove(int index) throws ListIndexOutOfBoundsException {
        if ( index<1 || index >numItems) {
                throw new ListIndexOutOfBoundsException("cannot use function remove(). index is not valid");
        }
        else {
                for(int i=index+1; i<=numItems; i++) {
                        item[arrayIndex(i-1)] = item[arrayIndex(i)];
                }
                numItems--;
        }
}

public void removeAll(){
  numItems = 0;
}




}
