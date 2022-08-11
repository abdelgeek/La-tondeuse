package tondeuse.domaine;

import java.util.List;

/**
 * Cette classe represente une tondeuse
 *
 * @author CISSE Abdoulaye 2022-08-09
 */
public class Tondeuse {

  private int x;
  private int y;
  private Orientation orientation;
  private List<Instruction> instructions;

  public Tondeuse(int x, int y, Orientation orientation) {
    this.x = x;
    this.y = y;
    this.orientation = orientation;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
  }

  public List<Instruction> getInstructions() {
    return instructions;
  }

  public void setInstructions(List<Instruction> instructions) {
    this.instructions = instructions;
  }

  public void piloter(LimitePelouse limitePelouse) {
    for (Instruction instruction : instructions) {
      executerInstruction(instruction, limitePelouse);
    }
  }

  private void executerInstruction(Instruction instruction, LimitePelouse limitePelouse) {
    switch (instruction) {
      case A:
        avancer(limitePelouse);
        break;
      case D:
        pivoterVersLaDroite();
        break;
      case G:
        pivoterVersLaGauche();
        break;
    }
  }

  private void avancer(LimitePelouse limitePelouse) {

    int limitePelouseX = limitePelouse.getX();
    int limitePelouseY = limitePelouse.getY();
    switch (orientation) {
      case NORD: {
        if (y < limitePelouseY) y += 1;
        break;
      }
      case SOUTH: {
        if (y > 0) y -= 1;
        break;
      }
      case EAST: {
        if (x < limitePelouseX) x += 1;
        break;
      }
      case WEAST: {
        if (x > 0) x -= 1;
        break;
      }
      default:
    }
  }

  private void pivoterVersLaDroite() {
    String orientationDroite = orientation.codeOrientationDroite();
    Orientation nouvelleOrientation = Orientation.obtenirParCode(orientationDroite);
    setOrientation(nouvelleOrientation);
  }

  private void pivoterVersLaGauche() {
    String orientationGauche = orientation.codeOrientationGauche();
    Orientation nouvelleOrientation = Orientation.obtenirParCode(orientationGauche);
    setOrientation(nouvelleOrientation);
  }
}



