package classDiagram.system.model;

public class Pracownik {

	protected int id;
	protected String imie;
	protected String nazwisko;

	/**
	 * 
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 */
	public Pracownik(int c_id, String c_imie, String c_nazwisko) {
		// TODO - implement Pracownik.Pracownik
		throw new UnsupportedOperationException();
	}

	public boolean mozeAutoryzowac() {
		return true;
	}

	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
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

}