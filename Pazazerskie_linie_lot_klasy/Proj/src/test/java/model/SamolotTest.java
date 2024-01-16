package model;

import Dane.Dane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Samolot")
class SamolotTest implements TestExecutionExceptionHandler {

    static Samolot samolot;


    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof RuntimeException) {
        } else throw throwable;
    }

    @BeforeEach
    public void setUp() {
        samolot = new Samolot(1, "Test_Model", 100);
        Dane dane = new Dane();
        dane.fillSamolot(samolot);

    }

    @Test
    void wyposazenieTest(){
        double value = 1.0;
        for(int i = 0; i<5; i++){
            assertEquals(value, samolot.getWyposazenie());
            samolot.dodajWyposazenie(0.1);
            value += 0.1;
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    @ExtendWith(SamolotTest.class)
    void czyDostepnyTrue(Lot lot) {
        assertTrue(samolot.czyDostepny(lot));
    }

    @ParameterizedTest
    @MethodSource("dataFalse")
    @ExtendWith(SamolotTest.class)
    void czyDostepnyFalse(Lot lot) {
        assertFalse(samolot.czyDostepny(lot));
    }

    @ParameterizedTest
    @MethodSource("data")
    @ExtendWith(SamolotTest.class)
    @Tag("Przypis")
    void przypiszDoLotuSukces(Lot lot) {
        assertTrue(samolot.przypiszDoLotu(lot));
    }

    @ParameterizedTest
    @MethodSource("dataFalse")
    @ExtendWith(SamolotTest.class)
    @Tag("Przypis")
    void przypiszDoLotuPorazka(Lot lot) {
        assertFalse(samolot.przypiszDoLotu(lot));
    }

    static Stream<Lot> data(){
        LocalDateTime date1 = LocalDateTime.of(2024, Month.JANUARY,20,7,30);
        LocalDateTime date2 = LocalDateTime.of(2024, Month.JANUARY,20,9,0);
        LocalDateTime date3 = LocalDateTime.of(2024, Month.JANUARY,21,8,0);
        LocalDateTime date4 = LocalDateTime.of(2024, Month.JANUARY,21,10,30);
        LocalDateTime date5 = LocalDateTime.of(2024, Month.JANUARY,22,6,0);
        LocalDateTime date6 = LocalDateTime.of(2024, Month.JANUARY,22,9,30);
        LocalDateTime date7 = LocalDateTime.of(2024, Month.JANUARY,23,17,0);
        LocalDateTime date8 = LocalDateTime.of(2024, Month.JANUARY,23,19,30);
        LocalDateTime date9 = LocalDateTime.of(2024, Month.JANUARY,24,20,0);
        LocalDateTime date10 = LocalDateTime.of(2024, Month.JANUARY,24,23,30);
        LocalDateTime date11 = LocalDateTime.of(2024, Month.JANUARY,20,15,30);
        LocalDateTime date12 = LocalDateTime.of(2024, Month.JANUARY,20,20,0);
        LocalDateTime date13 = LocalDateTime.of(2024, Month.JANUARY,21,14,0);
        LocalDateTime date14 = LocalDateTime.of(2024, Month.JANUARY,21,16,0);
        LocalDateTime date15 = LocalDateTime.of(2024, Month.JANUARY,22,12,0);
        LocalDateTime date16 = LocalDateTime.of(2024, Month.JANUARY,22,15,0);
        LocalDateTime date17 = LocalDateTime.of(2024, Month.JANUARY,22,16,0);
        LocalDateTime date18 = LocalDateTime.of(2024, Month.JANUARY,22,20,30);
        LocalDateTime date19 = LocalDateTime.of(2024, Month.JANUARY,22,21,0);
        LocalDateTime date20 = LocalDateTime.of(2024, Month.JANUARY,22,23,50);

        return Stream.of(
                new Lot(6,"Warszawa",date1,"Gdansk",date2,500, 40),
                new Lot(7,"Warszawa",date3,"Gdansk",date4,500, 40),
                new Lot(8,"Warszawa",date5,"Gdansk",date6,500, 40),
                new Lot(9,"Warszawa",date7,"Gdansk",date8,500, 40),
                new Lot(10,"Warszawa",date9,"Gdansk",date10,500, 40),

                new Lot(11,"Warszawa",date11,"Gdansk",date12,500, 40),
                new Lot(12,"Warszawa",date13,"Gdansk",date14,500, 40),
                new Lot(13,"Warszawa",date15,"Gdansk",date16,500, 40),
                new Lot(14,"Warszawa",date17,"Gdansk",date18,500, 40),
                new Lot(15,"Warszawa",date19,"Gdansk",date20,500, 40)
        );
    }
    static Stream<Lot> dataFalse(){
        LocalDateTime date1 = LocalDateTime.of(2024, Month.JANUARY,20,15,30);
        LocalDateTime date2 = LocalDateTime.of(2024, Month.JANUARY,20,20,0);
        LocalDateTime date3 = LocalDateTime.of(2024, Month.JANUARY,21,14,0);
        LocalDateTime date4 = LocalDateTime.of(2024, Month.JANUARY,21,16,0);
        LocalDateTime date5 = LocalDateTime.of(2024, Month.JANUARY,22,12,0);
        LocalDateTime date6 = LocalDateTime.of(2024, Month.JANUARY,22,15,0);
        LocalDateTime date7 = LocalDateTime.of(2024, Month.JANUARY,22,16,0);
        LocalDateTime date8 = LocalDateTime.of(2024, Month.JANUARY,22,20,30);
        LocalDateTime date9 = LocalDateTime.of(2024, Month.JANUARY,22,21,0);
        LocalDateTime date10 = LocalDateTime.of(2024, Month.JANUARY,22,23,50);

        return Stream.of(
                new Lot(6,"Warszawa",date1,"Gdansk",date2,500, 40),
                new Lot(7,"Warszawa",date3,"Gdansk",date4,500, 40),
                new Lot(8,"Warszawa",date5,"Gdansk",date6,500, 40),
                new Lot(9,"Warszawa",date7,"Gdansk",date8,500, 40),
                new Lot(10,"Warszawa",date9,"Gdansk",date10,500, 40)
        );
    }
};