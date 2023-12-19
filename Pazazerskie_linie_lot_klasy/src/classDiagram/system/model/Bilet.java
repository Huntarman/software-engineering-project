package classDiagram.system.model;

import java.time.LocalDateTime;

public class Bilet {

	protected int id;
	private int idLotu;
	private int idKlient;
	private int miejsce;
	private float cena;
	private LocalDateTime data_wylot;
	private LocalDateTime data_przylot;
	private String miejsceWylot;
	private String miejscePrzylot;
	private boolean autoryzacja = false;

	private boolean zwrot = false;

	public Bilet() {
		this.id = -1;
		this.idLotu = -1;
		this.miejsce = -1;
		this.cena = -1.0f;
	}
	/**
	 * 
	 * @param c_id
	 * @param c_idLotu
	 * @param c_idKlient
	 * @param c_miejsce
	 * @param c_cena
	 * @param data_wylot
	 * @param data_przylot
	 * @param miejscePrzylot
	 * @param miejsceWylot
	 */
	public Bilet(int c_id, int c_idLotu, int c_idKlient, int c_miejsce, LocalDateTime data_wylot,LocalDateTime data_przylot,String miejsceWylot, String miejscePrzylot, float c_cena) {
		this.id = c_id;
		this.idLotu = c_idLotu;
		this.miejsce = c_miejsce;
		this.cena = c_cena;
		this.idKlient = c_idKlient;
		this.data_wylot = data_wylot;
		this.data_przylot = data_przylot;
		this.miejsceWylot = miejsceWylot;
		this.miejscePrzylot = miejscePrzylot;
	}

	public void oznaczDoZwrotu() { this.zwrot = true; }


	public int getId() {
		return id;
	}

	public int getIdLotu() {
		return this.idLotu;
	}

	/**
	 * 
	 * @param idLotu
	 */
	public void setIdLotu(int idLotu) {
		this.idLotu = idLotu;
	}

	public int getMiejsce() {
		return this.miejsce;
	}

	/**
	 * 
	 * @param miejsce
	 */
	public void setMiejsce(int miejsce) {
		this.miejsce = miejsce;
	}

	public float getCena() {
		return this.cena;
	}

	/**
	 * 
	 * @param cena
	 */
	public void setCena(float cena) {
		this.cena = cena;
	}

	public boolean getAutoryzacja() {
		return this.autoryzacja;
	}

	/**
	 * 
	 * @param autoryzacja
	 */
	public void setAutoryzacja(boolean autoryzacja) {
		this.autoryzacja = autoryzacja;
	}

	public boolean getZwrot(){
		return zwrot;
	}

	public void setZwrot(boolean zwrot) {
		this.zwrot = zwrot;
	}

	public int getIdKlient() {
		return idKlient;
	}

	public LocalDateTime getData_wylot() {
		return data_wylot;
	}

	public LocalDateTime getData_przylot() {
		return data_przylot;
	}

	public String getMiejscePrzylot() {
		return miejscePrzylot;
	}

	public String getMiejsceWylot() {
		return miejsceWylot;
	}
}