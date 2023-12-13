package classDiagram.system.model;

import java.util.ArrayList;

public class Pilot extends Pracownik {

	private ArrayList<String> godzinyPrzypisane;

	/**
	 * 
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 */
	public Pilot(int c_id, String c_imie, String c_nazwisko) {
		super(c_id,c_imie,c_nazwisko);

		throw new UnsupportedOperationException();
	}

	public boolean mozeAutoryzowac() {
		return false;
	}

	/**
	 * 
	 * @param lot
	 */
	public void przypiszDoLotu(Lot lot) {
		// TODO - implement Pilot.przypiszDoLotu

	}

	/**
	 * 
	 * @param godzWylot
	 * @param godzPrzylot
	 */
	public boolean czyDostepny(String godzWylot, String godzPrzylot) {
		//todo
		return false;
	}

	/**
	 * 
	 * @param lot
	 */
	public void usunPrzypisanieDoLotu(Lot lot) {

		throw new UnsupportedOperationException();
	}

	public ArrayList<String> getGodzinyPrzypisane() {
		return this.godzinyPrzypisane;
	}

	/**
	 * 
	 * @param godzinyPrzypisane
	 */
	public void setGodzinyPrzypisane(ArrayList<String> godzinyPrzypisane) {
		this.godzinyPrzypisane = godzinyPrzypisane;
	}

}