/*                             ______
  __                          /     /
 /     __   __ __   __       /     /
 \__  |  \ |   ||   ||      /     /
    \ |__/ |__ ||   ||     /     /
  __/ |    |__ ||__ ||__  /     /
      |                  /     /
                        /     /
         ______        /     /
         \     \      /     /  __  ___
          \     \    /     /  |   |   \
           \     \  /     /   |__ |___/     
            \     \/     /    |__ |   \
             \          /         
              \________/             
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class runs a simple spell checker on a text document and returns
 * the number of words in the dictionary, the number of words spell checked
 * (including the number of words that are ran multiple times without endings),
 * the number of probes, average number of probes per word, and the number
 * of miss spelled words.
 * @author Lucas Ward
 * @version 1.0
 */
public class SpellChecker {
	private static final int HTS = 32768; //prime number
	private static final double GR = (1+Math.sqrt(5))/2;
	private static final int R = 4;
	private Bucket [] hashTable;
	private int numberWordsInDictionary = 0;
	private static int numberWordsToBeSpellChecked = 0;
	private int numberWordsMissSpelled = 0;
	private int numberOfProbes = 0;
	
////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////// Construction and Initialization of Bucket Object //////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs empty hashTable.
	 */
	public SpellChecker() {
		hashTable = new Bucket[HTS];
	}
	
	/**
	 * The Bucket Class creates an object that stores
	 * a word, the words key (which is its integer location
	 * in the hashTable array), and a pointer to the next word
	 * in that particular location of the hashTable array.
	 * @author Lucas Ward
	 */
	class Bucket {
		private int key;     //HashCode Value after compression
		private String word; //Word (read from dictionary)
		private Bucket next; //Pointer to next word when collisions occur
		
		/**
		 * constructs a Bucket with a key and a word only
		 * @param _key the hashcode after compression
		 * @param _word the word from the dictionary being stored
		 */
		public Bucket(int _key, String _word) {
			this(_key, _word, null);
		}
		
		/**
		 * Default Constructor
		 * @param _key
		 * @param _word
		 * @param _next pointer to next word in linked list
		 */
		public Bucket(int _key, String _word, Bucket _next) {
			key = _key;
			word = _word;
			next = _next;
		}
		
		/**
		 * @return key (hashCode) of current bucket
		 */
		public int getKey() { return key; }
		
	    /**
	     * @return word of current bucket
	     */
		public String getWord() { return word; }
		
		/**
		 * @return next word pointed to by current bucket
		 */
		public Bucket getNext() { return next; }
	}

////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////// Hash Table, Hash Function, Compression, Collision Resolution //////////
////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * Sets all entries to that hashTable to default values
	 */
	public static void initializeHashTable(SpellChecker sc) {
    	for(int i = 0; i < HTS; i++) {
    		sc.hashTable[i] = sc.new Bucket(-1, "");
    	}
    }
	
	/**
	 * Takes a word and turns it into hashCode using the polynomial method
	 * @param word
	 * @return int hashCode value
	 */
	public static int hashFunction(String word) {
		int hashCode = 0;
		int length = word.length();
		for(int i = 0; i < word.length(); i++) {
			hashCode += ((int)word.charAt(i))*(Math.pow(R, (--length)));
		}
		return hashCode;
	}
	
	/**
	 * Takes int hashCode and compresses it to a double in range of 
	 * HashTable size
	 * @param hashCode
	 * @return double compressed hash code value
	 */
	public static double compressHashCode(int hashCode) {
		double compHash = 0;
		compHash = Math.floor(HTS*((hashCode*Math.pow(GR, -1))-(Math.floor(hashCode*Math.pow(GR, -1)))));
		return compHash;
	}
	
