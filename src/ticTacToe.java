import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class ticTacToe {

	private int[][] board;
	//private static JButton[][] buttons;
	private static JFrame frame;
	private static game curGame;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		curGame=new game();
		
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


		JPanel ppanel, cpanel, ipanel;
		ppanel=new playPanel();
		cpanel=new chatPanel();
		ipanel=new infoPanel();
		ppanel.repaint();
		/*
		
		JPanel chatPanel;
		chatPanel = new JPanel();
		chatPanel.setLocation(10, 5);
		chatPanel.setBackground(Color.YELLOW);
		chatPanel.setSize(346, 523);
		
		
		JPanel playPanel = new JPanel();
		playPanel.setLocation(366, 5);
		playPanel.setBackground(Color.DARK_GRAY);
		playPanel.setSize(523, 523);
		playPanel.setLayout(new GridLayout(3,3));
		buttons = new JButton[3][3];
		
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLocation(898,5);
		infoPanel.setSize(276,523);
		infoPanel.setBackground(Color.white);
		
		
		
		
		
		
		*/
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(cpanel);
		frame.getContentPane().add(ppanel);
		frame.getContentPane().add(ipanel);
		frame.validate();
		frame.repaint();
		

	}
	
	static class playPanel extends JPanel
	{
		private JButton[][] buttons;
		
		playPanel()
		{
			setSize(523, 523);
			setBackground(Color.DARK_GRAY);
			setLocation(366, 5);
			setLayout(new GridLayout(3,3));
			buttons = new JButton[3][3];
			for(int r = 0;r<3;r++)
			{
				for(int c=0;c<3;c++)
				{
					final int row = r;
					final int col = c;
					buttons[r][c] = new JButton();
					buttons[r][c].setSize(174, 174);
					buttons[r][c].setBackground(Color.LIGHT_GRAY);
					buttons[r][c].addMouseListener(new MouseAdapter()
							{
						public void mousePressed(MouseEvent e)
						{
							int result = curGame.set(row, col);
							int curPlayer = curGame.getCurrentPlayer();
							if(result==0)
							{
								if(curPlayer==1)
									buttons[row][col].setText("X");
								else
									buttons[row][col].setText("O");
							}
						}
						
							});
					
					
					add(buttons[r][c]);
					

					
					//repaint();
					
				}
			}
			repaint();
		}
		
		public void syncBts(int[][] bt)
		{
			
		}
		
		
	}
	
	static class chatPanel extends JPanel
	{
		chatPanel()
		{
			setBackground(Color.YELLOW);
			setSize(346, 523);
			setLocation(10, 5);
		}
	}
	
	static class infoPanel extends JPanel
	{
		infoPanel()
		{
			setSize(276,523);
			setBackground(Color.WHITE);
			setLocation(898,5);
		}
	}
}
