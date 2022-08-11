package tondeuse.objet;

/**
 * @author CISSE Abdoulaye 2022-08-09
 */
public enum Instruction {
  G, D, A;

  public static Instruction getCommandeFromCode(String code) {
    for (Instruction instruction : Instruction.values()) {
      if (instruction.name().equals(code)) {
        return instruction;
      }
    }
    throw new IllegalArgumentException("L'intruction est incorrecte");
  }

}
