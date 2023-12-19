package classDiagram.system.model;

public class Pracownik {

	protected int id;
	protected String imie;
	protected String nazwisko;

	public Pracownik() {
		id = -1;
	};
	/**
	 * 
	 * @param c_id
	 * @param c_imie
	 * @param c_nazwisko
	 */
	public Pracownik(int c_id, String c_imie, String c_nazwisko) {
		this.id = c_id;
		imie = c_imie;
		nazwisko = c_nazwisko;
		System.out.print("\nStworzono pracownika ID: " + c_id + " Imie: " +
				c_imie + " Nazwisko: " + c_nazwisko);
	}
	@Override
	public String toString() {
		String b = (mozeAutoryzowac()) ? "|| Ten pracownik ma wyzszy poziom dostepu":"";
		return "\nID: " + this.id + " Imie: " + this.imie + " Nazwisko: " +
				this.nazwisko + b;
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