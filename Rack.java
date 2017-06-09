// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA3
// Spring 2017

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {
	
    private String rack;							//The string combine with unique characters of input string
    private String input = "";						//Store the original input string
    private Map<Character, Integer> wordInChar;		//Store the input string in Map format
    private int[] mult;								//The multiplicity of each letter from unique string
    private static final int start = 0;				//Find all the subset from the start index 
    
	public Rack(String s){
		for (int i = 0; i < s.length(); i++){		//Delete the characters which are not actual letters
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
				input += s.charAt(i);
			}
		}
		input = input.toLowerCase();				//Transfer letters of the rack to lower case 
		wordInChar= new TreeMap<Character, Integer>();
		wordInChar = changeWordToMap();             //Store the letters in TreeMap
		Iterator<Map.Entry<Character, Integer>> iter = wordInChar.entrySet().iterator();
		int numChar = wordInChar.size();
		mult = new int[numChar];
		rack = "";
		for(int i = 0; i < numChar; i++){			//Get the combine of unique characters and the multiplicity of each letter from unique string
			Map.Entry<Character, Integer> entry = iter.next();
			mult [i]= entry.getValue();
			rack += entry.getKey();
		}
	}
	
	/**
	* Finds all subsets of the rack.
	* PRE: mult.length must be at least as big as unique.length()
	* @return an ArrayList of all subsets of the rack
	*/
	public ArrayList<String> findAllSubsets(){
		ArrayList<String> result = new ArrayList<String>();	
		result = allSubsets(rack, mult, start);
		return result;
	}

   /**
    * Finds all subsets of the multiset starting at position k in unique and mult.
    * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
    *      unique.charAt(i).
    * PRE: mult.length must be at least as big as unique.length()
    * @param unique a string of unique letters
    * @param mult the multiplicity of each letter from unique.  
    * @param k the smallest index of unique and mult to consider.
    * @return all subsets of the indicated multiset
    * @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }
   
   /**
    * Sort the string in alphabetical order
    * @return a string with the same letters of input but in alphabetical order
    */
   public String orderWord(){
	   String result = "";
	   char[] temp = new char[input.length()];					//Put each letter of the string into an array
	   for (int i = 0; i < input.length(); i++){
		   temp[i] = input.charAt(i);
	   }
	   Arrays.sort(temp);										//Sort the array by alphabetical order
	   for (int i = 0; i < temp.length; i++){					//Transfer the array back to string
		   result += temp[i];
	   }
	   return result;
   }
   
   /**
    * Store the string in TreeMap.
    * @param s string to process
    * @return a TreeMap of s
    * 
    */
   private Map<Character, Integer> changeWordToMap(){
	   Map<Character, Integer> wordInMap = new TreeMap<Character, Integer>();	// The key of TreeMap is the unique character in the string
	   for(int i = 0; i < input.length(); i++){									// The value of TreeMap is the number of a unique character in the string
		   int numberOfChar = 1;
		   if(wordInMap.containsKey(input.charAt(i))){
			   wordInMap.put(input.charAt(i), wordInMap.get(input.charAt(i)) + 1); //If there already have character i, update the number of that character
		   }else{
			   wordInMap.put(input.charAt(i), numberOfChar);						//If the TreeMap doesn't contain character i yet, add the character
		   }
		   
	   }
	   return wordInMap;
   }
   
}
