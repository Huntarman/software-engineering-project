package model;

import Dane.Dane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter
import org.junit.jupiter.params.provider.MethodSource;

class KlientTest {

    Dane dane;

    @MethodSource(value=0)
    @MethodSource(value=1)
    @BeforeEach
    public void setUp(){
        dane = new Dane();
    }

    @Test
    void usunBilet() {
    }

    @Test
    void pobierzOplate() {
    }
}