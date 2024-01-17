package model;

import App.Aplikacja;
import App.AplikacjaTest;
import Dane.Dane;
import mockit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Aplikacja")
public class AplikacjaTestMocked implements TestExecutionExceptionHandler {
    @Mocked
    Lot lot;
    @Mocked
    Pracownik prac;
    @Mocked
    Bilet bilet;

    @Mocked
    Klient klient;

    @Tested
    Aplikacja app;

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof RuntimeException) {
        } else throw throwable;
    }

    @BeforeEach
    public void setUp(){
        Dane dane = new Dane();
        klient = dane.daneKlient[0];
    }

    @Test
    public void testAutoSprzedaz1() {
        Aplikacja apka = new Aplikacja();
        new Expectations() {
            {
                prac.mozeAutoryzowac(); result = true;
                prac.getId(); result = 1;

                lot.getId(); result = 1;
                lot.getCena(); result = 100;
                lot.getNastepneWolneMiejsce(); result = 1;

                bilet.getId(); result = 1;
                // bilet.getCena(); result = 100.0f;

                klient.getSaldo(); result = 500.0f;
                klient.getId(); result = 1;
                apka.getBilety().size(); result = 1;
                // apka.getBilety().get(0).getAutoryzacja(); result = true;
            }
        };
        /*
        System.out.println("Pracownik");
        System.out.println(prac.mozeAutoryzowac());
        System.out.println(prac.getId());
        System.out.println("Lot");
        System.out.println(lot.getId());
        System.out.println(lot.getCena());
        System.out.println(lot.getNastepneWolneMiejsce());
        System.out.println("Klient");
        System.out.println(klient.getId());
        System.out.println(klient.getSaldo());
        System.out.println("Apka");
        System.out.println(apka.getBilety().size());
*/
        apka.setLoty(new ArrayList<>(Arrays.asList(lot)));
        apka.setKlienci(new ArrayList<>(Arrays.asList(klient)));
        apka.kupnoBiletu(apka.getLoty().get(0), apka.getKlienci().get(0));//lot, klient);

        System.out.println(apka.getBilety().get(0).getId());
        apka.getBilety().get(0).setAutoryzacja(true);

        boolean resultTest = true;
        // Nie wiem czy tak to siê obs³uguje lol
        try {
            resultTest = apka.autoryzacjaSprzedazy(apka.getBilety().get(0), prac);
        }
        catch (Exception e) {
            resultTest = false;
        }
        finally {
            assertEquals(false, resultTest);
        }
    }

    @Test
    public void testAutoryzacjaSprzedazyBrakAuth() {
        Aplikacja apka = new Aplikacja();
        new Expectations() {
            {
                prac.mozeAutoryzowac(); result = false;
                prac.getId(); result = 1;

                lot.getId(); result = 1;
                lot.getCena(); result = 100;
                lot.getNastepneWolneMiejsce(); result = 1;

                bilet.getId(); result = 1;
                // bilet.getCena(); result = 100.0f;

                klient.getSaldo(); result = 500.0f;
                klient.getId(); result = 1;
                apka.getBilety().size(); result = 1;
                // apka.getBilety().get(0).getAutoryzacja(); result = true;
            }
        };
        System.out.println("Pracownik");
        System.out.println(prac.mozeAutoryzowac());
        System.out.println(prac.getId());
        System.out.println("Lot");
        System.out.println(lot.getId());
        System.out.println(lot.getCena());
        System.out.println(lot.getNastepneWolneMiejsce());
        System.out.println("Klient");
        System.out.println(klient.getId());
        System.out.println(klient.getSaldo());
        System.out.println("Apka");
        System.out.println(apka.getBilety().size());

        apka.setLoty(new ArrayList<>(Arrays.asList(lot)));
        apka.setKlienci(new ArrayList<>(Arrays.asList(klient)));
        apka.kupnoBiletu(apka.getLoty().get(0), apka.getKlienci().get(0));//lot, klient);

        System.out.println(apka.getBilety().get(0).getId());
        apka.getBilety().get(0).setAutoryzacja(true);

        boolean resultTest = true;
        // Nie wiem czy tak to siê obs³uguje lol
        try {
            resultTest = apka.autoryzacjaSprzedazy(apka.getBilety().get(0), prac);
        }
        catch (Exception e) {
            resultTest = false;
        }
        finally {
            assertEquals(false, resultTest);
        }
    }
}