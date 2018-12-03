import java.lang.IndexOutOfBoundsException;

public class DblList<T>
{
  private Link<T> head;
  private Link<T> tail;
  private int size;
  public DblList()
  {
    head = null;
    tail = null;
    size = 0;
  }
  
////////////////////////////////////////////////////////////////////// 
  
  class Link<T>
  {
    private T cargo;
    private Link<T> next;
    private Link<T> before;
    
    public Link(T _cargo)
    {
      this(_cargo, null, null);
    }
    
    public Link(T _cargo, Link<T> _next, Link<T> _before)
    {
      cargo = _cargo;
      next = _next;
      before = _before;
    }  
    
    public Link<T> getNext() {return next;}    
    public Link<T> getBefore() {return before;}    
    public void setNext(Link<T> newNode) {next = newNode;}
    public void setBefore(Link<T> newNode) {before = newNode;}
    public T getCargo() {return cargo;}
  }
  
////////////////////////////////////////////////////////////////////// 
  
  /**
   * Returns the object at index i
   *
   * @param  i    the interger index of the obj being shown
   * @return      the obj is printed to std-out
   */

  public void get(int i) throws IndexOutOfBoundsException
  {
    if(i > size)
      throw new IndexOutOfBoundsException();
    else
    {
      Link<T> pos = head;
      int j = 0;
      while(j < i)
      {
        pos = pos.next;
        j++;
      }
      System.out.println(pos.getCargo());
    }
  }
  
//////////////////////////////////////////////////////////////////////
  
  /**
   * Returns the index of the desired object
   *
   * @param  obj  the object that you want the index of
   * @return      returns index
   */

  public int indexOf(T obj)
  {
    Link<T> pos = head;
    int j = 0;
    while(j < size)
    {
      while( pos.getCargo().equals(obj) )
      {
        return j;
      }
      j++;
    }
    return -1;
  }
  
//////////////////////////////////////////////////////////////////////
  
  /**
   * Returns the index of the last occurance of the desired obj
   *
   * @param  obj  the object that you want the last occurance index of
   * @return      returns index
   */
  
  public int lastIndexOf(T obj)
  {
    Link<T> pos = tail;
    int i = size;
    while(pos != head)
    {
      i--;
      while(pos.getCargo().equals(obj))
      {
        return i;
      }
      pos = pos.before;
    }
    return -1;
  }
  
//////////////////////////////////////////////////////////////////////
  
  /**
   * Returns true if the object in question is in the Doubley Linked List
   *
   * @param  obj  the object in question
   * @return      true if the Doubley Linked List contains the object and false if not
   */
  
  public boolean equalz(T obj)
  {
    Link<T> pos = head;
    int j = 0;
    while(j < size)
    {
      while( pos.getCargo().equals(obj) )
      {
        return true;
      }
      pos = pos.next;
      j++;
    }
    return false;
  }
  
////////////////////////////////////////////////////////////////////// 
  
  /**
   * Adds a new object to the end of the Doubley Linked List
   *
   * @param  obj  The object to be added to the Doubley Linked List
   */
  
  public void add(T obj)
  {
    if(head == null)//list is empty
    {
      head = new Link<T>(obj);
      tail = head;
    }  
    
    else if(size == 1)//list contains one element
    {
      tail = new Link<T>(obj);
      head.next = tail;
      head.before = tail;
      tail.before = head;
      tail.next = head;
    }
    
    else//list of n elements
    {
      Link<T> newtail = new Link<T>(obj);
      tail.next = newtail;
      newtail.before = tail;
      newtail.next = head;
      head.before = newtail;  
      tail = newtail;
    }      
    size++;
  }
  
//////////////////////////////////////////////////////////////////////  
  
  /**
   * Adds a new object to the front of the Doubley Linked List
   *
   * @param  obj  The object to be added to the front of the Doubley Linked List.
   */
  
  public void addtoFront(T obj)
  {
    if(head == null)
    {
      head = new Link<T>(obj);
      tail = head;
    }
    
    else if(size == 1)
    {
      Link<T> tmp = new Link<T>(obj);
      tail = head;
      head = tmp;
      head.next = tail;
      head.before = tail;
      tail.next = head;
      tail.before = head;
    }
    
    else
    {
      Link<T> newHead = new Link<T>(obj);
      newHead.next = head;
      newHead.before = tail;
      head.before = newHead;
      tail.next = newHead;
      head = newHead;      
    }
    size++;
  }
  
////////////////////////////////////////////////////////////////////// 
  
  /**
   * Removes the object at specified index
   *
   * @param  i    the interger index of the object being removed
   */
  
  public void remove(int i) throws IndexOutOfBoundsException
  {
    if(i > size)
      throw new IndexOutOfBoundsException();
    if(i == 0)
    {
      head = head.next;
      head.before = tail;
      tail.next = head;
      size--;
    }
    if(i == size - 1)
    {
      tail = tail.before;
      tail.next = head;
      head.before = tail;
      size--;
    }
    else
    {
      Link<T> pos = head;
      int j = 0;
      while(j < i)
      {
        pos = pos.next;
        j++;
      }
      pos.before.next = pos.next;
      pos.next.before = pos.before;
      size--;
    }    
  }
  
//////////////////////////////////////////////////////////////////////
  
  /**
   * Removes the first occurance of the specified object from the Doubley Linked List
   *
   * @param  obj  the object that is to be removed
   * @return      true if the object was successfully removed and false if the object was
   *              not in the list
   */
  
