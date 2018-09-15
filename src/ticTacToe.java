import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class ticTacToe {

	private int[][] board;
	private static JFrame frame;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//basic frame
		frame = new JFrame();
		frame.setSize(1200,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-tac-toe");
		frame.setResizable(true);
		
		//menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu();
		menu.setText("Menu");
		JMenuItem item1 = new JMenuItem();
		item1.setText("save game");
		
		menu.add(item1);
		
		menuBar.add(menu);
		
		frame.setJMenuBar(menuBar);


		
		
		
		JPanel panel;
		panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setSize(400, 600);
		panel.add(new JButton("left bt"));
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setSize(800, 600);
		panel2.setLayout(new GridLayout(2,1));
		panel2.add(new JButton("right bt"));
		
		
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		
		frame.add(panel);
		frame.add(panel2);
		frame.repaint();
		

	}

}
