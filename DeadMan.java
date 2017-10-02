import java.awt.*;
import javax.swing.*;

public class DeadMan extends JPanel{
	private int wrongguesscount =0;
	//panel is 460x590
	
	public DeadMan(){
		setBackground(Color.WHITE);
		setLayout(null);
	}
	
	@Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g ); 
       Graphics2D g2 = (Graphics2D) g;
       g2.setStroke(new BasicStroke(5));
       g2.drawLine(425, 10, 425, 590);
       g2.drawLine(220, 10, 425, 10);
       g2.drawLine(220, 10, 220, 30);
       g2.setStroke(new BasicStroke(2));
        switch(wrongguesscount){
       case 0:
    	   //g2.drawArc(150,115,150,120,140,-45);
    	  // g2.drawArc(145,115,150,120,90,-55);
    	   break;
       case 1:
    	   g2.drawOval(150,32,140,140);
    	   break;
       case 2:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   break;
       case 3:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   break;
       case 4:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   g2.drawLine(220, 425, 305, 510);
    	   break;   
       case 5:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   g2.drawLine(220, 425, 305, 510);
    	   g2.drawLine(220,255,135,315);
    	   break;
       case 6:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   g2.drawLine(220, 425, 305, 510);
    	   g2.drawLine(220,255,135,315);
    	   g2.drawLine(220,255,305,315);
    	   break;   
       case 7:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   g2.drawLine(220, 425, 305, 510);
    	   g2.drawLine(220,255,135,315);
    	   g2.drawLine(220,255,305,315);
    	   g2.fillOval(180, 60, 26, 26);
    	   break;   
       case 8:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   g2.drawLine(220, 425, 305, 510);
    	   g2.drawLine(220,255,135,315);
    	   g2.drawLine(220,255,305,315);
    	   g2.fillOval(180, 60, 26, 26);
    	   g2.fillOval(240, 60, 26, 26);
    	   break;      
       case 9:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   g2.drawLine(220, 425, 305, 510);
    	   g2.drawLine(220,255,135,315);
    	   g2.drawLine(220,255,305,315);
    	   g2.fillOval(180, 60, 26, 26);
    	   g2.fillOval(240, 60, 26, 26);
    	   g2.drawArc(150,115,150,120,140,-45);
    	   g2.drawArc(145,115,150,120,90,-45);
    	   break;  
       case 10:
    	   g2.drawOval(150,32,140,140);
    	   g2.drawLine(220, 173, 220, 425);
    	   g2.drawLine(220, 425, 135, 510);
    	   g2.drawLine(220, 425, 305, 510);
    	   g2.drawLine(220,255,135,315);
    	   g2.drawLine(220,255,305,315);
    	   g2.drawLine(180, 60, 206, 86);
    	   g2.drawLine(180, 86, 206, 60);
    	   g2.drawLine(240, 60, 266, 86);
    	   g2.drawLine(240, 86, 266, 60);
    	   g2.drawArc(150,115,150,120,140,-45);
    	   g2.drawArc(145,115,150,120,90,-45);
    	   break;
       }
    }
	
	/*adds another wrong guess*/
	public void wrongGuess(){
		wrongguesscount++;
	}

	public void update(){
		repaint();
	}
	
	public void reset(){
		wrongguesscount=0;
		update();
	}
	
}
