package controller;

import model.Boot;
import model.Klant;
import model.MotorBoot;
import model.ZeilBoot;

public class BootVerhuurLauncher {
    public static void main(String[] args) {

        //test klasse klant toString
        Klant testKlant = new Klant("Jan de Boer");
        System.out.println(testKlant);

        //test abstracte klasse boot en interface vrijverhuurbaar
        Boot testBoot = new Boot("De Engel", 1) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        System.out.println(testBoot);

        //test klasse moterboot
        MotorBoot testMotorboot = new MotorBoot("De Engel", 8, 6);
        System.out.println(testMotorboot);
        MotorBoot motorBoot1 = new MotorBoot("De Engel2", -3, 15);
        System.out.println(motorBoot1);

        //test klasse zeilboot
        ZeilBoot testZeilboot = new ZeilBoot("Valk", 10);
        System.out.println(testZeilboot);



    }
}
