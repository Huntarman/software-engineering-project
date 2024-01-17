package App;

import Dane.Dane;
import model.Bilet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Aplikacja")
public class AplikacjaTest implements TestExecutionExceptionHandler {
    Aplikacja app;

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof RuntimeException) {
        } else throw throwable;
    }
    @BeforeEach
    public void fillData(){
        app = new Aplikacja();
        Dane dane = new Dane();
        dane.wypelnijDane(app);
    }

    @ParameterizedTest
    @CsvSource({"5,0","4,0","5,1","0,0"})
    @ExtendWith(AplikacjaTest.class)
    @Tags({@Tag("Bilet"), @Tag("Pracownik")})
    void autoryzacjaSprzedazy(int id_bilet, int id_pracownik) {
        assertTrue(app.autoryzacjaSprzedazy(app.getBilety().get(id_bilet), app.getPracownicy().get(id_pracownik)));
    }

    @ParameterizedTest
    @MethodSource("data")
    @ExtendWith(AplikacjaTest.class)
    @Tags({@Tag("Lot"), @Tag("Samolot"), @Tag("Pracownik"), @Tag("Przypis")})
    void przypisanieSamolotu(int id_lot, int id_samolot, int id_pracownik) {
        assertTrue(app.przypisanieSamolotu(id_lot, id_samolot, app.getPracownicy().get(id_pracownik)));
    }
    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1,1,0),
                Arguments.of(5,1,0),
                Arguments.of(1,1,1),
                Arguments.of(3,3,0)
        );
    }

    @ParameterizedTest
    @CsvSource({"3,0,2","3,1,2","3,0,3","3,0,1","3,0,0"})
    @ExtendWith(returnTestClass.class)
    @Tags({@Tag("Klient"), @Tag("Bilet"), @Tag("Pracownik")})
    void autoryzacjaZwrotu(int id_klient, int id_pracownik, int id_bilet) {
        assertTrue(app.autoryzacjaZwrotu(app.getPracownicy().get(id_pracownik),
                app.getKlienci().get(id_klient),
                app.getKlienci().get(id_klient).getBilety().get(id_bilet)));

    }
}