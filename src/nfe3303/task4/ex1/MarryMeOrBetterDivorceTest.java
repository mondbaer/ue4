package nfe3303.task4.ex1;


/**
 * Created by N on 4/10/14.
 */
public class MarryMeOrBetterDivorceTest {
    public static void main(String[] args) {
    //Person zu Jung
        Person ted = new Person("Ted","Mosby", gender.MALE,"10.10.2000");
    //Person ok
        Person donald = new Person("Donald","Duck", gender.MALE,"11.4.1996");
        Person daisy = new Person("Daisy","Queen", gender.FEMALE,"2.3.1991");
        Person barney = new Person("Barney","Stinson", gender.MALE,"3.4.1987");
    //Trennung ohne Partner
        System.out.println("Keine Ehe eingetragen:");
        donald.divorce("Streit");
    //WOllen zu Jung heiraten
        System.out.println("Zu junge Leute wollen heiraten:");
        ted.marry(daisy);
    //Alles ok
        System.out.println("OK:");
        donald.marry(daisy);
        System.out.println(donald.toString());
        System.out.println(daisy.toString());
    //Trennung mit Grund
        System.out.println("Trennung:");
        donald.divorce("Streit");
        System.out.println(donald.toString());
    //Gleichgeschlechtlich(nicht zeitgemäß)
        System.out.println("Gleichgeschlechtliche Ehe:");
        donald.marry(barney);
    }
}
