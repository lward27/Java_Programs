import java.util.AbstractList;
/**
 * single circulartly linked list implementation of java.util.List.
 */
public class LinkedLyst<T> //extends AbstractList<T>
{
  private int size;
  private Node<T> last;
  //nested class aka inner class definition
  private class Node<T> 
  {    
    public T cargo;
    public Node<T> next;        
  }
  
 /*public LinkedList()
  {
    
  }*/
  
  public void addtoFront(T obj)
  {
    Node<T> newNode = new Node<T>();
    newNode.cargo = obj;
    newNode.next = last;
    last = newNode;
    size++;
  }
  
  public boolean add(T obj)
  {
    Node<T> interloper = new Node<T>();
    interloper.cargo = obj;
    interloper.next = last.next;
    last.next = interloper;
    last = interloper;
    //find last node
    //create a new node, give it obj
    //attach new node to the last node
    // If list is currently empty
    if(last == null)
    {
      last = interloper;
      interloper.next = interloper;

    }
    
    //otherwise
    else
    {
      //find last node
      Node<T> curr = last;
      while(curr.next == null)
      {
        curr = curr.next;
      }
      //create a new node, give it obj
      curr.next = interloper;
      //attach new node to the last node
      curr.next.cargo = obj;
    }
    size++;
    return true;

  }

  public boolean add(int index, T obj)
  {
    Node<T> newNode = new Node<T>();
    newNode.cargo = obj;
    Node<T> nav = new Node<T>();
    newNode.next = nav.next;
    nav.next = newNode;
    size++;
    return true;
  }
  
  public int size()
  {
    
    return size;
  }
  
  public String toString()
  {
    String result = "[";
    Node<T> ptr = last.next;
    while(ptr != last)
    {
      result += ptr.cargo;
      result += ",";
      ptr = ptr.next;
    }
    return result + "]";
  }
 
  /*public boolean isEmpty();
  {
    if(last == null)
    {
      return True;
    }
  }*/
  
  /*public T remove ( int n ) throws IndexOutOfBoundsException
  {
    int num = size();
    if ( n > num )
    {
      throw new IndexOutOfBoundsException("index " + n + " size: " + num);
    }
    switch (num)
    {
      case 0:
      case 1:
        T removee = last.cargo;
        last = null;
        return removee;
      
      default:
    
    // find n-1 node
        Node<T> curr = last;
        int i = 0;
        while ( i < n )
        {
          curr = curr.next;
          i++;
        }
        curr.next = curr.next.next;
    }
    
    // reassign next to following node

    // return element at posistion n
    
    // throw exception if n is out of bounds

    
  }*/

  
  
  
}
