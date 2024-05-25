package model;

//Naam, studentennummer en doel van de klasse
/*Naam:   M.C.
Studentennummer: 500241293
Doel: Een klantmodel aanmaken waarin enkele attributen worden opgeslagen, waaronder een boolean die van belang is om elders te bepalen of een boot gehuurd mag worden. Het verhuurmodel heeft een unidirectionele relatie met de klant. Verhuur bevat één klant; verhuur is op de hoogte van de klant, maar de klant weet niets van de verhuur.*/

public class Klant {
    //attributen
    private String naam;
    private String email;
    private boolean vaarVaardig;

    //constructor met constructor chaining
    public Klant() {
        this("naam");
    }

    public Klant(String naam) {
        this(naam, "onbekend", false);
    }

    public Klant(String naam, String email, boolean vaarVaardig) {
        this.naam = naam;
        this.email = email;
        this.vaarVaardig = vaarVaardig;
    }

    @Override
    public String toString() {
        return String.format("Klant %s", this.naam);
    }
}
