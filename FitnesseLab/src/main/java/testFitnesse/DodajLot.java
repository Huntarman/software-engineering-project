package testFitnesse;

import fit.ColumnFixture;
import dane.Dane;

public class DodajLot extends ColumnFixture {
    int index_lot;
    int index_pracownik;

    public boolean dodajLot() throws NullPointerException {
        Dane dane = new Dane();

        int jeden = lotySize();

        try {
            SetUp.aplikacja.utworzenieLotu(dane.daneLot[index_lot], dane.danePracownik[index_pracownik]);
            int dwa = lotySize();
            return jeden != dwa;
        }
        catch (NullPointerException e) { }

        return false;
    }

    public int lotySize() {
        return SetUp.aplikacja.getLoty().size();
    }
}
