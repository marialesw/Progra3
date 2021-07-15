package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import Utilities.Utillidades;

public class JPanelNewConcert extends JPanel{

	private static final String CONCERT_DATE = "Fecha del concierto ";
	private static final long serialVersionUID = 1L;
	private static final Color COLOR_BACKGROUND = Color.black;
	private static final Color COLOR_FOREGROUND = Color.WHITE;
	private GridBagConstraints gbc;
	private JTextField jtextNameConcert;
	private JTextField numberPersons;
	private JButton buttonRegistrer;
	private JPanel panelCalendario;
	private JTextField valueTicket;
	private JCalendar jcalDateConcert;

	public JPanelNewConcert(ActionListener listener) {
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#070202"));
		initComponents(listener);
		setVisible(true);
	}

	private void initComponents(ActionListener listener) {
		setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Agregar Concierto" )) );
		Font font = new Font("Times New Roman", 0, 20);
		createGridBag();

		JLabel labelInit = new JLabel(Constants.MESSAGE_WELCOME);
		setPropertiesComponent(this, labelInit,0, 1, 40, 500 , 8,font, COLOR_BACKGROUND,COLOR_FOREGROUND);

		JLabel labelNames = new JLabel(Constants.NAME_CONCERT);
		setPropertiesComponent(this, labelNames,0, 5, 40, 200 , 3,font, COLOR_BACKGROUND, COLOR_FOREGROUND);

		jtextNameConcert = new JTextField();
		setPropertiesComponent(this,jtextNameConcert,2, 5, 40, 200 , 2,font, Color.DARK_GRAY, Color.white);

		JLabel labelnumberPersons = new JLabel(Constants.NUMBER_PERSONS);
		setPropertiesComponent(this, labelnumberPersons,0, 7, 40, 200 , 3,font, COLOR_BACKGROUND, COLOR_FOREGROUND);

		numberPersons = new JTextField();
		setPropertiesComponent(this,numberPersons,2, 7, 40, 200 , 2,font, Color.DARK_GRAY, Color.white);


		JLabel labelValueTicket = new JLabel(Constants.VALUE_TICKET);
		setPropertiesComponent(this, labelValueTicket,0, 9, 40, 200 , 3,font, COLOR_BACKGROUND, COLOR_FOREGROUND);

		valueTicket = new JTextField();
		setPropertiesComponent(this,valueTicket,2, 9, 40, 200 , 2,font, Color.DARK_GRAY, Color.white);

		panelCalendario = new JPanel();
		panelCalendario.setLayout(new GridLayout(2, 1));
		JLabel labelCalendar = new JLabel( CONCERT_DATE );
		labelCalendar.setFont(font);
		labelCalendar.setForeground(Color.white);
		panelCalendario.add( labelCalendar );
		jcalDateConcert = new JCalendar();
		panelCalendario.add(jcalDateConcert);
		gbc.gridheight = 5;
		setPropertiesComponent(this, panelCalendario, 7, 6, 320, 300, 3, font, Color.black, Color.white);
		gbc.gridheight = 1;

		buttonRegistrer = new JButton(Constants.BUTTON_REGISTER);
		setPropertiesComponent(this, buttonRegistrer, 2, 14, 40, 300, 3, font, Color.WHITE, Color.BLACK);
		buttonRegistrer.setActionCommand(Constants.BUTTON_REGISTER);
		buttonRegistrer.addActionListener(listener);

	}

	private void createGridBag() {
		gbc = new GridBagConstraints();
		generateBasicGridX(gbc);
		generateBasicGridY(gbc);
		gbc.insets = new Insets(5, 0, 5, 0);
	}

	private void setPropertiesComponent(JComponent addComp, JComponent comp, int x, int y, 
			int height, int width, int gridWidth, Font font, Color back, Color fore) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = gridWidth;
		comp.setFont(font);
		comp.setBackground(back);
		comp.setForeground(fore);
		comp.setPreferredSize(new Dimension(width, height));
		addComp.add(comp, gbc);
	}

	public String getNameUser() {
		if (jtextNameConcert.getText() != null && !jtextNameConcert.getText().isEmpty()) {
			return jtextNameConcert.getText();
		} else {
			Utillidades.showMessageWarning(Constants.PLEASE_INGRESS_TO_USER, Constants.WARNING);
		}
		return null;
	}

	public int getNumberPersons() {
		if (numberPersons.getText() != null && !numberPersons.getText().isEmpty()) {
			return Integer.valueOf(numberPersons.getText());
		} else {
			Utillidades.showMessageWarning(Constants.PLEASE_INGRES_TO_PASSWORD, Constants.WARNING);
		}
		return 0;
	}
	
	public int getValueConcert(){
		if (valueTicket.getText() != null && !valueTicket.getText().isEmpty()) {
			return Integer.valueOf(valueTicket.getText());
		} else {
			Utillidades.showMessageWarning(Constants.PLEASE_INGRES_TO_PASSWORD, Constants.WARNING);
		}
		return 0;
	}
	
	public Calendar getDateConcert() {
		Calendar fecha = jcalDateConcert.getCalendar();
		return fecha;
	}
	
	private void generateBasicGridX(GridBagConstraints gbc){
		gbc.weightx = 1;
		gbc.gridheight = 1;
		for (int i = 0; i < 12; i++) {
			gbc.gridx = i;
			add(new JLabel("" ), gbc);
		}
	}

	private void generateBasicGridY(GridBagConstraints gbc){
		gbc.weighty = 1;
		gbc.gridheight = 1;
		for (int i = 0; i < 14; i++) {
			gbc.gridy = i;
			add(new JLabel("" ), gbc);
		}
	}
}
