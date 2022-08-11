package tondeuse.domaine;

/**
 * @author CISSE Abdoulaye 2022-08-09
 */
public enum Orientation {
  NORD("N", "W", "E"),
  SOUTH("S", "E", "W"),
  EAST("E", "N", "S"),
  WEAST("W", "S", "N");


  private final String code;
  private final String codeOrientationGauche;
  private final String codeOrientationDroite;

  Orientation(String code, String codeOrientationGauche, String codeOrientationDroite) {
    this.code = code;
    this.codeOrientationGauche = codeOrientationGauche;
    this.codeOrientationDroite = codeOrientationDroite;
  }

  public static Orientation obtenirParCode(String code) {
    for (Orientation orientation : Orientation.values()) {
      if (orientation.getCode().equals(code)) {
        return orientation;
      }
    }
    throw new IllegalArgumentException("L'orientation est incorrecte");
  }

  public String getCode() {
    return code;
  }


  public String codeOrientationGauche() {
    return codeOrientationGauche;
  }

  public String codeOrientationDroite() {
    return codeOrientationDroite;
  }

}
