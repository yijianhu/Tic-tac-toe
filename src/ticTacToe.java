import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class ticTacToe {

	private int[][] board;
	//private static JButton[][] buttons;
	private static JFrame frame;
	private static game curGame;
	private static int winner;
	private static int steps; // MAX 9 Steps
	private static playPanel ppanel;
	private static chatPanel cpanel;
	private static infoPanel ipanel;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		frame = new JFrame();
		ppanel=new playPanel();
		cpanel=new chatPanel();
		ipanel=new infoPanel();
		curGame=new game();
		
		
		//basic frame 
		frame.setSize(1200,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic-tac-toe");
		frame.setResizable(false);

		//menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu();
		menu.setText("Menu");
		JMenuItem item1 = new JMenuItem();
		item1.setText("new game");
		item1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)
			{
				curGame=new game();
				winner=0;
				steps=0;
				ppanel.clear();
				ipanel.setWinner("");
			}
		});
		
		
		menu.add(item1);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		
		winner=0;
		steps=0;


		//JPanel ppanel, cpanel, ipanel;
		ppanel.repaint();

		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(cpanel);
		frame.getContentPane().add(ppanel);
		frame.getContentPane().add(ipanel);
		frame.validate();
		frame.repaint();
		

	}
	
	private static void init()
	{
		
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
							if(winner==0)
							{
								int result = curGame.set(row, col);
								//System.out.println("result= " + winner);
								int curPlayer = curGame.getCurrentPlayer();
								if(result!=-1)
								{
									if(curPlayer==1)
										buttons[row][col].setText("X");
									else
										buttons[row][col].setText("O");
									if(result==1)
									{
										winner=1;
										ipanel.setWinner("Player 1 with O");
									}
									else if(result==2)
									{
										winner=2;
										ipanel.setWinner("Player 2 with X");
									}
									buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 80));
									//System.out.println("winner= " + winner);
									steps++;
									if(steps==9 && winner==0)
										ipanel.setWinner("Draw");
								}
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
		
		public void clear()
		{
			for(int r = 0;r<buttons.length;r++)
			{
				for(int c=0;c<buttons[r].length;c++)
				{
					buttons[r][c].setText("");
				}
			}
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
		private JLabel curWinner_lb, winner_lb;
		
		infoPanel()
		{
			setSize(276,523);
			setBackground(Color.WHITE);
			setLocation(898,5);
			
			curWinner_lb = new JLabel("Current Winner : ");
			winner_lb = new JLabel();
			setLayout(new GridLayout(1,2));
			add(curWinner_lb);
			add(winner_lb);
		}
		
		public void setWinner(String win)
		{
			winner_lb.setText(win);
			validate();
			repaint();
		}
	}
}
