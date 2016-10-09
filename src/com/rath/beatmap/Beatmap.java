
package com.rath.beatmap;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class handles all of a beatmap's metadata, objects, and settings.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *         
 */
public class Beatmap implements Iterable<HitObject> {
  
  /** The non-Unicode title of the beatmap. */
  private final String title;
  
  /** The song's artist. */
  private final String artist;
  
  /** The creator of the beatmap. */
  private final String creator;
  
  /** The name of the difficulty. */
  private final String diffName;
  
  /** What source material the song originates from. */
  private final String source;
  
  /** The HP Drain of a beatmap. */
  private final double hpDrain;
  
  /** The circle size of a beatmap. */
  private final double circleSize;
  
  /** The overall difficulty (accuracy) of a beatmap. */
  private final double accuracy;
  
  /** The approach rate of a beatmap. */
  private final double approachRate;
  
  /** A list of the map's timing points. */
  private final ArrayList<TimingPoint> timingPoints;
  
  /** A list of the map's hit objects. */
  private final ArrayList<HitObject> hitObjects;
  
  /** How likely overlapping hit circles are to stack. */
  private final double stackLeniency;
  
  /** The multiplier for slider speed. */
  private final double sliderSpeedMult;
  
  /** How frequently slider ticks appear along sliders. */
  private final int sliderTickRate;
  
