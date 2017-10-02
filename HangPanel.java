import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class HangPanel extends JPanel{
	private RunManFrame parent;
	private JLabel entrybox;
	private JTextField letterentry;
	private JButton guessletter;
	private JButton playAgain;
	private JLabel guessword;
	private JLabel theword;
	private JLabel alreadyguessed;
	private JLabel guessesleft;
	private DeadMan dm;
	private theTrial trial = new theTrial(characterReader.getWords("words.txt"));
	
	public HangPanel(RunManFrame f) {
		parent =f;
		setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        entrybox=new JLabel("Guess a letter");
        entrybox.setBounds(5, 5, 100, 25);
         
        letterentry= new JTextField();
        letterentry.setBounds(95, 5, 45, 25);
        
        guessletter = new JButton("Enter");
        guessletter.setBounds(15,35,90,35);
        guessletter.addActionListener( new ButtonEars() );

        theword = new JLabel("");
        theword.setBounds(10, 215, 100, 25);
        
        guessword = new JLabel(trial.getGuessWord());
        guessword.setBounds(10, 125, 100, 25);
        
        alreadyguessed = new JLabel("");
        alreadyguessed.setBounds(10, 140, 120, 100);
        
        guessesleft = new JLabel("Guesses Left: "+trial.getGuessesLeft());
        guessesleft.setBounds(10, 80, 100, 25);
        
        dm = new DeadMan();
        dm.setBounds(145,5,450,590);
        
        this.add(entrybox);
		this.add(letterentry);
		this.add(guessletter);
		this.add(theword);
		this.add(guessword);
		this.add(alreadyguessed);
		this.add(guessesleft);
		this.add(dm);
	}

	private void letterguess(String a){			
		boolean b = trial.checkletter(a);
		if(!b)
			dm.wrongGuess();
		if(trial.Won()) {
			update();
			gameOver(true);
		}else if(trial.getGuessesLeft()==0){
			gameOver(false);
			return;
		}else{
			dm.update();
			update();
		}
	}
	
	/*
	 * Updates the guessed word and the letters guessed displays
	 */
	private void update(){
		guessesleft.setText("Guesses Left: "+trial.getGuessesLeft());
        guessword.setText(trial.getGuessWord());
        String [] a = trial.getLettersGuessed();
        String temp="";
        for(String b: a){
        	if(temp.length()>8)
        		temp+="\n";
        	temp+=b+", ";
        }
        alreadyguessed.setText(temp);
        letterentry.setText("");
	letterentry.requestFocusInWindow();
	}
	
	/*
	 * Action after a game is lost. Recieves true if game was won and false if game was lost.
	 */
	private void gameOver(boolean b) {
		playAgain = new JButton("Play Again");
		playAgain.addActionListener(new ButtonEars() );
		JButton done = new JButton("Done for Now");
		done.addActionListener(new ButtonEars() );
		JButton[] options = {playAgain,done};
		if(b)
			JOptionPane.showOptionDialog(null,"You Win!","Game Over",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[1]);
		else
			JOptionPane.showOptionDialog(null,"You have run out of guesses.","Game Over",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]);
	}
	
	/*
	 * resets the game so you can play again
	 */
	private void resetGame() {
		trial = new theTrial(characterReader.getWords("words.txt"));
		dm.reset();
		update();
	}
	
	@Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );        
    }	
	
	private class ButtonEars implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	if(e.getSource()==guessletter){
        	  	String letter = letterentry.getText();
        	  	letterguess(letter);
        	}else if(e.getSource()==playAgain){
        		resetGame();
        	}else{
        		System.exit(0);
        	}
        }
      }
}
