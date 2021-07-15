package models;

public class Concert {

	private String name;
	private int numberPersons;
	private double value;
	//private LocalDate dateEvent;
	
	public Concert(String name, int numberPersons, double value) {
		super();
		this.name = name;
		this.numberPersons = numberPersons;
		this.value = value;
		//this.dateEvent = dateEvent;
	}

	public String getName() {
		return name;
	}

	public int getNumberPersons() {
		return numberPersons;
	}

	public double getValue() {
		return value;
	}

//	public LocalDate getDateEvent() {
//		return dateEvent;
//	}
}