package tondeuse.utils;

import java.util.Iterator;
import tondeuse.domaine.LimitePelouse;

/**
 * Cette classe permet de recuperer les limites de la pelouses
 *
 * @author CISSE Abdoulaye 2022-08-11
 */
public class LimitePelouseUtilitaire {

  public static LimitePelouse recupererLimitePelouse(Iterator<String> lignes) {
    String ligne = lignes.next();
    String[] positionInitiale = ligne.split(" ");
    int x = Integer.parseInt(positionInitiale[0]);
    int y = Integer.parseInt(positionInitiale[1]);

    return new LimitePelouse(x, y);
  }
}
