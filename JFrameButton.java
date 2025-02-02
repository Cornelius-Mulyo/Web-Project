package mulyo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameButton extends JFrame implements ActionListener {
	private JLabel enterName;
	private JTextField name;
	private JButton click;
	private String storeName = "";
	
	public JFrameButton() {

		setLayout(null);
		JButton button = new JButton("Click me");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enterName = new JLabel("Enter Your Name: ");
		click = new JButton("click");
		name = new JTextField();
		enterName.setBounds(60, 30, 120, 30);
		name.setBounds(80, 60, 130, 30);
		click.setBounds(100, 190, 60, 30);
		click.addActionListener(this);
		add(click);
		add(name);
		add(enterName);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() ==click ) {
			storeName = name.getText();
			JOptionPane.showMessageDialog(null, "Hello " + storeName);
			System.exit(0);
			// Go HATTERS
			// Program by : Cornelius Mulyokela
		}
		

		
		
		

	}

}
