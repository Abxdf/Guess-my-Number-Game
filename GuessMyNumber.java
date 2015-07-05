import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 class GuessDone extends JFrame
 {
	 boolean playgame=true;
	 JLabel status;
	public GuessDone()
	{
		setSize(500,100);
		setVisible(true);
		status=new JLabel("Guess my Number has successfully guessed the number :) ", JLabel.CENTER);
	add(status);	
	}	
}



public class GuessMyNumber extends JFrame implements ActionListener {
	JLabel statuslabel;
	JButton okbutton, cancelbutton, yesbutton;
	String str = "Click GREATER if your guess is greater else click LESSER\n";
	int low = 0;
	int high = 1000;
	int mid = (low + high) / 2;
	int count = 0;
	boolean playagain = false;

	public GuessMyNumber() {

		setTitle("Welcome to Guess My Number");
		setSize(400, 400);
		setLayout(new GridLayout(4, 1));
		setVisible(true);
		statuslabel = new JLabel("", JLabel.CENTER);
		okbutton = new JButton("GREATER");
		cancelbutton = new JButton("LESSER");
		yesbutton = new JButton("CORRECTGUESS!!!");
		okbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		yesbutton.addActionListener(this);
		add(okbutton);
		add(cancelbutton);
		add(yesbutton);
		add(statuslabel);

		statuslabel.setText("GUESS ANY NUMBER BETWEEN 0 AND 1000\n");
		try{
		Thread.sleep(1000);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		statuslabel.setText("Your Guess Number is " + mid + "\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		String command = e.getActionCommand();

		if (command.equals("GREATER") && low<high) {
			count++;
			low = mid + 1;
			mid = (low + high) / 2;
			statuslabel.setText("Your Guess Number is " + mid + "\n");
			return;

		} else if (command.equals("LESSER") && low<high) {
			count++;
			high = mid - 1;
			mid = (low + high) / 2;
			statuslabel.setText("Your Guess Number is " + mid + "\n");
			return;
		} else if (command.equals("CORRECTGUESS!!!")) {

			statuslabel.setText("Your Guess is identified in " + count
					+ " clicks :)");
			destroy();

			return;

		} else if (low >= high) {
			
			statuslabel.setText("Your Guess must be " + mid + " :)");

			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
				System.out.println(ex);
			}

			statuslabel.setText("Your Guess is identified in " + count
					+ " clicks :)");
			destroy();
			return;
		}

	}

	public void destroy() {
		// System.out.println("DESTOR");

		 
		// System.out.println("DESTOR");
		String str2 = "Your Guess is identified in " + count + " clicks :)";
		String str1 = statuslabel.getText();
		// System.out.println(str1);
		// System.out.println(str2);
		if (str1.equals(str2)){
			setVisible(false);
			new GuessDone();
		}

	}

	public static void main(String args[]) {

	
			new GuessMyNumber();
		
	
}}
