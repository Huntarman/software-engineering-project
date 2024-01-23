package testFitnesse;

import fit.ColumnFixture;

public class KupnoBiletu extends ColumnFixture {
    int index_lotu, index_klient;

    public boolean kupnoBiletu() {
        try {
            return SetUp.aplikacja.kupnoBiletu(SetUp.aplikacja.getLoty().get(index_lotu),
                    SetUp.aplikacja.getKlienci().get(index_klient));
        }
        catch (Exception e) {
            return false;
        }
    }

    public int liczbaBiletow() {
        return SetUp.aplikacja.getBilety().size();
    }
}
