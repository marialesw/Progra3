package models;

import java.util.ArrayList;

public class ManagerConcert {

	private ArrayList<Concert> concerts;
	
	public ManagerConcert() {
		concerts = new ArrayList<>();
	}
	
	public ArrayList<Concert> getConcerts() {
		return new ArrayList<>(concerts);
	}
	
	public void addConcert(Concert concert) {
		concerts.add(concert);
	}
}