  /**
   * Default and obnoxious constructor.
   * 
   * @param title the title of the beatmap's audio.
   * @param artist the artist of the beatmap's audio.
   * @param creator the player who created this beatmap.
   * @param diffName the name of this particular difficulty.
   * @param source what media the audio originates from.
   * @param hpDrain the HP Drain parameter of the beatmap, or how quickly the life bar decreases during play.
   * @param circleSize the size of the hit circles. The larger the number, the smaller the circles.
   * @param accuracy the overall difficulty parameter of the beatmap. The higher the OD, the more accurate timing is
   *        required to score 300's on the map's hit circles, and complete its spinners.
   * @param approachRate the approach rate parameter of the beatmap. The higher the AR, the more quickly approach
   *        circles close in on a hit circle.
   * @param timingPoints a list of timing points this map utilizes.
   * @param hitObjects every hit object of this map.
   * @param stackLeniency the stack leniency of the map.
   * @param sliderSpeedMult the slider speed multiplier.
   * @param sliderTickRate how frequently slider ticks appear along the map's sliders.
   */
  public Beatmap(String title, String artist, String creator, String diffName, String source, double hpDrain,
      double circleSize, double accuracy, double approachRate, ArrayList<TimingPoint> timingPoints,
      ArrayList<HitObject> hitObjects, double stackLeniency, double sliderSpeedMult, int sliderTickRate) {
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
  
  /**
   * Gets the average beats-per-minute of this beatmap.
   * 
   * @return a double of the average BPM.
   */
  public double getAverageBPM() {
    double total = 0;
    int numTP = 0;
    for (TimingPoint tp : this.timingPoints) {
      if (tp.getMsPerBeat() > 0.0D) {
        total += tp.getMsPerBeat();
        numTP++;
      }
    }
    return Math.round(60000.0D / (total / numTP));
  }
  
  /**
   * Gets the BPM range of this beatmap.
   * 
   * @return a double[] with the first index being the minimum BPM, and the second index being the maximum BPM of this
   *         beatmap.
   */
  public double[] getBPMRange() {
    double[] result = new double[2];
    
    double min = 0.0D;
    double max = 0.0D;
    
    for (TimingPoint tp : this.timingPoints) {
      final double mspb = tp.getMsPerBeat();
      if (min > mspb)
        min = mspb;
      else if (max < mspb) max = mspb;
    }
    
    result[0] = min;
    result[1] = max;
    return result;
  }
  
  /**
   * Gets the song's title.
   * 
   * @return a String containing the title of the beatmap's audio.
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * Gets the song's artist.
   * 
   * @return a String containing the artist of the beatmap's audio.
   */
  public String getArtist() {
    return artist;
  }
  
  /**
   * Gets the beatmap's creator.
   * 
   * @return a String containing the player's name who mapped this beatmap.
   */
  public String getCreator() {
    return creator;
  }
  
  /**
   * Gets the difficulty name.
   * 
   * @return a String containing the name of this specific map's difficulty.
   */
  public String getDiffName() {
    return diffName;
  }
  
  /**
   * Gets the audio's source.
   * 
   * @return a String containing the media the map's song originates from.
   */
  public String getSource() {
    return source;
  }
  
  /**
   * Gets the HP parameter.
   * 
   * @return a double containing the HP Drain rate of this beatmap from 0 to 10.
   */
  public double getHpDrain() {
    return hpDrain;
  }
  
  /**
   * Gets the CS parameter.
   * 
   * @return a double containing the Circle Size of this beatmap from 0 to 10 (which is hopefully never above 7).
   */
  public double getCircleSize() {
    return circleSize;
  }
  
  /**
   * Gets the OD parameter.
   * 
   * @return a double containing the Overall Difficulty (Accuracy) of this beatmap from 0 to 10.
   */
  public double getAccuracy() {
    return accuracy;
  }
  
  /**
   * Gets the AR parameter.
   * 
   * @return a double containing the Approach Rate of this beatmap from 0 to 10.
   */
  public double getApproachRate() {
    return approachRate;
  }
  
  /**
   * Gets the map's timing points.
   * 
   * @return an ArrayList of TimingPoints in the order they appear in the .osu file.
   */
  public ArrayList<TimingPoint> getTimingPoints() {
    return timingPoints;
  }
  
  /**
   * Gets the map's hit objects.
   * 
   * @return an ArrayList of HitObjects in the order they appear in the .osu file. HitObjects may be either HitCircles,
   *         Sliders, or Spinners.
   *         
   */
  public ArrayList<HitObject> getHitObjects() {
    return hitObjects;
  }
  
  /**
   * Gets the map's stack leniency.
   * 
   * @return a double representing how unlikely osu! is to stack overlapping hit circles.
   */
  public double getStackLeniency() {
    return stackLeniency;
  }
  
  /**
   * Gets the slider speed multiplier.
   * 
   * @return a double representing how fast sliders travel along their path in relation to the map's BPM.
   */
  public double getSliderSpeedMult() {
    return sliderSpeedMult;
  }
  
  /**
   * Gets the slider tick rate.
   * 
   * @return an int containing how frequently slider ticks appear along a slider's path.
   */
  public int getSliderTickRate() {
    return sliderTickRate;
  }
  
  /**
   * Gets a String representation of this object.
   * 
   * @return a String listing the beatmap's metadata, difficulty parameters, object count, and BPM.
   *         
   */
  @Override
  public String toString() {
    String result = "> Beatmap:\n";
    result += metaStr();
    result += paramStr();
    result += objStr();
    return result;
  }
  
  /**
   * toString() helper method for metadata.
   * 
   * @return a String of format "$ARTIST - $TITLE [$DIFFICULTY] // $MAPPER".
   */
  private String metaStr() {
    return "  " + this.artist + " - " + this.title + " [" + this.diffName + "]" + " // " + this.creator + "\n";
  }
  
  /**
   * toString() helper method for difficulty parameters.
   * 
   * @return a String of format "CS=$CS AR=$AR, OD=$OD, HP=$HP".
   */
  private String paramStr() {
    return "  CS=" + this.circleSize + " AR=" + this.approachRate + " OD=" + this.accuracy + " HP=" + this.hpDrain
        + "\n";
  }
  
  /**
   * toString() helper method for objects and BPM.
   * 
   * @return a String of format "$#HITOBJECTS HitObjects @ $BPM BPM".
   */
  private String objStr() {
    return "  " + this.hitObjects.size() + " HitObjects @ " + getAverageBPM() + "BPM";
  }

  @Override
  public Iterator<HitObject> iterator() {
    return this.hitObjects.iterator();
  }
}
