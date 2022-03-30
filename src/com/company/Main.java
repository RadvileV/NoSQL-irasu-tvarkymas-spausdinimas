package com.company;

public class Main {

    public static void main(String[] args) {
        CharacterDAO characterDAO = new CharacterDAO();

        //1.1 Prisijungti prie MongoDB ir sukurti kolekciją chars su dokumentais:
        /*
        Character character1 = new Character(1, "Kempiniukas Plačiakelnis", "Kempinė", "Bikini įduba", "Virėjas", 1000);
        characterDAO.insert(character1);
        Character character2 = new Character(2, "Patrikas Žvaigždė", "Žvaigždė", "Bikini įduba", "Virėjo padėjėjas", 500);
        characterDAO.insert(character2);
        Character character3 = new Character(3, "Ponas Krabas", "Krabas", "Bikini įduba", "Traškiojo Krabo užkandinės šefas", 3000);
        characterDAO.insert(character3);
        */

        //1.2 Pridėti prie kolekcijos 50 naujų dokumentų (gali būti užpildyta tuščiais įrašais)
        /*
        for (int i = 4; i < 54; i++) {
            Character character4 = new Character(i, "", "", "", "", 0);
            characterDAO.insert(character4);
        }
        */

        //1.3 Atnaujinti Kempiniuko Plačiakelnio adresą. Pagal vairavimo licenziją Kempiniukas gyvena Kriauklių g. 124, Bikini įlanka.
        /*
        Character character5 = new Character(1, "Kempiniukas Plačiakelnis", "Kempinė", "Kriauklių g. 124, Bikini įlanka", "Virėjas", 1000);
        characterDAO.update(character5);
        */

        //1.4 Atspausdinti visus dokumentus esančius kolekcijoje
        //characterDAO.printAll();

        //1.5 Sukurti galimybę surasti ir atspausdinti dokumentus pagal nurodytą personažo vardą
        //System.out.println(CharacterDAO.searchByName("Ponas Krabas"));

        //1.6 Surasti ir atspausdinti tuos dokumentus, kuriuose personažų atlyginimas (jūros kriauklėmis) yra mažesnis už vartotojo ranka įvestą.
        //characterDAO.printLowerSalary(1000);

        //1.7 Ištrinti visus dokumentus, kurių id lygus arba didesnis už 4.
        /*
        int i = 4;
        while (i < 54){
            characterDAO.delete(i);
            i++;
        }
         */

        //1.8 Pašalinti iš kolekcijos visus likusius dokumentus.
        //characterDAO.deleteWhatsLeft();
    }
}
