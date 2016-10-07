
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

  private static final HashMap<String, HitObjectType> typeMap = new HashMap<String, HitObjectType>();

  public static Beatmap parse(File osuFile) throws FileNotFoundException {

    if (typeMap.isEmpty()) {
      buildTypeMap();
    }

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
      System.err.println(osuFile.getAbsolutePath());
      throw new FileNotFoundException("Beatmap file does not exist!");
    }
    return null;
  }

  private static Beatmap parse(Scanner fscan) {

    System.out.println("Parsing");

    // Put values in a map
    HashMap<String, String> parseMap = new HashMap<String, String>();
    for (int i = 0; i < labelList.length; i++) {
//      System.out.println(" Searching for label \"" + labelList[i] + "\"");
      while (fscan.hasNextLine()) {
        String line = fscan.nextLine();
//        System.out.println("   Found next line: \"" + line + "\"");
        if (line.startsWith(labelList[i])) {
//          System.out.println("  Found label: " + labelList[i]);
          String dataValue = line.split(":", 2)[1];
          parseMap.put(labelList[i], dataValue.trim());
          break;
        }
      }
    }

    // Create beatmap object
    final String title = parseMap.get(labelList[1]);
    final String artist = parseMap.get(labelList[2]);
    final String creator = parseMap.get(labelList[3]);
    final String diffName = parseMap.get(labelList[4]);
    final String source = parseMap.get(labelList[5]);

    // for (String s : parseMap.keySet()) {
    // System.out.println(s + " -> " + parseMap.get(s));
    // }

    final double hpDrain = Double.parseDouble(parseMap.get(labelList[6]));
    final double circleSize = Double.parseDouble(parseMap.get(labelList[7]));
    final double accuracy = Double.parseDouble(parseMap.get(labelList[8]));
    final double approachRate = Double.parseDouble(parseMap.get(labelList[9]));
    final ArrayList<TimingPoint> timingPoints = parseTimingPoints(fscan);
    final ArrayList<HitObject> hitObjects = parseHitObjects(fscan);
    final double stackLeniency = Double.parseDouble(parseMap.get(labelList[0]));
    final double sliderSpeedMult = Double.parseDouble(parseMap
        .get(labelList[10]));
    final int sliderTickRate = Integer.parseInt(parseMap.get(labelList[11]));

    return new Beatmap(title, artist, creator, diffName, source, hpDrain,
        circleSize, accuracy, approachRate, timingPoints, hitObjects,
        stackLeniency, sliderSpeedMult, sliderTickRate);
  }

  private static ArrayList<TimingPoint> parseTimingPoints(Scanner fscan) {
    ArrayList<TimingPoint> result = new ArrayList<TimingPoint>();

    // Get the read position to the line after "[TimingPoints]"
    while (fscan.hasNextLine()
        && !fscan.nextLine().startsWith("[TimingPoints]")) {}

    // Get the timing points
    while (fscan.hasNextLine()) {
      String line = fscan.nextLine();

      // If it's a timing point line, stop parsing
      if (line.length() < 15) break;

      // Split into 8 strings delimited by commas
      String[] tpData = line.split(",");

      // There should be 8 values in each TimingPoint
      if (tpData.length != 8) {
        System.err.println("Wrong number of timing points in .osu file!");
        break;
      }

      final int offset = Integer.parseInt(tpData[0]);
      final double msPerBeat = Double.parseDouble(tpData[1]);
      final boolean inherited = Boolean.parseBoolean(tpData[6]);
      result.add(new TimingPoint(offset, msPerBeat, inherited));
    }

    return result;
  }

  private static ArrayList<HitObject> parseHitObjects(Scanner fscan) {
    ArrayList<HitObject> result = new ArrayList<HitObject>();

    // Get the read position to the line after "[HitObjects]"
    while (fscan.hasNextLine() && !fscan.nextLine().startsWith("[HitObjects]")) {}

    while (fscan.hasNextLine()) {
      String line = fscan.nextLine();

      if (line.length() < 10) break;

      // There's probably a better regex for this...
      String[] objData = line.split(",");

      final int objX = Integer.parseInt(objData[0]);
      final int objY = Integer.parseInt(objData[1]);
      final Coord objPos = new Coord(objX, objY);
      final int time = Integer.parseInt(objData[2]);

      // Check what HitObject we're dealing with
      switch (typeMap.get(objData[3])) {
        case SLIDER:
          ArrayList<SliderPoint> sliderPoints = new ArrayList<SliderPoint>();
          String[] spString = objData[5].split("\\|");

          // Slider curve type
          SliderType type = Slider.getType(spString[0]);

          // Pack up slider points
          for (int i = 1; i < spString.length; i++) {
            final String[] curvePosArr = spString[i].split(":");
            final int curveX = Integer.parseInt(curvePosArr[0]);
            final int curveY = Integer.parseInt(curvePosArr[1]);

            boolean isStraight = false;

            // Detect straight slider points
            if (i < spString.length - 1 && spString[i + 1].equals(spString[i])) {
              isStraight = true;
            }

            sliderPoints.add(new SliderPoint(curveX, curveY, isStraight));
          }
          result.add(new Slider(objPos, time, type, sliderPoints));
        break;
        case SPINNER:
          final int endTime = Integer.parseInt(objData[5]);
          result.add(new Spinner(time, endTime));
        break;
        default:
          result.add(new HitCircle(objPos, time));
      }

    }

    return result;
  }

  private static void buildTypeMap() {
    // System.err.println("Built type map.");
    typeMap.put("1", HitObjectType.HIT_CIRCLE);
    typeMap.put("2", HitObjectType.SLIDER);
    typeMap.put("5", HitObjectType.HIT_CIRCLE);
    typeMap.put("6", HitObjectType.SLIDER);
    typeMap.put("8", HitObjectType.SPINNER);
    typeMap.put("12", HitObjectType.SPINNER);
  }
}
