import model.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Dane {
    public Dane(){}

    public Klient daneKlient[] = new Klient[]{
        new Klient(1, "Michal", "Zajdel", "miczaj@gmail.com", 999929999,3213421,600),
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
        new Samolot(5, "Hasani", 55)
    };

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
