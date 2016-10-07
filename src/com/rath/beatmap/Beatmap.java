
package com.rath.beatmap;

import java.util.ArrayList;

public class Beatmap {

  private final String title;
  private final String artist;
  private final String creator;
  private final String diffName;
  private final String source;

  private final double hpDrain;
  private final double circleSize;
  private final double accuracy;
  private final double approachRate;

  private final ArrayList<TimingPoint> timingPoints;
  private final ArrayList<HitObject> hitObjects;
  private final double stackLeniency;
  private final double sliderSpeedMult;
  private final int sliderTickRate;

  /**
   * 
   * @param title
   * @param artist
   * @param creator
   * @param diffName
   * @param source
   * @param hpDrain
   * @param circleSize
   * @param accuracy
   * @param approachRate
   * @param timingPoints
   * @param hitObjects
   * @param stackLeniency
   * @param sliderSpeedMult
   * @param sliderTickRate
   */
  public Beatmap(String title, String artist, String creator, String diffName,
      String source, double hpDrain, double circleSize, double accuracy,
      double approachRate, ArrayList<TimingPoint> timingPoints,
      ArrayList<HitObject> hitObjects, double stackLeniency,
      double sliderSpeedMult, int sliderTickRate) {
    this.title = title;
    this.artist = artist;
    this.creator = creator;
    this.diffName = diffName;
    this.source = source;
    this.hpDrain = hpDrain;
    this.circleSize = circleSize;
    this.accuracy = accuracy;
    this.approachRate = approachRate;
    this.timingPoints = timingPoints;
    this.hitObjects = hitObjects;
    this.stackLeniency = stackLeniency;
    this.sliderSpeedMult = sliderSpeedMult;
    this.sliderTickRate = sliderTickRate;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getCreator() {
    return creator;
  }

  public String getDiffName() {
    return diffName;
  }

  public String getSource() {
    return source;
  }

  public double getHpDrain() {
    return hpDrain;
  }

  public double getCircleSize() {
    return circleSize;
  }

  public double getAccuracy() {
    return accuracy;
  }

  public double getApproachRate() {
    return approachRate;
  }

  public ArrayList<TimingPoint> getTimingPoints() {
    return timingPoints;
  }

  public ArrayList<HitObject> getHitObjects() {
    return hitObjects;
  }

  public double getStackLeniency() {
    return stackLeniency;
  }

  public double getSliderSpeedMult() {
    return sliderSpeedMult;
  }

  public int getSliderTickRate() {
    return sliderTickRate;
  }

  @Override
  public String toString() {
    String result = "> Beatmap:\n";
    result += metaStr();
    result += paramStr();
    result += objStr();
    return result;
  }

  private String metaStr() {
    return "  -" + this.artist + " - " + this.title + " [" + this.diffName
        + "]" + " // " + this.creator;
  }

  private String paramStr() {
    return "  -CS=" + this.circleSize + " AR=" + this.approachRate + " OD="
        + this.accuracy + " HP=" + this.hpDrain;
  }

  private String objStr() {
    return "  -" + this.hitObjects.size() + " HitObjects @ " + getAverageBPM()
        + "BPM";
  }

  private double getAverageBPM() {
    double total = 0;
    for (TimingPoint tp : this.timingPoints) {
      total += 60000.0D / (double) tp.getMsPerBeat();
    }
    return total / this.timingPoints.size();
  }
}
