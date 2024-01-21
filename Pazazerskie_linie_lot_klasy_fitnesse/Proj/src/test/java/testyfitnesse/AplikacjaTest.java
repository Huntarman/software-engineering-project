package testyFitnesse;

import model.Samolot;
import fit.ColumnFixture;

public class TestSamolot extends ColumnFixture {

    void wyposazenieTest(){
        double value = 1.0;
        for(int i = 0; i<5; i++){
            (value, samolot.getWyposazenie());
            samolot.dodajWyposazenie(0.1);
            value += 0.1;
        }
    }
}
