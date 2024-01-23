package testFitnesse;

import fit.ColumnFixture;
import dane.Dane;

public class DodajSamolot extends ColumnFixture {
    int index_samolot;

    public boolean dodajSamolot() throws NullPointerException {
        if (SetUp.aplikacja == null) return false;
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

    public int samolotySize() {
        return SetUp.aplikacja.getSamoloty().size();
    }
}