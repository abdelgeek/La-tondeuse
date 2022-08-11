package tondeuse;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author CISSE Abdoulaye 2022-08-11
 */
class MainTest {

  @Test
  public void testMain() throws Exception {

    String urlFichier = "/home/inexa-pc/workspace/tondeuse/src/main/resources/tondeuxe.txt";
    Main.main(new String[] {urlFichier});
  }
}
