package Application;

import Entites.Calculs;
import Entites.Dialogue;
import Entites.SaisieErroneeException;

public class Main {
    public static void main(String[] args) throws SaisieErroneeException {
        do {
            Dialogue.dialogue();
            Calculs.bissextile();
        } while (Dialogue.encore() == 0);
    }
}
