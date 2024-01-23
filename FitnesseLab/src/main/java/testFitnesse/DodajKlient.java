package testFitnesse;

import fit.ColumnFixture;
import dane.Dane;

public class DodajKlient extends ColumnFixture {
    int index_klient;

    public boolean dodajKlient() throws NullPointerException {
        Dane dane = new Dane();

        int jeden = klientSize();

        try {
            SetUp.aplikacja.dodajKlient(dane.daneKlient[index_klient]);
            int dwa = klientSize();
            return jeden != dwa;
        }
        catch (NullPointerException e) { }

        return false;
    }

    public int klientSize() {
        return SetUp.aplikacja.getKlienci().size();
    }
}
