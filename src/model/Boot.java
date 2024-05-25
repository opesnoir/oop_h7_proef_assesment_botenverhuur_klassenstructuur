package model;

// implementeer interfaces Comparable en VrijVerhuurbaar
public abstract class Boot implements Comparable<Boot>, VrijVerhuurbaar {
    //attributen
    private static int lastId = 0;
    private int id;
    private String naam;
    private int lengte;
    private final int DEFAULT_MIN_BOOT_LENGTE = 0;
    private final int DEFAULT_BOOT_LENGTE = 5;


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
        return String.format("Boot %d met de naam %s", this.id, this.naam); //this ervoor omdat het deze instantie betreft
    }
}
