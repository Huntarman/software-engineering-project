package model;

import java.util.ArrayList;

public class Klient {

	protected int id;
	private String imie;
	private String nazwisko;
	private String email;
	private int nr_telefonu;
	private int nr_kontaBank;
	private float saldo = 0.0f;
	private ArrayList<Bilet> bilety = new ArrayList<>();
	
	public Klient() {
		id = -1;
		imie = null;
		nazwisko = null;
		email = null;
		nr_telefonu = -1;
		nr_kontaBank = -1;
	}

	/**
	 *
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 * @param c_email
	 */
	public Klient(int c_id, String c_imie, String c_nazwisko, String c_email) {
		id = c_id;
		imie = c_imie;
		nazwisko = c_nazwisko;
		email = c_email;
		//System.out.print("\nStworzono klienta ID: " + c_id + " Imie: "
		//		+ c_imie + " Nazwisko: " + c_nazwisko + " e-mail: " + c_email);
		nr_telefonu = -1;
		nr_kontaBank = -1;
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
	public Klient(int c_id, String c_imie, String c_nazwisko, String c_email,
				  int c_nr_telefonu, int c_nr_kontaBank, float saldo) {
		this(c_id, c_imie, c_nazwisko, c_email);
		nr_telefonu = c_nr_telefonu;
		nr_kontaBank = c_nr_kontaBank;
		this.saldo = saldo;
		//System.out.print(" Nr. telefonu: " + c_nr_telefonu + " Nr. konta bankowego: "
		//+ c_nr_kontaBank + " Saldo: " + this.saldo);
	}
	@Override
	public String toString() {
		return "\nID: " + this.id + " Imie: " + this.imie + " Nazwisko: " +
				this.nazwisko + " e-mail: " + this.email + " Nr. telefonu: " +
				this.nr_telefonu + " Nr. konta bankowego: "
				+ this.nr_kontaBank + " Saldo: " + this.saldo;
	}
	public Bilet szukajBilet(int idBilet) {
		for (Bilet c : bilety) {
			if (c.id == idBilet) {
				return c;
			}
		}

		return new Bilet();
	}

	public boolean usunBilet(int idBilet) {
		for (int i = 0; i < bilety.size(); i++) {
			if (bilety.get(i).getId() == idBilet){
				bilety.remove(i);
				return true;
			}
		}
		System.out.println("Usuniecie biletu nie powiodlo sie; Bilet nie istnieje");
		throw new RuntimeException("Usuniecie biletu nie powiodlo sie; Bilet nie istnieje");
	}

	public boolean printBilet(Bilet bilet) {
		System.out.println("Bilet ID: " + bilet.id + " " +
				"\nklienta: " + this.imie + " " + this.nazwisko +
				"\nDla lotu: " + bilet.getIdLotu() +
				"\nMiejsce: " + bilet.getMiejsce() +
				"\nCena: " + bilet.getCena());
		return true;
	}

	public boolean pobierzOplate(Bilet bilet) {
		if (this.saldo >= bilet.getCena()) {
			this.saldo -= bilet.getCena();
			return true;
		}
		System.out.println("Klient nie ma odpowiednich srodkow na koncie");
		throw new RuntimeException("Klient nie ma odpowiednich srodkow na koncie");
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

	public int getNr_kontaBank() {
		return this.nr_telefonu;
	}

	/**
	 *
	 * @param nr_kontaBank
	 */
	public void setNr_kontaBank(int nr_kontaBank) {
		this.nr_kontaBank = nr_kontaBank;
	}
	public ArrayList<Bilet> getBilety() { return bilety; }

	/**
	 * 
	 * @param bilety
	 */
	public void setBilety(ArrayList<Bilet> bilety) { this.bilety = bilety; }
	public void addBilet(Bilet newBilet){
		this.bilety.add(newBilet);
	}
	public int getId() {
		return id;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}