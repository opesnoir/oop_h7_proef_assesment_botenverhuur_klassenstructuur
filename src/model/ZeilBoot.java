package model;


//Naam, studentennummer en doel van de klasse
/*Naam:   M.C.
Studentennummer: 500241293
Doel: Zeilboot-klassen (children) extends boot; Zeilboot 'is-a' Boot. De constructor is tevens afkomstig van de super Boot. Hij heeft geen attributen, checked of er een vaarbewijs vereist is op basis van zijn vereiste. en geeft een tostring nodig met info.*/

public class ZeilBoot extends Boot {
    //attributen (om magic numbers te voorkomen)
    private final static int DEFAULT_MIN_GRENS_ZEILBOOTLENGTE_VAARBEWIJS_VERPLICHT = 15;
    private final static int DEFAULT_MIN_GRENS_ZEILBOOTLENGTE_MIN_HUURBEDRAG = 7;
    private final static double DEFAULT_MIN_BEDRAG_ZEILBOOTVERHUUR = 40.00;
    private final static double DEFAULT_MAX_BEDRAG_ZEILBOOTVERHUUR = 70.00;

    //constructor
    public ZeilBoot(String naam, int lengte) {
        super(naam, lengte);
    }

    //methoden
    @Override
    public boolean isVaarbewijsPlichtig() {
        return super.getLengte() > DEFAULT_MIN_GRENS_ZEILBOOTLENGTE_VAARBEWIJS_VERPLICHT;
    }

    public double berekenHuurprijs() {
        if (super.getLengte() < DEFAULT_MIN_GRENS_ZEILBOOTLENGTE_MIN_HUURBEDRAG) {
            return DEFAULT_MIN_BEDRAG_ZEILBOOTVERHUUR;
        } else {
            return DEFAULT_MAX_BEDRAG_ZEILBOOTVERHUUR;
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("Boot", "Zeilboot") + String.format("\tVaarbewijs vereist: %s\n", this.isVaarbewijsPlichtig() ? "Ja" : "Nee") +
                String.format("\tHuurprijs: %.2f euro\n", this.berekenHuurprijs());
    }

}
