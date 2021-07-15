package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import models.Concert;
import networking.Administrator;
import views.Constants;
import views.JFMainWindow;

public class MainControllerAdm implements ActionListener{

	private Administrator administrator;

	public MainControllerAdm() {
		try {
			administrator = new Administrator();
			registerConcert();
			JFMainWindow jfMainWindow = new JFMainWindow(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
		switch (comand) {
		case Constants.BUTTON_REGISTER:
			registerConcert();
			break;

		default:
			break;
		}
	}

	private void registerConcert() {
		Concert concert = new Concert("dshc", 46576, 45687);
		//String JSON = gson.toJson(new Concert("fcsxgv", 400, 4567867));
		administrator.sendConcert(concert.toString());
	}
}