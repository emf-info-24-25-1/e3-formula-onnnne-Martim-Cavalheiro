package app;

import models.Pilote;
import models.Pneu;
import models.TypePneu;
import models.Voiture;

public class Application {

    public static void main(String[] args) {
        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------
        Voiture ferrari = new Voiture(16, "Ferrari");

        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------
        System.out.println(ferrari.toString());

        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------
        Pilote charles = new Pilote("Charles Leclerc", "Monégasque", ferrari);
        charles.setNombreCourses(16);
        charles.setNombrePoints(65);
        charles.setNombreVictoires(3);
        charles.setNombrePodiums(7);

        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------
        System.out.println(charles.toString());

        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        Pneu n1 = new Pneu(TypePneu.DUR_BLANC, 1.5);
        Pneu n2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu n3 = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);
        Pneu n4 = new Pneu(TypePneu.DUR_BLANC, 1.6);
        Pneu n5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);

        // deposerPneuEnReserve() 5 fois de types différents
        charles.deposerPneuEnReserve(n1);
        charles.deposerPneuEnReserve(n2);
        charles.deposerPneuEnReserve(n3);
        charles.deposerPneuEnReserve(n4);
        charles.deposerPneuEnReserve(n5);

        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        System.out.print("Le pneu " + TypePneu.TENDRE_ROUGE + " qui a été retiré : ");
        System.out.println(charles.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE));
        

        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        System.out.print("Nombre de pneus en réserve : ");
        System.out.println(charles.getNombrePneusEnReserve());

        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        System.out.println("Pneus en réserve sans trous :");
        for (int i = 0; i < charles.getPneusEnReserveSansTrous().length; i++) {

            if (charles.getPneusEnReserveSansTrous()[i] != null) {
                System.out.print("- " + charles.getPneusEnReserveSansTrous()[i].getType());
                System.out.println(" avec pression " + charles.getPneusEnReserveSansTrous()[i].getPression());
            }
        }

        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne
        // des pneus
        System.out.print("Pression moyenne des pneus en réserve : "); 
        System.out.println(charles.permissionMoyenneDesPneusEnReserveFormatee());

        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        System.out.print("Nombre de pneus en réserve de type " + TypePneu.DUR_BLANC + " : ");
        System.out.println(charles.compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC));

        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué
        Pneu[] pneus = new Pneu[3];
        pneus[0] = new Pneu(TypePneu.DUR_BLANC, 1.3);
        pneus[1] = new Pneu(TypePneu.DUR_BLANC, 1.2);
        pneus[2] = new Pneu(TypePneu.DUR_BLANC, 1.1);

        if (charles.ajouterLotDePneus(pneus)) {
            System.out.println("Ajout du lot de pneus réusi :-)");
        } else {
            System.out.println("Ajout du lot de pneus pas réusi :-()");
        }

        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        System.out.print("Nombre de pneus supprimés de pression inférieur à 1.4 : ");
        System.out.println(charles.supprimerPneusDePressionInferieure(1.4));

        // ---------------------------------------------------------------------------------------

    }

}
