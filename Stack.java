import java.util.NoSuchElementException;

public interface Stack<E>
{
  void push(E next);
  E pop();
  E peek();
  boolean isEmpty();
}

class ArrayStack<E> implements Stack<E>
{
  private E[] array;
  private int topIndex;
  public static final int DEFAULT_CAPACITY = 10;
  private static final NoSuchElementException EMPTY_STACK = new NoSuchElementException("i'm empty. regards, stack");
  
  
  public ArrayStack()
  {
    array = (E[])(new Object[DEFAULT_CAPACITY]);
    topIndex = 0;
  }
  
  public void push(E next)
  {
    array[topIndex++] = next;
  }
  
  public E pop() throws NoSuchElementException
  {
    return array[--topIndex];
  }
  
  public E peek() throws NoSuchElementException
  {
    return array[topIndex-1];
  }
  
  public boolean isEmpty()
  {
    if(topIndex == 0)
    {
      return true;
    }
    return false;
  }
}

class LinkedListStack<E> implements Stack<E>
{
  private class Node<E>
  {
    public E cargo;
    public Node next;
  }
  
  private Node<E> top;
  public int size = 0;
  
  public void push(E obj)
  {
    if(size == 0)
    {
      Node<E> newTop = new Node<E>();
      newTop.cargo = obj;
      top = newTop;
    }
    else
    {
      Node<E> newTop = new Node<E>();
      newTop.cargo = obj;
      top.next = newTop;
      top = newTop;
    }
    size++;
  }
  
  public E pop()
  {
    int i = 1;
    Node<E> newTop = new Node<E>();
    while(i < size)
    {
      newTop = newTop.next;
      i++;
    }
    top = newTop;
    return top.cargo;
  }
  
  public E peek()
  {
    return null;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
}







