package classDiagram.system;

import classDiagram.system.model.*;

import java.util.ArrayList;

public class Aplikacja {

	private ArrayList<Klient> klienci = new ArrayList<>();
	private ArrayList<Lot> loty = new ArrayList<>();
	private ArrayList<Pracownik> pracownicy = new ArrayList<>();
	private ArrayList<Samolot> samoloty = new ArrayList<>();
	private ArrayList<Bilet> bilety = new ArrayList<>();

	public ArrayList<Lot> przegladanieLotow() {
		return loty;
	}

	/**
	 * 
	 * @param kryteriaWyszukiwania
	 */
	public ArrayList<Lot> szukanieLotu(String[] kryteriaWyszukiwania) {
		ArrayList<Lot> loty_O_Kryteriach = new ArrayList<>();
		return loty_O_Kryteriach;
	}

	/**
	 * 
	 * @param kryteriaWyszukiwania
	 * @param klient
	 */
	public boolean kupnoBiletu(String[] kryteriaWyszukiwania, Klient klient) {
		// TODO - implement Aplikacja.kupnoBiletu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idKlient
	 * @param idBilet
	 * @param pracownik
	 */
	public void autoryzacjaSprzeda¿y(int idKlient, int idBilet, Pracownik pracownik) {
		if (pracownik.mozeAutoryzowac()){
			// TODO: 13.12.2023
		}
	}

	/**
	 * 
	 * @param daneKlient
	 * @param idBilet
	 */
	public boolean zwrotBiletu(Klient daneKlient, int idBilet) {
		//daneKlient.getBilety().get(/// TODO: 13.12.2023 ).setZwrot(true);
		return false;
	}

	/**
	 * 
	 * @param pracownik
	 * @param daneKlient
	 * @param idBilet
	 */
	public boolean autoryzacjaZwrotu(Pracownik pracownik, Klient daneKlient,int idBilet) {
		if (pracownik.mozeAutoryzowac()){
			// TODO: 13.12.2023
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klient
	 * @param idBilet
	 */
	public boolean zwrotPieniedzy(Klient klient, int idBilet) {
		// TODO - implement Aplikacja.zwrotPieniedzy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lot
	 */
	public void zarzadzanieWyposazeniemSamolotu(Lot lot) {
		// TODO - implement Aplikacja.zarzadzanieWyposazeniemSamolotu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param daneLotu
	 */
	public Lot utworzenieLotu(String[] daneLotu) {
		// TODO - implement Aplikacja.utworzenieLotu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idLot
	 * @param idSamolot
	 */
	public boolean przypisanieSamolotu(int idLot, int idSamolot) {
		// TODO - implement Aplikacja.przypisanieSamolotu
		throw new UnsupportedOperationException();
	}

	public ArrayList<Klient> getKlienci() {
		// TODO - implement Aplikacja.getKlienci
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param klienci
	 */
	public void setKlienci(ArrayList<Klient> klienci) {
		// TODO - implement Aplikacja.setKlienci
		throw new UnsupportedOperationException();
	}

	public ArrayList<Lot> getLoty() {
		// TODO - implement Aplikacja.getLoty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loty
	 */
	public void setLoty(ArrayList<Lot> loty) {
		// TODO - implement Aplikacja.setLoty
		throw new UnsupportedOperationException();
	}

	public ArrayList<Pracownik> getPracownicy() {
		// TODO - implement Aplikacja.getPracownicy
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pracownicy
	 */
	public void setPracownicy(ArrayList<Pracownik> pracownicy) {
		// TODO - implement Aplikacja.setPracownicy
		throw new UnsupportedOperationException();
	}

	public ArrayList<Samolot> getSamoloty() {
		// TODO - implement Aplikacja.getSamoloty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param samolotythrow new UnsupportedOperationException();
	}

	/**
	 */
	public void setSamoloty(ArrayList<Samolot> samoloty) {
		// TODO - implement Aplikacja.setSamoloty
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO - implement Aplikacja.main
		System.out.println("Hello world!");
	}

}