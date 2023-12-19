package classDiagram.system;

import classDiagram.system.model.*;

import java.lang.reflect.Array;
import java.security.PrivilegedActionException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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
	 * @param bilet
	 * @param pracownik
	 */
	public void autoryzacjaSprzedazy(Bilet bilet, Pracownik pracownik) {
		if (pracownik.mozeAutoryzowac()){
			if (bilety.get(bilet.getId()-1).getAutoryzacja()){
				System.out.println("Bilet zostal juz zautoryzowany");
				return;
			}
			if (klienci.get(bilet.getIdKlient()-1).pobierzOplate(bilety.get(bilet.getId()-1))){
				System.out.println("Bilet zostaje zatwierdzony");
				bilety.get(bilet.getId()-1).setAutoryzacja(true);
			}
			else{
				System.out.println("Bilet zostaje usuniety, klient nie posiada wymaganych srodków w saldzie");
				bilety.remove(bilet.getId()-1);
			}
		}
		else {
			System.out.println("Pracownik " + pracownik.getId() + " nie ma wymaganego poziomu dostepu");;
		}
	}

	/**
	 *
	 * @param daneKlient
	 * @param bilet
	 */
	public boolean zwrotBiletu(Klient daneKlient, Bilet bilet) {
		if (bilety.get(bilet.getId()-1).getAutoryzacja()){
			if (bilety.get(bilet.getId()-1).getZwrot()){
				System.out.println("Bilet jest juz w trakcie zwrotu");
				return false;
			}
			System.out.println("Bilet zostaje podany do zwrotu");
			bilety.get(bilet.getId()-1).setZwrot(true);
			return true;
		}
		else{
			System.out.println("Bilet nie jest zautoryzowany");
			return false;
		}
	}

	/**
	 *
	 * @param pracownik
	 * @param klient
	 * @param bilet
	 */
	public boolean autoryzacjaZwrotu(Pracownik pracownik, Klient klient, Bilet bilet) {
		if (!pracownik.mozeAutoryzowac()){
			System.out.println("Dany pracownik nie autoryzowac");
			return false;
		}
		if(!bilety.get(bilet.getId()-1).getZwrot()){
			System.out.println("Bilet nie jest w trakcie zwrotu");
			return false;
		}
		if (LocalDateTime.now().isAfter(bilety.get(bilet.getId()-1).getData_wylot())){
			System.out.println("Lot juz sie odbyl, nie mozna dokonac zwrotu");
			return false;
		}
		long weeksBetween = ChronoUnit.WEEKS.between(LocalDateTime.now(), bilety.get(bilet.getId()-1).getData_wylot());
		if (weeksBetween > 2){
			zwrotPieniedzy(klient, bilet);
			loty.get(bilet.getIdLotu() - 1).zwrocMiejsce();
			bilety.remove(bilet.getId()-1);
			System.out.println("Zwrot biletu zostal zatwierdzony");
			return true;
		}
		else {
			System.out.println("Nie mozna zatwierdzic zwrotu. Do wylotu zostalo mniej niz 2 tygodnie");
			return false;
		}
	}

	/**
	 *
	 * @param klient
	 * @param bilet
	 */
	public boolean zwrotPieniedzy(Klient klient, Bilet bilet) {
		return true;
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
		Pilot p = (Pilot) pracownicy.get(3);
		ArrayList<Pilot> alp = app.getLoty().get(0).getPiloci();
		alp.add(p);
		app.getLoty().get(0).setPiloci(alp);
		app.getLoty().get(1).setSamolot(samoloty.get(1));

		app.setKlienci(klienci);
		System.out.println("\nKlienci: " + app.getKlienci().toString());
		System.out.println("\nLoty: " + app.getLoty().toString());
		app.setPracownicy(pracownicy);
		app.setSamoloty(samoloty);
		System.out.println("\nPracownicy: " + app.getPracownicy().toString());
		System.out.println("\nSamoloty: " + app.getSamoloty().toString());

		app.kupnoBiletu(app.loty.get(0),app.klienci.get(0));
		System.out.println(app.bilety.toString());
		app.autoryzacjaSprzedazy(app.bilety.get(0),app.getPracownicy().get(0));
		System.out.println("Pkt widzenia app: " + app.bilety.toString());
		System.out.println("Pkt widzenia klient: " + app.klienci.get(0).getBilety().toString());

		System.out.println("\nLoty: " + app.getLoty().toString());

		app.zwrotBiletu(app.klienci.get(0),app.klienci.get(0).getBilety().get(0));
		System.out.println("Pkt widzenia app: " + app.bilety.toString());
		System.out.println("Pkt widzenia klient: " + app.klienci.get(0).getBilety().toString());

		app.autoryzacjaZwrotu(app.pracownicy.get(0), app.klienci.get(0), app.klienci.get(0).getBilety().get(0));
		System.out.println("Pkt widzenia app: " + app.bilety.toString());
		System.out.println("Pkt widzenia klient: " + app.klienci.get(0).getBilety().toString());

		System.out.println("\nLoty: " + app.getLoty().toString());
	}
}