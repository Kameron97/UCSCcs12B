//Kameronjeet Singh Gilll
//1476833
//kgill2@Ucsc.edu

//this is based of  IntergerList Array
//most of the functions are based on the code given by Charlie on IntergerList Array
@SuppressWarnings("overrides")
class List<T> implements ListInterface<T> {

//private functions
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
//checks to see if List is empty by seeing if numItems is 0.
public boolean isEmpty(){
        return numItems ==0;
}

//checks to see size by returning numItems.
public int size(){
        return numItems;
}
//gets the item at arraylist at a certain index
//if index is not greater than 1 and index is smaller than numitems, then u can get the item at index
//otherwise error is thrown
public T get(int index) throws ListIndexOutOfBoundsException {
        if (index <1 || index > numItems) {
                throw new ListIndexOutOfBoundsException("get(): invalid index:"+ index);
        }
        else {
                return item[arrayIndex(index)];
        }
}
//this functions is responsible for adding an T object on
public void add(int index, T newItem) throws ListIndexOutOfBoundsException {
        if( index<1 || index>(numItems+1) ) { //checks to see if index is negative or if index is bigger than items in the arraylist
                throw new ListIndexOutOfBoundsException("Cannot use function add(). Index is not valid");
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

//this function will remove the value at a certain index and append the arraylist to continue on
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
//removes all element
public void removeAll(){
        numItems = 0;
        item = null;
}
public String toString(){
        String word="";
        for(int i=0; i<numItems; i++) {
                word += item[i]+ " ";
        }
        return word;
}

@SuppressWarnings("unchecked")
public boolean equals(Object rhs){
        boolean eq =false;
        List<T> R = null;

        if(this.getClass() == rhs.getClass()) {
                int i=0;
                R = (List<T>)rhs;
                eq = (this.numItems == R.numItems);
                while( eq && i<numItems) {
                        eq = (this.item[i] == R.item[i]);
                        i++;
                }
        }
        return eq;
}
}
