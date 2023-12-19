package classDiagram.system;

import classDiagram.system.model.*;

import java.lang.reflect.Array;
import java.security.PrivilegedActionException;
import java.time.LocalDateTime;
import java.time.Month;
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
	 * @param miejsceWylot
	 * @param miejscePrzylot
	 * @param cenaMax
	 */
	public ArrayList<Lot> szukanieLotu(String miejsceWylot, String miejscePrzylot, int cenaMax) {
		ArrayList<Lot> loty_O_Kryteriach = new ArrayList<>();
		return loty_O_Kryteriach;
	}

	/**
	 *
	 * @param lot
	 * @param klient
	 */
	public boolean kupnoBiletu(Lot lot, Klient klient) {
		Bilet newBilet = new Bilet(bilety.size()+1,
									lot.getId(),
									klient.getId(),
									lot.getNastepneWolneMiejsce(),
									lot.getDataWylot(),
									lot.getDataPrzylot(),
									lot.getMiejsceWylot(),
									lot.getMiejscePrzylot(),
									lot.getCena());
		bilety.add(newBilet);
		klient.addBilet(newBilet);
		return true;
	}

	/**
	 *
	 * @param idKlient
	 * @param idBilet
	 * @param pracownik
	 */
	public void autoryzacjaSprzedazy(int idKlient, int idBilet, Pracownik pracownik) {
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
	public void zarzadzanieWyposazeniemSamolotu(Lot lot, Pracownik pracownik) {
		// TODO - implement Aplikacja.zarzadzanieWyposazeniemSamolotu
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param lot
	 */
	public boolean utworzenieLotu(Lot lot, Pracownik pracownik) {
		if (!pracownik.mozeAutoryzowac()) return false;

		return loty.add(lot);
	}

	/**
	 *
	 * @param idLot
	 * @param idSamolot
	 */
	public boolean przypisanieSamolotu(int idLot, int idSamolot, Pracownik pracownik) {
		if (!pracownik.mozeAutoryzowac()){
			System.out.println("Dany pracownik nie autoryzowac");
			return false;
		}
		if (this.samoloty.get(idSamolot-1).getWyposazenie() < 0.5){
			System.out.println("Niespelniony wymog wyposazenia");
			return false;
		}
		if (this.samoloty.get(idSamolot - 1).czyDostepny(this.loty.get(idLot-1))){
			this.samoloty.get(idSamolot-1).addGodzinyPrzypisane(this.loty.get(idLot-1));
			this.loty.get(idLot-1).setSamolot(this.samoloty.get(idSamolot-1));
			return true;
		}
		else return false;
	}

	public ArrayList<Klient> getKlienci() {
		return this.klienci;
	}

	/**
	 *
	 * @param klienci
	 */
	public void setKlienci(ArrayList<Klient> klienci) {
		this.klienci = klienci;
	}

	public ArrayList<Lot> getLoty() {
		return this.loty;
	}

	/**
	 *
	 * @param loty
	 */
	public void setLoty(ArrayList<Lot> loty) {
		this.loty = loty;
	}

	public ArrayList<Pracownik> getPracownicy() {
		return pracownicy;
	}

	/**
	 *
	 * @param pracownicy
	 */
	public void setPracownicy(ArrayList<Pracownik> pracownicy) {
		this.pracownicy = pracownicy;
	}

	public ArrayList<Samolot> getSamoloty() {
		return this.samoloty;
	}

	/**
	 */
	public void setSamoloty(ArrayList<Samolot> samoloty) {
		this.samoloty = samoloty;
	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Aplikacja app = new Aplikacja();
		ArrayList<Klient> klienci = new ArrayList<>();
		ArrayList<Lot> loty = new ArrayList<>();
		ArrayList<Pracownik> pracownicy = new ArrayList<>();
		ArrayList<Samolot> samoloty = new ArrayList<>();

		klienci.add(new Klient(1, "Michal", "Zajdel", "miczaj@gmail.com", 999929999,3213421,600));
		klienci.add(new Klient(2, "Kuba", "Lazorko", "kublaz@gmail.com", 119121911,1243123,400));

		LocalDateTime date1 = LocalDateTime.of(2022, Month.DECEMBER,20,12,30);
		LocalDateTime date2 = LocalDateTime.of(2022, Month.DECEMBER,20,19,0);
		LocalDateTime date3 = LocalDateTime.of(2022, Month.DECEMBER,20,13,0);
		LocalDateTime date4 = LocalDateTime.of(2022, Month.DECEMBER,20,16,30);

		pracownicy.add(new Pracownik(1,"Michal","Lazorko"));
		pracownicy.add(new PersonelPokladowy(2, "Kuba", "Zajdel"));
		pracownicy.add(new PersonelPokladowy(3, "Kichal", "Zalorko"));
		pracownicy.add(new Pilot(4,"Muba","Kajdel"));

		app.utworzenieLotu(new Lot(1,"Warszawa",date1,"Gdansk",date2,500,40), pracownicy.get(0));
		app.utworzenieLotu(new Lot(2,"Warszawa",date3,"Wroclaw",date4,300,30), pracownicy.get(0));

		samoloty.add(new Samolot(1, "LotoSam", 40));
		samoloty.add(new Samolot(2, "SotoLam",30));

		app.getLoty().get(0).setSamolot(samoloty.get(0));
		app.getLoty().get(1).setSamolot(samoloty.get(1));

		app.setKlienci(klienci);
		System.out.println("\nKlienci: " + app.getKlienci().toString());
		System.out.println("\nLoty: " + app.getLoty().toString());
		app.setPracownicy(pracownicy);
		app.setSamoloty(samoloty);
		System.out.println("\nPracownicy: " + app.getPracownicy().toString());
		System.out.println("\nSamoloty: " + app.getSamoloty().toString());
	}
}