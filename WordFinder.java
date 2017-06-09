import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA3
// Spring 2017
/**
 * 
 * This contains the main method. 
 * This class will have a main that's responsible for processing the command-line argument, 
 * opening and closing the dictionary file, and handling any errors related to the above tasks. 
 *
 */
public class WordFinder {
	
	public static void main(String[] args){
		 try {
			 	
			 	AnagramDictionary dictionary;					//Create an dictionary object 
			 	String fileName = args[0];						//Read dictionary file
				dictionary = new AnagramDictionary(fileName);
				Scanner in = new Scanner(System.in);			//Read the rack
				
				System.out.println("Type . to quit.");
				boolean exit = false;
				while (!exit){
					 System.out.print("Rack? ");
					 if (in.hasNext()){
						 String input = in.next();
						 if (input.equals(".")){
							 exit = true;														//If input is ., exit
						 }else{
							 
							 Rack rack = new Rack(input);										//Create the rack
							 String inputInOrder = rack.orderWord(); 							//Sort the input string by alphabetical order
							 ArrayList<String> allSubset = new ArrayList<String>(); 
							 ArrayList<ScoreTable> finalResults = new ArrayList<ScoreTable>();
							 ArrayList<String> resultsInOrder = new ArrayList<String>();
							 allSubset = rack.findAllSubsets();									//Find all the subsets of the rack
							 
							 for (int i = 0; i < allSubset.size(); i++){						//For each subset, find the anagrams from the dictionary
								 ArrayList<String> results = new ArrayList<String>();
								 results = dictionary.getAnagramsOf(allSubset.get(i));
								 resultsInOrder.addAll(results);								//Add all the anagrams
							 }
							 Collections.sort(resultsInOrder);									//Sort the all results by alphabetical order
							 for (int j = 0; j < resultsInOrder.size(); j++){					//For each word find in the dictionary, calculate their score
								 ScoreTable subScore = new ScoreTable(resultsInOrder.get(j));
								 finalResults.add(subScore);
							 }
							 Collections.sort(finalResults, new ScoreComp());					//Sort the results by score
							 int numOfWords = finalResults.size();								//Print the results
							 System.out.println("We can make " + numOfWords + " words from " + "\"" + inputInOrder + "\"");
							 if(numOfWords > 0){
								 System.out.println("All of the words with their scores (sorted by score):");
								 for(int i = 0; i < finalResults.size(); i++){
									 System.out.println(finalResults.get(i).getScore() + ": " + finalResults.get(i).getString());
								 }
							 }
						 } 
					 }
				}
		 	}
			catch(FileNotFoundException e){
				System.out.println("File not found");
			}
	}
	
}		 
/**
* This class used to compare the words by their score
*Returns negative value if b is less than a
*Returns positive value if b is greater than a
*otherwise returns zero.
*/
class ScoreComp implements Comparator<ScoreTable>{
	public int compare(ScoreTable a,ScoreTable b){
		return b.getScore() - a.getScore();
	}
}
