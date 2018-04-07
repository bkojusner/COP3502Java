//Do not edit this imports
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;

/**
 * @author Blas Kojusner
 * COP 3502 Section Number: 1A64
 * Date: 3/16/17
 *
 */
public class PoetryDecoder {

	/**
	 * @param args This main method does not take command line args.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//This prompt to the user is intentionally vague to avoid
		//incrimating those who use this program. 
		System.out.println("Please enter your input: ");
		String hex = sc.nextLine();

		//STUDENTS: Your decode method must return a fully formatted String,
		//which will be output here. 
		System.out.print(decode(hex));
		
		sc.close();
	}

	/**
	 * @param hex The string of hex digits that is to be decoded.
	 * @return A String representing an entire decoded poem of English words. 
	 * (The returned string includes line breaks and spacing.) 
	 */
	
	public static String decode(String hex) {
		
		//Declaring Arrays for the storage of words
		String engLetters = toEnglishLetters(hex);
		String[] fourLetWords = findWordsOfLength(engLetters , 4);
		String[] fiveLetWords = findWordsOfLength(engLetters , 5);
		String[] sixLetWords = findWordsOfLength(engLetters , 6);
		
		//Creates a string to hold in the finished poem 
		//words that have been found
		String format = formatPoem( fourLetWords , fiveLetWords , sixLetWords);
		
		return format;
	}


	/**
	 * @param String hex: String of hex characters. If the String is of odd length, the final hex
	 * character is ignored and not translated.
	 * @return String: the String of English letters. Each letter came from a pair of hex
	 * digits in the original input String. 
	 */
	
	public static String toEnglishLetters(String hex){
		
		StringBuilder output = new StringBuilder();
		
		//This for loop converts Ascii symbols into Hex which goes to English Characters
		for(int i = 0; i < hex.length() - 1; i += 2){
			
			String sTest = hex.substring(i, i+2);
			int dec = Integer.parseInt(sTest, 16);
			
			while(dec < 97){
				dec = 97 + (dec % 26);
			}
			while (dec > 122){
				dec = 97 + (dec % 26);
			}
			
			output.append((char)dec);
		}
		
		return output.toString();
	}


	/**
	 * @param String letters: A string of English letters
	 * @param String wordSize: The size of words to be extracted from the input String
	 * @return String[]: Contains a word in each element. Elements can be null if no words are found.  
	 */
	
	public static String[] findWordsOfLength(String letters, int wordSize) {
		
		//Creating these two arrays to hold the possible words and the actual words that
		//are extracted from the string
		String[] allWords = new String[letters.length() - wordSize +1];
		String [] allWordsFinal = new String[letters.length() - wordSize +1];
		
		//Frame that slides through the string and gathers every possible combination
		//of a potential words, and checks whether or not it is a word and stores it to
		//the allWordsFinal array
		int h = 0;
		for(int i = 0; i < letters.length() + 1 - wordSize; i++){
			String s = letters.substring(i,  i + wordSize);
			allWords[i] = s;
			boolean word = isWord(allWords[i]);
			
			if(word == true){
				allWordsFinal[h] = allWords[i];
				h++;
			}
		}
		
		return allWordsFinal;
	}

	/**
	 * This method formats a poem according to Poetry Movement specifications. 
	 * @param Takes three arrays of Strings of shortest, medium, and longest lengths. 
	 * @return Returns a String with line breaks and tabs as needed for poetic formatting. 
	 */
	
