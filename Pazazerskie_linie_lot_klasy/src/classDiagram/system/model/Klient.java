package classDiagram.system.model;

import java.util.ArrayList;

public class Klient {

	protected int id;
	private String imie;
	private String nazwisko;
	private String email;
	private int nr_telefonu;
	private int nr_kontaBank;
	private ArrayList<Bilet> bilety = new ArrayList<>();

	/**
	 * 
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 * @param c_email
	 */
	public Klient(int c_id, String c_imie, String c_nazwisko, String c_email) {
		// TODO - implement Klient.Klient
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 * @param c_email
	 * @param c_nr_telefonu
	 * @param c_nr_kontaBank
	 */
	public Klient(int c_id, String c_imie, String c_nazwisko, String c_email, int c_nr_telefonu, int c_nr_kontaBank) {
		// TODO - implement Klient.Klient
		throw new UnsupportedOperationException();
	}

	public String getImie() {
		return this.imie;
	}

	/**
	 * 
	 * @param imie
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	/**
	 * 
	 * @param nazwisko
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public int getNr_telefonu() {
		return this.nr_telefonu;
	}

	/**
	 * 
	 * @param nr_telefonu
	 */
	public void setNr_telefonu(int nr_telefonu) {
		this.nr_telefonu = nr_telefonu;
	}

	public ArrayList<Bilet> getBilety() {
		// TODO - implement Klient.getBilety
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bilety
	 */
	public void setBilety(ArrayList<Bilet> bilety) {
		// TODO - implement Klient.setBilety
		throw new UnsupportedOperationException();
	}

}