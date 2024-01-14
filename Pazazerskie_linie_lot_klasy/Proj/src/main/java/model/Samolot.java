package model;

import java.time.LocalDateTime;
import java.util.*;

public class Samolot {

	protected int id;
	private String model;
	private int iloscMiejsc;
	private HashMap<Integer, ArrayList<LocalDateTime>> godzinyPrzypisane = new HashMap<>();
	private double wyposazenie;

	/**
	 * @param c_id
	 * @param c_model
	 * @param c_iloscMiejsc
	 */
	public Samolot(int c_id, String c_model, int c_iloscMiejsc) {
		this.id = c_id;
		this.model = c_model;
		this.iloscMiejsc = c_iloscMiejsc;
		this.wyposazenie = 1.0;
		//System.out.print("\nStworzono samolot ID: " + c_id + " Model: " + c_model +
		//		" Ilosc miejsc: " + c_iloscMiejsc);
	}

	/**
	 * @param lot
	 */
	public boolean przypiszDoLotu(Lot lot) {
		if (czyDostepny(lot)) {
			addGodzinyPrzypisane(lot);
			//System.out.println("Sukces");
			return true;
		}
		System.out.println("!!!!!!");
		return false;
	}

	/**
	 * @param lot
	 */
	public boolean czyDostepny(Lot lot) throws RuntimeException{

		for (Map.Entry<Integer, ArrayList<LocalDateTime>> entry : godzinyPrzypisane.entrySet()) {
			if (!(lot.getDataWylot().isAfter(entry.getValue().get(1)) || lot.getDataPrzylot().isBefore(entry.getValue().get(0)))) {
				throw new RuntimeException("Samolot nie moze zostac przypisany do lotu");
			}
		}
		return true;
	}

	/**
	 *
	 * @param lot
	 */
	public void usunPrzypisanieDoLotu(Lot lot) {
		this.godzinyPrzypisane.remove(lot.id);
		this.wyposazenie -= 0.1;
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

	public HashMap<Integer, ArrayList<LocalDateTime>> getGodzinyPrzypisane() {
		return this.godzinyPrzypisane;
	}

	/**
	 *
	 * @param lot
	 */
	public void addGodzinyPrzypisane(Lot lot) {
		ArrayList<LocalDateTime> godziny = new ArrayList<>();
		godziny.add(lot.getDataWylot());
		godziny.add(lot.getDataPrzylot());
		this.godzinyPrzypisane.put(lot.id,godziny);
	}

	/**
	 *
	 * @param nowe_wyposazenie
	 */
	public void dodajWyposazenie(double nowe_wyposazenie){
		this.wyposazenie += nowe_wyposazenie;
	}

	public double getWyposazenie() {
		return wyposazenie;
	}
	@Override
	public String toString(){
		return "\nID: " + this.id + " Model: " + this.model + " Miejsca: " + (this.iloscMiejsc) ;
	}

	public void setWyposazenie(double wyposazenie) {
		this.wyposazenie = wyposazenie;
	}
}

