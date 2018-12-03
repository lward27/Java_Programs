import java.util.AbstractList;

public class DoublelyLinkedLyst<T>
{
  private int size;
  private Node<T> first;
  private Node<T> last;
  private class Node<T>
  {
    public T cargo;
    public Node<T> next;
    public Node<T> before;
    public Node<T> curr;
    
  }
/*  public Node<T> getNext()
  {
    return next;
  }
*/  
  public void add(T obj)
  {
    /*Node<T> newNode = new Node<T>();
    newNode.cargo = obj;*/
    if(first == null)
    {
      first = new Node<T>();
      last = new Node<T>();
      first.cargo = obj;
      first.next = last;
      last.before = first;
      size++;
    }
    /*if(first.before == last)
    {
      Node<T> newNode = new Node<T>();
      newNode.cargo = obj;
      first.next = newNode;
      last.before = newNode;
      newNode.next = last;
      size++;
    }*/
    else
    {
      Node<T> pos = first;
      while(pos.getNext() != null)
      {
        pos = pos.getNext();
      }
      pos.next = new Node<T>(obj);
      /*Node<T> curr = new Node<T>();
      Node<T> newNode = new Node<T>();
      newNode.cargo = obj;
      newNode.before = curr;
      newNode.next = curr.next;
      newNode.before.next = newNode;
      //newNode.next.before = newNode;
      curr = newNode;
      size++;*/
    }
   
  }

  
  public String toString()
  {
    String result = "[";
    Node<T> ptr = first;
    int i = 1;
    while(i < size+1)
    {
      result += ptr.cargo;
      result += ",";
      ptr = ptr.next;
      i++;
    }
    return result + "]";
  }
  
  public int size()
  {
    return size;
  }
}
