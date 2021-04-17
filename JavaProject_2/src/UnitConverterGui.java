import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class UnitConverterGui extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField txtImperial;
	private JTextField txtMetric;
	private JButton btnconvert;
	private JComboBox comboxUnit1;
	private JComboBox comboxUnit2;
	private boolean UnitSystem;//To tell the code if what we typed was imperial or metric. if true, then convert to metric. vice versa.
	
	private float Imperial;
	private float Metric;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitConverterGui window = new UnitConverterGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnitConverterGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 620, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Imperial/Metric Item Converter");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(0, 0, 606, 39);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 20));
		frame.getContentPane().add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBounds(301, 37, 2, 43);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(10, 37, 586, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblequation = new JLabel("=");
		lblequation.setBackground(Color.DARK_GRAY);
		lblequation.setHorizontalAlignment(SwingConstants.CENTER);
		lblequation.setForeground(Color.WHITE);
		lblequation.setFont(new Font("Arial", Font.BOLD, 30));
		lblequation.setBounds(280, 90, 45, 13);
		frame.getContentPane().add(lblequation);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(301, 113, 2, 404);
		frame.getContentPane().add(separator_2);
		
		JLabel lbl1 = new JLabel("Imperial");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl1.setBounds(10, 42, 281, 26);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Metric");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl2.setBounds(313, 42, 281, 26);
		frame.getContentPane().add(lbl2);
		
		txtImperial = new JTextField();
		txtImperial.setHorizontalAlignment(SwingConstants.CENTER);
		txtImperial.setForeground(Color.BLACK);
		txtImperial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtImperial.setBounds(10, 79, 275, 33);
		frame.getContentPane().add(txtImperial);
		txtImperial.setColumns(10);
		
		txtMetric = new JTextField();
		txtMetric.setHorizontalAlignment(SwingConstants.CENTER);
		txtMetric.setForeground(Color.BLACK);
		txtMetric.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMetric.setColumns(10);
		txtMetric.setBounds(323, 78, 275, 33);
		frame.getContentPane().add(txtMetric);
		
		JLabel lblType1 = new JLabel("Convert Imperial to:");
		lblType1.setForeground(Color.WHITE);
		lblType1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType1.setBounds(10, 122, 155, 18);
		frame.getContentPane().add(lblType1);
		
		JLabel lblType2 = new JLabel("Convert Metric to:");
		lblType2.setForeground(Color.WHITE);
		lblType2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblType2.setBounds(323, 121, 128, 22);
		frame.getContentPane().add(lblType2);
		
		comboxUnit1 = new JComboBox();
		comboxUnit1.setModel(new DefaultComboBoxModel(new String[] {"", "Celcius", "kilometer", 
		"meter", "centimeter", "kilogram", "gram", "hectare", "mililiter", "liter", "kiloliter"}));
		comboxUnit1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboxUnit1.setBounds(160, 122, 125, 18);
		frame.getContentPane().add(comboxUnit1);
		
		comboxUnit2 = new JComboBox();
		comboxUnit2.setModel(new DefaultComboBoxModel(new String[] {"", "Fahrenheit", "mile", "yard",
		"foot", "inch", "ounce", "pound", "acre", "pint", "quart", "gallon"}));
		comboxUnit2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboxUnit2.setBounds(461, 121, 135, 21);
		frame.getContentPane().add(comboxUnit2);
		
		btnconvert = new JButton("Convert");
		btnconvert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnconvert.setBounds(255, 527, 95, 26);
		frame.getContentPane().add(btnconvert);
	}
	private boolean Validate()
	{
		boolean bool = true;
		//if both are empty, set bool to false and send message - one must be open and one must be empty
		
		if(txtImperial.getText().equals("") & txtMetric.getText().equals("")) 
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"There must be a variable in one of the boxes");
		}
		else { 
			
			Imperial = Float.parseFloat(txtImperial.getText());
			Metric = Float.parseFloat(txtMetric.getText());
			if (Metric == 0) {
				
			}
			else if (Imperial == 0) {
				UnitSystem = false;
			}
			else {
				JOptionPane.showMessageDialog(null,"There must be a number in one of the boxes");
			}
		}
		return bool;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
				
				if(source == btnconvert)
				{
					//if controls are valid, run the code
					if(Validate()) {
						
					}
		
	}
}
}
