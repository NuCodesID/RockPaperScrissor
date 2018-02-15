package team.nucodes.rockpaperscrissor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JLabel lblScore = new JLabel();
	public static JLabel lblGame = new JLabel();
	public static JLabel lblLose = new JLabel();
	public static JTextField textField = new JTextField();
	public static int Score = 0;
	public static int Game = 0;
	public static int Lose = 0;
	public static String previousPlayerSelection = null;
	public static String previousComputerSelection = null;
	public static String result = null;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static boolean Chance(int Chance) {
		return ((Math.random() * 100) < Chance);
	}
	
	public static String getComputerSelection() {
		String[] list = {"Rock", "Paper", "Scrissor"};
		result = list[new Random().nextInt(list.length - 1)];
		int switchComputer = new Random().nextInt(2);
		try {
			if (switchComputer == 2) {
				if (!previousComputerSelection.equals(result)) {
					getComputerSelection();
				}else {
					previousComputerSelection = result;
				}
			}if (switchComputer == 1) {
				
				if (previousPlayerSelection.equals("Rock")) {
					if (Chance(75) == true) {
						result = list[1];
					}else if (Chance(90)== true){
						result = list[2];
					}else {
						result = list[0];
					}
				}else if(previousPlayerSelection.equals("Scrissor")) {
					if (Chance(75) == true) {
						result = list[0];
					}else if (Chance(80) == true){
						result = list[2];
					}else {
						result = list[1];
					}
				}else if(previousPlayerSelection.equals("Paper")) {
					if (Chance(75) == true) {
						result =  list[2];
					}else if (Chance(90) == true){
						result = list[1];
					}else {
						result = list[0];
					}
				}else {
					getComputerSelection();
				}
			}else {
				getComputerSelection();
			}			
		}catch(Exception e) {
			return (list[new Random().nextInt(list.length - 1)]);
		}
		if (result == null || result == "") {
			getComputerSelection();
		}
		return result;
	}
	
	public static boolean getPlayerIsWinner(String selection) {
		
		String computerSelection = getComputerSelection();
		Game++;
		lblGame.setText("Game: " + Game);
		previousPlayerSelection = selection;
		
		if (computerSelection == null || computerSelection == "") {
			return false;
		}
		
		//Computer Winner
		if (selection.equals("Rock") && computerSelection.equals("Paper")) {
			textField.setText(selection + " [P] vs [C] " + result);
			Lose++;
			lblLose.setText("Lose: " + Lose);
			return false;
		}
		
		if (selection.equals("Paper") && computerSelection.equals("Scrissor")) {
			textField.setText(selection + " [P] vs [C] " + result);
			Lose++;
			lblLose.setText("Lose: " + Lose);
			return false;
		}
		
		if (selection.equals("Scrissor") && computerSelection.equals("Rock")) {
			textField.setText(selection + " [P] vs [C] " + result);
			Lose++;
			lblLose.setText("Lose: " + Lose);
			return false;
		}
		
		//Player Winner
		if (selection.equals("Rock") && computerSelection.equals("Scrissor")) {
			Score++;
			lblScore.setText("Score: " + Score);
			textField.setText(selection + " [P] vs [C] " + result);
			return true;
		}
		if (selection.equals("Paper") && computerSelection.equals("Rock")) {
			Score++;
			lblScore.setText("Score: " + Score);
			textField.setText(selection + " [P] vs [C] " + result);
			return true;
		}
		if (selection.equals("Scrissor") && computerSelection.equals("Paper")) {
			Score++;
			lblScore.setText("Score: " + Score);
			textField.setText(selection + " [P] vs [C] " + result);
			return true;
		}
		// Tie
		else {
			textField.setText(selection + " [P] vs [C] " + result);
			return false;
		}
		
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Rock Paper Scrissor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JList list = new JList();
		
		JButton btnRock = new JButton("Rock");
		
		
		JButton btnPaper = new JButton("Paper");
		
		JButton btnScrissor = new JButton("Scrissor");
		
		lblScore = new JLabel("Score: 0");
		
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getPlayerIsWinner("Rock");
				
			}
		});
		
		btnScrissor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getPlayerIsWinner("Scrissor");
				
			}
		});
		
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getPlayerIsWinner("Paper");
				
			}
		});
		
		lblGame = new JLabel("Game: 0");
		
		lblLose = new JLabel("Lose: 0");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblGame)
							.addGap(18)
							.addComponent(lblLose))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRock, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblScore))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnPaper, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnScrissor, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(38)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
							.addGap(64)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScore)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGame)
						.addComponent(lblLose))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRock)
						.addComponent(btnPaper)
						.addComponent(btnScrissor))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
