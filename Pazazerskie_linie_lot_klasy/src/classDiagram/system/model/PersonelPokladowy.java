package classDiagram.system.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PersonelPokladowy extends Pracownik {

	private HashMap<Integer, ArrayList<LocalDateTime>> godzinyPrzypisane;
	public PersonelPokladowy() {super();}
	/**
	 *
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 */
	public PersonelPokladowy(int c_id, String c_imie, String c_nazwisko) {
		super(c_id,c_imie,c_nazwisko);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public boolean mozeAutoryzowac() {
		return false;
	}

	/**
	 *
	 * @param lot
	 */
	public void przypiszDoLotu(Lot lot) {
		addGodzinyPrzypisane(lot);
	}

	/**
	 *
	 * @param lot
	 */
	public boolean czyDostepny(Lot lot) {
		for (Map.Entry<Integer, ArrayList<LocalDateTime>> entry : godzinyPrzypisane.entrySet()) {
			if (!(lot.getDataWylot().isAfter(entry.getValue().get(0)) && lot.getDataPrzylot().isBefore(entry.getValue().get(1))))
				return false;
		}
		return true;
	}

	/**
	 *
	 * @param lot
	 */
	public void usunPrzypisanieDoLotu(Lot lot) {
		this.godzinyPrzypisane.remove(lot.id);
	}

	public HashMap<Integer, ArrayList<LocalDateTime>> getLotyPrzypisane() {
		return this.godzinyPrzypisane;
	}

	/**
	 *
	 * @param lot
	 */
	public void addGodzinyPrzypisane(Lot lot) {
		this.godzinyPrzypisane.put(lot.id,(ArrayList<LocalDateTime>) Arrays.asList(lot.getDataWylot(), lot.getDataPrzylot()));
	}
}