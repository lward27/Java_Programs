public class Hashtable<T>// implements Iterable<T>
{
  private T[] backbone;
  public static final int LENGTH = 10;
  private static final int STEP = 2;
  private int size;
  
  public Hashtable()
  {
    backbone = (T[])(new Object[LENGTH]);
    size = 0;
  }
  
  /*public Iterator<Integer> iterator()
  {
    return new MyIterator();
  }
  
  private static class MyIterator implements Iterator<Interger>
  {
    
  }*/
  
  public boolean isEmpty()
  {
    int i = 0;
    while(i < 10)
    {
      if(backbone[i] != null)
      {
        return false;
      }
      i++;
    }
    return true;
  }
  
  public int size()
  {
    return size;
  }
  
  public T lookup(T key)
  {
    int x = 0;
    x = key.hashCode() % 10;
    if(backbone[x] == key)
    {
      return backbone[x];
    }
    return null;
  }
  
  //Assume no collision
  //insert key into its one digit's bucket
  public void insert(T key)
  {
    int x = 0;
    x = key.hashCode() % 10;
    backbone[x] = key;
    size++;
  }
}
