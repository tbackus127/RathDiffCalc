
package com.rath.diffcalc;

public class DifficultyVector {

  private final AimDifficulty aimDifficulty;
  private final TimingDifficulty timingDifficulty;
  private final ReadingDifficulty readingDifficulty;

  public DifficultyVector(AimDifficulty ad, TimingDifficulty td,
      ReadingDifficulty rd) {
    this.aimDifficulty = ad;
    this.timingDifficulty = td;
    this.readingDifficulty = rd;
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
