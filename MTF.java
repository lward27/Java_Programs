import java.util.*;
import java.io.*;

public class MTF {
	private static final int KEY_ARRAY_SIZE = 100000;
	private Link head;
    private Link tail;
    private int size;
    private int [] keys;
    private int entry_number;
    private int number_comparisons;
    private PrintStream output;
    public MTF()
    {
        head = null;
        tail = null;
        size = 0;
        keys = new int[KEY_ARRAY_SIZE];
        entry_number = 0;
        number_comparisons = 0;
    }

/////////////////////////////////////////////////////////////////////////////////
    
    class Link
    {
    	private int key;
    	private String value;
    	private Link next;
    	private Link before;
    	
    	public Link(int _key, String _value)
    	{
    		this(_key, _value, null, null);
    	}	
    	
    	public Link(int _key, String _value, Link _next, Link _before)
    	{
    			key = _key;
    			value = _value;
    			next = _next;
    			before = _before;
        }  
        
        public Link getNext() {return next;}    
        public Link getBefore() {return before;}    
        public void setNext(Link newNode) {next = newNode;}
        public void setBefore(Link newNode) {before = newNode;}
        public String getValue() {return value;}
        public int getKey() {return key;}
    }
    
    public int find(int k)
    {
    	
    	if(head == null) // List is empty
    		return 0;
    	
    	else
    	{
    		//System.out.println("im here");
    		Link pos = head;
    		int l = 0;
    		while(l < size)
    		{
    			if(head.getKey() == k)
    			{
    				return number_comparisons+=l;
    			}
    			else if(tail.getKey() == k)
    			{
    				Link newTail = tail.before;
    				Link newHead = tail;
    				newHead.next = head;
    				head.before = newHead;
    				newHead.before = newTail;
    				newTail.next = newHead;
    				tail = newTail;
    				head = newHead;
    				return number_comparisons+=l;
    			}
    			else if(pos.getKey() == k)
    			{
    				Link newHead = pos;
    				pos.before.next = pos.next;      //removes the
    				pos.next.before = pos.before;    //dictionary entry
    				newHead.next = head;
    	            newHead.before = tail;
    	            head.before = newHead;           //adds removed entry to front
    	            tail.next = newHead;
    	            head = newHead;
    				return number_comparisons+=l;
    			}
    			pos = pos.next;
    			l++;
    			
    		}
    	}
    	return 0; //Dictionary does not contain this key
    
    }
    
    public int size()
    {
    	return size;
    }
    
    public int keyArraySize(int [] array)
    {
    	return array.length;
    }
    
    public boolean isEmpty()
    {
    	return head == tail;
    }

    public boolean put(int k, String value)
    {
    	keys[entry_number] = k;
    	entry_number++;
    	
    	if(head == null)//list is empty
        {
            head = new Link(k, value);
            tail = head;
            size++;
            return true;
        }  
        
        else if(size == 1)//list contains one element
        {
        	if(head.getKey() == k)
        		return false;
        	else
        	{
        		tail = new Link(k, value);
        		head.next = tail;
        		head.before = tail;
        		tail.before = head;
        		tail.next = head;
        		size++;
        		return true;
        	}
        }
    	
    	
        
        else if(checkKey(k) == false)//list of n elements
        {
            Link newtail = new Link(k, value);
            tail.next = newtail;
            newtail.before = tail;
            newtail.next = head;
            head.before = newtail;  
            tail = newtail;
            size++;
            return true;
        }
        
        else {return false;}
    }
    
    public boolean checkKey(int k)
    {
    	Link pos = head;
		int j = 0;
		while(j < size)
		{
			if(pos.getKey() == k)
			{
				return true;
			}
			pos = pos.next;
			j++;
		}
		return false;
    }
    
    private void show(Link pos)
    {
    	try
    	{
    		output = new PrintStream("output.txt");
    	}
    	catch (FileNotFoundException e)
    	{
    		System.out.println("Output file could not be written");

        }
        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        if(head == tail)
        {
            System.out.print(head.getKey());
            System.out.print("    ");
            System.out.println(head.getValue());
            output.println(head.getKey() + "    " + head.getValue());
            return;
        }
        while(pos != tail)
        {
            System.out.print(pos.getKey());
            System.out.print("    ");
            System.out.println(pos.getValue()); 
            output.println(pos.getKey() + "    " + pos.getValue());
            //show(pos.next);
            pos = pos.next;
        }
        System.out.print(tail.getKey());
        System.out.print("    ");
        System.out.println(tail.getValue());
        output.println(tail.getKey() + "    " + tail.getValue());

    }
    
    public void show()
    {
    	show(head);
    }
    
    public String printArray(int[] array)
    {
    	String s = "[";
    	for(int i = 0; i < entry_number; i++)
    	{
    		if(i > 0) s += ", ";
    		s += array[i];
    	}
    	return s + "]";
    }
    
    public int[] getKeyArray()
    {
    	return keys;
    }
    
    public static void getFile(MTF dictionary)
    {
    	try
        {
        	Scanner fileInput = new Scanner(new File("Zipf-large.dat"));
                    while(fileInput.hasNextLine())
                    {
                    	processLine(fileInput.nextLine(), dictionary);
                    }
        }
        catch(FileNotFoundException e)
        {
        	System.out.println("File does not exist");
        }
    }
    
    public static void processLine(String line, MTF dictionary)
    {
    	Scanner lineInput = new Scanner(line);
    	String value = "";
    	int key = lineInput.nextInt();
    	value = lineInput.next();
    	dictionary.put(key, value);
    	//System.out.println(line);
    }
    

    
    public static void main (String[] args) 
    {
        MTF dictionary = new MTF();
        getFile(dictionary);
        int keys_dup[] = dictionary.getKeyArray();
        int j = dictionary.keyArraySize(keys_dup);
        System.out.println(j);
        

        
        for(int i = 0; i < j; i++ )
        {
        	
        	if(i % 1000 == 0)
        	{
				//System.out.println(i);
        		//System.out.print("   ");

        		System.out.println(dictionary.find(keys_dup[i]));
        	}
        	else
        	{
        		dictionary.find(keys_dup[i]);
        	}

       	
        }
        dictionary.show();
    }
}
















