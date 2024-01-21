package testFitnesse;

import fit.Fixture;
import app.Aplikacja;
import dane.Dane;

public class SetUp extends Fixture {
    static Aplikacja aplikacja;
    public SetUp() {
        aplikacja = new Aplikacja();
        Dane dane = new Dane();
        dane.wypelnijDane(aplikacja);
    }
}