package tondeuse.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cette classe permet de recuperer les lignes d'un fichier donné.
 *
 * @author CISSE Abdoulaye 2022-08-11
 */
public class ConvertisseurFichier {

  public static List<String> recuperLignes(String urlFichier) {
    List<String> fileLine = new ArrayList<>();
    try {
      File file = new File(urlFichier);
      Scanner scanner = new Scanner(file);
      fileLine = new ArrayList<>();
      while (scanner.hasNext()) {
        String line = scanner.nextLine();
        fileLine.add(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return fileLine;
  }
}
