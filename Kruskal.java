import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class will calculate the minimum spanning tree of an
 * undirected graph using Kruskal's algorithm and heap data structure
 * @author Lucas Ward
 * @version 1.0
 */
public class Kruskal {
	private static final int ADJACENCY_LIST_ARRAY_SIZE = 1000;
	private static final int HEAP_ARRAY_SIZE = 5000;
	private Edge [] heap;
	private Edge [] adjacencyList;
	private static Edge [] mstArray;
	Edge [] mstPrintArray;
	private int [] adjacencyListCount;
	private static int size;
	private static int numVertices;
	
	/**
	 * Initializes arrays used in program.
	 */
	public Kruskal() {
		adjacencyList = new Edge[ADJACENCY_LIST_ARRAY_SIZE];
		adjacencyListCount = new int[ADJACENCY_LIST_ARRAY_SIZE];
		heap = new Edge[HEAP_ARRAY_SIZE];
		mstPrintArray = new Edge[ADJACENCY_LIST_ARRAY_SIZE];
		size = 0;
		for(int i = 0; i < ADJACENCY_LIST_ARRAY_SIZE; i++)
			adjacencyListCount[i] = 0;
	}
	
	/**
	 * This class Creates and constructs an edge object.
	 * @author Lucas Ward
	 */
	class Edge {
		private double weight;
		private int vertex1;
		private int vertex2;
		private Edge next;
		private int count;
		//private int flag; //0 for not in MST, 1 if contained in MST;
		
		public Edge(double _weight, int _vertex1, int _vertex2) { 
			this(_weight, _vertex1, _vertex2, null, 0);
		}
		
		
		public Edge(double _weight, int _vertex1, int _vertex2, Edge _next, int _count) {
			weight = _weight;
			vertex1 = _vertex1;
			vertex2 = _vertex2;
			next = _next;
			count = _count;	
		}
		
		public double getWeight() { return weight; }
		public int getVertex1() { return vertex1; }
		public int getVertex2() { return vertex2; }
		public Edge getNext() { return next; }
		public void setNext(Edge newEdge) { next = newEdge; }
	}
					   //////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////Adjacency List Functions///////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				   //////////////////////////
	/**
	 * Adds the edge to the Adjacency List using the first vertex as an index to the array.
	 * @param vertex1
	 * @param vertex2
	 * @param weight
	 * @param mst
	 */
	public static void addToAListV1(int vertex1, int vertex2, double weight, Kruskal mst) {
		Edge newEdge = mst.new Edge(weight, vertex1, vertex2);
		
		if(mst.adjacencyListCount[vertex1] == 0) {
			//System.out.println("i'm here0");
			mst.adjacencyList[vertex1] = newEdge;
			newEdge.next = null;
			mst.adjacencyListCount[vertex1]++;
		}
		else if(mst.adjacencyListCount[vertex1] != 0) {
			//System.out.println("i'm here1");
			Edge pos = mst.adjacencyList[vertex1];
			for(int i = 1; i < mst.adjacencyListCount[vertex1]; i++)
				pos = pos.next;
			pos.next = newEdge;
			newEdge.next = null;
			mst.adjacencyListCount[vertex1]++;
		}
	}	
	
	/**
	 * Adds the edge to the Adjacency List using the first vertex as an index to the array
	 * @param vertex1
	 * @param vertex2
	 * @param weight
	 * @param mst
	 */
	public static void addToAListV2(int vertex1, int vertex2, double weight, Kruskal mst) {
		Edge newEdge = mst.new Edge(weight, vertex1, vertex2);
		
		if(mst.adjacencyListCount[vertex2] == 0) {
			//System.out.println("i'm here2");
			mst.adjacencyList[vertex2] = newEdge;
			newEdge.next = null;
			mst.adjacencyListCount[vertex2]++;
		}
		else if(mst.adjacencyListCount[vertex2] != 0) {
			//System.out.println("i'm here3");
			Edge pos1 = mst.adjacencyList[vertex2];
			for(int i = 1; i < mst.adjacencyListCount[vertex2]; i++)
				pos1 = pos1.next;
			pos1.next = newEdge;
			newEdge.next = null;
			mst.adjacencyListCount[vertex2]++;
		}
	}
					   ///////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////Heap Data Structure Functions//////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				   ///////////////////////////////
	
	/**
	 * Adds the edge into the heap. Partial ordered by weight
	 * @param _weight
	 * @param _vertex1
	 * @param _vertex2
	 * @param mst
	 */
	public static void heapInsert(double _weight, int _vertex1, int _vertex2, Kruskal mst) {
		Edge e = mst.new Edge(_weight, _vertex1, _vertex2);
		mst.heap[size] = e;
		/*mst.heap[size].weight = _weight;
		mst.heap[size].vertex1 = _vertex1;
		mst.heap[size].vertex2 = _vertex2;*/
		size++;
		upHeap(mst, size-1);
	}
	
