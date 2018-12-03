import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class BST {
	private static final int KEY_ARRAY_SIZE = 100000;
    private static int size;
    private Node [] preOrderTravArray;
    private PrintStream output;
    private Node root;

    
    public BST()
    {
    	size = 0;
    	preOrderTravArray = new Node[KEY_ARRAY_SIZE];
    	root = null;
    	for(int i = 0; i < KEY_ARRAY_SIZE; i++)
    	{
    		preOrderTravArray[i] = new Node(-1, "");
    	}
    }

	
	class Node
    {
    	private int key;
    	private String value;
    	private Node leftChild;
    	private Node rightChild;
    	
    	public Node(int _key, String _value)
    	{
    		this(_key, _value, null, null);
    	}	
    	
    	public Node(int _key, String _value, Node _left, Node _right)
    	{
    			key = _key;
    			value = _value;
    			leftChild = _left;
    			rightChild = _right;
        }  
        
        public Node getLeftSub() {return leftChild;}    
        public Node getRightSub() {return rightChild;}    
        public void setLeftSub(Node newNode) {leftChild = newNode;}
        public void setRightSub(Node newNode) {rightChild = newNode;}
        public void setKey(int keyValue) {key = keyValue;}
        public void setValue(String stringValue) {value = stringValue;}
        public String getValue() {return value;}
        public int getKey() {return key;}
    }
	
	
	
	public Node buildTree(int size, int start)
	{
		Node rootTemp = preOrderTravArray[start];
		if(start == preOrderTravArray.length - 1)
		{
			System.out.println(34);
			return rootTemp;
		}
		else if((preOrderTravArray[(start+1)].key < preOrderTravArray[start].key) && (preOrderTravArray[(start+1)].key != -1))
		{
			size = 0;
			int temp = (start+1);
			//System.out.println(start);
			while((preOrderTravArray[start+1].key != -1) && (preOrderTravArray[(temp)].key < rootTemp.key))
			{
				size++;
				temp++;
			}
			if(start == 0)
				root = rootTemp;
			rootTemp.setLeftSub(preOrderTravArray[start+1]);
			return buildTree(size, start+1);
		}
		else if((preOrderTravArray[(start+1)].key > preOrderTravArray[start].key) && (preOrderTravArray[(start+1)].key != -1))
		{
			size = 0;
			int temp = (start+1);
			while((preOrderTravArray[start+1].key != -1) && (preOrderTravArray[(temp)].key > rootTemp.key))
			{
				size++;
				temp++;
			}
			if(start == 0)
				root = rootTemp;
			rootTemp.setRightSub(preOrderTravArray[start+1]);
			return buildTree(size, start+1);
		}
		return rootTemp;
		
	}
	
	public static void getFile(Node [] preOrderArray)
    {
		int arrayIndex = 0;
    	try
        {
        	Scanner fileInput = new Scanner(new File("small.dat"));
                    while(fileInput.hasNextLine())
                    {
                    	//System.out.println(arrayIndex);
                    	Scanner lineInput = new Scanner(fileInput.nextLine());
                    	int f = lineInput.nextInt();
                    	if(f == -1)
                    	{
                    		break;
                    	}
                    	processLine(lineInput, preOrderArray, arrayIndex, f);
                    	arrayIndex++;
                    }
        }
        catch(FileNotFoundException e)
        {
        	System.out.println("File does not exist");
        }
    }
    
    public static void processLine(Scanner lineInput, Node [] preOrderArray, int arrayIndex, int f)
    {
    	//Scanner lineInput = new Scanner(line);
    	String value = "";    	
    	int key = f;
    	value = lineInput.next();
    	put(preOrderArray, key, value, arrayIndex);
    	//System.out.println(line);
    }

    public static void put(Node [] preOrderArray, int key, String value, int arrayIndex)
    {
    	preOrderArray[arrayIndex].key = key;
    	preOrderArray[arrayIndex].value = value;
    	size++;
    	
    }
	
    public static void showArray(Node [] preOrderArray)
    {
    	int i = 0;
    	while(preOrderArray[i].key != -1)
    	{
    		System.out.print(preOrderArray[i].key);
    		System.out.print("    ");
    		System.out.println(preOrderArray[i].value);
    		i++;
    	}
    }
    
    public static void preOrder(Node root)
    {
    	System.out.print(root.key);
    	System.out.print("    ");
    	System.out.println(root.value);
    	if(root.getLeftSub() != null)
    	{
    		preOrder(root.getLeftSub());
    	}
    	if(root.getRightSub() != null)
    	{
    		preOrder(root.getRightSub());
    	}
    }
    
    public static void inOrder(Node root)
    {
    	if(root.getLeftSub() != null)
    	{
    		inOrder(root.getLeftSub());
    	}
    	System.out.print(root.key);
    	System.out.print("    ");
    	System.out.println(root.value);
    	if(root.getRightSub() != null)
    	{
    		inOrder(root.getRightSub());
    	}
    }
    
    public static Node find(int k, Node p)
    {
    	if(p == null)
    		return null;
    	else if(k == p.key)
    	{
    		System.out.println(p.value);
    		return p;
    	}
    	else if(k < p.key)
    		return find(k, p.getLeftSub());
    	else
    		return find(k, p.getRightSub());
    }
    
    public static Node insert(int k, String val, Node p, BST dictionary)
    {
    	
    	if((p.getLeftSub() == null) && (k < p.key))
    	{
    		//System.out.println("i'm here");
    		Node newb = dictionary.new Node(k, val);
    		p.setLeftSub(newb);
    		return p;
    	}
    	else if((p.getRightSub() == null) && (k > p.key))
    	{
    		//System.out.println("i'm here2");
    		Node newb = dictionary.new Node(k, val);
    		p.setRightSub(newb);
    		return p;
    	}
    	else if(k < p.key)
    	{
    		return insert(k, val, p.getLeftSub(), dictionary);
    	}
    	else if(k > p.key)
    	{
    		return insert(k, val, p.getRightSub(), dictionary);
    	}
    	else
    		return p;
    }
    
    public static void delete(int key, Node p)
    {
    	if((p != null) && (p.key == key))
    	{
    		if((p.getLeftSub() == null) || p.getRightSub() == null)
    		{
    			if(p.getLeftSub() == null)
    				p = p.getRightSub();
    			else
    				p = p.getLeftSub();
    		}
    		else
    		{
    			int kPrime = leftMost(p.getRightSub()).key;
    			p.value = leftMost(p.getRightSub()).value;
    			p.key = kPrime;
    			delete(kPrime, p.getRightSub());
    		}
    	}
    	else if((p != null) && (p.key > key))
    	{
    		delete(key, p.getLeftSub());
    	}
    	else if(p != null)
    	{
    		delete(key, p.getRightSub());
    	}
    }
	
    public static Node leftMost(Node p)
    {
    	while(p.getLeftSub() != null)
    	{
    		p = p.getLeftSub();
    	}
    	return p;
    }
    
	public static void main (String[] args) 
    {
		BST dictionary = new BST();
		//put(dictionary.preOrderTravArray, 0001, "AAAA", 0);
		//showArray(dictionary.preOrderTravArray);
		getFile(dictionary.preOrderTravArray);
		//showArray(dictionary.preOrderTravArray);
		//System.out.println(size);
		dictionary.buildTree(size, 0);
		//System.out.println(dictionary.root.key);
		//System.out.println(dictionary.root.getLeftSub().key);
		//inOrder(dictionary.root);
		//System.out.println();
		//preOrder(dictionary.root);
		//System.out.println("  ");
		//inOrder(dictionary.root);
		//System.out.println(BST.find(677094528, dictionary.root).value);
		//find(739515840, dictionary.root);
		insert(990000000, "AAAAAAAAA", dictionary.root, dictionary);
		insert(100000000, "BBBBBBBBB", dictionary.root, dictionary);
		delete(524287808, dictionary.root);
		preOrder(dictionary.root);
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