  public boolean remove(T obj)
  {
    Link<T> pos = head;
    int j = 0;
    int i = size;
    while(j < i)     
    {
      if(pos == tail)
      {
        if(pos.getCargo().equals(obj))
        {
          tail = tail.before;
          tail.next = head;
          head.before = tail;
          size--;
          return true;
        }
      }
      if(pos == head)
      {
        if(pos.getCargo().equals(obj))
        {
          head = head.next;
          head.before = tail;
          tail.next = head;
          size--;    
          return true;
        }
      }
      else
      {
        while( pos.getCargo().equals(obj) )
        {
          pos.before.next = pos.next;
          pos.next.before = pos.before;
          size--;
          return true;
        }
      }
      
      pos = pos.next;
      j++;
    }
    
    
    return false;
  }
  
  
//////////////////////////////////////////////////////////////////////
  
  /**
   * Replaces the object at the specified index with a new specified object
   *
   * @param  i    the interger index of the object to be replaced
   * @param  obj  the new object that will replace the object at the specified index
   */
  
  public void set(int i, T obj) throws IndexOutOfBoundsException
  {
    if(i > size)
      throw new IndexOutOfBoundsException();
    else
    {
      Link<T> pos = head;
      int j = 0;
      while(j < i)
      {
        pos = pos.next;
        j++;
      }
      Link<T> newObject = new Link<T>(obj);
      pos.before.next = newObject;
      newObject.before = pos.before;
      pos.next.before = newObject;
      newObject.next = pos.next;
    }
  }
  
//////////////////////////////////////////////////////////////////////  
  
  /**
   * Adds a new object before the specified index
   *
   * @param  i    the index of the object that the new object will be inserted before
   * @param  obj  the object to be inserted before the index specified
   */
  
  public void insertBefore(int i, T obj) throws IndexOutOfBoundsException
  {
    if(i > size)
      throw new IndexOutOfBoundsException();
    else
    {
      Link<T> pos = head;
      int j = 0;
      while(j < i)
      {
        pos = pos.next;
        j++;
      }
      Link<T> newObject = new Link<T>(obj);
      pos.before.next = newObject;
      newObject.before = pos.before;
      newObject.next = pos;
      pos.before = newObject;
      size++;
    }
  }
  
//////////////////////////////////////////////////////////////////////   
  
  public void insertAfter(int i, T obj) throws IndexOutOfBoundsException
  {
    if(i > size)
      throw new IndexOutOfBoundsException();
    else
    {
      Link<T> pos = head;
      int j = 0;
      while(j < i)
      {
        pos = pos.next;
        j++;
      }
      Link<T> newObject = new Link<T>(obj);
      pos.next.before = newObject;
      newObject.next = pos.next;
      pos.next = newObject;
      newObject.before = pos;
      size++;
    }
  }
  
//////////////////////////////////////////////////////////////////////   
  
  public int size()
  {
    return size;
  }
  
//////////////////////////////////////////////////////////////////////   
  
  public boolean isEmpty()
  {
    return head == tail;
  }
  
////////////////////////////////////////////////////////////////////// 
  
  public void clear()
  {
    head = null;
    tail = null;
    size = 0;
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void subList(int fromIndex, int toIndex)
  {
    Link<T> pos = head;
    int i = 0;
    while(i < fromIndex)
    {
      pos = pos.next;
      i++;
    }
    System.out.print("[");
    while(fromIndex < toIndex - 1)
    {
      System.out.print(pos.getCargo());
      System.out.print(", ");
      pos = pos.next;
      fromIndex++;
    }
    while(fromIndex < toIndex)
    {
      System.out.print(pos.getCargo());
      System.out.println("]");
      fromIndex++;
    }
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void addAll(DblList<T> appended)
  {
    int i = 0;
    Link<T> pos = appended.head;
    while(i < appended.size())
    {
      add(pos.getCargo());
      pos = pos.next;
      i++;
    }
    //size = size + appended.size();
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void addAll(int index, DblList<T> inserted)
  {
    int i = 0;
    Link<T> pos = inserted.head;
    while(i < inserted.size())
    {
      insertBefore(index, pos.getCargo());
      pos = pos.next;
      i++;
      index++;
    }
    //size = size + inserted.size();
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void containsAll(DblList<T> contained)
  {
    
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void iterator()
  {
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void listIterator()
  {
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void listIterator(int index)
  {
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void removeAll(DblList<T> removethese)
  {
    int i = 0;
    Link<T> pos = removethese.head;
    while(i < removethese.size())
    {
      remove(pos.getCargo());
      i++;
      pos = pos.next;
    }
  }
  
//////////////////////////////////////////////////////////////////////
  
  public void retainAll(DblList<T> retainthese)
  {
  }
  
//////////////////////////////////////////////////////////////////////  
  
  private void show(Link<T> pos)
  {
    if(head == null)
    {
      System.out.println("List is Empty yo");
      return;
    }
    if(head == tail)
    {
      System.out.print("[");
      System.out.print(head.getCargo());
      System.out.println("]");
      return;
    }
    System.out.print("[");
    while(pos != tail)
    {
      System.out.print(pos.getCargo());
      System.out.print(", ");
      //show(pos.next);
      pos = pos.next;
    }
    System.out.print(tail.getCargo());
    System.out.println("]");
  }
  
////////////////////////////////////////////////////////////////////// 
  
  
  
  public void show()
  {
    show(head);
  }
  
  public static void main (String[] args) 
  {
    DblList us = new DblList<String>();
  }
}

