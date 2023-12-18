package classDiagram.system.model;

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
	public Lot(int c_id, String c_miejsceWylot, LocalDateTime c_dataWylot, String c_miejscePrzylot, LocalDateTime c_dataPrzylot, ArrayList<Pilot> c_piloci, ArrayList<PersonelPokladowy> c_personelPokladowy, int cena, int maxMiejsc) {
		this.id = c_id;
		this.miejsceWylot = c_miejsceWylot;
		this.miejscePrzylot = c_miejscePrzylot;
		this.data_przylot = c_dataPrzylot;
		this.data_wylot = c_dataWylot;
		this.piloci = c_piloci;
		this.personelPokladowy = c_personelPokladowy;
		this.cena = cena;
		this.maxMiejsc = maxMiejsc;
		this.dostepnychMiejsc = this.maxMiejsc;
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
	public Lot(int c_id, String c_miejsceWylot, LocalDateTime c_dataWylot, String c_miejscePrzylot, LocalDateTime c_dataPrzylot, int cena, int maxMiejsc) {
		this.id = c_id;
		this.miejsceWylot = c_miejsceWylot;
		this.data_wylot = c_dataWylot;
		this.miejscePrzylot = c_miejscePrzylot;
		this.data_przylot = c_dataPrzylot;
		this.cena = cena;
		this.maxMiejsc = maxMiejsc;
		this.dostepnychMiejsc = this.maxMiejsc;
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
		return this.maxMiejsc - this.dostepnychMiejsc-- + 1;
	}
}