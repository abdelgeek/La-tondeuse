package tondeuse.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tondeuse.domaine.Instruction;
import tondeuse.domaine.Orientation;
import tondeuse.domaine.Tondeuse;

/**
 * Cette classe permet de recuperer une tondeuse presente dans le fichier
 *
 * @author CISSE Abdoulaye 2022-08-10
 */
public class TondeuseUtilitaire {

  public static List<Tondeuse> recupererTondeuses(Iterator<String> ligneIterator) {

    List<Tondeuse> tondeuses = new ArrayList<>();
    while (ligneIterator.hasNext()) {
      String ligneTondeuse = ligneIterator.next();
      Tondeuse tondeuse = TondeuseUtilitaire.recupererTondeuse(ligneTondeuse);

      String ligneCommande = ligneIterator.next();
      List<Instruction> instructions = TondeuseUtilitaire.recupererInstruction(ligneCommande);
      tondeuse.setInstructions(instructions);

      tondeuses.add(tondeuse);
    }
    return tondeuses;
  }

  private static List<Instruction> recupererInstruction(String line) {
    List<Instruction> instructions = new ArrayList<>();
    char[] listeInstructions = line.toCharArray();
    for (char code : listeInstructions) {
      instructions.add(Instruction.getCommandeFromCode(String.valueOf(code)));
    }
    return instructions;
  }

  private static Tondeuse recupererTondeuse(String line) {
    String[] positionInitiale = line.split(" ");
    int x = Integer.parseInt(positionInitiale[0]);
    int y = Integer.parseInt(positionInitiale[1]);
    Orientation orientation = Orientation.obtenirParCode(positionInitiale[2]);
    return new Tondeuse(x, y, orientation);
  }

}
