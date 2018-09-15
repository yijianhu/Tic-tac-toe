import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;

public class gameUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameUI frame = new gameUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 1200, 600);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 616, 551);
		contentPane.add(panel);
		panel.setBackground(Color.gray);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 198, 365, 230);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 438, 365, 70);
		panel.add(textArea_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(636, 10, 550, 550);
		contentPane.add(panel_1);
		panel_1.setBackground(Color.white);
		panel_1.setLayout(new GridLayout(3, 3, 10, 10));
		
		JButton[][] blocks = new JButton[3][3];
	}
}
