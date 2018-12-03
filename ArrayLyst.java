import java.util.List;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

//public class ArrayLyst<T> implements List<T>
//{
public class ArrayLyst<T> extends AbstractList<T> 
{
  
  private T[] array;
  public static final int DEFAULT_INITIAL_CAPACITY = 10;
  private int end;
  
  public ArrayLyst ()
  {
    this(DEFAULT_INITIAL_CAPACITY);
  }
  
  public ArrayLyst( int initialCapacity )
  {
    array = (T[])(new Object[initialCapacity]);
    end = 0;
  }
  
  public boolean add(T element)
  {
    array[end] = element;
    end++;
    return true;
  }
  
  public void add(int index, T element)
  {
    //shift tail elements (after index)
    //insert element after index
    while(end >= index)
    {
      array[end] = array[end++];
      end--;
    }
    array[end] = element;
  }
  
  /*public void remove(int index)
  {
    while(index <= end)
    {
      array[index++] = array[index];
      index++;
    }
  }*/
  
  private void increaseCapacity()
  {
    int newCapacity = policy();
    T tempArray = array[policy()];
    // allocate an empty array of that length
    //copy the element into the new array
    //reassign the new array into the array field
  }
  
  private int policy() 
  {
    return 2*array.length;
  }
  
  public boolean isEmpty()
  {
    return end == 0;
  }
  
  public int size()
  {
    return end;
  }
  
  public T get(int index)throws IndexOutOfBoundsException 
  {
    return array[index];
  }
  
  public T set(int index, T element)throws IndexOutOfBoundsException
  {
    T temp = array[index];
    array[index] = element;
    return temp;
  }
  
  public Iterator<T> interator()
  {
    return new MyIterator();
  }
  
  private class MyIterator implements Iterator<T>
  {
    
    private int index;
    private final NoSuchElementException NO_ELEMENT = new NoSuchElementException();
    
    public T next()
    {
      return array[index++];
    }
    
    public boolean hasNext()
    {
      return index < array.length;
    }
    
    public void remove() throws IllegalStateException
    {
      
    }
  }
  
 
  /*public String toString()
  {
    //return "[]";
    int n = 0;
    while(n <= end)
    {
      if(n == 0)
      {
        System.out.print("[", array[n], ", ");
      }
    }
  }*/
  
}
