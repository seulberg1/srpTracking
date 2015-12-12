package srpTracking;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WindowLesson {

	private JFrame frame;

	public static void main(String[] args) {
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

	public WindowLesson() {
		initialize();
	}

	private void initialize() {
		
		//Create the main Frame (muhaha, such sophistication)
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Create program Headline and Action Listener
		
		JLabel lblStundenplanToolPrs = new JLabel("StundenPlan Tool PRS");
		lblStundenplanToolPrs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblStundenplanToolPrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblStundenplanToolPrs.setBounds(187, 13, 342, 60);
		frame.getContentPane().add(lblStundenplanToolPrs);
		
		//Create ComboBox Class Level and Action Listener
		
		Integer[] stufenMoeglichkeiten = {5,6,7,8,9,10,11,12,13};
		
		JComboBox comboBoxStufe = new JComboBox(stufenMoeglichkeiten);
		comboBoxStufe.setBounds(10, 150, 110, 40);
		comboBoxStufe.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Integer stufenWert = (Integer)comboBoxStufe.getSelectedItem();
	            System.out.println(stufenWert);
			}
		});
		frame.getContentPane().add(comboBoxStufe);
		
		
		//Create ComboBox Class School Type and Action Listener
		
		String [] zweigMoeglichkeiten = {"Haupt","Real","Gym","Ober"};
		
		JComboBox comboBoxZweig = new JComboBox(zweigMoeglichkeiten);
		comboBoxZweig.setBounds(130, 150, 110, 40);
		comboBoxZweig.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String zweigWert = (String)comboBoxZweig.getSelectedItem();
	            System.out.println(zweigWert);
			}
		});
		frame.getContentPane().add(comboBoxZweig);
		
		//Create ComboBox to specify the class more and Action Listener
		
		Integer[] klassenMoeglichkeiten = {1,2,3,4,5,6,7,8,9};
		
		JComboBox comboBoxKlasse = new JComboBox(klassenMoeglichkeiten);
		comboBoxKlasse.setBounds(250, 150, 110, 40);
		comboBoxKlasse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Integer klassenWert = (Integer)comboBoxKlasse.getSelectedItem();
	            System.out.println(klassenWert);
			}
		});
		frame.getContentPane().add(comboBoxKlasse);
		
		//Create ComboBox to specify the subject and Action Listener
		
		String [] fachMoeglichkeiten = {"Deutsch","Mathe","Geschichte","PW","Leben"};
		
		JComboBox comboBoxFach = new JComboBox(fachMoeglichkeiten);
		comboBoxFach.setBounds(370, 150, 110, 40);
		comboBoxFach.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String fachWert = (String)comboBoxFach.getSelectedItem();
	            System.out.println(fachWert);
			}
		});
		frame.getContentPane().add(comboBoxFach);
		
		//Create ComboBox to specify the amount of hours the subject is thought per week and Action Listener
		
		Integer[] stundenMoeglichkeiten = {1,2,3,4,5,6};
		
		JComboBox comboBoxStunden = new JComboBox(stundenMoeglichkeiten);
		comboBoxStunden.setBounds(490, 150, 110, 40);
		comboBoxStunden.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Integer stundenWert = (Integer)comboBoxStunden.getSelectedItem();
	            System.out.println(stundenWert);
			}
		});
		frame.getContentPane().add(comboBoxStunden);
		
		//Create ComboBox to specify the teacher's name and Action Listener
		
		String [] lehrerMoeglichkeiten = {"Kaps","Boegel","Schilling","Dreseler"};
		
		JComboBox comboBoxLehrer = new JComboBox(lehrerMoeglichkeiten);
		comboBoxLehrer.setBounds(610, 150, 110, 40);
		comboBoxLehrer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String lehrerWert = (String)comboBoxLehrer.getSelectedItem();
	            System.out.println(lehrerWert);
			}
		});
		frame.getContentPane().add(comboBoxLehrer);
		//
		//Create ComboBox to specify room type and Action Listener
		
		String [] raumMoeglichkeiten = {"Normal","Bio","Chemie","Musik", "Sport","Kunst"};
		
		JComboBox comboBoxRaum = new JComboBox(raumMoeglichkeiten);
		comboBoxRaum.setBounds(730, 150, 110, 40);
		comboBoxRaum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String raumWert = (String)comboBoxRaum.getSelectedItem();
	            System.out.println(raumWert);
			}
		});
		frame.getContentPane().add(comboBoxRaum);
		
		
		//Create all according labels for the ComboBoxes
		JLabel lblNewLabel = new JLabel("Stufe");
		lblNewLabel.setToolTipText("Klassenstufe 5-13 eingeben");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 110, 110, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblZweig = new JLabel("Zweig");
		lblZweig.setToolTipText("Zweig ausw\u00E4hlen");
		lblZweig.setHorizontalAlignment(SwingConstants.CENTER);
		lblZweig.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblZweig.setBounds(130, 110, 110, 40);
		frame.getContentPane().add(lblZweig);
		
		JLabel lblSprache = new JLabel("Klasse");
		lblSprache.setToolTipText("Welche Klasse im Zweig?");
		lblSprache.setHorizontalAlignment(SwingConstants.CENTER);
		lblSprache.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSprache.setBounds(250, 110, 110, 40);
		frame.getContentPane().add(lblSprache);
		
		JLabel lblFach = new JLabel("Fach");
		lblFach.setToolTipText("Unterrichtsfach ausw\u00E4hlen");
		lblFach.setHorizontalAlignment(SwingConstants.CENTER);
		lblFach.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFach.setBounds(370, 110, 110, 40);
		frame.getContentPane().add(lblFach);
		
		JLabel lblStunden = new JLabel("Stunden");
		lblStunden.setToolTipText("Anzahl Wochenstundenausw\u00E4hlen");
		lblStunden.setHorizontalAlignment(SwingConstants.CENTER);
		lblStunden.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStunden.setBounds(490, 110, 110, 40);
		frame.getContentPane().add(lblStunden);
		
		JLabel lblLehrer = new JLabel("Lehrer");
		lblLehrer.setToolTipText("Lehrer ausw\u00E4hlen");
		lblLehrer.setHorizontalAlignment(SwingConstants.CENTER);
		lblLehrer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLehrer.setBounds(610, 110, 110, 40);
		frame.getContentPane().add(lblLehrer);
		
		JLabel lblRaum = new JLabel("Raum");
		lblRaum.setToolTipText("Raumtyp ausw\u00E4hlen");
		lblRaum.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaum.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRaum.setBounds(730, 110, 110, 40);
		frame.getContentPane().add(lblRaum);
	}
}