	/**
	 * Adds word to hash table array at indices determined by compressed hash code
	 * @param word
	 * @param hashCode
	 * @param sc instance of spell checker
	 */
	public static void addToHashTable(String word, int hashCode, SpellChecker sc) {
		Bucket b = sc.new Bucket(hashCode, word);
		if(sc.hashTable[hashCode].key == -1) {
			sc.hashTable[hashCode] = b;	
			sc.numberWordsInDictionary++;
		}
		else {
			Bucket pos = sc.hashTable[hashCode];
			while(pos.next != null)
				pos = pos.next;
			pos.next = b;
			sc.numberWordsInDictionary++;
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////// Spell Checker and Rules for Removing Endings and Punctuation //////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Searches hash table for possible match in dictionary of word in question
	 */
	public static boolean checkHashTableForWord(SpellChecker sc, String word) {
		int i = hashFunction(word);
		int j = (int)compressHashCode(i);
		Bucket pos = sc.hashTable[j];
		//System.out.println(pos.word);
		if(pos.word.equals(""))
			return false;
		else if(pos.word.equals(word)) {
			sc.numberOfProbes++;
			return true;
		}
		else {
			while(pos.next != null) {
				pos = pos.next;
			    if(pos.word.equals(word))
			    	sc.numberOfProbes++;
			    	return true;
			}
			return false;
		}
	}
	
	/**
	 * Sends word to checkHashTableForWord function and removes endings
	 * depending on rules to check word multiple times for correct root spelling
	 * @param sc
	 * @param word
	 */
	public static void checkSpelling(SpellChecker sc, String word) {
		word = removePuncuation(word); //removes punctuation if any exists;
		String origWord = word;
		if(checkHashTableForWord(sc, word) == false)
			word = word.toLowerCase();
		if(checkHashTableForWord(sc, word) == false) {
			origWord = word;
			word = removeAposS(origWord);
		}
		if(checkHashTableForWord(sc, word) == false)
			word = removeS(origWord);
		if(checkHashTableForWord(sc, word) == false)
			word = removeES(origWord);
		if(checkHashTableForWord(sc, word) == false)
			word = removeED(origWord);
		if(checkHashTableForWord(sc, word) == false)
			word = removeD(origWord);
		if(checkHashTableForWord(sc, word) == false)
			word = removeER(origWord);
		if(checkHashTableForWord(sc, word) == false)
			word = removeR(origWord);
		if(checkHashTableForWord(sc, word) == false)
			word = removeING(origWord);
		if(checkHashTableForWord(sc, word) == false)
			word = replaceING_E(origWord);
		if(checkHashTableForWord(sc, word) == false) 
			word = removeLY(origWord);
		if(checkHashTableForWord(sc, word) == false) 
			word = removeR(removeS(origWord));       // for special cases of words ending in rs like bakers.
		if(checkHashTableForWord(sc, word) == false) {
			System.out.println(origWord);
			sc.numberWordsMissSpelled++;
		}
	}
	
	/**
	 * removes punctuation from word
	 * @param word
	 * @return
	 */
	public static String removePuncuation(String word) {
		int length = word.length();
		char c = word.charAt(length -1);
		if((c == ',') || (c == '.') || (c == '?') || (c == '!') || (c == ':') || (c == ';')) {
			String word_minus_punc = "";
			for(int i = 0; i < (length-1); i++)
				word_minus_punc += word.charAt(i);
			word = word_minus_punc;
		}
		return word;
	}
	
	/**
	 * removes __'s__ ending
	 * @param word
	 * @return
	 */
	public static String removeAposS(String word) {
		int length = word.length();
		char c = word.charAt(length - 2);
		char d = word.charAt(length - 1);
		String s = "";
		s = (s + c + d);
		if(s.equals("'s") == true) {
			numberWordsToBeSpellChecked++;
			String word_minus_apostrophe_s = "";
			for(int i = 0; i < (length - 2); i++)
				word_minus_apostrophe_s += word.charAt(i);
			word = word_minus_apostrophe_s;
		}
		return word;
	}
	
	/**
	 * removes __s__ ending
	 * @param word
	 * @return
	 */
	public static String removeS(String word) {
		int length = word.length();
		char c = word.charAt(length -1);
		if(c == 's') {
			numberWordsToBeSpellChecked++;
			String word_minus_s = "";
			for(int i = 0; i < (length -1); i++)
				word_minus_s += word.charAt(i);
			word = word_minus_s;
		}
		return word;
	}
	
	/**
	 * removes __es__ ending
	 * @param word
	 * @return
	 */
	public static String removeES(String word) {/////////////////
		int length = word.length();
		char c = word.charAt(length - 2);
		char d = word.charAt(length - 1);
		String s = "";
		s = (s + c + d);
		if(s.equals("es") == true) {
			numberWordsToBeSpellChecked++;
			String word_minus_apostrophe_s = "";
			for(int i = 0; i < (length - 2); i++)
				word_minus_apostrophe_s += word.charAt(i);
			word = word_minus_apostrophe_s;
		}
		return word;
	}
	
	/**
	 * removes __ed__ ending
	 * @param word
	 * @return
	 */
	public static String removeED(String word) {/////////////////
		int length = word.length();
		char c = word.charAt(length - 2);
		char d = word.charAt(length - 1);
		String s = "";
		s = (s + c + d);
		if(s.equals("ed") == true) {
			numberWordsToBeSpellChecked++;
			String word_minus_apostrophe_s = "";
			for(int i = 0; i < (length - 2); i++)
				word_minus_apostrophe_s += word.charAt(i);
			word = word_minus_apostrophe_s;
		}
		return word;
	}
	
	/**
	 * removes __d__ ending
	 * @param word
	 * @return
	 */
	public static String removeD(String word) {/////////////////
		int length = word.length();
		char c = word.charAt(length -1);
		if(c == 'd') {
			numberWordsToBeSpellChecked++;
			String word_minus_s = "";
			for(int i = 0; i < (length -1); i++)
				word_minus_s += word.charAt(i);
			word = word_minus_s;
		}
		return word;
	}
	
	/**
	 * removes __er__ ending
	 * @param word
	 * @return
	 */
	public static String removeER(String word) {/////////////////
		int length = word.length();
		char c = word.charAt(length - 2);
		char d = word.charAt(length - 1);
		String s = "";
		s = (s + c + d);
		if(s.equals("er") == true) {
			numberWordsToBeSpellChecked++;
			String word_minus_apostrophe_s = "";
			for(int i = 0; i < (length - 2); i++)
				word_minus_apostrophe_s += word.charAt(i);
			word = word_minus_apostrophe_s;
		}
		return word;
	}
	
	/**
	 * removes __r__ ending
	 * @param word
	 * @return
	 */
	public static String removeR(String word) {/////////////////
		int length = word.length();
		char c = word.charAt(length -1);
		if(c == 'r') {
			numberWordsToBeSpellChecked++;
			String word_minus_s = "";
			for(int i = 0; i < (length -1); i++)
				word_minus_s += word.charAt(i);
			word = word_minus_s;
		}
		return word;
	}
	
	/**
	 * removes __ing__ ending
	 * @param word
	 * @return
	 */
	public static String removeING(String word) {/////////////////
		int length = word.length();
		//System.out.println(word);
		char b = word.charAt(length - 3);
		char c = word.charAt(length - 2);
		char d = word.charAt(length - 1);
		String s = "";
		s = (s + b + c + d);
		if(s.equals("ing") == true) {
			numberWordsToBeSpellChecked++;
			String word_minus_apostrophe_s = "";
			for(int i = 0; i < (length - 3); i++)
				word_minus_apostrophe_s += word.charAt(i);
			word = word_minus_apostrophe_s;
		}
		return word;
	}
	
	/**
	 * removes __ing__ ending and replaces it with
	 * __e__ ending
	 * @param word
	 * @return
	 */
	public static String replaceING_E(String word) {/////////////////
		int length = word.length();
		char b = word.charAt(length - 3);
		char c = word.charAt(length - 2);
		char d = word.charAt(length - 1);
		String s = "";
		s = (s + b + c + d);
		if(s.equals("ing") == true) {
			numberWordsToBeSpellChecked++;
			String word_minus_apostrophe_s = "";
			for(int i = 0; i < (length - 3); i++)
				word_minus_apostrophe_s += word.charAt(i);
			word = word_minus_apostrophe_s;
		}
		word += 'e';
		return word;
	}
	
	/**
	 * removes __ly__ ending
	 * @param word
	 * @return
	 */
	public static String removeLY(String word) {/////////////////
		int length = word.length();
		char c = word.charAt(length - 2);
		char d = word.charAt(length - 1);
		String s = "";
		s = (s + c + d);
		if(s.equals("ly") == true) {
			numberWordsToBeSpellChecked++;
			String word_minus_apostrophe_s = "";
			for(int i = 0; i < (length - 2); i++)
				word_minus_apostrophe_s += word.charAt(i);
			word = word_minus_apostrophe_s;
		}
		return word;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////// File Readers and Word Processing, Print Functions /////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * access dictionary text file and read in data line at a time
	 * calls processWord function
	 * 
	 */
	public static void getDictionary(SpellChecker sc) {
    	try {
        	Scanner fileInput = new Scanner(new File("dict.txt"));
            while(fileInput.hasNextLine())
            	processWord(fileInput.nextLine(), sc);
        }
        catch(FileNotFoundException e) {
        	System.out.println("File does not exist");
        }
    }
    
	/**
	 * takes input from the dictionary and sends it to the hashing
	 * functions, adds word to the hashTable
	 * @param line
	 * @param sc
	 */
    public static void processWord(String line, SpellChecker sc) {
    	int hashCode = hashFunction(line);
    	int compressedHashCode = (int)compressHashCode(hashCode);
    	addToHashTable(line, compressedHashCode, sc);
    	//Bucket b = new Bucket(compressedHashCode, line, 0);
    }
    
    /**
     * Access text file to be spell check and passes line at a time
     * to process line
     * @param sc
     * @param textFile
     */
    public static void spellCheckTextFile(SpellChecker sc, String textFile) {
    	try {
    		Scanner fileInput = new Scanner(new File(textFile));
    		while(fileInput.hasNextLine())
    			processLine(fileInput.nextLine(), sc);
    	}
    	catch(FileNotFoundException e) {
    		System.out.println("File does not exist");
    	}
    	
    }
    
    /**
     * reads tokens from line and determine if they are words
     * and then sends them to the spellChecker function
     * @param line
     * @param sc
     */
    public static void processLine(String line, SpellChecker sc) {
    	Scanner lineInput = new Scanner(line);
    	String word = "";
    	while(lineInput.hasNext()) {
    		word = lineInput.next();
    		if(((int)word.charAt(0) - '0') >= 9 ) {
    			checkSpelling(sc, word);
    			numberWordsToBeSpellChecked++;
    		}
    	}
    }
    
    /**
     * Prints the hashTable in a readable format
     * Shows collisions on the same line
     * @param sc
     */
    public static void showHashTable(SpellChecker sc) {
    	for(int i = 0; i < HTS; i++) {
    		if(sc.hashTable[i].key != -1) {
    			Bucket pos = sc.hashTable[i];
    			System.out.print(pos.word);
    			while(pos.next != null) {
    				pos = pos.next;
    				System.out.print(" - " + pos.word);
    			}
    			System.out.println();
    			
    		}
    	}
    	//System.out.println(poop);
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////// Program Driver ////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Main program driver
     */
	public static void main(String[] args) {
		SpellChecker sc = new SpellChecker();
		initializeHashTable(sc);
		getDictionary(sc);
		spellCheckTextFile(sc, "sampletext.txt"); //name of text file document to spell check goes here!!!
		System.out.println("Number of words in the dictionary is: " + sc.numberWordsInDictionary);
		System.out.println("Number of words in the document spellchecked is: " + numberWordsToBeSpellChecked);
		System.out.println("Number of words miss spelled in the document is: " + sc.numberWordsMissSpelled);
		System.out.println("Number of probes is: " + sc.numberOfProbes);
		System.out.println("Average number of probes is: " + ((double)sc.numberOfProbes/(double)numberWordsToBeSpellChecked));

		
		//checkSpelling(sc,"bakers");
		/*checkSpelling(sc, "cook");
		checkSpelling(sc, "cook's");
		checkSpelling(sc, "cakes");
		checkSpelling(sc, "dishes");
		checkSpelling(sc, "cooked");
		checkSpelling(sc, "baked");
		checkSpelling(sc, "cooker");
		checkSpelling(sc, "baker");
		checkSpelling(sc, "cooking");
		checkSpelling(sc, "baking");
		checkSpelling(sc, "deliciously");*/

//remove comments to show hash Table 
		//showHashTable(sc);
//remove comments to show hash code and compression function on one word
		/*int j = hashFunction("don't");
		System.out.println(j);
		double d = compressHashCode(j);
		System.out.println(d);*/
		
	}
}
