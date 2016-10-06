
package com.rath.beatmap;

public abstract class HitObject {

  protected Coord pos;
  protected int offset;
  protected HitObjectType type;

  protected HitObject(Coord pos, int offset) {
    this.pos = pos;
    this.offset = offset;
  }

  public Coord getPos() {
    return this.pos;
  }

  public int getOffset() {
    return this.offset;
  }
  
  public abstract String toString();
}
