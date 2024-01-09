import model.Bilet;
import model.Klient;
import model.Lot;
import model.Pracownik;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.imageio.stream.ImageInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

// -javaagent:"C:/Program Files/Java/jmockit.1.49.jar"
// C:\Users\kubal\.m2\repository\org\jmockit\jmockit\1.49\jmockit-1.49.jar

import static org.junit.jupiter.api.Assertions.*;

class AplikacjaTest {

    @Test
    void przegladanieLotow() {

    }

    @Test
    void szukanieLotu() {
    }

    @Test
    void kupnoBiletu() {
    }

    @Test
    void autoryzacjaSprzedazy() {
        Dane dane = new Dane();
        Aplikacja app = new Aplikacja();
        dane.wypelnijDane(app);
        app.kupnoBiletu(app.getLoty().get(0), app.getKlienci().get(0));

        boolean wynik = app.autoryzacjaSprzedazy(app.getKlienci().get(0).getBilety().get(0), app.getPracownicy().get(0));
        System.out.print("Your momma");
        assertEquals(true, wynik);
    }

    @Test
    void autoryzacjaSprzedazy1() {
        Dane dane = new Dane();
        Aplikacja app = new Aplikacja();
        dane.wypelnijDane(app);
        app.kupnoBiletu(app.getLoty().get(0), app.getKlienci().get(0));

        boolean wynik = app.autoryzacjaSprzedazy(app.getKlienci().get(0).getBilety().get(0), app.getPracownicy().get(1));
        assertEquals(false, wynik);
    }

    @Test
    void zwrotBiletu() {
    }

    @Test
    void autoryzacjaZwrotu() {
    }

    @Test
    void zwrotPieniedzy() {
    }

    @Test
    void zarzadzanieWyposazeniemSamolotu() {
    }

    @Test
    void utworzenieLotu() {
    }

    @Test
    void przypisanieSamolotu() {
    }
}