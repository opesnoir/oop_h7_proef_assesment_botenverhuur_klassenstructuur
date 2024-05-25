package model;

//Naam, studentennummer en doel van de klasse
/*Naam:   M.C.
Studentennummer: 500241293
Doel: De abstracte Boot-klasse implementeert Comparable en Vrijverhuurbaar. Comparable wordt later gebruikt om te sorteren. Deze klasse is tevens de hoofklasse (parent) van de Motorboot- en Zeilboot-klassen (children); zij hebben een 'is-a' relatie met Boot. De constructor van Boot is protected. Het statische attribuut lastId betreft een klasse-attribuut.

De methode setLengte(lengte) test eerst of de lengte voldoet aan de minimum eisen alvorens deze toe te wijzen (al dan niet als minimum standaardlengte). Er is voor gekozen om twee default waarden final te maken om magic numbers te voorkomen.*/

// implementeer interfaces Comparable en VrijVerhuurbaar
public abstract class Boot implements Comparable<Boot>, VrijVerhuurbaar {
    //attributen
    private static int lastId = 0;
    private int id;
    private String naam;
    private int lengte;
    private final int DEFAULT_MIN_BOOT_LENGTE = 0; // toegevoegd om magic numbers te voorkomen
    private final int DEFAULT_BOOT_LENGTE = 5; // toegevoegd om magic numbert te voorkomen


    //constructor
    protected Boot(String naam, int lengte) {
        this.naam = naam;
        setLengte(lengte); // setter test eerst of lengte voldoet aan minimum eis alvorens hem toe te wijzen (al dan niet als min default lengte)
        this.id = ++lastId; // id wordt dynamisch toegewezen, eerst wordt het statische attribuut (lastId) opgehoogd met 1 en de nieuwe waarde wordt toegewezen aan het attribuut id
    }

    //methoden
    public double berekenHuurprijs() {
        return 0;
    }

    public int setLengte(int lengte) {
        if (lengte < DEFAULT_MIN_BOOT_LENGTE) {
            System.out.printf("De bootlengte mag niet negatief, de bootlengte wordt daarom automatisch ingesteld op %d", DEFAULT_BOOT_LENGTE);
            return DEFAULT_BOOT_LENGTE;
        } else {
            return this.lengte = lengte;
        }
    }

    @Override
    public int compareTo(Boot andereBoot) {
        return this.naam.compareTo(andereBoot.naam);
    }

    @Override
    public boolean isVaarbewijsPlichtig() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Boot %d met de naam %s\n", this.id, this.naam); //this ervoor omdat het deze instantie betreft, deze is zonder stringbuilder [je sorteert hier niks en je hebt hier ook niet meerdere zinnen die je aan elkaar wil plakken]
    }

    //getter(s)
    public int getLengte() {
        return lengte;
    }

}
