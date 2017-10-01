import java.awt.*;import javax.swing.*;

public class RunManFrame extends JFrame{
	private HangPanel hp;
	
	public RunManFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle( "Hang on This" );
        
        hp = new HangPanel( this );
        hp.setPreferredSize(new Dimension(600, 600));
        
        getContentPane().add( hp );
        pack();
	}

	public static void main(String[] args) {
		RunManFrame f = new RunManFrame();
        f.display();
	}
	
	public void display() {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    setVisible(true);
                }
            });
    }

}
