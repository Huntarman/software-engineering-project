package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
public class Lot {

	protected int id;

	private LocalDateTime data_wylot;
	private LocalDateTime data_przylot;
	private String miejsceWylot;
	private String miejscePrzylot;
	private Samolot samolot;
	private float wyposazenie;
	private ArrayList<Pilot> piloci = new ArrayList<>();
	private ArrayList<PersonelPokladowy> personelPokladowy = new ArrayList<>();
	private int cena;

	private int maxMiejsc;
	private int dostepnychMiejsc;
	private boolean[] zajeteMiejsca;

	/**
	 *
	 * @param c_id
	 * @param c_miejsceWylot
	 * @param c_dataWylot
	 * @param c_miejscePrzylot
	 * @param c_dataPrzylot
	 * @param c_piloci
	 * @param c_personelPokladowy
	 * @param cena
	 */
	public Lot(int c_id, String c_miejsceWylot, LocalDateTime c_dataWylot, String c_miejscePrzylot,
			   LocalDateTime c_dataPrzylot, ArrayList<Pilot> c_piloci, ArrayList<PersonelPokladowy> c_personelPokladowy,
			   int cena, int maxMiejsc) {
		this(c_id, c_miejsceWylot, c_dataWylot, c_miejscePrzylot, c_dataPrzylot, cena, maxMiejsc);
		this.piloci = c_piloci;
		this.personelPokladowy = c_personelPokladowy;
		System.out.print(" Piloci: ");
		for (Pilot p : c_piloci)
			System.out.print(p.toString());
		System.out.print(" Personel pokladowy: ");
		for (PersonelPokladowy p : c_personelPokladowy)
			System.out.print(p.toString());
	}

	/**
	 *
	 * @param c_id
	 * @param c_miejsceWylot
	 * @param c_dataWylot
	 * @param c_miejscePrzylot
	 * @param c_dataPrzylot
	 * @param cena
	 */
	public Lot(int c_id, String c_miejsceWylot, LocalDateTime c_dataWylot, String c_miejscePrzylot,
			   LocalDateTime c_dataPrzylot, int cena, int maxMiejsc) {
		this.id = c_id;
		this.miejsceWylot = c_miejsceWylot;
		this.data_wylot = c_dataWylot;
		this.miejscePrzylot = c_miejscePrzylot;
		this.data_przylot = c_dataPrzylot;
		this.cena = cena;
		this.maxMiejsc = maxMiejsc;
		this.zajeteMiejsca = new boolean[this.maxMiejsc];
		System.out.print("\nStworzono lot ID: " + c_id + " Miejsce wylotu: " + c_miejsceWylot +
				" Data wylotu: " + c_dataWylot + " Miejsce przylotu: " + c_miejscePrzylot +
				" Data przylotu: " + c_dataPrzylot + " Cena: " + cena + " Samolot: " + "Nie przypisany" +" Maks. Liczba miejsc: 0/0");
	}
	@Override
	public String toString() {
		String s = "\nID: " + id + " Miejsce wylotu: " + miejsceWylot +
				" Data wylotu: " + data_wylot + " Miejsce przylotu: " + miejscePrzylot +
				" Data przylotu: " + data_przylot + " Samolot " + samolot.getModel() + "\nCena: " + cena + " Zajete miejsca: " +
				(maxMiejsc - dostepnychMiejsc) + "/" + maxMiejsc + "\nPiloci: ";

		for (Pilot p : piloci) {
			s += p.toString();
		}
		s += "\nPersonel pokladowy: ";
		for (PersonelPokladowy p : personelPokladowy) {
			s += p.toString();
		}
		return s;
	}
	public String getMiejsceWylot() {
		return this.miejsceWylot;
	}

	/**
	 *
	 * @param miejsceWylot
	 */
	public void setMiejsceWylot(String miejsceWylot) {
		this.miejsceWylot = miejsceWylot;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDataWylot() {
		return this.data_wylot;
	}

	/**
	 *
	 * @param dataWylot
	 */
	public void setDataWylot(LocalDateTime dataWylot) {
		this.data_wylot = dataWylot;
	}

	public String getMiejscePrzylot() {
		return this.miejscePrzylot;
	}

	/**
	 *
	 * @param miejscePrzylot
	 */
	public void setMiejscePrzylot(String miejscePrzylot) {
		this.miejscePrzylot = miejscePrzylot;
	}

	public LocalDateTime getDataPrzylot() {
		return this.data_przylot;
	}

	/**
	 *
	 * @param dataPrzylot
	 */
	public void setGodzPrzylot(LocalDateTime dataPrzylot) {
		this.data_przylot = dataPrzylot;
	}

	public Samolot getSamolot() {
		return this.samolot;
	}

	/**
	 *
	 * @param samolot
	 */
	public void setSamolot(Samolot samolot) {
		this.maxMiejsc = samolot.getIloscMiejsc();
		this.dostepnychMiejsc = this.maxMiejsc;
		this.zajeteMiejsca = new boolean[this.maxMiejsc];
		this.samolot = samolot;
	}

	public float getWyposazenie() {
		return this.wyposazenie;
	}

	/**
	 *
	 * @param wyposazenie
	 */
	public void setWyposazenie(float wyposazenie) {
		this.wyposazenie = wyposazenie;
	}

	public ArrayList<Pilot> getPiloci() {
		return this.piloci;
	}

	/**
	 *
	 * @param piloci
	 */
	public void setPiloci(ArrayList<Pilot> piloci) {
		this.piloci = piloci;
	}

	public ArrayList<PersonelPokladowy> getPersonelPokladowy() {
		return this.personelPokladowy;
	}

	/**
	 *
	 * @param personelPokladowy
	 */
	public void setPersonelPokladowy(ArrayList<PersonelPokladowy> personelPokladowy) {
		this.personelPokladowy = personelPokladowy;
	}

	public int getCena() {
		return cena;
	}
	public int getNastepneWolneMiejsce(){
		this.dostepnychMiejsc--;
		for (int i = 0; i < zajeteMiejsca.length; i++) {
			if(!zajeteMiejsca[i]){
				zajeteMiejsca[i] = true;
				return i+1;
			}
		}
		return -1;
	}
	public void zwrocMiejsce(int numerMiejsca) {this.zajeteMiejsca[numerMiejsca-1] = false; dostepnychMiejsc++;}
}