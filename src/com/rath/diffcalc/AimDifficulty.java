
package com.rath.diffcalc;

import java.util.ArrayList;

import com.rath.beatmap.Beatmap;
import com.rath.beatmap.HitObject;
import com.rath.beatmap.HitObjectType;

/**
 * The aim difficulty vector.
 * 
 * @author Tim Backus tbackus127@gmail.com
 * 
 */
public class AimDifficulty {
  
  private static final double JUMP_THRESHOLD = 0.6667;
  
  private final double precision;
  private final double speed;
  private final double control;
  private final double stamina;

  public AimDifficulty(double p, double s, double c, double t) {
    this.precision = p;
    this.speed = s;
    this.control = c;
    this.stamina = t;
  }

  public double getPrecision() {
    return precision;
  }

  public double getSpeed() {
    return speed;
  }

  public double getControl() {
    return control;
  }

  public double getStamina() {
    return stamina;
  }

  public static final double calcPrecision(Beatmap beatmap) {
    
    final double circleSize = beatmap.getCircleSize();
    
    
    return 0;
  }

  /**
   * Calculates the speed component of the aim difficulty.
   * @param beatmap the map to calculate from.
   * @return a double that is higher for more required jump speed.
   */
  public static double calcSpeed(Beatmap beatmap) {

    final ArrayList<Double> jumpSpeeds = new ArrayList<Double>();
    HitObject lastObj = null;

    // Get the mean jump speed
    for (HitObject mapObj : beatmap) {

      // If it's not the first HitObject and aimable
      if (lastObj != null && mapObj.getType() != HitObjectType.SPINNER) {
        CircleDelta jump = new CircleDelta(lastObj, mapObj);
        final double jumpSpeed = jump.getJumpSpeed();
        jumpSpeeds.add(jumpSpeed);
      }

      lastObj = mapObj;
    }
    
    final double jumpSpeedMean = calcAverage(jumpSpeeds);
    final double jumpSpeedSD = calcStdDev(jumpSpeeds, jumpSpeedMean);
    
    // Get all the jumps > SD1
    final ArrayList<Double> devJump = new ArrayList<Double>();
    for(Double d : jumpSpeeds) {
      
      final double zScore = (d - jumpSpeedMean) / jumpSpeedSD;
      if(zScore > JUMP_THRESHOLD) {
        devJump.add(d);
      }
    }
    
    final double devJumpMean = calcAverage(devJump);
    final double jumpWeight = devJump.size() / jumpSpeeds.size();
    final double leftEq = jumpSpeedMean * (1 - (jumpWeight));
    final double rightEq = devJumpMean * (jumpWeight);

    final double bpm = beatmap.getBPM();
    final double optAR = beatmap.getOptimalAR();
    System.out.println("    AR=" + optAR + " BPM=" + bpm);
    
    return leftEq + rightEq;
  }

  public static double calcControl(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcStamina(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  /**
   * Gets the average of the values in a list.
   * 
   * @param list the ArrayList of doubles to average.
   * @return the mean of the values of list.
   */
  private static double calcAverage(ArrayList<Double> list) {
    double total = 0.0D;
    for (double d : list) {
      total += d;
    }
    return total / list.size();
  }

  /**
   * Gets the standard deviation of the values in a list.
   * 
   * @param list the ArrayList of doubles to get the SD of.
   * @param mean the previously calculated mean of the list.
   * @return the standard deviation of the values of list.
   */
  private static double calcStdDev(ArrayList<Double> list, double mean) {
    final ArrayList<Double> tmpList = new ArrayList<Double>();

    for (double d : list) {
      double entry = Math.pow((d - mean), 2);
      tmpList.add(entry);
    }

    return Math.sqrt(calcAverage(tmpList));
  }
}
