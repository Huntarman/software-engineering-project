package dane;

import app.Aplikacja;
import model.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Dane {
    public Dane(){}

    public Klient daneKlient[] = new Klient[]{
        new Klient(1, "Michal", "Zajdel", "miczaj@gmail.com", 999929999,3213421,600.0f),
        new Klient(2, "Kuba", "Lazorko", "kublaz@gmail.com", 119121911,1243123,400),
        new Klient(3, "Ramia", "Blau", "shar_simmersbz9@accommodations.vct", 43946, 312312, 1839),
        new Klient(4, "Claud", "Barna", "odell_millnera@webmasters.lv", 6462, 43421341, 575),
        new Klient(5, "Jeanmarie", "Huber", "quentella_mcculleyqmv@strength.sb", 718522, 98478, 3198)
    };

    public Pracownik danePracownik[] = new Pracownik[] {
        new Pracownik(1,"Michal","Lazorko"),
        new PersonelPokladowy(2, "Kuba", "Zajdel"),
        new PersonelPokladowy(3, "Kichal", "Zalorko"),
        new Pilot(4,"Muba","Kajdel"),
        new PersonelPokladowy(5, "Sarina", "Mendieta")
    };

    public Lot daneLot[] = new Lot[] {
        new Lot(1,"Warszawa", LocalDateTime.of(2024, Month.JANUARY,20,12,30),
                "Gdansk", LocalDateTime.of(2024, Month.JANUARY,20,19,0),500,40),
        new Lot(2,"Warszawa", LocalDateTime.of(2023, Month.DECEMBER,20,13,0),
                "Wroclaw", LocalDateTime.of(2023, Month.DECEMBER,20,16,30),300,30),
        new Lot(3,"Warszawa", LocalDateTime.of(2022, Month.DECEMBER,20,13,0),
                "Wroclaw", LocalDateTime.of(2022, Month.DECEMBER,20,16,30),10,35),
        new Lot(4,"Wroclaw", LocalDateTime.of(2024, Month.DECEMBER,20,13,0),
                    "Jasionka", LocalDateTime.of(2024, Month.DECEMBER,20,16,30),10,105),
        new Lot(5,"Radom", LocalDateTime.of(2024, Month.JANUARY,20,13,0),
                    "Warszawa", LocalDateTime.of(2024, Month.JANUARY,20,16,30),10,55),
    };

    public Samolot daneSamolot[] = new Samolot[] {
        new Samolot(1, "LotoSam", 40),
        new Samolot(2, "SotoLam",30),
        new Samolot(3, "Jonette", 35),
        new Samolot(4, "Danah", 105),
        new Samolot(5, "Hasani", 64),
        new Samolot(6, "Chiketa", 75),
        new Samolot(7, "Edison", 88),
    };

    public LocalDateTime daneDaty[] = new LocalDateTime[] {
            LocalDateTime.of(2024, Month.JANUARY,20,12,30),
            LocalDateTime.of(2024, Month.JANUARY,20,19,0),
            LocalDateTime.of(2023, Month.DECEMBER,20,13,0),
            LocalDateTime.of(2023, Month.DECEMBER,20,16,30),
            LocalDateTime.of(2022, Month.DECEMBER,20,13,0),
            LocalDateTime.of(2022, Month.DECEMBER,20,16,30),
            LocalDateTime.of(2024, Month.JULY,22,17,0),
            LocalDateTime.of(2024, Month.JULY,22,19,30),
            LocalDateTime.of(2024, Month.JULY,22,18,0),
            LocalDateTime.of(2024, Month.JULY,22,23,30)
    };

    public static void ustawArray(Aplikacja app) {
        ArrayList<Klient> klienci = new ArrayList<>();
        ArrayList<Lot> loty = new ArrayList<>();
        ArrayList<Pracownik> pracownicy = new ArrayList<>();
        ArrayList<Samolot> samoloty = new ArrayList<>();

        app.setSamoloty(samoloty);
        app.setLoty(loty);
        app.setKlienci(klienci);
        app.setPracownicy(pracownicy);
    }

    public static void wypelnijDane(Aplikacja app){
        ArrayList<Klient> klienci = new ArrayList<>();
        ArrayList<Lot> loty = new ArrayList<>();
        ArrayList<Pracownik> pracownicy = new ArrayList<>();
        ArrayList<Samolot> samoloty = new ArrayList<>();

        klienci.add(new Klient(1, "Michal", "Zajdel", "miczaj@gmail.com", 999929999,3213421,600));
        klienci.add(new Klient(2, "Kuba", "Lazorko", "kublaz@gmail.com", 119121911,1243123,400));
        klienci.add(new Klient(3, "Kuba", "Lazorko", "kublaz@gmail.com", 222222222,1232133,100));
        klienci.add(new Klient(4, "Kuba", "Lazorko", "kublaz@gmail.com", 444444444,12424312,10000));
        LocalDateTime date1 = LocalDateTime.of(2024, Month.JANUARY,20,12,30);
        LocalDateTime date2 = LocalDateTime.of(2024, Month.JANUARY,20,19,0);
        LocalDateTime date3 = LocalDateTime.of(2023, Month.DECEMBER,20,13,0);
        LocalDateTime date4 = LocalDateTime.of(2023, Month.DECEMBER,20,16,30);
        LocalDateTime date5 = LocalDateTime.of(2022, Month.DECEMBER,20,13,0);
        LocalDateTime date6 = LocalDateTime.of(2022, Month.DECEMBER,20,16,30);
        LocalDateTime date7 = LocalDateTime.of(2024, Month.JULY,22,17,0);
        LocalDateTime date8 = LocalDateTime.of(2024, Month.JULY,22,19,30);
        LocalDateTime date9 = LocalDateTime.of(2024, Month.JULY,22,18,0);
        LocalDateTime date10 = LocalDateTime.of(2024, Month.JULY,22,23,30);

        pracownicy.add(new Pracownik(1,"Michal","Lazorko"));
        pracownicy.add(new PersonelPokladowy(2, "Kuba", "Zajdel"));
        pracownicy.add(new PersonelPokladowy(3, "Kichal", "Zalorko"));
        pracownicy.add(new Pilot(4,"Muba","Kajdel"));

        app.utworzenieLotu(new Lot(1,"Warszawa",date1,"Gdansk",date2,500,40), pracownicy.get(0));
        app.utworzenieLotu(new Lot(2,"Warszawa",date3,"Wroclaw",date4,300,30), pracownicy.get(0));
        app.utworzenieLotu(new Lot(3,"Warszawa",date5,"Wroclaw",date6,100,35), pracownicy.get(0));
        app.utworzenieLotu(new Lot(4,"Walbrzych",date7,"Radom",date8,400,50), pracownicy.get(0));
        app.utworzenieLotu(new Lot(5,"Sosnowiec",date9,"Grzegorzow",date10,25,100), pracownicy.get(0));

        samoloty.add(new Samolot(1, "LotoSam", 40));
        samoloty.add(new Samolot(2, "SotoLam",30));
        samoloty.add(new Samolot(3, "TEstoLot",30));

        app.setKlienci(klienci);
        app.setPracownicy(pracownicy);
        app.setSamoloty(samoloty);

        app.przypisanieSamolotu(4,1,pracownicy.get(0));
        app.getSamoloty().get(2).setWyposazenie(0.4);

        app.kupnoBiletu(app.getLoty().get(0), app.getKlienci().get(3));
        app.kupnoBiletu(app.getLoty().get(1), app.getKlienci().get(3));
        app.kupnoBiletu(app.getLoty().get(3), app.getKlienci().get(3));
        app.kupnoBiletu(app.getLoty().get(4), app.getKlienci().get(3));
        app.kupnoBiletu(app.getLoty().get(0), app.getKlienci().get(1));
        app.kupnoBiletu(app.getLoty().get(3), app.getKlienci().get(0));

        app.autoryzacjaSprzedazy(app.getBilety().get(0), app.getPracownicy().get(0));
        app.autoryzacjaSprzedazy(app.getBilety().get(1), app.getPracownicy().get(0));
        app.autoryzacjaSprzedazy(app.getBilety().get(2), app.getPracownicy().get(0));
        app.autoryzacjaSprzedazy(app.getBilety().get(3), app.getPracownicy().get(0));

        app.zwrotBiletu(app.getKlienci().get(3).getBilety().get(0));
        app.zwrotBiletu(app.getKlienci().get(3).getBilety().get(1));
        app.zwrotBiletu(app.getKlienci().get(3).getBilety().get(2));
    }
    public void fillSamolot(Samolot samolot){
        LocalDateTime date1 = LocalDateTime.of(2024, Month.JANUARY,20,12,30);
        LocalDateTime date2 = LocalDateTime.of(2024, Month.JANUARY,20,19,0);
        LocalDateTime date3 = LocalDateTime.of(2024, Month.JANUARY,21,13,0);
        LocalDateTime date4 = LocalDateTime.of(2024, Month.JANUARY,21,16,30);
        LocalDateTime date5 = LocalDateTime.of(2024, Month.JANUARY,22,13,0);
        LocalDateTime date6 = LocalDateTime.of(2024, Month.JANUARY,22,16,30);
        LocalDateTime date7 = LocalDateTime.of(2024, Month.JANUARY,22,17,0);
        LocalDateTime date8 = LocalDateTime.of(2024, Month.JANUARY,22,19,30);
        LocalDateTime date9 = LocalDateTime.of(2024, Month.JANUARY,22,20,0);
        LocalDateTime date10 = LocalDateTime.of(2024, Month.JANUARY,22,23,30);
        samolot.przypiszDoLotu(new Lot(1,"Warszawa",date1,"Gdansk",date2,500, samolot.getIloscMiejsc()));
        samolot.przypiszDoLotu(new Lot(2,"Gdansk",date3,"Katowice",date4,600,samolot.getIloscMiejsc()));
        samolot.przypiszDoLotu(new Lot(3,"Terespol",date5,"Zakopane",date6,300,samolot.getIloscMiejsc()));
        samolot.przypiszDoLotu(new Lot(4,"Walbrzych",date7,"Radom",date8,400,samolot.getIloscMiejsc()));
        samolot.przypiszDoLotu(new Lot(5,"Sosnowiec",date9,"Grzegorzow",date10,25,samolot.getIloscMiejsc()));
    }

    public void fillKlient(Klient klient){
        LocalDateTime date1 = LocalDateTime.of(2024, Month.JANUARY,20,12,30);
        LocalDateTime date2 = LocalDateTime.of(2024, Month.JANUARY,20,19,0);
        LocalDateTime date3 = LocalDateTime.of(2024, Month.JANUARY,21,13,0);
        LocalDateTime date4 = LocalDateTime.of(2024, Month.JANUARY,21,16,30);
        LocalDateTime date5 = LocalDateTime.of(2024, Month.JANUARY,22,13,0);
        LocalDateTime date6 = LocalDateTime.of(2024, Month.JANUARY,22,16,30);
        LocalDateTime date7 = LocalDateTime.of(2024, Month.JANUARY,22,17,0);
        LocalDateTime date8 = LocalDateTime.of(2024, Month.JANUARY,22,19,30);
        LocalDateTime date9 = LocalDateTime.of(2024, Month.JANUARY,22,20,0);
        LocalDateTime date10 = LocalDateTime.of(2024, Month.JANUARY,22,23,30);
        klient.setSaldo(500.0f);
        klient.addBilet(new Bilet(1, 1, klient.getId(), 1, date1, date2, "Warszawa", "Gdansk", 500, true));
        klient.addBilet(new Bilet(2, 2, klient.getId(), 1, date3, date4, "Gdansk", "Katowice", 600, true));
        klient.addBilet(new Bilet(3, 3, klient.getId(), 1, date5, date6, "Terespol", "Zakopane", 300, true));
        klient.addBilet(new Bilet(4, 4, klient.getId(), 1, date7, date8, "Walbrzych", "Radom", 400, true));
        klient.addBilet(new Bilet(5, 5, klient.getId(), 1, date9, date10, "Sosnowiec", "Grzegorzow", 25, true));
    }
}
