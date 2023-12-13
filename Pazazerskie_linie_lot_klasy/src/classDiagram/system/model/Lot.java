package classDiagram.system.model;

import java.util.ArrayList;

public class Lot {

	protected int id;
	private String miejsceWylot;
	private String godzWylot;
	private String miejscePrzylot;
	private String godzPrzylot;
	private Samolot samolot;
	private float wyposazenie;
	private ArrayList<Pilot> piloci = new ArrayList<>();
	private ArrayList<PersonelPokladowy> personelPokladowy = new ArrayList<>();

	/**
	 * 
	 * @param c_id
	 * @param c_miejsceWylot
	 * @param c_godzWylot
	 * @param c_miejscePrzylot
	 * @param c_godzPrzylot
	 * @param c_piloci
	 * @param c_personelPokladowy
	 */
	public Lot(int c_id, String c_miejsceWylot, String c_godzWylot, String c_miejscePrzylot, String c_godzPrzylot, ArrayList<Pilot> c_piloci, ArrayList<PersonelPokladowy> c_personelPokladowy) {
		this.id = c_id;
		this.miejsceWylot = c_miejsceWylot;
		this.godzWylot = c_godzWylot;
		this.miejscePrzylot = c_miejscePrzylot;
		this.godzPrzylot = c_godzPrzylot;
		this.piloci = c_piloci;
		this.personelPokladowy = c_personelPokladowy;
	}

	/**
	 * 
	 * @param c_id
	 * @param c_miejsceWylot
	 * @param c_godzWylot
	 * @param c_miejscePrzylot
	 * @param c_godzPrzylot
	 */
	public Lot(int c_id, String c_miejsceWylot, String c_godzWylot, String c_miejscePrzylot, String c_godzPrzylot) {
		this.id = c_id;
		this.miejsceWylot = c_miejsceWylot;
		this.godzWylot = c_godzWylot;
		this.miejscePrzylot = c_miejscePrzylot;
		this.godzPrzylot = c_godzPrzylot;
		throw new UnsupportedOperationException();
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

	public String getGodzWylot() {
		return this.godzWylot;
	}

	/**
	 * 
	 * @param godzWylot
	 */
	public void setGodzWylot(String godzWylot) {
		this.godzWylot = godzWylot;
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

	public String getGodzPrzylot() {
		return this.godzPrzylot;
	}

	/**
	 * 
	 * @param godzPrzylot
	 */
	public void setGodzPrzylot(String godzPrzylot) {
		this.godzPrzylot = godzPrzylot;
	}

	public Samolot getSamolot() {
		return this.samolot;
	}

	/**
	 * 
	 * @param samolot
	 */
	public void setSamolot(Samolot samolot) {
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

	public ArrayList<PersonelPokladowy> getPersonelPok³adowy() {
		return this.personelPokladowy;
	}

	/**
	 * 
	 * @param personelPok³adowy
	 */
	public void setPersonelPok³adowy(ArrayList<PersonelPokladowy> personelPok³adowy) {
		this.personelPokladowy = personelPok³adowy;
	}

}