package tondeuse;

import tondeuse.service.TondeuseService;

/**
 * @author CISSE Abdoulaye 2022-08-10
 */
public class Main {

  public static void main(String[] args) throws Exception {

    verifierArguments(args);
    String urlFichier = args[0];
    TondeuseService tondeuseService = new TondeuseService(urlFichier);
    tondeuseService.piloterTondeuse();
  }


  private static void verifierArguments(String[] args) throws Exception {
    if (args == null || args.length == 0) {
      throw new Exception("Le fichier manque");
    }
  }
}
