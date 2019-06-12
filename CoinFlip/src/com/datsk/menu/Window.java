package com.datsk.menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

public class Window extends JFrame {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, StartButtonPanel,backgroundPanel,foregroundPanel,calcButton, basePanel, infoPanel, creditsPanel;
	JLabel titleNameLabel, infoLabel, creditsLabel;
	JButton calcButtonOp;
	JFormattedTextField input1;
	JFormattedTextField input2;
	JFormattedTextField output;
	Font titleFont = new Font("Arial", Font.PLAIN, 50);
	Font normalFont = new Font("Arial", Font.PLAIN, 20);
	Font smallFont = new Font("Arial", Font.PLAIN, 12);
	static int incTailsCount = 0;
	static int incHeadsCount = 0;

	public Window() {
		int WIDTH = 1920/2;
		int HEIGHT = WIDTH * 9/16;
		pack();
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setName("Coin-Flip Game");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container con;
		con = getContentPane();

		//GUI interactable element definition
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		input1 = new JFormattedTextField(formatter);
		input1.setVisible(true);
		input1.setBounds(250, 250, 200, 25);
		con.add(input1);
		 
		input2 = new JFormattedTextField(formatter);
		input2.setVisible(true);
		input2.setBounds(500, 250, 200, 25);
		con.add(input2);
		
		String outputName = "          Answer and percent error";
		output = new JFormattedTextField(outputName);
		output.setVisible(true);
		output.setBounds(375, 360, 200, 25);
		output.setEditable(false);
		con.add(output);
		
		calcButton = new JPanel();
		calcButton.setBounds(375, 300, 200, 50);
		calcButton.setBackground(Color.RED);
		calcButton.setVisible(true);
		con.add(calcButton);
		

		//GUI shape creation, expressions, and value-to-frame rendering
		int r1w = 525;
		int r1h = r1w*9/16;
		
		creditsPanel = new JPanel();
		creditsPanel.setBounds(960-140, 540-50, 145, 30);
		creditsPanel.setBackground(Color.BLACK);
		JLabel creditsLabel = new JLabel("<html><div style='text-align: center;'>Ben D., June 2019</html>");
		creditsLabel.setVerticalAlignment(JLabel.CENTER);
		creditsLabel.setForeground(Color.WHITE);
		creditsLabel.setFont(smallFont);
		creditsLabel.setVisible(true);
		creditsPanel.add(creditsLabel);
		con.add(creditsPanel);
		
		infoPanel = new JPanel();
		infoPanel.setBounds(225, 190, 510, 40);
		infoPanel.setBackground(Color.BLACK);
		JLabel infoLabel = new JLabel("<html><div style='text-align: center;'>Directions: Enter the number of coin-flips (left box) and your guess for the number of times <br>the coin will land on heads (right box). Finally, press 'calculate' and receive your percent error!</html>");
		infoLabel.setVerticalAlignment(JLabel.CENTER);
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setFont(smallFont);
		infoLabel.setVisible(true);
		infoPanel.add(infoLabel);
		con.add(infoPanel);
		
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(480-(r1w / 2), 480*9/16-(r1h / 2), r1w , r1h);
		titleNamePanel.setBackground(Color.RED);
		JLabel titleNameLabel = new JLabel("Coin-Flip Game");
		titleNameLabel.setForeground(Color.BLACK);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		titleNameLabel.setVisible(true);
		con.add(titleNamePanel);
		
		
		int r2w = 525;
		int r2h = r2w*9/16;
		
		foregroundPanel = new JPanel();
		foregroundPanel.setBounds(480-(r2w / 2)+10, 480*9/16-(r2h / 2)-6, r2w , r2h);
		foregroundPanel.setBackground(new Color(73, 73, 73));
		foregroundPanel.setVisible(true);
		con.add(foregroundPanel);
		

		backgroundPanel = new JPanel();
		backgroundPanel.setBounds(480-(r2w / 2), 480*9/16-(r2h / 2), r2w , r2h);
		backgroundPanel.setBackground(Color.RED);
		backgroundPanel.setVisible(true);
		con.add(backgroundPanel);
		
		basePanel = new JPanel();
		basePanel.setBounds(480-(WIDTH/ 2), 480*9/16-(HEIGHT / 2), WIDTH, HEIGHT);
		basePanel.setBackground(Color.BLACK);
		basePanel.setVisible(true);
		con.add(basePanel);

		

		
		calcButtonOp = new JButton("Calculate");
		calcButtonOp.setBackground(Color.WHITE);
		calcButtonOp.setForeground(Color.BLACK);
		
		calcButton.add(calcButtonOp);
		calcButton.setFont(normalFont);


	calcButtonOp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String s1 = input1.getText();
			String s2 = input2.getText();
			double var1 = Double.valueOf(s1);
			double var2 = Double.valueOf(s2);

 		    	Coin coin = new Coin();
		    	System.out.println("side facing up " + coin.getSideUp());
		    	int headsCount = 0;
		    	int tailsCount = 0;
		    	
		    	for( int currentToss = 1; currentToss <= var1; currentToss ++) {
		    		Coin.toss();
		    		if(coin.getSideUp() == "Heads") {
		    			headsCount = headsCount += 1;
		    		}
		    		else {
		    			tailsCount = tailsCount += 1;
		    		}
		    		
		    		double percErr = (double) Math.abs((headsCount - var2)/headsCount)*100.0;
		    		DecimalFormat df = new DecimalFormat("###.###");
		    		
		    		System.out.println("side up" + coin.getSideUp());
		    	
		    	output.setText("H: " + headsCount + ", T: " + tailsCount + ", Your % Error: " + df.format(percErr));
		    	System.out.println("out of " + var1 + " tosses, there were " + headsCount + " heads tosses and " + tailsCount + " tails tosses.");
		    	}
			}
		});
		
	}
	
	public static void main(String[] args) {

		new Window();
		
	}
}