	public static String formatPoem(String[] shortest, String[] medium, String[] longest){
		
		//Declaring a String and int values to simplify coding 
		String poemFinal = "";
		int sL = shortest.length; int mL = medium.length; int lL = longest.length;
		int num = 0;
		
		//Seeing which of the arrays has the most elements, and then that is the restriction
		//that is set for the for loop.
		if((sL > mL && sL > lL) || (sL >= mL && sL > lL) || (sL > mL && sL >= lL)){
			num = sL;
		}else if((mL > sL && mL > lL) || (mL >= sL && mL > lL) || (mL > sL && mL >= lL)){
			num = mL;
		}else{
			num = lL;
		}
		
		//Tests if there is a value in a specific part of the array
		int h = 0;
		for(int i = 0; i < num; i++){
			
			boolean long1 = (lL > i && longest[i] != null);
			boolean med1 = (mL > i && medium[i] != null);
			boolean short1 = (sL > i && shortest[i] != null);
			
			if(long1){
				poemFinal += longest[i];
				if (short1 == true || med1 == true){
					poemFinal += " ";
				}
			}
			if (med1){
				poemFinal += medium[i];
				if (short1 == true){
					poemFinal += " ";
				}
			}
			if (short1){
				poemFinal += shortest[i];
			}
			
			//Determines if there are words in the next line to determine if
			//another output line will be created
			boolean long2 = ((lL > (i + 1)) && longest[i + 1] != null);
			boolean med2 = ((mL > (i + 1)) && medium[i + 1] != null);
			boolean short2 = ((sL > (i + 1)) && shortest[i + 1] != null);
			
			if(!(long2 == false && med2 == false && short2 == false)){
				poemFinal += "\n";
				for(h = 0; h <= i; h++){
					poemFinal += "\t";
				}
			}
			
			poemFinal.trim();
		}
		
	poemFinal.trim();
	return poemFinal;
	}

	/* *******************************************************************************
	STUDENTS -- BELOW THIS POINT ARE METHODS PROVIDED FOR YOU. DO NOT EDIT THEM. 
	USE THEM AS INDICATED IN THEIR DESCRIPTIONS. 
	 ********************************************************************************/

	/**
	 * This method checks whether the given String occurs in a dictionary of English.
	 * STUDENTS: DO NOT MODIFY THIS METHOD IN ANY WAY. IT IS PROVIDED FOR YOU. 
	 * This method will terminate your program if it is unable to access the remote URL.
	 * You must be online for this code to work. 
	 * @param possWord The word to be checked.
	 * @return boolean Returns true if the word given is an English word, false otherwise.
	 */
	private static boolean isWord(String possWord) {
		boolean isWord = true;
		try {
			//connect to the URL. 
			String s = getUrl(possWord);
			Document d = Jsoup.connect(s).timeout(6000).get();
			Elements tdTags = d.select("h3");

			// Loop over all tdTags, in this case: the h3 tag 
			for( Element element : tdTags ){
				String check = element.toString();

				//Wordnet has a special h3 tag that appears only if the word is not in the dictionary
				//We search for this tag. If it is found, then the word searched is not in the dictionary
				if(check.equals("<h3>Your search did not return any results.</h3>") ){
					isWord = false;
				}
			}
		}
		catch (IOException e) {
			System.err.print("CHECK INTERNET CONNECTION. Could not connect to jsoup URL.");
			System.exit(0);
		}
		return isWord;
	}

	/**
	 * This is a helper method that the teaching staff code uses. 
	 * STUDENTS: DO NOT EDIT THIS METHOD.
	 * This method will terminate your program if it is unable to access the remote URL.
	 * You must be online for this code to work. 
	 * @param String: search 
	 * @return A string containing the URL for the wordnet search.
	 */
	private static String getUrl(String search) {
		//Standard URL for wordnet to search
		String url = "http://wordnetweb.princeton.edu/perl/webwn?s=";
		String newURL = null;
		try {
			//Get new page from word wordnet and get its location
			Document doc = Jsoup.connect(url + search).timeout(6000).get();
			newURL = doc.location().toString();
		}
		catch (IOException e) {
			System.err.print("CHECK INTERNET CONNECTION. Could not connect to jsoup URL.");
			System.exit(0);
		}
		//Return the string of the new URL. 
		return (newURL);
	}

}