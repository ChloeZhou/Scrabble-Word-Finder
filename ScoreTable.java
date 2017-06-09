// Name: Keying Zhou
// USC NetID: 1935-0418-72
// CS 455 PA3
// Spring 2017
/**
 * 
 * This class has information about Scrabble scores for scrabble letters and words
 * and it can calculate the scores of input strings.
 *
 */
import java.util.Comparator;
import java.util.Map;
public class ScoreTable{
	private String word;						//Store the input string
	private static final int TEN_POINTS = 10;
	private static final int EIGHT_POINTS = 8;
	private static final int FIVE_POINTS = 5;
	private static final int FOUR_POINTS = 4;
	private static final int THREE_POINTS = 3;
	private static final int TWO_POINTS = 2;
	private static final int ONE_POINTS = 1;
	private static final int NUM_CHAR = 26;
	private int[] scoreTable;					//Store the score table
	private int score;						    
	
	public ScoreTable(String s){
		word = s;
		scoreTable = new int[NUM_CHAR];
		scoreTable['a' - 'a'] = ONE_POINTS;		//Hard code scores for each character
		scoreTable['b' - 'a'] = THREE_POINTS;
		scoreTable['c' - 'a'] = THREE_POINTS;
		scoreTable['d' - 'a'] = TWO_POINTS;
		scoreTable['e' - 'a'] = ONE_POINTS;
		scoreTable['f' - 'a'] = FOUR_POINTS;
		scoreTable['g' - 'a'] = TWO_POINTS;
		scoreTable['h' - 'a'] = FOUR_POINTS;
		scoreTable['i' - 'a'] = ONE_POINTS;
		scoreTable['j' - 'a'] = EIGHT_POINTS;
		scoreTable['k' - 'a'] = FIVE_POINTS;
		scoreTable['l' - 'a'] = ONE_POINTS;
		scoreTable['m' - 'a'] = THREE_POINTS;
		scoreTable['n' - 'a'] = ONE_POINTS;
		scoreTable['o' - 'a'] = ONE_POINTS;
		scoreTable['p' - 'a'] = THREE_POINTS;
		scoreTable['q' - 'a'] = TEN_POINTS;
		scoreTable['r' - 'a'] = ONE_POINTS;
		scoreTable['s' - 'a'] = ONE_POINTS;
		scoreTable['t' - 'a'] = ONE_POINTS;
		scoreTable['u' - 'a'] = ONE_POINTS;
		scoreTable['v' - 'a'] = FOUR_POINTS;
		scoreTable['w' - 'a'] = FOUR_POINTS;
		scoreTable['x' - 'a'] = EIGHT_POINTS;
		scoreTable['y' - 'a'] = FOUR_POINTS;
		scoreTable['z' - 'a'] = TEN_POINTS;
		score = 0;
		for (int i = 0; i < word.length(); i++){				//Calculate the score of input string
			score += scoreTable[word.charAt(i) - 'a'];
		}
	}
	 /**
	    * Return score of the input string
	    */
	public int getScore(){										
		return score;
	}
	 /**
	    * Return input string
	    */
	public String getString(){
		String s;
		s = word;
		return s;
	}
	
}