	/**
	 * Used in the heapInsert method to sort edges according to weight
	 * @param mst
	 * @param i
	 */
	public static void upHeap(Kruskal mst, int i) {
		if(i > 0) {
			if(mst.heap[(i-1)/2].weight > mst.heap[i].weight) {
				if(mst.heap[i].vertex1 < mst.heap[i].vertex2) {
					Edge temp = mst.new Edge(mst.heap[i].weight, mst.heap[i].vertex1, mst.heap[i].vertex2);
					mst.heap[i] = mst.heap[(i-1)/2];
					mst.heap[(i-1)/2] = temp;
					upHeap(mst, (i-1)/2);
				}
				else {
					Edge temp = mst.new Edge(mst.heap[i].weight, mst.heap[i].vertex2, mst.heap[i].vertex1);
					mst.heap[i] = mst.heap[(i-1)/2];
					mst.heap[(i-1)/2] = temp;
					upHeap(mst, (i-1)/2);
				}
			}
		}
	}
	
	/**
	 * This program deletes the root node of the heap, which is the 
	 * edge with the smallest weight.
	 * @param mst
	 * @return returns and Edge e to be added to the MST
	 */
	public static Edge heapDeleteMin(Kruskal mst) {
		Edge e = mst.heap[0];
		size = (size-1);
		mst.heap[0] = mst.heap[size];
		mst.heap[size] = null;
		downHeap(mst, 0);
		return e;
	}
	
	/**
	 * Used to assist the heapDeleteMin function in keeping the heap sorted.
	 * @param mst
	 * @param m
	 */
	public static void downHeap(Kruskal mst, int m) {
		int i = 0;
		if(((2*m)+2) < size) { // both children exist 
			if(mst.heap[(2*m)+2].weight <= mst.heap[(2*m)+1].weight)
				i = ((2*m)+2);
			else
				i = ((2*m)+1);
		}
		else if(((2*m)+1) < size) // only the left child exists
			i = ((2*m)+1); // at this stage, if i = 0, then the node has no children
		if((i > 0) && (mst.heap[m].weight > mst.heap[i].weight)) {
			Edge temp = mst.new Edge(mst.heap[m].weight, mst.heap[m].vertex1, mst.heap[m].vertex2);
			mst.heap[m] = mst.heap[i];
			mst.heap[i] = temp;
			downHeap(mst, i);
		}
	}
					   ///////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////Up-Tree Data Structure Operations//////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				   ///////////////////////////////////
	
	/**
	 * Creates the edge to be added to the upTree used to calculate MST.
	 * @param vertex
	 * @param mst
	 * @return returns Edge to be added.
	 */
	public static Edge makeSet(int vertex, Kruskal mst) {
		Edge e = mst.new Edge(0.0, vertex, -1, null, -1);
		return e;
	}
	
	/**
	 * Find operation of up-Tree.
	 * @param e
	 * @return returns Edge e.
	 */
	public static Edge find(Edge e) {
		while(e.next != null)
			e = e.next;
		return e;
	}
	
	/**
	 * Maintains connected components and tests for loops.
	 * @param s
	 * @param t
	 * @return returns root node to new combined up-Tree.
	 */
	public static Edge union(Edge s, Edge t) {  // s and t are the roots of two sets
		if(s.count <= t.count) {
			mstArray[s.vertex1].count = (mstArray[s.vertex1].count + mstArray[t.vertex1].count);
			mstArray[t.vertex1].count = -(mstArray[t.vertex1].count);
			mstArray[s.vertex1].next = null;
			mstArray[t.vertex1].next = mstArray[s.vertex1];
			//System.out.printf("Edge U is the new root and has count %d, Edge V has count %d\n", mstArray[s.vertex1].count, mstArray[t.vertex1].count);
			return s;
		}
		else {
			mstArray[t.vertex1].count = (mstArray[s.vertex1].count + mstArray[t.vertex1].count);
			mstArray[s.vertex1].count = -(mstArray[s.vertex1].count);
			mstArray[t.vertex1].next = null;
			mstArray[s.vertex1].next = mstArray[t.vertex1];
			//System.out.printf("Edge V is the new root and has count %d, Edge U has count %d\n", mstArray[t.vertex1].count, mstArray[s.vertex1].count);
			return t;
		}
	}
				       /////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////Kruskal's Algorithm////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
				   /////////////////////
	
	/**
	 * builds empty MST array, initializes all vertex count values to -1.
	 * @param mst
	 */
	public static void makeMSTArray(Kruskal mst) {
		int pos = 0;
		while(mst.adjacencyList[pos] != null)
			pos++;
		
		numVertices = pos;
		mstArray = new Edge[numVertices];
		
		for(int i = 0; i < pos; i++) {
			Kruskal.mstArray[i] = makeSet(i, mst);
			mstArray[i].count = -1;
		}
	}
	
