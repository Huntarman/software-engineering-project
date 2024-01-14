package App;

import Dane.Dane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;


import static org.junit.jupiter.api.Assertions.*;

class AplikacjaTest implements TestExecutionExceptionHandler {
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
    @CsvSource()
    @ExtendWith(AplikacjaTest.class)
    void autoryzacjaSprzedazy() {
    }

    @ParameterizedTest
    @CsvSource()
    @ExtendWith(AplikacjaTest.class)
    void przypisanieSamolotu() {
    }


}
class returnTestClass implements TestExecutionExceptionHandler {
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
    @BeforeEach
    void addReturns(){
        app.zwrotBiletu(app.getKlienci().get(0).getBilety().get(0));
        app.zwrotBiletu(app.getKlienci().get(0).getBilety().get(0));
        app.zwrotBiletu(app.getKlienci().get(1).getBilety().get(0));
        app.zwrotBiletu(app.getKlienci().get(0).getBilety().get(0));
    }
    @ParameterizedTest
    @CsvSource()
    @ExtendWith(AplikacjaTest.class)
    void autoryzacjaZwrotu() {
    }
}