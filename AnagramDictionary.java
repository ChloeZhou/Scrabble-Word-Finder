// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA3
// Spring 2017

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;



/**
 * This class represent a dictionary of all anagram sets. 
 * Note: the processing is case-sensitive; so if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   
	private ArrayList<Map<Character, Integer>> dictionaryInChar;  		//Store the dictionary in Map format
	private ArrayList<String> dictionary;  								//Store the dictionary in string format

   /**
    * Create an anagram dictionary from the list of words given in the file
    * indicated by fileName.  
    * PRE: The strings in the file are unique.
    * @param fileName  the name of the file to read from
    * @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	   File inFile = new File(fileName);								//Read dictionary file
	   Scanner in = new Scanner(inFile);								
	   dictionaryInChar = new ArrayList<Map<Character, Integer>>();		
	   dictionary = new ArrayList<String>();							
	   while(in.hasNext()){												
		   String word = in.next();
		   Map<Character, Integer> wordInChar= new TreeMap<Character, Integer>();
		   wordInChar = changeWordToMap(word);							//Change the word to Map<Character, Integer> type
		   dictionaryInChar.add(wordInChar);							//Add word in Map format to dictionary
		   dictionary.add(word);										//Add word in String format to dictionary
	   }
   }
   

   /**
    * Get all anagrams of the given string. This method is case-sensitive.
    * E.g. "CARE" and "race" would not be recognized as anagrams.
    * @param s string to process
    * @return a list of the anagrams of s
    * 
    */
   public ArrayList<String> getAnagramsOf(String s) {
	   ArrayList<String> results = new ArrayList<String>();
       Map<Character, Integer> charSort = new TreeMap<Character, Integer>();   
       charSort = changeWordToMap(s);											//Change to input string to Map format   
       for(int i = 0; i < dictionaryInChar.size(); i++){						//Compare each word in dictionary with the input string
		   if (charSort.equals(dictionaryInChar.get(i))){						//If the tree map of input string equals the tree map of words in dictionary, find anagrams
			   results.add(dictionary.get(i));									//Add anagrams to results
		   }
			   
	   }
	   return results;
   }
   /**
    * Store the string in TreeMap.
    * @param s string to process
    * @return a TreeMap of s
    * 
    */
   
   private Map<Character, Integer> changeWordToMap(String s){
	   Map<Character, Integer> wordInMap = new TreeMap<Character, Integer>();	// The key of TreeMap is the unique character in the string
	   for(int i = 0; i < s.length(); i++){										// The value of TreeMap is the number of a unique character in the string
		   int numberOfChar = 1;
		   if(wordInMap.containsKey(s.charAt(i))){
			   wordInMap.put(s.charAt(i), wordInMap.get(s.charAt(i)) + 1);		//If there already have character i, update the number of that character
		   }else{
			   wordInMap.put(s.charAt(i), numberOfChar);						//If the TreeMap doesn't contain character i yet, add the character
		   }
		   
	   }
	   return wordInMap;
   }
}
