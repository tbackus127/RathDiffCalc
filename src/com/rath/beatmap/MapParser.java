
package com.rath.beatmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MapParser {

  private static final String[] labelList = { "StackLeniency", "Title",
      "Artist", "Creator", "Version", "Source", "HPDrainRate", "CircleSize",
      "OverallDifficulty", "ApproachRate", "SliderMultiplier", "SliderTickRate" };

  public Beatmap parse(File osuFile) throws FileNotFoundException {

    if (osuFile.exists()) {
      Scanner fileScan = null;
      try {
        fileScan = new Scanner(osuFile, "UTF-8");
        return parse(fileScan);
      }
      catch (IOException ioe) {
        ioe.printStackTrace();
      }
      finally {
        fileScan.close();
      }
    } else {
      throw new FileNotFoundException("Beatmap file does not exist!");
    }
    return null;
  }

  private Beatmap parse(Scanner fscan) {
    for (int i = 0; i < labelList.length && fscan.hasNextLine(); i++, fscan
        .nextLine()) {
      String line = fscan.nextLine();
      
    }

    return null;
  }
}
