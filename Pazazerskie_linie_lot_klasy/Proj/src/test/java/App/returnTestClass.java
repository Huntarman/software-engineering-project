package App;

import Dane.Dane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class returnTestClass implements TestExecutionExceptionHandler {
    Aplikacja app;
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof RuntimeException) {
        } else throw throwable;
    }
    @BeforeEach
    void addReturns(){
        app = new Aplikacja();
        Dane dane = new Dane();
        dane.wypelnijDane(app);

    }
    @ParameterizedTest
    @CsvSource({"3,0,2","3,1,2","3,0,3","3,0,1","3,0,0"})
    @ExtendWith(returnTestClass.class)
    void autoryzacjaZwrotu(int id_klient, int id_pracownik, int id_bilet) {
        assertTrue(app.autoryzacjaZwrotu(app.getPracownicy().get(id_pracownik),
                app.getKlienci().get(id_klient),
                app.getKlienci().get(id_klient).getBilety().get(id_bilet)));

    }
}