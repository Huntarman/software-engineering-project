package model;

import Dane.Dane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter

@Tag("Klient")
class KlientTest implements TestExecutionExceptionHandler {

    static Klient klient;
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof RuntimeException) {
        } else throw throwable;
    }
    @BeforeEach
    public void setUp(){
        Dane dane = new Dane();
        klient = new Klient(1, "Michal", "Lazorko", "test@test.com", 999999999, 1014012423, 500);
        dane.fillKlient(klient);
    }

    @ParameterizedTest
    @CsvSource({"1","2","3","4","5"})
    @ExtendWith(KlientTest.class)
    @Tag("Bilet")
    void usunBiletTrue(int Bilet_id) {
       assertTrue(klient.usunBilet(Bilet_id));
    }

    @ParameterizedTest
    @MethodSource("dataDeleteFalse")
    @ExtendWith(KlientTest.class)
    @Tag("Bilet")
    void usunBiletFalse(int Bilet_id) {
        assertFalse(klient.usunBilet(Bilet_id));
    }

    @ParameterizedTest
    @MethodSource("dataBilet")
    @ExtendWith(KlientTest.class)
    void pobierzOplate(Bilet bilet) {
        assertTrue(klient.pobierzOplate(bilet));
    }

    @ParameterizedTest
    @MethodSource("dataBilet")
    @ExtendWith(KlientTest.class)
    void pobierzOplate_BalanceTest(Bilet bilet) {
        float balance_theory = klient.getSaldo()- bilet.getCena();
        klient.pobierzOplate(bilet);
        float balance_afr = klient.getSaldo();
        assertEquals(balance_theory, balance_afr);
    }
    static Stream<Integer> dataDeleteFalse() {
        return Stream.of(0,6,999,23,-1);
    }
    static Stream<Bilet> dataBilet(){
        LocalDateTime date1 = LocalDateTime.of(2024, Month.JANUARY,20,12,30);
        LocalDateTime date2 = LocalDateTime.of(2024, Month.JANUARY,20,19,0);
        LocalDateTime date3 = LocalDateTime.of(2024, Month.FEBRUARY,12,13,0);
        LocalDateTime date4 = LocalDateTime.of(2024, Month.FEBRUARY,12,16,30);
        LocalDateTime date5 = LocalDateTime.of(2024, Month.MAY,1,13,0);
        LocalDateTime date6 = LocalDateTime.of(2024, Month.MAY,1,16,30);
        LocalDateTime date7 = LocalDateTime.of(2024, Month.JUNE,5,17,0);
        LocalDateTime date8 = LocalDateTime.of(2024, Month.JUNE,5,19,30);
        LocalDateTime date9 = LocalDateTime.of(2024, Month.JULY,30,20,0);
        LocalDateTime date10 = LocalDateTime.of(2024, Month.JULY,30,23,30);
        return Stream.of(
                new Bilet(6, 6, 1, 1, date1, date2, "Warszawa", "Gdansk", 500, true),
                new Bilet(7, 7, 1, 1, date3, date4, "Gdank", "Warszawa", 400, true),
                new Bilet(8, 8, 1, 1, date5, date6, "Wroclaw", "Walbrzych", 200, true),
                new Bilet(9, 9, 1, 1, date7, date8, "Szczecin", "Katowice", 600, true),
                new Bilet(10, 10, 1, 1, date9, date10, "Lolowo", "Lmalowo", 1000, true)
        );
    }
}