	/**
	 * Builds to Minimus Spanning tree using an Array representation
	 * and an up-Tree to keep track of connected components.
	 * @param mst
	 * @return returns Root Edge of up-Tree.
	 */
	public static Edge kruskalMST(Kruskal mst) {
		Edge e = null;
		makeMSTArray(mst);
		int components = numVertices;

		while(components > 1) {
			e = Kruskal.heapDeleteMin(mst);
			Edge u = makeSet(e.vertex1, mst);
			Edge v = makeSet(e.vertex2, mst);
			Edge U = find(mstArray[u.vertex1]);
			Edge V = find(mstArray[v.vertex1]);
			
			if(U != V) {
				union(U,V);
				components = components -1;
			}
		}
		return e;
	}
					   ///////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////File Retrieval and Processing//////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
				   ///////////////////////////////
	/**
	 * Retrieves file from work space for review.
	 * @param mst
	 */
	public static void getFile(Kruskal mst) {
    	try {
        	Scanner fileInput = new Scanner(new File("graph1-input.txt"));
            while(fileInput.hasNextLine())
            	processLine(fileInput.nextLine(), mst);
        }
        catch(FileNotFoundException e) {
        	System.out.println("File does not exist");
        }
    } 
    
	/**
	 * process line from file to obtain weight, vertex1, and vertex2 of edges.
	 * @param line
	 * @param mst
	 */
    public static void processLine(String line, Kruskal mst) {
    	Scanner lineInput = new Scanner(line);
    	int vertex1 = lineInput.nextInt();
    	if(vertex1 != -1) {
    		int vertex2 = lineInput.nextInt();
    		double weight = lineInput.nextDouble();
    		Kruskal.addToAListV1(vertex1, vertex2, weight, mst);
    		Kruskal.addToAListV2(vertex1, vertex2, weight, mst);
    		Kruskal.heapInsert(weight, vertex1, vertex2, mst);
    	}
    }
    				   ///////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////Print Functions: Standard Out//////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	    
	               ///////////////////////////////
    /**
     * Displays the adjacencyList in a visual format
     * @param mst
     */
    public static void showAdjacencyList(Kruskal mst) {
    	int pos = 0;
    	while(mst.adjacencyList[pos] != null) {
    		Edge position = mst.adjacencyList[pos];
    		for(int i = 0; i < mst.adjacencyListCount[pos]; i++) {
    			System.out.print(position.vertex1 + " " + position.vertex2 + " " + position.weight + " | ");
    			position = position.next;
    		}
    		pos++;
    		System.out.println();
    	}
    }
    
    /**
     * Displays the MST in line format
     * @param mst
     */
    public static void showMST(Kruskal mst) {
    	for(int i = 0; i < numVertices; i++) {
    		if(Kruskal.mstArray[i].next == null) // root found
    			System.out.printf("%4d %4d\n", Kruskal.mstArray[i].vertex1, findRootVertex(mst));
    		else
    			System.out.printf("%4d %4d\n", Kruskal.mstArray[i].vertex1, Kruskal.mstArray[i].next.vertex1);
    	}
    }
    
    /**
     * Locates root vertex and returns value.
     * @param mst
     * @return returns value of root vertex.
     */
    public static int findRootVertex(Kruskal mst) {
    	int rootValue = 0;
    	for(int i = 0; i < numVertices; i++) {
    		if(Kruskal.mstArray[i].next == null) // root found
    			rootValue = Kruskal.mstArray[i].vertex1;
    	}
    	return rootValue;
    }
    
    /**
     * Prints number of edges per vertex in the adjacencyListArray.
     * @param mst
     */
    public static void showAdjacencyListCountArray(Kruskal mst) {
    	int pos = 0;
    	while(mst.adjacencyList[pos] != null) {
    		System.out.println(mst.adjacencyListCount[pos]);
    		pos++;
    	}
    }
    
    /**
     * Prints the heap of edges in line format.
     * @param mst
     */
    public static void showHeap(Kruskal mst) {
    	int pos = 0;
    	while(mst.heap[pos] != null) {
    		System.out.printf("%4d %4d\n", mst.heap[pos].vertex1, mst.heap[pos].vertex2);
    		pos++;
    	}
    }
    				   ////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////Main - Calls Functions/////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	    
    			   ////////////////////////
    
    /**
     * Runs program elements.
     * @param args
     */
	public static void main (String[] args) {
		Kruskal mst = new Kruskal();
		getFile(mst);
		//showAdjacencyList(mst);    ////////Remove comment to show visual representation of AdjacencyList;
		showHeap(mst);
		
		kruskalMST(mst);
		showMST(mst);
		System.out.println();
		

    }
}
