package srpTracking;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;



//DB Connector import
import java.sql.*;
import org.h2.*;
import org.h2.tools.DeleteDbFiles;


public class WindowLesson {

	private JFrame frame;
	private JTable eintraegetabelle;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowLesson window = new WindowLesson();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public WindowLesson() throws ClassNotFoundException, SQLException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, SQLException {

		// Create the main Frame (muhaha, such sophistication)

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1000, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Create program Headline and Action Listener

		JLabel lblStundenplanToolPrs = new JLabel("StundenPlan Tool PRS");
		lblStundenplanToolPrs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblStundenplanToolPrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblStundenplanToolPrs.setBounds(370, 10, 260, 60);
		frame.getContentPane().add(lblStundenplanToolPrs);

		// Create ComboBox Class Level and Action Listener
		// Create DB Query for the DropDownContent
		DatabaseConnector dropDownConnect = new DatabaseConnector();
		String [] lehrerMoeglichkeiten = dropDownConnect.queryresultsfordropdown("lehrer","nachname");
		
		Integer[] stufenMoeglichkeiten = { 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		JComboBox comboBoxStufe = new JComboBox(stufenMoeglichkeiten);
		comboBoxStufe.setBounds(12, 118, 110, 40);
		/*
		 * old action listener, deleted for all other buttons
		 * comboBoxStufe.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent e){ Integer stufenWert =
		 * (Integer)comboBoxStufe.getSelectedItem();
		 * System.out.println(stufenWert); } });
		 */
		frame.getContentPane().add(comboBoxStufe);

		// Create ComboBox Class School Type and Action Listener

		String[] zweigMoeglichkeiten = { "Haupt", "Real", "Gym", "Ober" };

		JComboBox comboBoxZweig = new JComboBox(zweigMoeglichkeiten);
		comboBoxZweig.setBounds(132, 118, 110, 40);
		frame.getContentPane().add(comboBoxZweig);

		// Create ComboBox to specify the class more and Action Listener

		Integer[] klassenMoeglichkeiten = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		JComboBox comboBoxKlasse = new JComboBox(klassenMoeglichkeiten);
		comboBoxKlasse.setBounds(252, 118, 110, 40);
		frame.getContentPane().add(comboBoxKlasse);

		// Create ComboBox to specify the subject and Action Listener
		
		String[] fachMoeglichkeiten = { "Deutsch", "Mathe", "Geschichte", "PW", "Leben" };

		JComboBox comboBoxFach = new JComboBox(fachMoeglichkeiten);
		comboBoxFach.setBounds(372, 118, 110, 40);
		frame.getContentPane().add(comboBoxFach);

		// Create ComboBox to specify the amount of hours the subject is thought
		// per week and Action Listener

		Integer[] stundenMoeglichkeiten = { 1, 2, 3, 4, 5, 6 };

		JComboBox comboBoxStunden = new JComboBox(stundenMoeglichkeiten);
		comboBoxStunden.setBounds(492, 118, 110, 40);
		frame.getContentPane().add(comboBoxStunden);

		// Create ComboBox to specify the teacher's name and Action Listener

		//String[] lehrerMoeglichkeiten = { "Kaps", "Boegel", "Schilling", "Dreseler" };
		
		JComboBox comboBoxLehrer = new JComboBox(lehrerMoeglichkeiten);
		comboBoxLehrer.setBounds(612, 118, 110, 40);
		frame.getContentPane().add(comboBoxLehrer);

		// Create ComboBox to specify room type and Action Listener

		String[] raumMoeglichkeiten = { "Normal", "Bio", "Chemie", "Musik", "Sport", "Kunst" };

		JComboBox comboBoxRaum = new JComboBox(raumMoeglichkeiten);
		comboBoxRaum.setBounds(732, 118, 110, 40);
		frame.getContentPane().add(comboBoxRaum);

		// Create all according labels for the ComboBoxes
		JLabel lblNewLabel = new JLabel("Stufe");
		lblNewLabel.setToolTipText("Klassenstufe 5-13 eingeben");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 78, 110, 40);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblZweig = new JLabel("Zweig");
		lblZweig.setToolTipText("Zweig ausw\u00E4hlen");
		lblZweig.setHorizontalAlignment(SwingConstants.CENTER);
		lblZweig.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZweig.setBounds(132, 78, 110, 40);
		frame.getContentPane().add(lblZweig);

		JLabel lblSprache = new JLabel("Klasse");
		lblSprache.setToolTipText("Welche Klasse im Zweig?");
		lblSprache.setHorizontalAlignment(SwingConstants.CENTER);
		lblSprache.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSprache.setBounds(252, 78, 110, 40);
		frame.getContentPane().add(lblSprache);

		JLabel lblFach = new JLabel("Fach");
		lblFach.setToolTipText("Unterrichtsfach ausw\u00E4hlen");
		lblFach.setHorizontalAlignment(SwingConstants.CENTER);
		lblFach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFach.setBounds(372, 78, 110, 40);
		frame.getContentPane().add(lblFach);

		JLabel lblStunden = new JLabel("Stunden");
		lblStunden.setToolTipText("Anzahl Wochenstundenausw\u00E4hlen");
		lblStunden.setHorizontalAlignment(SwingConstants.CENTER);
		lblStunden.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStunden.setBounds(492, 78, 110, 40);
		frame.getContentPane().add(lblStunden);

		JLabel lblLehrer = new JLabel("Lehrer");
		lblLehrer.setToolTipText("Lehrer ausw\u00E4hlen");
		lblLehrer.setHorizontalAlignment(SwingConstants.CENTER);
		lblLehrer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLehrer.setBounds(612, 78, 110, 40);
		frame.getContentPane().add(lblLehrer);

		JLabel lblRaum = new JLabel("Raum");
		lblRaum.setToolTipText("Raumtyp ausw\u00E4hlen");
		lblRaum.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRaum.setBounds(732, 78, 110, 40);
		frame.getContentPane().add(lblRaum);

		// create Table inside JPane to show last 3 entries

		eintraegetabelle = new JTable() {
			// Cell values are not editable
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		eintraegetabelle.setRowSelectionAllowed(false);
		eintraegetabelle.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Stufe", "Zweig", "Klasse", "Fach", "Stunden", "Lehrer", "Raum" }));
		eintraegetabelle.getColumnModel().getColumn(0).setPreferredWidth(119);
		eintraegetabelle.getColumnModel().getColumn(1).setPreferredWidth(119);
		eintraegetabelle.getColumnModel().getColumn(2).setPreferredWidth(119);
		eintraegetabelle.getColumnModel().getColumn(3).setPreferredWidth(119);
		eintraegetabelle.getColumnModel().getColumn(4).setPreferredWidth(119);
		eintraegetabelle.getColumnModel().getColumn(5).setPreferredWidth(119);
		eintraegetabelle.getColumnModel().getColumn(6).setPreferredWidth(119);
		eintraegetabelle.setBounds(10, 220, 833, 75);
		eintraegetabelle.getTableHeader().setPreferredSize(new Dimension(119, 25));
		eintraegetabelle.setRowHeight(0, 25);
		eintraegetabelle.setRowHeight(1, 25);
		eintraegetabelle.setRowHeight(2, 25);
		eintraegetabelle.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(eintraegetabelle);
		scrollPane.setBounds(12, 178, 833, 100);

		frame.getContentPane().add(scrollPane);

		JButton hinzufuegenButton = new JButton("Add");
		hinzufuegenButton.setForeground(Color.BLACK);
		hinzufuegenButton.setBackground(Color.ORANGE);
		hinzufuegenButton.setBounds(852, 125, 90, 26);
		hinzufuegenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Save selected values in variables
				Integer wertStufe = (Integer)comboBoxStufe.getSelectedItem();
				String wertZweig = (String)comboBoxZweig.getSelectedItem();
				Integer wertKlasse = (Integer)comboBoxKlasse.getSelectedItem();
				String wertFach = (String)comboBoxFach.getSelectedItem();
				Integer wertStunden = (Integer)comboBoxStunden.getSelectedItem();
				String wertLehrer = (String)comboBoxLehrer.getSelectedItem();
				String wertRaum = (String)comboBoxRaum.getSelectedItem();
				
				//Connect to DATABASE
				//DatabaseConnector dropDownConnect;
				try {
					//dropDownConnect = new DatabaseConnector();
				//ADD current values to DB
					dropDownConnect.insert(""+wertStufe+",'"+wertZweig+"',"+wertKlasse+",'"+wertFach+"',"+wertStunden+",'"+wertLehrer+"','"+wertRaum+"');");
				//Show last 3 DB entries
					String[][] queryErgebnis = dropDownConnect.retrieveForTable();
					for(int r=0;r<3;r++){
						//Starts at 1, cause I dont want to confuse ppl with the ID form the DB
						for(int c=1;c<8;c++){
							eintraegetabelle.setValueAt(queryErgebnis[r][c], r, c-1);
						}
					}
					/*eintraegetabelle.setValueAt(comboBoxStufe.getSelectedItem(), 0, 0);
				eintraegetabelle.setValueAt(comboBoxZweig.getSelectedItem(), 0, 1);
				eintraegetabelle.setValueAt(comboBoxKlasse.getSelectedItem(), 0, 2);
				eintraegetabelle.setValueAt(comboBoxFach.getSelectedItem(), 0, 3);
				eintraegetabelle.setValueAt(comboBoxStunden.getSelectedItem(), 0, 4);
				eintraegetabelle.setValueAt(comboBoxLehrer.getSelectedItem(), 0, 5);
				*/
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(hinzufuegenButton);
	}
}
