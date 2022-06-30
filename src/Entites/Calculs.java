package Entites;

import javax.swing.JOptionPane;

public class Calculs {

    private Calculs() {
    }

    public static void bissextile() {
        int test1 = Dialogue.getAnnee() % 4;
        int test2 = Dialogue.getAnnee() % 100;
        int test3 = Dialogue.getAnnee() % 400;
        final int[] bissextile = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final int[] nonBissextile = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String message;
        final String dateExiste = "La date existe ! \n L'année est bissextile";
        final String dateNExistePas = "La date n'existe pas \n L'année n'est pas bissextile";

        if ((test1 == 0 && test2 != 0) || (test3 == 0)) {
            if (Dialogue.getJour() > bissextile[Dialogue.getMois() - 1]) {
                message = dateNExistePas;
            } else {
                message = dateExiste;
            }
        } else {
            if (Dialogue.getJour() > nonBissextile[Dialogue.getMois() - 1]) {
                message = dateNExistePas;
            } else {
                message = dateExiste;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                message,
                "Réponse",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
