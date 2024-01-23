package testFitnesse;

import dane.Dane;
import fit.ColumnFixture;

public class AplikacjaPrzypisanieSamolotu extends ColumnFixture {
    //int index_lot; //, index_pracownik;
   // int index_samolot;

    int id_lot, id_samolot, id_pracownik;
    /*

    public boolean dodajLot() throws NullPointerException {
        Dane dane = new Dane();

        int jeden = lotySize();

        try {
            SetUp.aplikacja.utworzenieLotu(dane.daneLot[index_lot], dane.danePracownik[id_pracownik]);
            int dwa = lotySize();
            return jeden != dwa;
        }
        catch (NullPointerException e) { }

        return false;
    }

    public boolean dodajSamolot() throws NullPointerException {
        Dane dane = new Dane();

        int jeden = samolotySize();

        try {
            SetUp.aplikacja.dodajSamolot(dane.daneSamolot[index_samolot]);
            int dwa = samolotySize();
            return jeden != dwa;
        }
        catch (NullPointerException e) { }

        return false;
    }
*/
    public boolean przypisanieSamolotu() {
        try {
            SetUp.aplikacja.przypisanieSamolotu(id_lot, id_samolot, SetUp.aplikacja.getPracownicy().get(id_pracownik));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
/*
    public int lotySize() {
        return SetUp.aplikacja.getLoty().size();
    }
    public int samolotySize() {
        return SetUp.aplikacja.getSamoloty().size();
    }
 */
}
