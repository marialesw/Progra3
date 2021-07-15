package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;

public class JFMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private ActionListener listener;
	private JPanelNewConcert jPanelNewConcert;
	
	public JFMainWindow(ActionListener listener) {
		this.listener = listener;
		setLayout(new BorderLayout());
		//setPreferredSize(new Dimension(800));
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		jPanelNewConcert = new JPanelNewConcert(listener);
		add(jPanelNewConcert, BorderLayout.CENTER);
	}
	
	public String getNameConcert() {
		return jPanelNewConcert.getNameUser();
	}

	public int getNumberPersons() {
		return jPanelNewConcert.getNumberPersons();
	}
	
	public int getValueConcert(){
		return jPanelNewConcert.getValueConcert();
	}
	
	public Calendar getDateConcert(){
		return jPanelNewConcert.getDateConcert();
	}
}