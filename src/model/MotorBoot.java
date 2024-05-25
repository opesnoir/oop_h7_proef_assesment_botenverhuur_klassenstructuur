package model;

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

/*oude versie van schrijven, gebruik de versie met stringbuilder, omdat je hier meerdere zinnen samenvoegt
    @Override
    public String toString() {
        return super.toString().replace("Boot", "Motorboot") +
                String.format("\tVaarbewijs vereist: %b\n\tHuurprijs: %.2f\n", this.isVaarbewijsPlichtig()? "Ja" : "Nee", this.berekenHuurprijs());
    }*/

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString().replace("Boot", "Motorboot"));
        stringBuilder.append(String.format("\tVaarbewijs vereist: %s\n", this.isVaarbewijsPlichtig() ? "Ja" : "Nee"));
        stringBuilder.append(String.format("\tHuurprijs: %.2f\n", this.berekenHuurprijs()));
        return stringBuilder.toString();
    }


}
