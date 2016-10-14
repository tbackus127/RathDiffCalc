
package com.rath.diffcalc;

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
}
