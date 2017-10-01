import java.util.*;

public class theTrial {
	private ArrayList<String> lettersguessed=new ArrayList<String>();
	private String word;
	private String guessword = "";
	private int guessesleft = 10;
	
	public theTrial(String w){
		word =w;
		for(int i =0;i<word.length();i++)
			guessword+="*";
	}
	
	public boolean checkletter(String a){
		for(int i =0;i<lettersguessed.size();i++){
			if(lettersguessed.get(i).equals(a)){
				guessesleft--; 
				return false;				 
			}
		}
		for(int i =0;i<word.length();i++){
			if(word.substring(i, i+1).equals(a)){
				//lettersguessed.add(a);    		toggles whether letters displayed correctly guessed show up as letter guessed
				updateguess(a);
				return true;
			}
		}
		lettersguessed.add(a);
		guessesleft--;
		return false;
			
	}
	
	/*update the guessed word to reflect the newest guessed letter*/
	private void updateguess(String a){
		ArrayList<Integer> indexofletters=new ArrayList<Integer>();
		int i =0;
		while(i<word.length()){
			int index =word.indexOf(a, i);
			if(index!=-1){
				indexofletters.add(index);
				i=index+1;
			}else
				break;
		}
		for(int ind : indexofletters)
			guessword=guessword.substring(0,ind)+ a+guessword.substring(ind+1);
	}
	
	public String getWord(){
		return word;
	}
	
	public String getGuessWord(){
		return guessword;
	}
	
	public String [] getLettersGuessed(){
		String [] a = new String[lettersguessed.size()];
		for(int i=0;i<a.length;i++)
			a[i]=lettersguessed.get(i);
		return a;
	}
	
	
	 public int getGuessesLeft(){
	 	return guessesleft;
	 }
	 
	 public boolean Won(){
		 if(guessword.equals(word))
			 return true;
		 else
			 return false;
	 }
	
}
