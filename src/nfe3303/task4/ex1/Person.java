package nfe3303.task4.ex1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by N on 4/10/14.
 */
public class Person {

    //Vor- und Nachname, Geschlecht, Geburtsdatum, Partner falls vorhanden und bei einer Scheidung der Scheidungsgrund
    private String fname = "";
    private String lname = "";
    private gender gender = null;
    private String birthdate = "";
    private Person partner = null;
    private String divorceReason = "";

    /**
     *
     * @param fname Vorname
     * @param lname Nachname
     * @param gender Geschlecht
     * @param birthdate Geburtsdatum
     */
    public Person(String fname, String lname, gender gender, String birthdate){
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    // verheiraten von einer Person. Bei beiden PersonObjekte Partner eintragen

    /**
     *
     * @param person Die Person mit der verheiratet wird.
     */
    public void marry(Person person){

        if(checkAge(this) && checkAge(person) && checkGender(person)){
            setPartner(person);
            person.setPartner(this);
        }
    }
    //Scheidung mit einem Grund. Von beiden den Partner austragen

    /**
     *
     * @param reason Der Grund warum es zu der Scheidung kommt
     */
    public void divorce(String reason){
        if(partner != null){
            setDivorceReason(reason);
            partner.setPartner(null);
            partner = null;
        }
        else{
            System.out.println("Die Person ist nicht verheiratet!");
        }
    }

    //Alter überprüfen mithilfe dem aktuellen Datum dass bei der Heirat ist. Alter wird nur auf Jahre genau beachtet nicht
    //Tage genau
    private boolean checkAge(Person person){

        //aktuelles Datum
        GregorianCalendar now = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String actualDate = dateFormat.format(now.getTime());
        //String aufsplitten nach . und " " damit die Jahreszahlen verglichen werdne können
        String[] pbirthdate = person.getBirthdate().split("\\.");
        String[] secondDate = actualDate.split("\\.");
        if(Integer.parseInt(secondDate[2]) -  Integer.parseInt(pbirthdate[2]) > 18){
            return true;
        }
        else if(Integer.parseInt(secondDate[2]) - Integer.parseInt(pbirthdate[2]) == 18 &&
                Integer.parseInt(pbirthdate[1]) < Integer.parseInt(secondDate[1])){
                return true;
        }
        else if(Integer.parseInt(pbirthdate[1]) == Integer.parseInt(secondDate[1]) &&
                Integer.parseInt(pbirthdate[0]) <= Integer.parseInt(secondDate[0])){

                return true;
        }

        else{
            System.out.println("Teilnehmer zu jung!");
        }
        return false;
    }
    //Da in Österreich gleichgeschlechtliche Ehe erlaubt ist muss das abgeprüft werden
    private boolean checkGender(Person person){
        if(getGender() != person.getGender()){
            return true;
        }
        else {
            System.out.println("Gleichgeschlechtliche Ehe ist nicht erlaubt!");
        }
        return false;
    }

    @Override
    public String toString() {
        String temp = "";
        if(partner != null){
            temp = partner.getFname();
        }
        return "Person{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", gender=" + gender +
                ", partner ='" + temp + '\''+
                ", birthdate='" + birthdate + '\'' +
                '}';
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public gender getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public void setDivorceReason(String reason){
        divorceReason = reason;
    }
}
