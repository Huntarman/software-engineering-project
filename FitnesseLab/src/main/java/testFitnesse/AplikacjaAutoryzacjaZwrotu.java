package testFitnesse;

import fit.ColumnFixture;

public class AplikacjaAutoryzacjaZwrotu extends ColumnFixture {
    int id_klient, id_pracownik, id_bilet;

    public boolean autoryzacjaZwrotu() {
        try {
            return SetUp.aplikacja.autoryzacjaZwrotu(SetUp.aplikacja.getPracownicy().get(id_pracownik),
                    SetUp.aplikacja.getKlienci().get(id_klient),
                    SetUp.aplikacja.getKlienci().get(id_klient).getBilety().get(id_bilet));
        }
        catch (Exception e) {
            return false;
        }
    }
}
