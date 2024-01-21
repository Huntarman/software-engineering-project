package testFitnesse;

import fit.ColumnFixture;

public class AplikacjaTestBase extends ColumnFixture {
    int id_bilet, id_pracownik;

    public boolean autoryzacjaSprzedazy () {
        int first = liczbaBiletow();
        try {
            SetUp.aplikacja.autoryzacjaSprzedazy(SetUp.aplikacja.getBilety().get(id_bilet), SetUp.aplikacja.getPracownicy().get(id_pracownik));
            int second = liczbaBiletow();
            return first == second;
        }
        catch (Exception e) {

        }
        return false;
        // assertTrue(app.autoryzacjaSprzedazy(app.getBilety().get(id_bilet), app.getPracownicy().get(id_pracownik)));
    }

    public int liczbaBiletow() {
        return SetUp.aplikacja.getBilety().size();
    }
}
