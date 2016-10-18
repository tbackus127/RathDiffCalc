
package com.rath.diffcalc;

import com.rath.beatmap.Beatmap;

public class ReadingDifficulty {

  private final double range;
  private final double path;
  private final double timing;

  public ReadingDifficulty(double r, double p, double t) {
    this.range = r;
    this.path = p;
    this.timing = t;
  }

  public double getRange() {
    return range;
  }

  public double getPath() {
    return path;
  }

  public double getTiming() {
    return timing;
  }

  public static double calcRange(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcPath(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcTiming(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }
}
