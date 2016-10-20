import com.rath.diffcalc.DiffCalc;

public class DiffCalcTest {

  public static void main(String[] args) {
    System.out.println("Running...");
    for(int i = 0; i < args.length; i++) {
      DiffCalc dc = new DiffCalc(args[0]);
      System.out.println(dc + "\n  Aim.SPD = " + dc.getDiff().getAimDifficulty().getSpeed());      
    }
  }
}
