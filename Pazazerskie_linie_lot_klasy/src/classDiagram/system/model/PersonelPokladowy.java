package classDiagram.system.model;

import java.util.ArrayList;

public class PersonelPokladowy extends Pracownik {

	private ArrayList<Lot> lotyPrzypisane;

	/**
	 * 
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 */
	public PersonelPokladowy(int c_id, String c_imie, String c_nazwisko) {
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
		// TODO - implement PersonelPokladowy.przypiszDoLotu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param godzWylot
	 * @param godzPrzylot
	 */
	public boolean czyDostepny(String godzWylot, String godzPrzylot) {
		// TODO - implement PersonelPokladowy.czyDostepny
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lot
	 */
	public void usunPrzypisanieDoLotu(Lot lot) {
		// TODO - implement PersonelPokladowy.usunPrzypisanieDoLotu
		throw new UnsupportedOperationException();
	}

	public ArrayList<Lot> getLotyPrzypisane() {
		return this.lotyPrzypisane;
	}

	/**
	 * 
	 * @param lotyPrzypisane
	 */
	public void setLotyPrzypisane(ArrayList<Lot> lotyPrzypisane) {
		this.lotyPrzypisane = lotyPrzypisane;
	}

}