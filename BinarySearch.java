import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch {
	private static final int DICTIONARY_SIZE = 500;
	private static final int KEY_ARRAY_SIZE = 500;
	private static final int MAX = 999999999;
	private static final int MIN = 0;
	private Entry [] dictionary;
	private int [] keys;
	private int entry_number;
	private int size;
	private int binarySearchPos;
	public BinarySearch()
	{
		dictionary = new Entry[DICTIONARY_SIZE];
		keys = new int[KEY_ARRAY_SIZE];
		size = 0;
		entry_number = 0;
	}
	
	
	class Entry
	{
		private int key;
		private String value;
		
		public Entry(int _key, String _value)
    	{
    			key = _key;
    			value = _value;
        }  
		public String getValue() {return value;}
        public int getKey() {return key;}
	}
	
	public boolean put(int k, String value)
    {
		keys[entry_number] = k;
    	entry_number++;
    	
    	
    	if(size == 0)
    	{
    		dictionary[0] = new Entry(k, value);
    		size++;
    		return true;
    	}
    	if(size == 1)
    	{
    		if(k > dictionary[0].getKey())
    		{
    			dictionary[1] = new Entry(k, value);
    			size++;
    		}
    		else
    		{
    			dictionary[1] = new Entry(dictionary[0].getKey(), dictionary[0].getValue());
    			dictionary[0] = new Entry(k, value);
    			size++;
    		}
    		return true;
    	}
    	
    	else if(binSearch(k,0,size-1, 0) == -1)
    	{
    		System.out.println("allready contains this entry");
    		return false;
    	}
    	
    	else
    	{
    		//System.out.println("im here");
    		int placeHolder = binSearch(k,0,size-1,0);
    		dictionary[size] = new Entry(0, "");
    		for(int i = size; i >= placeHolder; i--)
    		{
    			
    			dictionary[i] = dictionary[--i];
    		}
    		dictionary[placeHolder] = new Entry(k,value);
    		size++;
    		return true;
    	}
    }
    	
    	
    	
    	

    	
    	
    
	public int binSearch(int k, int low, int high, int placeHolder)
	{
		
		
		if(low > high)
		{
			return placeHolder;
		}
		else
		{
			placeHolder = (low + high)/2;
			//System.out.println(placeHolder);
			if(dictionary[placeHolder].getKey() == k)
			{
				System.out.println(dictionary[placeHolder].getValue());

				return -1;
			}
			else if(dictionary[placeHolder].getKey() < k)
			{
				return binSearch(k, placeHolder+1, high, 0);
			}
			else
				return binSearch(k, low, placeHolder-1, 0);
		}
	}
	
	public static void getFile(BinarySearch dictionary)
	{
		try
		{
			Scanner fileInput = new Scanner(new File("Zipf-small.dat"));
			while(fileInput.hasNextLine())
			{
				processLine(fileInput.nextLine(), dictionary );
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File does not exist");
		}
	}
	
	public static void processLine(String line, BinarySearch dictionary)
    {
		
    	Scanner lineInput = new Scanner(line);
    	String value = "";
    	int key = lineInput.nextInt();
    	value = lineInput.next();
    	dictionary.put(key, value);
    	//System.out.println(line);
    }

	public void show()
	{
		for(int i = 0; i < size; i++)
		{
			System.out.print(dictionary[i].getKey());
			System.out.print("    ");
			System.out.println(dictionary[i].getValue());
		}
	}
	
	public static void main (String[] args) 
    {
		BinarySearch dictionary = new BinarySearch();
		//getFile(dictionary);
		dictionary.put(01, "AA");
		System.out.println(dictionary.size);
		dictionary.put(02, "BB");
		System.out.println(dictionary.size);
		dictionary.put(03, "CC");
		//System.out.println(dictionary.size);

		//dictionary.put(04, "DD");
		//dictionary.put(05, "EE");
		//dictionary.put(06, "FF");*/
		
		//dictionary.binSearch(3, 0, dictionary.size);

		
		dictionary.show();
    }
	
}
