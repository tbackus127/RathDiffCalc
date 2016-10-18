
package com.rath.diffcalc;

import com.rath.beatmap.Beatmap;

public class DifficultyVector {

  private final AimDifficulty aimDifficulty;
  private final TimingDifficulty timingDifficulty;
  private final ReadingDifficulty readingDifficulty;

  public DifficultyVector(Beatmap b) {
    this.aimDifficulty = calculateAimDiff(b);
    this.timingDifficulty = calculateTimingDiff(b);
    this.readingDifficulty = calculateReadingDiff(b);
  }

  private AimDifficulty calculateAimDiff(Beatmap b) {
    double precision = AimDifficulty.calcPrecision(b); 
    double speed = AimDifficulty.calcSpeed(b);
    double control = AimDifficulty.calcControl(b);
    double stamina = AimDifficulty.calcStamina(b);
    return new AimDifficulty(precision, speed, control, stamina);
  }
  
  private TimingDifficulty calculateTimingDiff(Beatmap b) {
    double control = TimingDifficulty.calcControl(b);
    double speed = TimingDifficulty.calcSpeed(b);
    double accuracy = TimingDifficulty.calcAccuracy(b);
    double stamina = TimingDifficulty.calcStamina(b);
    return new TimingDifficulty(control, speed, accuracy, stamina);
  }
  
  private ReadingDifficulty calculateReadingDiff(Beatmap b) {
    double range = ReadingDifficulty.calcRange(b);
    double path = ReadingDifficulty.calcPath(b);
    double timing = ReadingDifficulty.calcTiming(b);
    return new ReadingDifficulty(range, path, timing);
  }
  
  public AimDifficulty getAimDifficulty() {
    return aimDifficulty;
  }

  public TimingDifficulty getTimingDifficulty() {
    return timingDifficulty;
  }

  public ReadingDifficulty getReadingDifficulty() {
    return readingDifficulty;
  }
}
