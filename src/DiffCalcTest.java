import java.io.File;

import com.rath.diffcalc.DiffCalc;

public class DiffCalcTest {

  public static void main(String[] args) {
    System.out.println("Running...");

    File testMapDir = new File("MapFiles/");

    File[] mapFiles = testMapDir.listFiles();

    for (int i = 0; i < mapFiles.length; i++) {
      DiffCalc dc = new DiffCalc(testMapDir.getName() + "/"
          + mapFiles[i].getName());
      System.out.println(dc + "\n  Aim.SPD = "
          + dc.getDiff().getAimDifficulty().getSpeed());
    }
  }
}
