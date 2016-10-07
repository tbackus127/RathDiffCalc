
package com.rath.beatmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MapParser {

  // In order
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
    
    // Put values in a map
    HashMap<String, String> parseMap = new HashMap<String, String>();
    for (int i = 0; i < labelList.length; i++) {
      if(fscan.hasNextLine()) {
        String line = fscan.nextLine();
        if(line.startsWith(labelList[i])) {
          String dataValue = line.split(":", 2)[1];
          parseMap.put(labelList[i], dataValue.trim());
        }
      }
    }
    
    // Create beatmap object
    final String title = parseMap.get(labelList[1]);
    final String artist = parseMap.get(labelList[2]);
    final String creator = parseMap.get(labelList[3]);
    final String diffName = parseMap.get(labelList[4]);
    final String source = parseMap.get(labelList[5]);
    final double hpDrain = Double.parseDouble(parseMap.get(labelList[6]));
    final double circleSize = Double.parseDouble(parseMap.get(labelList[7]));
    final double accuracy = Double.parseDouble(parseMap.get(labelList[8]));
    final double approachRate = Double.parseDouble(parseMap.get(labelList[9]));
    final ArrayList<TimingPoint> timingPoints = parseTimingPoints();
    final ArrayList<HitObject> hitObjects = parseHitObjects();
    final double stackLeniency = Double.parseDouble(parseMap.get(labelList[0]));
    final double sliderSpeedMult = Double.parseDouble(parseMap.get(labelList[10]));
    final int sliderTickRate = Integer.parseInt(parseMap.get(labelList[11]));

    
    return null;
  }
}
