package model;

//Naam, studentennummer en doel van de klasse
/*Naam:   M.C.
Studentennummer: 500241293
Doel: Een Motorboot-klasse aanmaken, die de interface VrijVerhuurbaar implementeerd, waarin enkele attributen worden opgeslagen. Er is gekozen om diverse final (en static) attributen aan te maken om magic numbers te voorkomen. Verder wordt de methode getLengte uit de Boot-klasse gebruikt om te bepalen of de boot met of zonder vaarbewijs gehuurd mag worden en om de huurprijs te bepalen. Daarnaast is ervoor gekozen om String te gebruiken, omdat ik dat als leesbaarder ervaar in dit geval, vooral omdat er niets gesorteerd hoeft te worden. Ook wordt het woord 'boot' vervangen door 'motorboot'.

Als ik StringBuilder had gebruikt dan had ik het als volgt gedaan:
@Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString().replace("Boot", "Motorboot"));
        stringBuilder.append(String.format("\tVaarbewijs vereist: %s\n", this.isVaarbewijsPlichtig() ? "Ja" : "Nee"));
        stringBuilder.append(String.format("\tHuurprijs: %.2f\n", this.berekenHuurprijs()));
        return stringBuilder.toString();
    }*/

public class MotorBoot extends Boot implements VrijVerhuurbaar {
    //attribuut
    private int maxSnelheid;
    private final static int DEFAULT_MIN_GRENS_MOTORBOOTLENGTE_VAARBEWIJS_VERPLICHT = 15;
    private final static int DEFAULT_MIN_GRENS_MOTORBOOTSNELHEID_VAARBEWIJS_VERPLICHT = 20;
    private final static int DEFAULT_MIN_GRENS_MOTORBOOTLENGTE_MIN_HUURBEDRAG = 10;
    private final static double DEFAULT_MIN_BEDRAG_MOTORBOOTVERHUUR = 60.00;
    private final static double DEFAULT_MAX_BEDRAG_MOTORBOOTVERHUUR = 90.00;


    //constructor
    protected MotorBoot(String naam, int lengte, int snelheid) {
        super(naam, lengte);
        this.maxSnelheid = snelheid;
    }

    //methoden
    @Override
    public boolean isVaarbewijsPlichtig() {
        return super.getLengte() > DEFAULT_MIN_GRENS_MOTORBOOTLENGTE_VAARBEWIJS_VERPLICHT || this.maxSnelheid > DEFAULT_MIN_GRENS_MOTORBOOTSNELHEID_VAARBEWIJS_VERPLICHT;
    }

    @Override
    public double berekenHuurprijs() {
        if (super.getLengte() < DEFAULT_MIN_GRENS_MOTORBOOTLENGTE_MIN_HUURBEDRAG) {
            return DEFAULT_MIN_BEDRAG_MOTORBOOTVERHUUR;
        } else {
            return DEFAULT_MAX_BEDRAG_MOTORBOOTVERHUUR;
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("Boot", "Motorboot") + String.format("\tVaarbewijs vereist: %s\n", this.isVaarbewijsPlichtig() ? "Ja" : "Nee") +
                String.format("\tHuurprijs: %.2f\n", this.berekenHuurprijs());
    }


}
