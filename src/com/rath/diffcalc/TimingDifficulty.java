
package com.rath.diffcalc;

import com.rath.beatmap.Beatmap;

public class TimingDifficulty {

  private final double control;
  private final double speed;
  private final double accuracy;
  private final double stamina;

  public TimingDifficulty(double c, double s, double a, double t) {
    this.control = c;
    this.speed = s;
    this.accuracy = a;
    this.stamina = t;
  }

  public double getControl() {
    return control;
  }

  public double getSpeed() {
    return speed;
  }

  public double getAccuracy() {
    return accuracy;
  }

  public double getStamina() {
    return stamina;
  }

  public static double calcControl(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcSpeed(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcAccuracy(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcStamina(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }
}
