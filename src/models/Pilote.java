package models;

import java.text.DecimalFormat;

public class Pilote {

    public static final int NOMBRE_PNEUS_EN_RESERVE = 16;

    private final String nom;
    private final String nationalite;
    private int nombrePoints;
    private int nombreCourses;
    private int nombreVictoires;
    private int nombrePodiums;
    private Pneu[] pneusEnReserve;
    private final Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        this.voiture = null;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        this.voiture = voiture;
    }

    public boolean deposerPneuEnReserve(Pneu pneu) {
        boolean placeDisponible = false;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                pneusEnReserve[i] = pneu;
                placeDisponible = true;
                break;
            }
        }

        return placeDisponible;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        Pneu retirer = null;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i].getType() == type) {
                retirer = pneusEnReserve[i];
                pneusEnReserve[i] = null;
                break;
            }
        }

        return retirer;
    }

    public int compterNombrePneusEnReserveDeType(TypePneu type) {
        int nbrPneusDeCeType = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                if (pneusEnReserve[i].getType() == type) {
                    nbrPneusDeCeType++;
                }
            }

        }

        return nbrPneusDeCeType;
    }

    public int getNombrePneusEnReserve() {
        int nbrPneusEnReserve = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                nbrPneusEnReserve++;
            }
        }

        return nbrPneusEnReserve;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        Pneu[] listeSansTrous = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        int j = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                listeSansTrous[j++] = pneusEnReserve[i];
            }
        }

        return listeSansTrous;
    }

    public String permissionMoyenneDesPneusEnReserveFormatee() {
        DecimalFormat format = new DecimalFormat("0.00"); // "#'##0.00"
        String pressionMoyenne = "";
        double pression = 0;
        double resultat = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                pression += pneusEnReserve[i].getPression();
            }

        }

        if (pression != 0) {
            resultat = (pression / getNombrePneusEnReserve());
        }

        pressionMoyenne += format.format(resultat);

        return pressionMoyenne;
    }

    public int supprimerPneusDePressionInferieure(double pression) {
        int nbrPneusSupprimer = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                if (pneusEnReserve[i].getPression() < pression) {
                    pneusEnReserve[i] = null;
                    nbrPneusSupprimer++;
                }
            }
        }

        return nbrPneusSupprimer;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        Pneu[] pneusSansTrous = new Pneu[pneus.length];
        boolean ajoutReussi = false;
        int j = 0;
        int k = 0;

        for (int i = 0; i < pneusSansTrous.length; i++) {
            if (pneus[i] != null) {
                pneusSansTrous[j++] = pneus[i];
            }
        }


        if (pneusSansTrous.length <= (NOMBRE_PNEUS_EN_RESERVE - getNombrePneusEnReserve())) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] == null) {
                    if (pneus.length > k) {
                        pneusEnReserve[i] = pneus[k++];
                    } else {
                        break;
                    }
                }
            }
            ajoutReussi = true;
        }

        return ajoutReussi;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public int getNombreCourses() {
        return nombreCourses;
    }

    public void setNombreCourses(int nombreCourses) {
        this.nombreCourses = nombreCourses;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    @Override
    public String toString() {
        String resultat = "Pilote: " + nom + " (" + nationalite + ")\n";

        if (voiture != null) {
            resultat += "-> Voiture: " + voiture.getNomEquipe() + " (" + voiture.getNumero() + ")\n";
            resultat += "-> Points: " + nombrePoints + "\n";
            resultat += "-> Courses: " + nombreCourses + "\n";
            resultat += "-> Victoires: " + nombreVictoires + "\n";
            resultat += "-> Podiums: " + nombrePodiums + "\n";

        } else {
            resultat += "-> Pas de voiture assignée.\n";
        }

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                resultat += "-> Pneu en réserve: " + pneusEnReserve[i].getType() + "\n";
            }
        }

        return resultat;
    }
}
