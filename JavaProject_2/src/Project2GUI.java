import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import classes.InitEntityValue;
import classes.InitEntityValue.LocationAdder;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import java.awt.SystemColor;

public class Project2GUI extends JFrame implements ActionListener{

	//field variables
	private JFrame frame;
	private JEditorPane inputPlan;
	private JTable tableplanner;
	private JButton btnAdd;
	private JButton btnImagesbutton;
	private JButton btnNewButton;
	private JComboBox extrainfoComBox;
	private JEditorPane childclassinput;
	//our inputs of due date and time
	private JTextField txtHour;
	private JTextField txtMinute;
	private JTextField txtdd;
	private JTextField txtmm;
	private JTextField txtyear;
	
	private InitEntityValue plan;
	//private LocationAdder childata;
	//private LocationAdder childata;
	private ArrayList<InitEntityValue> Planner = new ArrayList<InitEntityValue>();
	private String[] columns;
	private Object[][] data;
	private ArrayList<String> infostore = new ArrayList<String>();
	String strPlan = new String("");
	String strTime = new String("");
	String date = new String("");
	private int hour, minute, day, month, year;
	private int tempor;
	private BufferedImage bImg;
	
	private String timetemp[] = new String[100], planString[] = new String[100], childcString[] = new String[100],
			timeminute[] = new String[100], timehour[] = new String[100], dateday[] = new String[100], 
			datemonth[] = new String[100], dateyear[] = new String[100];
	private int timeminuteint[] = new int[100], timehourint[] = new int[100], datedayint[] = new int[100], 
			datemonthint[] = new int[100], dateyearint[] = new int[100];
	private InitEntityValue.LocationAdder variableN;
	private String strchildc;
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
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 620, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Scheduler");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setForeground(new Color(70, 130, 180));
		lblTitle.setBounds(0, 0, 606, 39);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 24));
		frame.getContentPane().add(lblTitle);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(10, 37, 586, 2);
		frame.getContentPane().add(separator_1);
		
		//User inputs plans
		inputPlan = new JEditorPane();
		inputPlan.setBackground(SystemColor.control);
		inputPlan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		inputPlan.setBounds(10, 84, 268, 39);
		frame.getContentPane().add(inputPlan);
		
		tableplanner = new JTable();
		tableplanner.setShowVerticalLines(false);
		tableplanner.setShowGrid(false);
		tableplanner.setBackground(SystemColor.control);
		tableplanner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableplanner.setBounds(298, 59, 298, 494);
		frame.getContentPane().add(tableplanner);
		//line below sets editing to false
		tableplanner.setEnabled(false);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnAdd.setBounds(68, 460, 168, 55);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		JLabel lblTime = new JLabel("Time (12 Hour)");
		lblTime.setForeground(new Color(70, 130, 180));
		lblTime.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		lblTime.setBounds(10, 134, 131, 21);
		frame.getContentPane().add(lblTime);
		
		txtHour = new JTextField();
		txtHour.setHorizontalAlignment(SwingConstants.CENTER);
		txtHour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHour.setBounds(10, 164, 45, 23);
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
		txtMinute.setBounds(84, 164, 45, 23);
		frame.getContentPane().add(txtMinute);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(70, 130, 180));
		lblDate.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		lblDate.setBounds(151, 134, 45, 20);
		frame.getContentPane().add(lblDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(151, 153, 119, 2);
		frame.getContentPane().add(separator);
		
		JLabel lbldd = new JLabel("Day    #:");
		lbldd.setForeground(new Color(70, 130, 180));
		lbldd.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		lbldd.setBounds(151, 165, 77, 22);
		frame.getContentPane().add(lbldd);
		
		txtdd = new JTextField();
		txtdd.setHorizontalAlignment(SwingConstants.CENTER);
		txtdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtdd.setColumns(10);
		txtdd.setBounds(238, 165, 35, 23);
		frame.getContentPane().add(txtdd);
		
		JLabel lblmm = new JLabel("Month #:");
		lblmm.setForeground(new Color(70, 130, 180));
		lblmm.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		lblmm.setBounds(151, 198, 77, 22);
		frame.getContentPane().add(lblmm);
		
		txtmm = new JTextField();
		txtmm.setHorizontalAlignment(SwingConstants.CENTER);
		txtmm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtmm.setColumns(10);
		txtmm.setBounds(238, 199, 35, 23);
		frame.getContentPane().add(txtmm);
		
		JLabel lblyyyy = new JLabel("Year   #:");
		lblyyyy.setForeground(new Color(70, 130, 180));
		lblyyyy.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		lblyyyy.setBounds(151, 231, 77, 22);
		frame.getContentPane().add(lblyyyy);
		
		txtyear = new JTextField();
		txtyear.setHorizontalAlignment(SwingConstants.CENTER);
		txtyear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtyear.setColumns(10);
		txtyear.setBounds(238, 233, 35, 23);
		frame.getContentPane().add(txtyear);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(139, 134, 2, 119);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Event Name");
		lblNewLabel.setForeground(new Color(70, 130, 180));
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(97, 50, 99, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 153, 121, 2);
		frame.getContentPane().add(separator_3);
		
		extrainfoComBox = new JComboBox();
		extrainfoComBox.setModel(new DefaultComboBoxModel(new String[] {"", "Location"}));
		extrainfoComBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		extrainfoComBox.setBounds(10, 290, 119, 26);
		frame.getContentPane().add(extrainfoComBox);
		
		JLabel lblExtraInfo = new JLabel("Extra Info:");
		lblExtraInfo.setForeground(new Color(70, 130, 180));
		lblExtraInfo.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		lblExtraInfo.setBounds(10, 258, 119, 22);
		frame.getContentPane().add(lblExtraInfo);
		
		childclassinput = new JEditorPane();
		childclassinput.setBackground(SystemColor.control);
		childclassinput.setBounds(139, 266, 139, 50);
		frame.getContentPane().add(childclassinput);
		//will try to create the image variable
		//needs try/catch just in case it can't find/read the image file
		//NOTE: in order for image to work, run in administrator
		//If you decrease the JLabel, you must decrease the width and height of the actual image as well
		try {
			bImg = ImageIO.read(new File("img/RedX.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Image Unable to load, Run in administrator");
		}
		
		btnImagesbutton = new JButton(" ");
		btnImagesbutton.setToolTipText("CLEAR INPUTS");
		btnImagesbutton.setBackground(Color.LIGHT_GRAY);
		btnImagesbutton.setBounds(68, 340, 168, 50);
		btnImagesbutton.setIcon(new ImageIcon(bImg.getScaledInstance(100, 70, Image.SCALE_SMOOTH)));
		frame.getContentPane().add(btnImagesbutton);
		btnImagesbutton.addActionListener(this);
		
		btnNewButton = new JButton("CLEAR SCHEDULE");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnNewButton.setBounds(68, 400, 168, 50);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		
		
		//How many columns are in the table
		if (extrainfoComBox.getSelectedItem().equals("Location")) {
			columns = new String[] { 
			"Plan", "Due Time", "Due Date", "Location"
			};
		}
		else {
			columns = new String[] { 
			"Plan", "Due Time", "Due Date"
			};
		}
		
		data = new Object[][] {
			
		};
	}
	
	private boolean Validate() 
	{
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
			hour = Integer.parseInt(txtHour.getText());
			if(hour < 0 || hour > 12) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Hour must be within 0 - 12");
			}
		}
		
		if(txtMinute.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Minute is a required variable");
		}
		else {
			minute = Integer.parseInt(txtMinute.getText());
			if(minute < 0 || minute > 60) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Minute must be within 0 - 60");
			}
		}
		
		if(txtdd.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Day is a required variable");
		}
		else {
			day = Integer.parseInt(txtdd.getText());
			if(day < 0 || day > 31) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Day must be within 0 - 31/30");
			}
		}
		
		if(txtmm.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Month is a required variable");
		}
		else {
			month = Integer.parseInt(txtmm.getText());
			if(month < 0 || month > 12) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Month must be an integer between 1-12");
			}
		}
		
		if(txtyear.getText().equals(""))
		{
			bool = false;
			JOptionPane.showMessageDialog(null,"Year is a required variable");
		}
		else {
			year = Integer.parseInt(txtyear.getText());
			if(year < 0) {
				bool = false;
				JOptionPane.showMessageDialog(null,"Year must be a integer greater than 0");
			}
		}
		
		return bool;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//press the button
		Object source = e.getSource();
		if(source == btnImagesbutton)
		{
			inputPlan.setText("");
			childclassinput.setText("");
			txtHour.setText("");
			txtMinute.setText("");
			txtdd.setText("");
			txtmm.setText("");
			txtyear.setText("");
		}
		if(source == btnAdd)
		{
			//if controls are valid, run the code
			if(Validate())
			{
				
				//we need to store this info somewhere
				//oldest to newest
				//put all into one string
				String str1 = Integer.toString(hour);
				String str2 = Integer.toString(minute);
				String str3 = Integer.toString(day);
				String str4 = Integer.toString(month);
				String str5 = Integer.toString(year);
				String variablex = new String(str1 + "-" + str2 + "-" + str3 + "-" + 
				str4 + "-" + str5 + "-" + inputPlan.getText());
				if (extrainfoComBox.getSelectedItem().equals("Location")) {
					variablex = variablex + "+" + childclassinput.getText();
				}
				
				infostore.add(variablex);
				System.out.println(infostore);
				
				//Bubble sorts
				 
				String temp = "";
				int temp1, temp2, temp3, temp4, temp5 = 0;
		        if(infostore.size() > 1) {
		        	
		        	for(int x = 0; x < infostore.size(); x++)
					{
						timetemp[x] = infostore.get(x);
						
						//split an array index into their own useful forms - does this for ALL indexes
						String[] parts = timetemp[x].split("-");
						timehour[x] = parts[0];
						timeminute[x] = parts[1];
						dateday[x] = parts[2];
						datemonth[x] = parts[3];
						dateyear[x] = parts[4];
						//turn them into integers in order to bubble sort
						timehourint[x] = Integer.parseInt(timehour[x]);
						timeminuteint[x] = Integer.parseInt(timeminute[x]);
						datedayint[x] = Integer.parseInt(dateday[x]);
						datemonthint[x] = Integer.parseInt(datemonth[x]);
						dateyearint[x] = Integer.parseInt(dateyear[x]);
					}	
			        /*this controls how many times we need to
			        repeat the sort (for every item in the array)
			        NOTE: extremely sensitive to order in which you for loop
			        */
		            for(int i = 0; i < infostore.size(); i++)
			        {
		            	for(int j = 1; j < (infostore.size() - i); j++)
					       	{
				            	if(timeminuteint[j - 1] > timeminuteint[j])
				            	{
				            	temp = infostore.get(j);
						        infostore.set(j, infostore.get(j - 1));
						        infostore.set(j - 1, temp);
						                     
						        temp1 = dateyearint[j-1];
						        dateyearint[j-1] = dateyearint[j];
						        dateyearint[j] = temp1;
						        temp2 = datemonthint[j-1];
						        datemonthint[j-1] = datemonthint[j];
						        datemonthint[j] = temp2;
						        temp3 = datedayint[j-1];
						        datedayint[j-1] = datedayint[j];
						        datedayint[j] = temp3;
						        temp4 = timehourint[j-1];
						        timehourint[j-1] = timehourint[j];
						        timehourint[j] = temp4;
						        temp5 = timeminuteint[j-1];
						        timeminuteint[j-1] = timeminuteint[j];
						        timeminuteint[j] = temp5;
						        }
					       	}
		            	for(int j = 1; j < (infostore.size() - i); j++)
					       	{
				            	if(timehourint[j - 1] > timehourint[j])
				            	{
				            	temp = infostore.get(j);
						        infostore.set(j, infostore.get(j - 1));
						        infostore.set(j - 1, temp);
						                     
						        temp1 = dateyearint[j-1];
						        dateyearint[j-1] = dateyearint[j];
						        dateyearint[j] = temp1;
						        temp2 = datemonthint[j-1];
						        datemonthint[j-1] = datemonthint[j];
						        datemonthint[j] = temp2;
						        temp3 = datedayint[j-1];
						        datedayint[j-1] = datedayint[j];
						        datedayint[j] = temp3;
						        temp4 = timehourint[j-1];
						        timehourint[j-1] = timehourint[j];
						        timehourint[j] = temp4;
						        temp5 = timeminuteint[j-1];
						        timeminuteint[j-1] = timeminuteint[j];
						        timeminuteint[j] = temp5;
						        }
					       	}
			            for(int j = 1; j < (infostore.size() - i); j++)
					        {
				            	if(datedayint[j - 1] > datedayint[j])
				            	{
				            	temp = infostore.get(j);
				            	infostore.set(j, infostore.get(j - 1));
						        infostore.set(j - 1, temp);
						                     
						        temp1 = dateyearint[j-1];
						        dateyearint[j-1] = dateyearint[j];
						        dateyearint[j] = temp1;
						        temp2 = datemonthint[j-1];
						        datemonthint[j-1] = datemonthint[j];
						        datemonthint[j] = temp2;
						        temp3 = datedayint[j-1];
						        datedayint[j-1] = datedayint[j];
						        datedayint[j] = temp3;
						        temp4 = timehourint[j-1];
						        timehourint[j-1] = timehourint[j];
						        timehourint[j] = temp4;
						        temp5 = timeminuteint[j-1];
						        timeminuteint[j-1] = timeminuteint[j];
						        timeminuteint[j] = temp5;
						        }
					        }
			            for(int j = 1; j < (infostore.size() - i); j++)
				           	{
				            //System.out.println(j);
				            //i represents the current value in the current index, starting from 0
					            if(datemonthint[j - 1] > datemonthint[j])
					            {
					            temp = infostore.get(j);
					            infostore.set(j, infostore.get(j - 1));
					            infostore.set(j - 1, temp);
						                     
					            temp1 = dateyearint[j-1];
					            dateyearint[j-1] = dateyearint[j];
					            dateyearint[j] = temp1;
					            temp2 = datemonthint[j-1];
					            datemonthint[j-1] = datemonthint[j];
					            datemonthint[j] = temp2;  
					            temp3 = datedayint[j-1];
							    datedayint[j-1] = datedayint[j];
							    datedayint[j] = temp3;
							    temp4 = timehourint[j-1];
							    timehourint[j-1] = timehourint[j];
							    timehourint[j] = temp4;
							    temp5 = timeminuteint[j-1];
							    timeminuteint[j-1] = timeminuteint[j];
							    timeminuteint[j] = temp5;
						        }
				           	}
			            for(int j = 1; j < (infostore.size() - i); j++)
			                {
			            	//System.out.println(j);
			                //i represents the current value in the current index, starting from 0
			            	//sorts by year
				            	if(dateyearint[j - 1] > dateyearint[j])
				            	{
				            	temp = infostore.get(j);
				            	infostore.set(j, infostore.get(j - 1));
				            	infostore.set(j - 1, temp);
				                     
				            	temp1 = dateyearint[j-1];
				            	dateyearint[j-1] = dateyearint[j];
				            	dateyearint[j] = temp1;
				            	temp2 = datemonthint[j-1];
				            	datemonthint[j-1] = datemonthint[j];
				            	datemonthint[j] = temp2;
				            	temp3 = datedayint[j-1];
						        datedayint[j-1] = datedayint[j];
						        datedayint[j] = temp3;
						        temp4 = timehourint[j-1];
						        timehourint[j-1] = timehourint[j];
						        timehourint[j] = temp4;
						        temp5 = timeminuteint[j-1];
						        timeminuteint[j-1] = timeminuteint[j];
						        timeminuteint[j] = temp5;
				                }
			                }
			           	}
			            
			            String formattedArray = "test\n";
					    for(String tempint : infostore) //forEach loop
					    {
					    	formattedArray += tempint + "\n";
					    }
					    //System.out.println(formattedArray);
					    //System.out.println(infostore);
		            	}
		        		
				        for(int x = 0; x < infostore.size(); x++)
						{
							timetemp[x] = infostore.get(x);
							
							//split an array index into their own useful forms - does this for ALL indexes
							String[] parts = timetemp[x].split("-");
							timehour[x] = parts[0];
							timeminute[x] = parts[1];
							dateday[x] = parts[2];
							datemonth[x] = parts[3];
							dateyear[x] = parts[4];
							planString[x] = parts[5];
							if (extrainfoComBox.getSelectedItem().equals("Location")) {
								String[] parts1 = planString[x].split("\\+");
								planString[x] = parts1[0];
								childcString[x] = parts1[1];
								System.out.println(planString[x]);
								strchildc = childcString[x].toString();
							}
							//turn them into integers
							timehourint[x] = Integer.parseInt(timehour[x]);
							timeminuteint[x] = Integer.parseInt(timeminute[x]);
							datedayint[x] = Integer.parseInt(dateday[x]);
							datemonthint[x] = Integer.parseInt(datemonth[x]);
							dateyearint[x] = Integer.parseInt(dateyear[x]);
							
							String strPlan = planString[x].toString();
							String s = String.format("%02d", timeminuteint[x]);
							String strTime = timehourint[x] + ":" + s;
							String date = datedayint[x] + "/" + datemonthint[x] + "/" + dateyearint[x];
							
							
							plan = new InitEntityValue((String) strPlan, strTime, date); //sends into class
							if((variableN instanceof LocationAdder)) {
							variableN = new InitEntityValue().new LocationAdder();
							}
							Planner.add(plan);
							
							if (extrainfoComBox.getSelectedItem().equals("Location")) {
								data = new Object[Planner.size() + 1][columns.length];
								for(int i = 0; i < Planner.size(); i++)
								{
									data[i][0] = Planner.get(i).getPlans();
									data[i][1] = Planner.get(i).getTime();
									data[i][2] = Planner.get(i).getDate();
									data[i][3] = variableN.getEventLocation();
								}
							}
							else {
								data = new Object[Planner.size()][columns.length];
								for(int i = 0; i < Planner.size(); i++)
								{
									data[i][0] = Planner.get(i).getPlans();
									data[i][1] = Planner.get(i).getTime();
									data[i][2] = Planner.get(i).getDate();
									
								}
							}
							
							tableplanner.setModel(new DefaultTableModel(data,columns));
							//System.out.println(plan);
							hour = 0; minute = 0; day = 0; month = 0; year = 0;
							str1 = ""; str2 = ""; str3 = ""; str4 = ""; str5 = "";
							temp = "";
							temp1 = 0; temp2 = 0; temp3 = 0; temp4 = 0; temp5 = 0;
							timetemp[x] = ""; timehour[x] = ""; timeminute[x] = "";
							dateday[x] = ""; datemonth[x] = ""; dateyear[x] = "";
							timehourint[x] = 0; timeminuteint[x] = 0;
							datedayint[x] = 0; datemonthint[x] = 0; dateyearint[x] = 0;
							strPlan = ""; s = ""; strTime = ""; date = "";
							
					}
					Planner.clear();
				}
		            
			}
			//resets the table when table clear button is clicked on
			if(source == btnNewButton)
			{
				infostore.clear();
				DefaultTableModel model = (DefaultTableModel) tableplanner.getModel();
				model.setRowCount(0);
			}
		}
}






