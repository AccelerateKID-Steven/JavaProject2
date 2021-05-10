import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import classes.InitEntityValue;

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
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTable;

public class Project2GUI extends JFrame implements ActionListener{

	//field variables
	private JFrame frame;
	private JEditorPane inputPlan;
	private JTable tableplanner;
	private JButton btnAdd;
	//our inputs of due date and time
	private JTextField txtHour;
	private JTextField txtMinute;
	private JTextField txtdd;
	private JTextField txtmm;
	private JTextField txtyear;
	
	private InitEntityValue plan;
	private ArrayList<InitEntityValue> Planner = new ArrayList<InitEntityValue>();
	private String[] columns;
	private Object[][] data;
	private ArrayList<String> infostore = new ArrayList<String>();
	private int addpressnumber = 0;
	String strPlan = new String("");
	String strTime = new String("");
	String date = new String("");
	private int hour, minute, day, month, year;
	
	
	private String timetemp[] = new String[100], timeminute[] = new String[100], timehour[] = new String[100], 
			dateday[] = new String[100], datemonth[] = new String[100], dateyear[] = new String[100];
	private int timeminuteint[] = new int[100], timehourint[] = new int[100], datedayint[] = new int[100], 
			datemonthint[] = new int[100], dateyearint[] = new int[100];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project2GUI window = new Project2GUI();
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
	public Project2GUI() {
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
		
		JLabel lblTitle = new JLabel("Scheduler");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(0, 0, 606, 39);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 20));
		frame.getContentPane().add(lblTitle);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(10, 37, 586, 2);
		frame.getContentPane().add(separator_1);
		
		//User inputs plans
		inputPlan = new JEditorPane();
		inputPlan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputPlan.setBounds(10, 49, 586, 75);
		frame.getContentPane().add(inputPlan);
		
		tableplanner = new JTable();
		tableplanner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableplanner.setBounds(10, 390, 586, 163);
		frame.getContentPane().add(tableplanner);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(260, 357, 85, 21);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		JLabel lblTime = new JLabel("Time (12 Hour)");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(10, 134, 131, 21);
		frame.getContentPane().add(lblTime);
		
		txtHour = new JTextField();
		txtHour.setHorizontalAlignment(SwingConstants.CENTER);
		txtHour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHour.setBounds(20, 165, 35, 23);
		frame.getContentPane().add(txtHour);
		txtHour.setColumns(10);
		
		JLabel lbl1 = new JLabel(":");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl1.setForeground(Color.WHITE);
		lbl1.setBounds(65, 165, 6, 23);
		frame.getContentPane().add(lbl1);
		
		txtMinute = new JTextField();
		txtMinute.setHorizontalAlignment(SwingConstants.CENTER);
		txtMinute.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMinute.setColumns(10);
		txtMinute.setBounds(81, 165, 35, 23);
		frame.getContentPane().add(txtMinute);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(151, 134, 45, 20);
		frame.getContentPane().add(lblDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(151, 153, 141, 2);
		frame.getContentPane().add(separator);
		
		JLabel lbldd = new JLabel("Day #:");
		lbldd.setForeground(Color.WHITE);
		lbldd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldd.setBounds(151, 165, 57, 22);
		frame.getContentPane().add(lbldd);
		
		txtdd = new JTextField();
		txtdd.setHorizontalAlignment(SwingConstants.CENTER);
		txtdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtdd.setColumns(10);
		txtdd.setBounds(207, 165, 35, 23);
		frame.getContentPane().add(txtdd);
		
		JLabel lblmm = new JLabel("Month #:");
		lblmm.setForeground(Color.WHITE);
		lblmm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmm.setBounds(252, 165, 77, 22);
		frame.getContentPane().add(lblmm);
		
		txtmm = new JTextField();
		txtmm.setHorizontalAlignment(SwingConstants.CENTER);
		txtmm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtmm.setColumns(10);
		txtmm.setBounds(328, 165, 35, 23);
		frame.getContentPane().add(txtmm);
		
		JLabel lblyyyy = new JLabel("Year #:");
		lblyyyy.setForeground(Color.WHITE);
		lblyyyy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblyyyy.setBounds(373, 166, 62, 22);
		frame.getContentPane().add(lblyyyy);
		
		txtyear = new JTextField();
		txtyear.setHorizontalAlignment(SwingConstants.CENTER);
		txtyear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtyear.setColumns(10);
		txtyear.setBounds(434, 165, 35, 23);
		frame.getContentPane().add(txtyear);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(140, 134, 1, 75);
		frame.getContentPane().add(separator_2);
		
		//How many columns are in the table
		columns = new String[] { 
				"Plan", "Due Time", "Due Date",
				//"Day", "Month", "Year"
			};
		
		data = new Object[][] {
			
		};
	}
	
	private boolean Validate() {
		boolean bool = true;
		hour = 0;
		minute = 0;
		day = 0;
		month = 0;
		year = 0;
		if(inputPlan.getText().equals("")) //if empty or no reply
		{
			bool = false; //no initiation
			JOptionPane.showMessageDialog(null,"You must write something in the large box");
		}
		if(txtHour.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Hour is a required variable");
		}
		else {
			try { //same thing
				hour = Integer.parseInt(txtHour.getText());
				if(hour < 0 || hour > 12) {
					
				}
			}
			catch(Exception e) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Hour is a required variable");
				}
			}
		if(txtMinute.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Minute is a required variable");
		}
		else {
			try {
				minute = Integer.parseInt(txtMinute.getText());
				if(minute < 0 || minute > 60) {
					
				}
			}
			catch(Exception e) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Minute is a required variable");
				}
			}
		if(txtdd.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Day is a required variable");
		}
		else {
			try {
				day = Integer.parseInt(txtdd.getText());
				if(day < 0 || day > 31) {
					
				}
			}
			catch(Exception e) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Day is a required variable");
				}
			}
		if(txtmm.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Month is a required variable");
		}
		else {
			try {
				month = Integer.parseInt(txtmm.getText());
				if(month < 0 || month > 12) {
					
				}
			}
			catch(Exception e) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Month is a required variable");
				}
			}
		if(txtyear.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Year is a required variable");
		}
		else {
			try {
				year = Integer.parseInt(txtyear.getText());
				if(year < 0) {
					
				}
			}
			catch(Exception e) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Year is a required variable");
				}
			}
		return bool;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//press the button
		Object source = e.getSource();
		if(source == btnAdd)
		{
			addpressnumber = addpressnumber + 1;
			//if controls are valid, run the code
			if(Validate())
			{
				//strTime is like 5:30, strPlan is whatcha gonna do, date is like due date
				String strPlan = inputPlan.getText();
				String s = String.format("%02d", minute);
				String strTime = hour + ":" + s;
				String date = day + "/" + month + "/" + year;
				
				//send information to InitEntityValue class to create an InitEntityValue with constructor
				plan = new InitEntityValue((String) strPlan, strTime, date, (int) day, month, year);
				System.out.println(Planner.toString());
				
				Planner.add(plan);
				
				data = new Object[Planner.size()][columns.length];
				
				//take our information and put it in our 2D array
				
				/*TODO: every time we get information, we will loop it that many times the
				//next time we add another submission (after sorting)
				ex: 2 submissions -> runs two times*/
				for(int i = 0; i < Planner.size(); i++)
				{
					data[i][0] = Planner.get(i).getPlans();
					data[i][1] = Planner.get(i).getTime();
					data[i][2] = Planner.get(i).getDate();
					/*data[i][3] = Planner.get(i).getDay();
					data[i][4] = Planner.get(i).getMonth();
					data[i][5] = Planner.get(i).getYear();*/
				}
				//put into table
				tableplanner.setModel(new DefaultTableModel(data,columns));
				
				//TODO:sort multiple "Add" submissions
				//yeah i have no idea how to do this, help - we need to store this info somewhere
				//oldest to newest
				//put all into one string
				String str1 = Integer.toString(hour);
				String str2 = Integer.toString(minute);
				String str3 = Integer.toString(day);
				String str4 = Integer.toString(month);
				String str5 = Integer.toString(year);
				String variablex = new String(str1 + "-" + str2 + "-" + str3 + "-" + 
				str4 + "-" + str5 + "-" + strPlan);
				
				infostore.add(variablex);
				System.out.println(infostore);
				
				for(int x = 0; x < infostore.size(); x++)
				{
					timetemp[x] = infostore.get(x);
					//timeminute = timehour;
					
					String[] parts = timetemp[x].split("-");
					timehour[x] = parts[0];
					timeminute[x] = parts[1];
					dateday[x] = parts[2];
					datemonth[x] = parts[3];
					dateyear[x] = parts[4];
					
					timehourint[x] = Integer.parseInt(timehour[x]);
					timeminuteint[x] = Integer.parseInt(timeminute[x]);
					datedayint[x] = Integer.parseInt(dateday[x]);
					datemonthint[x] = Integer.parseInt(datemonth[x]);
					dateyearint[x] = Integer.parseInt(dateyear[x]);
					
					//timehour = timehour.substring(0,timehour.indexOf("-"));
					//timeminute = timeminute.substring(timeminute.indexOf("-") + 1, timeminute.length());
					System.out.println(timehourint[x] + ":" + timeminuteint[x] + ":" + datedayint[x]
							+ ":" + datemonthint[x] + ":" + dateyearint[x]);
				}	
				/*
				 	//TODO:SORTER
				 
					int temp = 0;
					int size = infostore.size();
		            
		            /*this controls how many times we need to
		            repeat the sort (for every item in the array)
		            *
		            for(int i = 0; i < infostore.size(); i++) 
		            {
		            /* This sorts the array once starting at the first index
		            *
		               for(int j = 1; j < (infostore.size() - i); j++)
		               {
		                  //i represents the current value in the current index, starting from 0
		                  if(timehourint[i] > timehourint[i+1]){
		                     //if the first letter in the current student's name has a greater
		                     //decimal than the next...
		                     temp = timehourint[j-1];
		                     timehourint[j-1] = timehourint[j];
		                     timehourint[j] = temp;
		                     
		                  }
		               }
		            }
		            String formattedArray = "thing\n";
		            for(int tempint : timehourint) //forEach loop
		            {
		               formattedArray += tempint;
		            }
		            System.out.println(formattedArray);
				*/
			} 
			
		} 
				
	}
	
}





