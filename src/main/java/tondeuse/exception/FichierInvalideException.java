package tondeuse.exception;

/**
 * Exception qui se lance quand un fichier est invalide
 *
 * @author CISSE Abdoulaye 2022-08-10
 */
public class FichierInvalideException extends RuntimeException {

  public FichierInvalideException(String message) {
    super(message);
  }
}
