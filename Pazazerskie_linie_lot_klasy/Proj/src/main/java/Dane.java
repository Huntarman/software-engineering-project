import model.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Dane {
    public Dane(){}
    public Klient daneKlient[] = new Klient[]{
            new Klient(1, "Michal", "Zajdel", "miczaj@gmail.com", 999929999,3213421,600),
            new Klient(),
            new Klient() };
    public static void wypelnijDane(Aplikacja app){
        ArrayList<Klient> klienci = new ArrayList<>();
        ArrayList<Lot> loty = new ArrayList<>();
        ArrayList<Pracownik> pracownicy = new ArrayList<>();
        ArrayList<Samolot> samoloty = new ArrayList<>();

        klienci.add(new Klient(1, "Michal", "Zajdel", "miczaj@gmail.com", 999929999,3213421,600));
        klienci.add(new Klient(2, "Kuba", "Lazorko", "kublaz@gmail.com", 119121911,1243123,400));

        LocalDateTime date1 = LocalDateTime.of(2024, Month.JANUARY,20,12,30);
        LocalDateTime date2 = LocalDateTime.of(2024, Month.JANUARY,20,19,0);
        LocalDateTime date3 = LocalDateTime.of(2023, Month.DECEMBER,20,13,0);
        LocalDateTime date4 = LocalDateTime.of(2023, Month.DECEMBER,20,16,30);
        LocalDateTime date5 = LocalDateTime.of(2022, Month.DECEMBER,20,13,0);
        LocalDateTime date6 = LocalDateTime.of(2022, Month.DECEMBER,20,16,30);

        pracownicy.add(new Pracownik(1,"Michal","Lazorko"));
        pracownicy.add(new PersonelPokladowy(2, "Kuba", "Zajdel"));
        pracownicy.add(new PersonelPokladowy(3, "Kichal", "Zalorko"));
        pracownicy.add(new Pilot(4,"Muba","Kajdel"));

        app.utworzenieLotu(new Lot(1,"Warszawa",date1,"Gdansk",date2,500,40), pracownicy.get(0));
        app.utworzenieLotu(new Lot(2,"Warszawa",date3,"Wroclaw",date4,300,30), pracownicy.get(0));
        app.utworzenieLotu(new Lot(3,"Warszawa",date5,"Wroclaw",date6,10,35), pracownicy.get(0));

        samoloty.add(new Samolot(1, "LotoSam", 40));
        samoloty.add(new Samolot(2, "SotoLam",30));

        app.getLoty().get(0).setSamolot(samoloty.get(0));
        Pilot p = (Pilot) pracownicy.get(3);
        ArrayList<Pilot> alp = app.getLoty().get(0).getPiloci();
        alp.add(p);
        app.getLoty().get(0).setPiloci(alp);
        app.getLoty().get(1).setSamolot(samoloty.get(1));
        app.getLoty().get(2).setSamolot(samoloty.get(0));

        app.setKlienci(klienci);
        app.setPracownicy(pracownicy);
        app.setSamoloty(samoloty);

    }
}
