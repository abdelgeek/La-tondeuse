package tondeuse.service;

import java.util.Iterator;
import java.util.List;
import tondeuse.exception.FichierInvalideException;
import tondeuse.domaine.LimitePelouse;
import tondeuse.domaine.Tondeuse;
import tondeuse.utils.ConvertisseurFichier;
import tondeuse.utils.LimitePelouseUtilitaire;
import tondeuse.utils.TondeuseUtilitaire;

/**
 * Cette classe permet de piloter des tondeuses
 * @author CISSE Abdoulaye 2022-08-11
 */
public class TondeuseService {

  private final String urlFichier;

  public TondeuseService(String urlFichier) {
    this.urlFichier = urlFichier;
  }

  public void piloterTondeuse() {
    List<String> lignes = ConvertisseurFichier.recuperLignes(urlFichier);
    verifierLignes(lignes);
    Iterator<String> ligneIterator = lignes.iterator();
    LimitePelouse limitePelouse = LimitePelouseUtilitaire.recupererLimitePelouse(ligneIterator);
    List<Tondeuse> tondeuses = TondeuseUtilitaire.recupererTondeuses(ligneIterator);

    System.out.println("position finale des tondeuses:");
    for (Tondeuse tondeuse : tondeuses) {
      tondeuse.piloter(limitePelouse);
      System.out.println(String.format("%d %d %s", tondeuse.getX(), tondeuse.getY(),
          tondeuse.getOrientation().getCode()));
    }
  }

  public void verifierLignes(List<String> lignes) {
    int taille = lignes.size();
    if (taille % 2 == 0) {
      throw new FichierInvalideException("Le nombre de ligne du fichier est incorrect");
    }
  }

}
