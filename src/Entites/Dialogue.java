package Entites;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dialogue {

    private static int jour;
    private static int mois;
    private static int annee;

    private Dialogue() {
    }

    public static int getAnnee() {
        return annee;
    }

    public static void setAnnee(int annee) {
        Dialogue.annee = annee;
    }

    public static int getJour() {
        return jour;
    }

    public static void setJour(int jour) {
        Dialogue.jour = jour;
    }

    public static int getMois() {
        return mois;
    }

    public static void setMois(int mois) {
        Dialogue.mois = mois;
    }

    public static void dialogue() throws NumberFormatException, SaisieErroneeException {
        boolean erreurSaisie = true;
        do {
            JTextField jourSaisi = new JTextField();
            JTextField moisSaisi = new JTextField();
            JTextField anneeSaisi = new JTextField();

            JOptionPane.showOptionDialog(
                    null,
                    new Object[]{"Veuillez saisir :\n",
                            "Jour : ", jourSaisi,
                            "Mois : ", moisSaisi,
                            "Année : ", anneeSaisi},
                    "Saisie informations",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null);
            try {
                if (Integer.parseInt(jourSaisi.getText()) > 0 && Integer.parseInt(jourSaisi.getText()) <= 31) {
                    jour = Integer.parseInt(jourSaisi.getText());
                } else {
                    erreurSaisie = false;
                    throw new SaisieErroneeException();
                }
                if (Integer.parseInt(moisSaisi.getText()) > 0 && Integer.parseInt(moisSaisi.getText()) <= 12) {
                    mois = Integer.parseInt(moisSaisi.getText());
                } else {
                    erreurSaisie = false;
                    throw new SaisieErroneeException();
                }
                annee = Integer.parseInt(anneeSaisi.getText());
                erreurSaisie = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Votre saisie n'est pas conforme (nombre entier uniquement).\n Merci de saisir à nouveau.",
                        "Erreur de saisie",
                        JOptionPane.ERROR_MESSAGE);
                dialogue();

            } catch (SaisieErroneeException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Votre saisie n'est pas conforme.\n 0 < jour < 31\n 0 < mois < 12\n Merci de saisir à nouveau.",
                        "Erreur de saisie",
                        JOptionPane.ERROR_MESSAGE);
                dialogue();
            }

        } while (erreurSaisie);
    }

    public static int encore() {
        int encore;
        encore = JOptionPane.showConfirmDialog(
                null,
                "Voulez-vous vérifier une autre date?",
                "Continuer ?",
                JOptionPane.YES_NO_OPTION);
        return encore;
    }
}
