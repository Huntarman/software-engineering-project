package classDiagram.system.model;

import java.util.ArrayList;

public class Samolot {

	protected int id;
	private String model;
	private int iloscMiejsc;
	private ArrayList<String> godzinyPrzypisane;
	private double wyposazenie;
	/**
	 * 
	 * @param c_id
	 * @param c_model
	 * @param c_iloscMiejsc
	 */
	public Samolot(int c_id, String c_model, int c_iloscMiejsc) {
		this.id = c_id;
		this.model = c_model;
		this.iloscMiejsc = c_iloscMiejsc;
		this.wyposazenie = 1.0;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lot
	 */
	public void przypiszDoLotu(Lot lot) {
		// TODO - implement Samolot.przypiszDoLotu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param godzWylot
	 * @param godzPrzylot
	 */
	public boolean czyDostepny(String godzWylot, String godzPrzylot) {
		// TODO - implement Samolot.czyDostepny
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lot
	 */
	public void usunPrzypisanieDoLotu(Lot lot) {
		// TODO - implement Samolot.usunPrzypisanieDoLotu
		throw new UnsupportedOperationException();
	}

	public int getIloscMiejsc() {
		return this.iloscMiejsc;
	}

	/**
	 * 
	 * @param iloscMiejsc
	 */
	public void setIloscMiejsc(int iloscMiejsc) {
		this.iloscMiejsc = iloscMiejsc;
	}

	public String getModel() {
		return this.model;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
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