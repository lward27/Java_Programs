/*import java.util.List;
 import java.util.AbstractList;
 import java.util.Comparator;
 
 public class Collectionz
 {
 
 private Collectionz() {}
 
 public static <T> void sort(List<T> list)
 {
 }
 public static <T extends Comparable<? super T>> void merge ( T[] array , int left, int middle)
 {
 }
 }*/

import java.util.List;
import java.util.Comparator;

class StringLength implements Comparator <String> 
{
  
  public int compare(String left, String right)
  {    
    return left.length() - right.length();
  }
  
}

public class Collectionz
{
  
  private Collectionz(){}
  
  public static <T extends Comparable<? super T>> boolean isIncreasing(List<T> list)
  {
    T last = list.get(0);
    int n = list.size();
    for(int i = 1; i < n; i++)
    {
      if(list.get(i).compareTo(list.get(i-1)) < 0)
      {
        return false;
      }
    }
    return true;
  }
  
  public static <T extends Comparable<T>> T max(List<T> list)
  {
    int n = list.size();
    
    if(n==0) 
    {
      //throw exception
    }
    T monarch = list.get(0);
    for(int i = 1; i <n; i++)
    {
      T contender = list.get(i);
      if(monarch.compareTo(contender) < 0 )
      {
        monarch = contender;
      }
    }
    return monarch; 
  }
  
  
  public static <T extends Comparable<T>> int sequentialSearch(T key, List<T> list)
  {
    //Look for key in list, return its index or -1
    //assume list is already sorted
    T last = list.get(0);
    int n = list.size();
    for(int i = 0; i < n; i++)
    {
      if(list.get(i) == key)
      {
        return i;
      }
    }
    return -1;
  }
  
  public static <T> void sort(List<T> list)
  {
  }
  
  private static <T extends Comparable<T>> void selectionSort (T[] list){
    //left to right
    //find "smallest" element and swap it with current position
    //T currPos = list.get(0);
    for(int pos = 0; pos < list.length-1; pos++)
    {
      int goatPen = pos;
      for( int i = pos+1; i < list.length; i++)
      {
        if( list[i].compareTo( list[goatPen])< 0 ) 
        {
          goatPen = i;
        }
      }
      
      if(pos != goatPen)
      {
        T temp = list[pos];
        list[pos] = list[goatPen];
        list[goatPen] = temp;
      }
    }
  }
  
  static class DefaultComparator<T extends Comparable<? super T>>implements Comparator<T> 
  {
    public int compare (T left, T right) 
    {
      return left.compareTo(right);
    }
  }
  
  public static <T extends Comparable<T>> void insertionSort (T[] array)
  {
    insertionSort (array, new DefaultComparator<T>());
    //insertion (array, new ReverseComparator<T>() );
  }
  
  public static <T> void insertionSort(T[] array, Comparator <T> metric)
  {
    //left to right
    for(int i = array.length-2; i >= 0; i++){
      
      T temp = array[i];
      //assume trailing elements are relatively sorted.
      
      for(int j = i+1; j < array.length && metric.compare(array[j], array[i]) < 0; j++) 
      {
        //shift elements to the right until you find current element's
        //position 
        array[j-1] = array[j];
        array[j-1] = temp;
      }
      
    }
  }
  public static<T extends Comparable<? super T>> void mergeSort(T[] array)
  {
    T[] tmpArray = (T[]) new Comparable[array.length];
    mergeSort(array, tmpArray, 0, array.length - 1);
  }
  
  private static <T extends Comparable<? super T>> void mergeSort(T[] array, T[] tmpArray, int left, int right) 
  {
    if(left < right)
    {
      int center = (left + right) / 2;
      mergeSort(array, tmpArray, left, center);
      mergeSort(array, tmpArray, center + 1, right);
      merge(array, tmpArray, left, center+1, right);
    }
  }
  
  private static <T extends Comparable<? super T>> void merge(T[] array, T[] tmpArray, int leftPos, int rightPos, int rightEnd)
  {
    int leftEnd = rightPos - 1;
    int tmpPos = leftPos;
    int numElements = rightEnd - leftPos + 1;
    
    while(leftPos <= leftEnd && rightPos <= rightEnd)
    {
      if(array[leftPos].compareTo(array[rightPos]) <= 0 )
      {
        tmpArray[tmpPos++] = array[leftPos++];
      }
      else
      {
        tmpArray[tmpPos++] = array[rightPos++];
      }
    }
    while(leftPos <= leftEnd)
    {
      tmpArray[tmpPos++] = array[leftPos++];
    }
    while(rightPos <= rightEnd)
    {
      tmpArray[tmpPos++] = array[rightPos++];
    }
    for(int i = 0; i < numElements; i++, rightEnd--)
    {
      array[rightEnd] = tmpArray[rightEnd];
    }
  }
  
  public static <T extends Comparable<? super T>> void quicksort(T[] array)
  {
    quicksort(array, 0, array.length -1);
  }
  
  private static <T extends Comparable<? super T>> void quicksort(T[] array, int low, int high)
  {
    if(low + CUTOFF > high)
    {
      insertionSort(array, low);
    }
    else
    {
      int middle = (low + high) / 2;
      if(array[middle].compareTo(array[low]) < 0)
      {
        swapReferences(array, low, middle);
      }
      if(array[high].compareTo(array[low]) < 0)
      {
        swapReferences(array, low, high);
      }
      if(array[high].compareTo(array[middle]) < 0)
      {
        swapReferences(array, middle, high);
      }
      
      swapReferences(array, middle, high - 1);
      T pivot = array[high - 1];
      
      int i, j;
      for(i = low, j = high -1; ;)
      {
        while(array[++i].compareTo(pivot) < 0);
        while(pivot.compareTo(array[--j]) < 0);
        if(i >= j)
          break;
        swapReferences(array, i, j);
      }
      swapReferences(array, i, high - 1);
      
      quicksort(array, low, i - 1);
      quicksort(array, i + 1, high);
    }
  }
  
  private static <T extends Comparable<? super T>> interface PivotSelector
  {
    getPivot(T[] array);
  }
  
  private static <T extends Comparable<? super T>>
    void quicksort(T[] array, int left, int middle, PivotSelector<T> ps)
  {
  }
  int pivot = ps.getPivot(array, left, right);
}

class MedianOf3 implements PivotSelector<T>
{
  
}

quicksort(array, 0, 3214, new PivotSelector(){
  public T getPivot(T[] array, int left, int right){
    return array[left];
  }
}
          
          
          
          /*private static void quicksort(T[] array, int left, int right)
           {
           if (right - left > 0 )
           {
           int juncture = partition(array, left, right);
           quicksort(array, left, juncture);
           quicksort(array, juncture, right);
           }  
           private static <T extends Comparable<? super T>> void quickSort(T[] array)
           {
           quickSort(array, 0, array.length - 1);
           }
           private static <T extends Comparable<? super T>> void quickSort(T[] array, int low, int high)
           {
           if(low + CUTOFF > high)
           {
           insertionSort(array, low, high);
           }
           else
           {
           int middle = (low + high) / 2;
           }
           }
           }*/
          
          
          
          
          
          
          
          
          
          
          
